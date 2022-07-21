package com.armazem.redis.estoques;

import com.armazem.redis.estoques.dto.EstoqueListarTodosDto;
import com.armazem.redis.galpoes.GalpaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueDao estoqueDao;

    @Autowired
    private GalpaoService galpaoService;

    public void criarEstoque(Estoque estoque) {
        estoque.setEstoqueId(UUID.randomUUID());
        estoqueDao.save(estoque);
    }

    public List<EstoqueListarTodosDto> listarEstoques() {
        List<Estoque> estoques = estoqueDao.findAll();
        return estoques.stream().map(e -> convertToEstoqueDto(e)).collect(Collectors.toList());
    }

    public Estoque listarEstoquesPorId(UUID id) {
        return estoqueDao.findById(id);
    }

    private EstoqueListarTodosDto convertToEstoqueDto(Estoque e) {
        return EstoqueListarTodosDto.builder()
                .estoqueId(e.getEstoqueId().toString())
                .nomegalpao(galpaoService.listarGalpoesPorId(e.getGalpaoId()).getNome())
                .capacidade(e.getCapacidade().toString())
                .setorestoque(e.getSetor())
                .build();
    }

    /*
    public ArrayList<EstoquesDisponiveisListarDto> listarEstoquesDisponiveis() {
        LocalDate dataAtual = LocalDate.now();
        ArrayList<Tuple> tuplas = estoqueRepository.listarEstoquesDisponiveis(dataAtual);
        return convertToEstoquesDisponiveisListarDto(tuplas);
    }
     */

    public void editarEstoque(UUID id, Estoque estoque) {
        estoqueDao.delete(id);
        estoque.setEstoqueId(id);
        estoqueDao.save(estoque);
    }

    public void deletarEstoque(UUID id) {
        estoqueDao.delete(id);
    }

    /*
    private ArrayList<EstoquesDisponiveisListarDto> convertToEstoquesDisponiveisListarDto(ArrayList<Tuple> tuplas) {
        ArrayList<EstoquesDisponiveisListarDto> estoquesDisponiveisDto = new ArrayList<>();
        tuplas.forEach(tupla -> {
            estoquesDisponiveisDto.add(
                    EstoquesDisponiveisListarDto.builder()
                            .estoqueId(obterValorTupla(tupla.get("estoqueid")))
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .build()
            );
        });
        return estoquesDisponiveisDto;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }

     */
}
