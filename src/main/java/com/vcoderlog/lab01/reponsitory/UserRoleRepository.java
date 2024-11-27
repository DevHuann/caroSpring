package com.vcoderlog.lab01.reponsitory;

import com.vcoderlog.lab01.reponsitory.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
