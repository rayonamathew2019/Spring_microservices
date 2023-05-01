package com.example.SpringBootTestDemo.StudentControllerTest;

import com.example.SpringBootTestDemo.controller.StudentController;
import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.service.StudentServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)

public class StudentTestController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentServices studentServices;
    private Student student;
    @BeforeEach
    public void setup(){
        student = new Student(0,"Rayona","Kerela","38");
    }
    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(0,"Rayona","Kerela","38");
        Mockito.when(studentServices.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" +
                                " \"id\" : 0, \r\n" +
                                " \"name\" : \"Rayona\", \r\n" +
                                " \"address\" :\"Kerela\", \r\n" +
                                " \"rollNo\" : \"38\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
