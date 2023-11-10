package br.com.turbomotors.turbomotors.Tabelas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargos database table.
 * 
 */
@Entity
@Table(name="cargos")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cargos")
	private int idCargos;

	@Column(name="nome_cargo")
	private String nomeCargo;

	//bi-directional many-to-one association to Cargofuncionario
	@OneToMany(mappedBy="cargo")
	private List<Cargofuncionario> cargofuncionarios;

	public Cargo() {
	}

	public int getIdCargos() {
		return this.idCargos;
	}

	public void setIdCargos(int idCargos) {
		this.idCargos = idCargos;
	}

	public String getNomeCargo() {
		return this.nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public List<Cargofuncionario> getCargofuncionarios() {
		return this.cargofuncionarios;
	}

	public void setCargofuncionarios(List<Cargofuncionario> cargofuncionarios) {
		this.cargofuncionarios = cargofuncionarios;
	}

	public Cargofuncionario addCargofuncionario(Cargofuncionario cargofuncionario) {
		getCargofuncionarios().add(cargofuncionario);
		cargofuncionario.setCargo(this);

		return cargofuncionario;
	}

	public Cargofuncionario removeCargofuncionario(Cargofuncionario cargofuncionario) {
		getCargofuncionarios().remove(cargofuncionario);
		cargofuncionario.setCargo(null);

		return cargofuncionario;
	}

}