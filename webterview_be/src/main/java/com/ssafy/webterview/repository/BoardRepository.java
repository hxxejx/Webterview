package com.ssafy.webterview.repository;

import com.ssafy.webterview.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	Page<Board> findByUserUserNoOrderByBoardNoDesc(int userNo, Pageable pageable);
	Page<Board> findByUserUserNo(int userNo, Pageable pageable);
}