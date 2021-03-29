package br.com.deveficiente.apicdc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.deveficiente.apicdc.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
