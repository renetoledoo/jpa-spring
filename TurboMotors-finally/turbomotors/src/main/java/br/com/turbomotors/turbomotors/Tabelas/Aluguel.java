package br.com.turbomotors.turbomotors.Tabelas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the aluguel database table.
 * 
 */
@Entity
@NamedQuery(name="Aluguel.findAll", query="SELECT a FROM Aluguel a")
public class Aluguel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluguel")
	private int idAluguel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fim")
	private Date dataFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Column(name="valor_hora")
	private BigDecimal valorHora;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="Cliente_idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="Veiculo_idCarro")
	private Veiculo veiculo;

	//bi-directional many-to-one association to Pagamento
	@OneToMany(mappedBy="aluguel")
	private List<Pagamento> pagamentos;

	public Aluguel() {
	}

	public int getIdAluguel() {
		return this.idAluguel;
	}

	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public BigDecimal getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setAluguel(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setAluguel(null);

		return pagamento;
	}

}