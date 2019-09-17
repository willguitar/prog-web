package br.com.larissa.AgendaDeObjetivos.domain;

import java.time.LocalDate;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodosUsuarios extends JpaRepository<Usuario, Id> {
	
	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	public boolean existe(@Param("login") String login , @Param("senha") String senha);
}
