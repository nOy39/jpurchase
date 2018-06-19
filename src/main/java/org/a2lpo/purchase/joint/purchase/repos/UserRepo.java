package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
