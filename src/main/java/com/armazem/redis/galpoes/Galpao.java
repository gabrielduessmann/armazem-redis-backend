package com.armazem.redis.galpoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Galpao")
public class Galpao implements Serializable {
    @Id
    private UUID galpaoId;

    private String nome;

    private String descricao;

    private String cidade;

    private String bairro;

    private String rua;

    private Integer numero;

    private String complemento;
}
