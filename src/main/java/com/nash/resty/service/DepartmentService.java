package com.nash.resty.service;

import com.nash.resty.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Optional<Department> findDepartmentById(Long id);

    void deleteById(Long id);

    Department updateDepartment(Long departmentId, Department department);

    Department findDepartmentByName(String name);
}
