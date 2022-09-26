package app.service;

import app.exception.EmployeeException;
import app.model.Employee;
import app.repository.EmployeeRepository;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

public class EmployeeService {

    public static EmployeeRepository employeeRepository;


    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    public List<Employee> getAll() {
        return employeeRepository.findAllEmployees();
    }

    public List<Employee> getByDepId(int depId) {
        return employeeRepository.findByDepId(depId);
    }

    public Employee getById(String id) {
        if (id == null) {
            throw new EmployeeException("employee id mast not be null");
        }
        return getById(Integer.parseInt(id));
    }

    public Employee getById(int id) {
        return employeeRepository.findById(id);
    }

    public int create(Employee employee) {
        List<ConstraintViolation> violations  = new Validator().validate(employee);
        if(!violations.isEmpty()) {
            throw new EmployeeException(violations);
        }
        return employeeRepository.create(employee);
    }

    public int update(Employee employee){
        List<ConstraintViolation> violations  = new Validator().validate(employee);
        if(!violations.isEmpty()) {
            throw new EmployeeException(violations);
        }
        return employeeRepository.update(employee);
    }
    public void delete(String id){
        if (id == null){
            throw new EmployeeException("employee id mast not be null");
    }
        delete(Integer.parseInt(id));

}
    public  void delete(int id) {
        Employee employee = getById(id);
        if( employee == null){
            throw new EmployeeException("cannot find employee with id " + id);
        }
        employeeRepository.delete(id);
    }

}
