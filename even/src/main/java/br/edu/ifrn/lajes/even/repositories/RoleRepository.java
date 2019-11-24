package br.edu.ifrn.lajes.even.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.lajes.even.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
