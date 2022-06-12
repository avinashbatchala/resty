package com.nash.resty.service;

import com.nash.resty.entity.Department;
import com.nash.resty.exception.DepartmentNotFoundException;
import com.nash.resty.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("ME")
                .departmentCode("ME-05")
                .departmentAddress("Dublin")
                .build();

        Mockito.when(departmentRepository.findDepartmentByDepartmentName("ME")).thenReturn(department);
        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
    }

    @Test
    void saveDepartment() {
    }

    @Test
    void getAllDepartments() {
    }

    @Test
    void findDepartmentById() throws DepartmentNotFoundException {
       Optional<Department> found = departmentService.findDepartmentById(1L);
       assertEquals("ME", found.get().getDepartmentName());

    }

    @Test
    void deleteById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void findDepartmentByNameTest() {
        String departmentName = "ME";
        Department found = departmentService.findDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}