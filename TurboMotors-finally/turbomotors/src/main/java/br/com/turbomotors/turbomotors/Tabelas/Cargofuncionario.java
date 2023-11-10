package br.com.turbomotors.turbomotors.Tabelas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cargofuncionario database table.
 * 
 */
@Entity
@NamedQuery(name="Cargofuncionario.findAll", query="SELECT c FROM Cargofuncionario c")
public class Cargofuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="Cargos_id_cargos")
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="Funcionarios_id_funcionario")
	private Funcionario funcionario;

	public Cargofuncionario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}