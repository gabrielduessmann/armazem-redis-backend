package com.armazem.galpoes.dto;

import lombok.Builder;

@Builder
public class GalpaoListarDto {
    public String id;

    public String nome;

    public String descricao;

    public String cidade;

    public String bairro;

    public String rua;

    public String numero;

    public String complemento;

//    public ArrayList<EstoqueListarDto> estoques;
}
