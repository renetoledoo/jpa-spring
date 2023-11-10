package br.com.turbomotors.turbomotors.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.turbomotors.turbomotors.Tabelas.Cliente;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    @Query("select u from Cliente u where u.email = ?1")
    Cliente findByEmail(String email);
    
}
