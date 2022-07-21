package com.armazem.redis.galpoes;

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
@RequestMapping("/galpoes")
public class GalpaoController {

    @Autowired
    private GalpaoService galpaoService;

    final String GALPOES_URL = "galpoes";

    @PostMapping("/criar")
    public ResponseEntity<Void> criarGalpao(@RequestBody Galpao galpao) {
        galpaoService.criarGalpao(galpao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Galpao>> listarGalpoes() {
        return ResponseEntity.ok(galpaoService.listarGalpoes());
    }

    @GetMapping("/{id}/listar")
    public ResponseEntity<Galpao> listarGalpoes(@PathVariable UUID id) {
        return ResponseEntity.ok(galpaoService.listarGalpoesPorId(id));
    }

    @PostMapping("/{id}/editar")
    public ResponseEntity<Void> editarGalpao(@PathVariable UUID id, @RequestBody Galpao galpao) {
        galpaoService.editarGalpao(id, galpao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/remover")
    public ResponseEntity<Void> deletarGalpao(@PathVariable UUID id) {
        galpaoService.deletarGalpao(id);
        return ResponseEntity.noContent().build();
    }
}
