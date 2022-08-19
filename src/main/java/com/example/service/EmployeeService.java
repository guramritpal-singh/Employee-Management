package com.example.service;

import com.example.beans.Action;
import com.example.beans.EmployeeDTO;
import com.example.entities.Employee;
import com.example.exceptions.EmployeeNotFoundException;
import com.example.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private int id=05;
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeService() {}

    public EmployeeDTO findEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("No Employee found with " +id+ " Id.");
        }
        return convertToDto(optional.get());
    }

    @Transactional
    public Action saveEmployee(EmployeeDTO emplyeeDTO) {
       Employee employee =  convertToEntity(emplyeeDTO);
        employee.setId(Long.valueOf(id));
        id++;
        employee = employeeRepository.save(employee);
        Action action =  new Action("Save","Employee saved successfully.");
        return action;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employees =  new ArrayList<>();
        for (Employee emp: employeeList) {
            employees.add(convertToDto(emp));
        }
        return employees;
    }

    public Action updateEmployee(Long id, EmployeeDTO newEmployeeDTO) {

        Optional <Employee> optional = employeeRepository.findById(id);
        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("No Employee found with " +id+ " Id.");
        }
                optional.map(employee -> {
                   // employee.setId(id);
                    employee.setFirstName(newEmployeeDTO.getFirstName());
                    employee.setLastName(newEmployeeDTO.getLastName());
                    employee.setRole(newEmployeeDTO.getRole());
                    return employeeRepository.save(employee);
                        });
        Action action =  new Action("update","Employee updated Successfully.");
        return action;
    }

    public Action deleteEmployee(Long id) {
        Optional <Employee> optional = employeeRepository.findById(id);
        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("No Employee found with " +id+ " Id.");
        }
        Action action =  new Action("delete","Employee deleted Successfully.");
        employeeRepository.deleteById(id);
        return action;
    }

    private EmployeeDTO convertToDto(Employee employee) {
       return modelMapper.map(employee, EmployeeDTO.class);
    }


    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        return  modelMapper.map(employeeDTO, Employee.class);
    }

}
