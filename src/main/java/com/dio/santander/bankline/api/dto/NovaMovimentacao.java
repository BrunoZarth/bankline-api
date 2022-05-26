package com.dio.santander.bankline.api.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import model.MovimentacaoTipo;

@Data
public class NovaMovimentacao {
	
	private String descricao;
	private Double valor;
	private Integer idConta;
	private MovimentacaoTipo movimentacaoTipo;
}
