package com.students.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.data.entity.Enrollment;

@Repository
public interface EnrollmentJpaRepository extends JpaRepository<Enrollment, Integer> {

	public Enrollment findByEnrollmentId(Integer id);

}
