package com.ssafy.webterview.repository;

import com.ssafy.webterview.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    long countByGroupGroupNo(int groupNo);
}
