package com.demoSpring.empservice;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmpserviceIMPL implements EmpService {
    @Autowired
    EmpRepositary emprepo;
    // List<Employee> employees = new ArrayList();

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empentity = new EmpEntity();
        BeanUtils.copyProperties(employee, empentity);
        emprepo.save(empentity);
        // employees.add(employee);
        return "SavedSuccesfully";
    }

    @Override
    public List<EmpEntity> readAllEmployess() {
        return emprepo.findAll();
    }

    @Override
    public Boolean deleteEmployeeID(Long id) {
        // Iterate over the list to find the employee with the given ID
        // EmpEntity empEntity = new EmpEntity();
        // emprepo.findById(id);
        if(emprepo.existsById(id)){
            emprepo.deleteById(id);
            return true;
        }
        return false; // Employee with the given ID not found
    }

    @Override
    public Boolean updatedEmpbyID(Long id, Employee employee) {
        if (emprepo.existsById(id)) {
            EmpEntity empEntity = emprepo.findById(id).get();
            if(employee.getEmail() != null)
            empEntity.setEmail(employee.getEmail());
            if(employee.getName() != null)
            empEntity.setName(employee.getName());
            if(employee.getPhone() != null)
            empEntity.setPhone(employee.getPhone());
            emprepo.save(empEntity);
            return true;
        } else {
            return false; // Employee with the given ID not found
        }
    }

    @Override
    public Employee getEmpbyID(Long id) {
        if (emprepo.existsById(id)) {
            EmpEntity emp = emprepo.findById(id).get();
            Employee employee= new Employee();
            BeanUtils.copyProperties(emp, employee);
            return employee;
        }
        return null;
    }

}
