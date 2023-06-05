package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

    public class EmployeeController {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping(path = "/add")
        public Employee adding(@RequestParam String lastName, @RequestParam String firstName,
                               @RequestParam int department, @RequestParam int wage) {
            return employeeService.addEmployee(lastName, firstName, department, wage);
        }

        @GetMapping(path = "/remove")
        public Employee remove(@RequestParam String lastName, @RequestParam String firstName) {
            return employeeService.delEmployee(lastName, firstName);
        }

        @GetMapping(path = "/find")
        public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
            return employeeService.findEmployee(lastName, firstName);
        }

        @GetMapping(path = "/all")
        public Collection<Employee> print() {
            return employeeService.getEmployee();
        }


    }

