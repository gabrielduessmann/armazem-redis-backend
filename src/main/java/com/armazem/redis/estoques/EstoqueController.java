package com.armazem.redis.estoques;

import com.armazem.redis.estoques.dto.EstoqueListarTodosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/criar")
    public ResponseEntity<Void> criarEstoque(@RequestBody Estoque estoque) {
        estoqueService.criarEstoque(estoque);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EstoqueListarTodosDto>> listarEstoques() {
        return ResponseEntity.ok(estoqueService.listarEstoques());
    }

    @GetMapping("/{id}/listar")
    public ResponseEntity<Estoque> listarEstoquesPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(estoqueService.listarEstoquesPorId(id));
    }

    /*
    @GetMapping("/listarDisponiveis")
    public ResponseEntity<ArrayList<EstoquesDisponiveisListarDto>> listarEstoquesDisponiveis() {
        return ResponseEntity.ok(estoqueService.listarEstoquesDisponiveis());
    }

     */

    @PostMapping("/{id}/editar")
    public ResponseEntity<Void> editarEstoque(@PathVariable UUID id, @RequestBody Estoque estoque) {
        estoqueService.editarEstoque(id, estoque);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/remover")
    public ResponseEntity<Void> deletarEstoque(@PathVariable UUID id) {
        estoqueService.deletarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
