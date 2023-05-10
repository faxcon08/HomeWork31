package ru.skypro.homework31.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.homework31.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employeesList = List.of(
            new Employee("Катя",90_000),
            new Employee("Дима",102_000),
            new Employee("Олег", 80_000),
            new Employee("Сергей", 50_000),
            new Employee("Владимир", 85_000),
            new Employee("Вика", 165_000));
@Override
    public List<Employee> getAllEmployee() {
        return employeesList;
    }

    @Override
    public String getSalarySum() {
        return "Sum of Salary = "+employeesList.stream().map(x->x.getSalary()).mapToInt(y->y.intValue()).sum();
    }

    @Override
    public String getMinSalary() {
        return "Min salary= "+employeesList.stream().map(x->x.getSalary()).mapToInt(y->y.intValue()).min();
    }

    @Override
    public String getMaxSalary() {
        return "MAX salary= "+employeesList.stream().map(x->x.getSalary()).mapToInt(y->y.intValue()).max();
    }

    @Override
    public List<Employee> getEmployeeWithHighSalary() {
        OptionalDouble averageSalary = employeesList.stream().map((x)->x.getSalary()).mapToInt(y->y.intValue()).average();
        return employeesList.stream().filter(x->x.getSalary()>=averageSalary.getAsDouble()).collect(Collectors.toList());
    }
}
