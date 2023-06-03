package com.sdp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdp.entity.JobApplications;

public interface JobApplicationsRepo extends JpaRepository<JobApplications, Integer>
{
	@Query("select s from JobApplications s where s.jobid=?1")
	public List<JobApplications> getAppliedStudents(long jobid);
}
