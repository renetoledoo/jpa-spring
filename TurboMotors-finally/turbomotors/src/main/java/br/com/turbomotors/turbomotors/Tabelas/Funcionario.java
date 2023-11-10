package br.com.turbomotors.turbomotors.Tabelas;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcionarios database table.
 * 
 */
@Entity
@Table(name="funcionarios")
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_funcionario")
	private int idFuncionario;

	private String cargo;

	private String funcionarioscol;

	private String password;

	private String user;

	//bi-directional many-to-one association to Cargofuncionario
	@OneToMany(mappedBy="funcionario")
	private List<Cargofuncionario> cargofuncionarios;

	public Funcionario() {
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncionarioscol() {
		return this.funcionarioscol;
	}

	public void setFuncionarioscol(String funcionarioscol) {
		this.funcionarioscol = funcionarioscol;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Cargofuncionario> getCargofuncionarios() {
		return this.cargofuncionarios;
	}

	public void setCargofuncionarios(List<Cargofuncionario> cargofuncionarios) {
		this.cargofuncionarios = cargofuncionarios;
	}

	public Cargofuncionario addCargofuncionario(Cargofuncionario cargofuncionario) {
		getCargofuncionarios().add(cargofuncionario);
		cargofuncionario.setFuncionario(this);

		return cargofuncionario;
	}

	public Cargofuncionario removeCargofuncionario(Cargofuncionario cargofuncionario) {
		getCargofuncionarios().remove(cargofuncionario);
		cargofuncionario.setFuncionario(null);

		return cargofuncionario;
	}

}