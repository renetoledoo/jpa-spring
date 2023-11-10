package br.com.turbomotors.turbomotors.Tabelas;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pagamento database table.
 * 
 */
@Entity
@NamedQuery(name="Pagamento.findAll", query="SELECT p FROM Pagamento p")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pagamento")
	private int idPagamento;

	@Column(name="card_expiracao")
	private String cardExpiracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_pagamento")
	private Date dataPagamento;

	private String descricao;

	@Column(name="nome_pagador")
	private String nomePagador;

	@Column(name="numero_cartao")
	private int numeroCartao;

	@Column(name="valor_total")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to Aluguel
	@ManyToOne
	@JoinColumn(name="Aluguel_idAluguel")
	private Aluguel aluguel;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="Compra_idCompra")
	private Compra compra;

	public Pagamento() {
	}

	public int getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getCardExpiracao() {
		return this.cardExpiracao;
	}

	public void setCardExpiracao(String cardExpiracao) {
		this.cardExpiracao = cardExpiracao;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomePagador() {
		return this.nomePagador;
	}

	public void setNomePagador(String nomePagador) {
		this.nomePagador = nomePagador;
	}

	public int getNumeroCartao() {
		return this.numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Aluguel getAluguel() {
		return this.aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}