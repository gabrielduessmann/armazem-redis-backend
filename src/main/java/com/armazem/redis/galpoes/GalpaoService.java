package com.armazem.redis.galpoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class GalpaoService {
    @Autowired
    private GalpaoDao galpaoDao;

    public void criarGalpao(Galpao galpao) {
        galpao.setGalpaoId(UUID.randomUUID());
        galpaoDao.save(galpao);
    }

    public List<Galpao> listarGalpoes() {
        return galpaoDao.findAll();
    }

    public Galpao listarGalpoesPorId(UUID id) {
        return galpaoDao.findById(id);
    }

    public void editarGalpao(UUID id, Galpao galpao) {
        galpaoDao.delete(id);
        galpao.setGalpaoId(id);
        galpaoDao.save(galpao);
        // método put
    }


    public void deletarGalpao(UUID id) {
        galpaoDao.delete(id);
    }

    /*

    private ArrayList<GalpaoListarDto> convertToGalpaoListarDtoListarTodos(ArrayList<Tuple> tuplas) {
        ArrayList<GalpaoListarDto> galpoes = new ArrayList<>();
        tuplas.forEach(tupla -> {
            galpoes.add(
                    GalpaoListarDto.builder()
                            .id(obterValorTupla(tupla.get("id")))
                            .nome(obterValorTupla(tupla.get("nome")))
                            .descricao(obterValorTupla(tupla.get("descricao")))
                            .build()
            );
        });
        return galpoes;
    }

    private ArrayList<GalpaoListarDto> convertToGalpaoListarDtoListarPorId(ArrayList<Tuple> tuplas) {
        ArrayList<GalpaoListarDto> galpoes = new ArrayList<>();
        tuplas.forEach(tupla -> {
            galpoes.add(
                    GalpaoListarDto.builder()
                            .id(obterValorTupla(tupla.get("id")))
                            .nome(obterValorTupla(tupla.get("nome")))
                            .descricao(obterValorTupla(tupla.get("descricao")))
                            .build()
            );
        });
        return galpoes;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }

     */
}
