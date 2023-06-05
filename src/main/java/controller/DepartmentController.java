package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.biblio.Employee;
import service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/Min")
    public Employee minWage(@RequestParam int department) {
        return service.max(department);

    }

    @GetMapping("/Max")
    public Employee maxWage(@RequestParam int department) {
        return service.max(department);
    }

    @GetMapping(value = "/All",params = "department")
        public Collection<Employee> allDepartment(@RequestParam int department) {
        return service.allByDepartment(department);
    }
    @GetMapping("/All")
    public Map<Integer, List<Employee>> all(){
        return service.allEmployee();
    }

}