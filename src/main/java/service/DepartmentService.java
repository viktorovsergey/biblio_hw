package service;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public EmployeeService max(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparing(EmployeeService::getWage))
                .orElse(null);
    }
    public EmployeeService min(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparing(EmployeeService::getWage))
                .orElse(null);
    }
    public Collection<EmployeeService> allByDepartment(int department) {
        return employeeService.getEmployee()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<EmployeeService>> allEmployee() {
        return employeeService.getEmployee()
                .stream()
                .collect(groupingBy(EmployeeService::getDepartment));
    }