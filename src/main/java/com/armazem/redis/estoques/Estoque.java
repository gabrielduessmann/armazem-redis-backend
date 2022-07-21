package com.armazem.redis.estoques;

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
@RedisHash("Estoque")
public class Estoque implements Serializable {
    @Id
    private UUID estoqueId;

    private String setor;

    private Integer capacidade;

    private UUID galpaoId;

}
