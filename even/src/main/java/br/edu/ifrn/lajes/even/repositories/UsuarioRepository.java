package br.edu.ifrn.lajes.even.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.lajes.even.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByMatricula(String matricula);
	
	Iterable<Usuario> findAllByNomeContaining(String nome);

}
