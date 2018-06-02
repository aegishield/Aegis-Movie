package com.aegis.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findAllByBranchIdAndStatus(Long branchId,boolean status);
	List<Room> findAllByBranchIdOrderByRoomId(Long branchId);
	Room findByRoomId(Long roomId);
	Room findByTypeAndBranchId(String type,Long branchId);
	List<Room> findAllByStatus(boolean status);
	List<Room> findAllByOrderByRoomId();
}
