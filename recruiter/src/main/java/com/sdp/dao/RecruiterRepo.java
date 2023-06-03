package com.sdp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp.entity.Recruiter;

public interface RecruiterRepo extends JpaRepository<Recruiter, String>{

//	List<Recruiter> findByUsername(String username);
}
