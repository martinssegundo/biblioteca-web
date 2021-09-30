package edu.facec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.facec.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
