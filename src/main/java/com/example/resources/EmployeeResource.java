package com.example.resources;

import com.example.beans.Action;
import com.example.beans.EmployeeDTO;
import com.example.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "employee", description = "API to perform operations on Employee resource")
public class EmployeeResource {
    @Autowired
    private EmployeeService service ;

   /* @ApiOperation(value = "/employees/{id}", notes="find employee", response = Employee.class)*/
    @GetMapping(value = "/employees/{id}",  produces = "application/json")
    public EmployeeDTO findEmployee(@PathVariable Long id) {
        return service.findEmployeeById(id);
    }

    @PostMapping(value = "/employees/save", produces = "application/json")
    public Action newEmployee(@RequestBody EmployeeDTO newEmployeeDTO) {
        return service.saveEmployee(newEmployeeDTO);
    }


    @PutMapping(value = "/employees/{id}", produces = "application/json")
   public Action updateEmployee(@RequestBody EmployeeDTO newEmployeeDTO, @PathVariable Long id) {
        return service.updateEmployee(id, newEmployeeDTO);
    }

    @DeleteMapping(value="/employees/{id}", produces = "application/json")
    public Action deleteEmployee(@PathVariable Long id) {
       return service.deleteEmployee(id);
    }

    @GetMapping(value="/employees/all", produces = "application/json")
    public List<EmployeeDTO> all() {
        return service.getAllEmployees();
    }
}
