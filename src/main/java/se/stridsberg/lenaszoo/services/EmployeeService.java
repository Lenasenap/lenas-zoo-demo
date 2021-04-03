package se.stridsberg.lenaszoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.dao.EmployeeDAO;
import se.stridsberg.lenaszoo.models.Animal;
import se.stridsberg.lenaszoo.models.Employee;
import se.stridsberg.lenaszoo.models.dto.AnimalDTO;
import se.stridsberg.lenaszoo.models.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDAO.getAllEmployees()) {
            Employee employee = mapToEmployee(employeeDTO);
            employees.add(employee);
        }
        return employees;
    }

    public Employee getEmployeeById(Integer id) {
        Optional<EmployeeDTO> maybeEmployee = employeeDAO.findEmployeeByID(id);
        if (maybeEmployee.isPresent()) {
            EmployeeDTO employeeDTO = maybeEmployee.get();
            return mapToEmployee(employeeDTO);
        }
        return null;

    }

    public Employee addEmployee(Employee employee) {
        EmployeeDTO newEmployeeDTO = employeeDAO.addEmployee(mapFromEmployee(employee));
        return mapToEmployee(newEmployeeDTO);

    }

    public void deleteEmployee(Integer id) {
        employeeDAO.deleteEmployee(id);

    }

    public Employee updateEmployee(Employee newEmployee, Integer id) {
        Employee employeeToUpdate = getEmployeeById(id);

        if (employeeToUpdate != null) {
            employeeToUpdate.setName(newEmployee.getName());
            employeeToUpdate.setRole(newEmployee.getRole());
        } else {
            employeeToUpdate.setId(id);
        }
        EmployeeDTO updatedEmployee = employeeDAO.addEmployee(mapFromEmployee(employeeToUpdate));
        return mapToEmployee(updatedEmployee);

    }

    public EmployeeDTO mapFromEmployee(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getRole());
    }

    public Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getRole());
    }
}
