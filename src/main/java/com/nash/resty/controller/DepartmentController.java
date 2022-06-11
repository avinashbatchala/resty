package com.nash.resty.controller;

import com.nash.resty.entity.Department;
import com.nash.resty.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add-department")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> findDepartmentById(@PathVariable("id") Long id) {
        return departmentService.findDepartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/department/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String name) {
        return departmentService.findDepartmentByName(name);
    }
}
