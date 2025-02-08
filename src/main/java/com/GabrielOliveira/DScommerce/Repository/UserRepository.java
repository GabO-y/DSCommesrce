package com.GabrielOliveira.DScommerce.Repository;

import com.GabrielOliveira.DScommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
