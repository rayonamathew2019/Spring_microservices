package com.example.Employee.controller;

import com.example.Employee.model.Emp;
import com.example.Employee.service.Empservice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(empcontroller.class)
class empcontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Empservice mockEmpservices;

    @Test
    void testAddress() throws Exception {
        // Setup
        // Configure Empservice.address(...).
        final Emp emp = new Emp(0, "empId", "emp_name", "emp_email", "designation", "hr");
        when(mockEmpservices.address(new Emp(0, "empId", "emp_name", "emp_email", "designation", "hr")))
                .thenReturn(emp);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/employee/emps")
                        .content(asJsonString(emp)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Emp emp) {
        return null;
    }

    @Test
    void testGetAllEmployee() throws Exception {
        // Setup
        // Configure Empservice.getEntity(...).
        final List<Emp> emps = List.of(new Emp(0, "empId", "emp_name", "emp_email", "designation", "hr"));
        when(mockEmpservices.getEntity()).thenReturn(emps);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee/employe")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAllEmployee_EmpserviceReturnsNoItems() throws Exception {
        // Setup
        when(mockEmpservices.getEntity()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee/employe")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetEmployeeById() throws Exception {
        // Setup
        // Configure Empservice.findByempId(...).
        final Emp emp = new Emp(0, "empId", "emp_name", "emp_email", "designation", "hr");
        when(mockEmpservices.findByempId("empId")).thenReturn(emp);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee/employe/{empId}", "empId")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteEmployee() throws Exception {
        // Setup
        when(mockEmpservices.deleteEmployee(0)).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/employee/deleteemployee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
