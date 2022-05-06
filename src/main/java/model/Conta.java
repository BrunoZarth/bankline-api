package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Embeddable
public class Conta {
	
	@Column(name = "conta_numero")
	private Long numero;
	
	@Column(name = "conta_saldo")
	private double saldo;
}
