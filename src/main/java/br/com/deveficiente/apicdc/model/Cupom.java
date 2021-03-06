package br.com.deveficiente.apicdc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

@Entity
@NamedQuery(
	    name="findCupomByCodigo",
	    query = "SELECT cup FROM Cupom cup WHERE cup.codigo = :codigo"
	)
public class Cupom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String codigo;
	private @Future @NotNull LocalDateTime expiracao;
	private @Positive @DecimalMax("0.25") BigDecimal desconto;

	@Deprecated
	public Cupom() {
	}
	
	public Cupom(@NotBlank String codigo, @Future @NotNull LocalDateTime expiracao,
			@Positive @DecimalMax("0.25") BigDecimal desconto) {
		Assert.isTrue(desconto.compareTo(new BigDecimal("0.25")) <= 0, "Desconto foi maior que 0.25 e não pode.");
		this.codigo = codigo;
		this.expiracao = expiracao;
		this.desconto = desconto;
	}

	public boolean taValido() {
		return expiracao.compareTo(LocalDateTime.now()) >= 0;
	}

}
