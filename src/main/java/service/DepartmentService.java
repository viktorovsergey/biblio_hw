package service;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee max(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparing(Employee::getWage))
                .orElse(null);
    }
    public Employee min(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparing(Employee::getWage))
                .orElse(null);
    }
    public Collection<Employee> allByDepartment(int department) {
        return employeeService.getEmployee()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService.getEmployee()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }