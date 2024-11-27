package com.vcoderlog.lab01.reponsitory;

import com.vcoderlog.lab01.reponsitory.models.BoardTransaction;
import com.vcoderlog.lab01.reponsitory.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardTransaction, Long> {
    List<BoardTransaction> findByIsDeleted(boolean statusDelete);
    BoardTransaction findAllById(long id);

    List<BoardTransaction> findByRoomId(long roomId);
    List<BoardTransaction> findByRoomAndStatus(Room room, int status);
}
