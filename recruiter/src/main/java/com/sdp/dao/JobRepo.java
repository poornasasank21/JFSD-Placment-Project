package com.sdp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdp.entity.Job;
import com.sdp.entity.Student;

public interface JobRepo extends JpaRepository<Job, Long>{

	
	@Query("SELECT j.role FROM Job j WHERE j.jobid = ?1")
    public String findByJobRole(long jobid);
	
}
