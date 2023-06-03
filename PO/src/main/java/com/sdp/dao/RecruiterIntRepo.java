package com.sdp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdp.entity.Recruiter;

@Repository
@Transactional
public interface RecruiterIntRepo extends JpaRepository<Recruiter, Integer>{
	@Modifying
	@Query("delete from Recruiter r where r.username=?1")
	public void deleteByUsername(String username);
	
	
}
