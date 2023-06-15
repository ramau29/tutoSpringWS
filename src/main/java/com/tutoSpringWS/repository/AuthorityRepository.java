package com.tutoSpringWS.repository;

import com.tutoSpringWS.model.Authority;
import com.tutoSpringWS.util.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(AuthorityName name);
}
