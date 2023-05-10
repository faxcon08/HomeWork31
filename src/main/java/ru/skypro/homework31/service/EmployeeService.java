package ru.skypro.homework31.service;

import ru.skypro.homework31.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public String getSalarySum();

    public String getMinSalary();

    public String getMaxSalary();

    public List<Employee> getEmployeeWithHighSalary();
}
