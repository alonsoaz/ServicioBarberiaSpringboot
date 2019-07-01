package com.barberia.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barberia.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

	Usuario findOneByUsername(String username);
}
