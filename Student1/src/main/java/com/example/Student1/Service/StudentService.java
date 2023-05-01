package com.example.Student1.Service;

import com.example.Student1.Entity.Student;
import com.example.Student1.Entity.Student$;
import com.example.Student1.Repository.Repo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private Repo repo;
    @Autowired
    private JPAStreamer jpaStreamer;


    public long getStudentBycourse(String course) {

        Predicate<Student> courseFilter = student -> student.getCourse().contains(course);
        return jpaStreamer.stream(Student.class)
                .filter(courseFilter)
                .count();
    }
    public Student addstudent(Student student) {
    return repo.save(student);
    }

    public List<Student> getall(){
        return repo.findAll();

    }

    public List<Student> getbyaddress(String address) {
        return jpaStreamer.stream(Student.class).filter(Student$.address.contains(address))
                .collect(Collectors.toList());
    }


//    public List<Student> getstudentbycourse() {

//    public List<Student> getstudentbycourse(String interestedCourse) {
//            return jpaStreamer.stream(Student.class)
//                    .filter(Student$.interestedCourse.equal(interestedCourse))
//                    .collect(Collectors.toList());
//    }
//public Long getStudentCountForCourses(List<String> course) {
//
//    return jpaStreamer.stream(StudentDetails.class)
//            .flatMap(student -> student.getInterestedCourse().stream())
//            .filter(courses -> course.contains(courses))
//            .distinct()
//            .count();
}

