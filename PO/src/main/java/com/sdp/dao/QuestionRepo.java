package com.sdp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.entity.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

}
