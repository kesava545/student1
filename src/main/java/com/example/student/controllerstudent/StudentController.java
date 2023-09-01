package com.example.student.controllerstudent;

import com.example.student.entitystudent.StudentEntity;
import com.example.student.repostudent.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
   @Autowired
   StudentRepo studentRepo;

   @PostMapping("/createstudent/data")
   public ResponseEntity<StudentEntity> studentDataCreate(@RequestBody StudentEntity studentEntity) {
      return new ResponseEntity<>(studentRepo.save(studentEntity), HttpStatus.CREATED);

   }

   @GetMapping("/readstudent/data")
   public List<StudentEntity> studentdataRead() {
      return studentRepo.findAll();
   }

   @GetMapping("/readstudent/data/{id}")
   public ResponseEntity<StudentEntity> studentonedataRead(@PathVariable long id)
   {
      Optional<StudentEntity> studentEntity=studentRepo.findById(id);
      if(studentEntity.isPresent()) {
         return new ResponseEntity<>(studentEntity.get(), HttpStatus.CREATED);
      }
      else {
         return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }
   @PutMapping ("/updatestudent/data/{id}")
   public ResponseEntity<StudentEntity> studentonedataUpdtae(@PathVariable long id , @RequestBody StudentEntity stud)
   {
      Optional<StudentEntity> studentEntity=studentRepo.findById(id);
      if(studentEntity.isPresent()) {
         studentEntity.get().setName(stud.getName());
         studentEntity.get().setAddress(stud.getAddress());

         return new ResponseEntity<>(studentRepo.save(studentEntity.get()),HttpStatus.OK);
      }
      else {
         return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }
   @DeleteMapping ("/deletestudent/data/{id}")
   public ResponseEntity<StudentEntity> studentonedataUpdate(@PathVariable long id) {
      Optional<StudentEntity> studentEntity = studentRepo.findById(id);
      if (studentEntity.isPresent()) {
         studentRepo.deleteById(id);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

}