package br.com.turbomotors.turbomotors.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.turbomotors.turbomotors.Tabelas.Marca;
import java.util.List;
import br.com.turbomotors.turbomotors.Tabelas.Veiculo;


public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Query("select m from Marca m where m.idMarca =  ?1")
    Marca findByVeiculosPorId(Long idMarca);
}
