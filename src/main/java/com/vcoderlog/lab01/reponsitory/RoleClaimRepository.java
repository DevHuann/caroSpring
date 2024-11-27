package com.vcoderlog.lab01.reponsitory;

import com.vcoderlog.lab01.reponsitory.models.RoleClaims;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleClaimRepository extends JpaRepository<RoleClaims, Long> {
}
