package br.com.deveficiente.apicdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.deveficiente.apicdc.model.Cupom;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long>{

	Optional<Cupom> findByCodigo(String codigoCupom);

}
