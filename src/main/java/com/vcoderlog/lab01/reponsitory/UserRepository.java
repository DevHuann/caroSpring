package com.vcoderlog.lab01.reponsitory;

import com.vcoderlog.lab01.reponsitory.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByIsDelete(boolean deleteStatus);

    Optional<User> findById(long userId);
}
