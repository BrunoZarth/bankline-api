package model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDateTime dataHora;
	private String descricao;
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private MovimentacaoTipo movimentacaoTipo;
}
