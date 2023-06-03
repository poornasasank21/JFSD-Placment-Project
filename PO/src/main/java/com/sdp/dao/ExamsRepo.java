package com.sdp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.entity.Exam;
@Repository
public interface ExamsRepo extends JpaRepository<Exam, Integer>{

}
