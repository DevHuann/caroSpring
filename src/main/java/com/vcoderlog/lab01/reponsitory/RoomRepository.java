package com.vcoderlog.lab01.reponsitory;

import com.vcoderlog.lab01.reponsitory.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsDelete(boolean deleteStatus);
    Optional<Room> findById(long id);

    Room findAllById(long id);
}
