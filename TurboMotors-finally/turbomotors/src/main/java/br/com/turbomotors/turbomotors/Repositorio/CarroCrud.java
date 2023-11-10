package br.com.turbomotors.turbomotors.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.turbomotors.turbomotors.Tabelas.Cliente;
import br.com.turbomotors.turbomotors.Tabelas.Veiculo;

import br.com.turbomotors.turbomotors.Tabelas.Veiculo;


@Repository
public interface CarroCrud extends JpaRepository<Veiculo, Long> {
 
    @Query("select v from Veiculo v order by v.idCarro DESC ")
    List<Veiculo> findByIdOrdernado();
}
