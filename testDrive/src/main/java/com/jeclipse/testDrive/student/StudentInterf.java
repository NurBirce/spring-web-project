package com.jeclipse.testDrive.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentInterf  extends JpaRepository<Student, Integer>{

}
