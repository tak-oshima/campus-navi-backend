package com.appkobo.campusnavi.repository;

import com.appkobo.campusnavi.model.CourseProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseProfessorRepository extends JpaRepository<CourseProfessor, Long> {
}
