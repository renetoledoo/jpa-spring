package br.com.turbomotors.turbomotors.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.turbomotors.turbomotors.Tabelas.Marca;
import br.com.turbomotors.turbomotors.Tabelas.Tipo;
import java.util.List;
import br.com.turbomotors.turbomotors.Tabelas.Veiculo;


public interface TipoRepositorio extends JpaRepository<Tipo, Long> {

    @Query("select t from Tipo t where t.idTipo = ?1")
    Tipo findByVeiculosIdtipo(Long idTipo);

}
