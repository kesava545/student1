package com.example.student.repostudent;

import com.example.student.entitystudent.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Long>
        {
}
