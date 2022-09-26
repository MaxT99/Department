package app.service;

import app.exception.DepartmentException;
import app.model.Department;
import app.repository.DepartmentRepository;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService() {
        departmentRepository = new DepartmentRepository();
    }

    public ArrayList<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(int id) {
        return departmentRepository.findById(id);
    }


    public int create(Department department) {
        List<ConstraintViolation> violations  = new Validator().validate(department);
        if(!violations.isEmpty()) {
            throw new DepartmentException(violations);
        }
        return departmentRepository.create(department);
    }

    private void validate(Department department) {
        if (StringUtils.isBlank(department.getName())) {
            throw new DepartmentException("Department name has");
        }
        if (StringUtils.isBlank(department.getAddress())) {
            throw  new DepartmentException("Address has to be filled");
        }
        if (StringUtils.isBlank(department.getDescription())) {
            throw  new DepartmentException("Description has be filled");
        }
    }

    public void update(Department department) {
        List<ConstraintViolation> violations  = new Validator().validate(department);
        if(!violations.isEmpty()) {
            throw new DepartmentException(violations);
        }
        departmentRepository.update(department);
    }

    public void delete(int id) {
        departmentRepository.delete(id);
    }

}
