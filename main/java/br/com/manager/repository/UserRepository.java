package br.com.manager.repository;

import br.com.manager.domain.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Page<Users> findAllByActiveTrue(Pageable pageable);
}