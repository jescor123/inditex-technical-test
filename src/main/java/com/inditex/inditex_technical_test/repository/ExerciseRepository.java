package com.inditex.inditex_technical_test.repository;

import com.inditex.inditex_technical_test.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>  {

}
