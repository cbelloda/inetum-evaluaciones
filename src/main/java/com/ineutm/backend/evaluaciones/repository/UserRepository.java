package com.ineutm.backend.evaluaciones.repository;

import com.ineutm.backend.evaluaciones.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

  Optional<User> findByDocumentNumber(String document);
  
}
