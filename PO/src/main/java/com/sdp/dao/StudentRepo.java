package com.sdp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdp.entity.Student;
@Repository
@Transactional
public interface StudentRepo extends JpaRepository<Student	,String>
{

}
