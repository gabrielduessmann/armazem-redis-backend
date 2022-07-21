package com.armazem.redis.estoques.dto;

import lombok.Builder;

@Builder
public class EstoqueListarTodosDto {
    public String estoqueId;

    public String nomegalpao;

    public String setorestoque;

    public String capacidade;
}
