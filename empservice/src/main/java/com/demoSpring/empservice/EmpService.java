package com.demoSpring.empservice;

import java.util.List;

// import org.springframework.stereotype.Service;

public interface EmpService {

    String createEmployee(Employee employee);

    List<EmpEntity> readAllEmployess();

    Boolean deleteEmployeeID(Long id);

    Boolean updatedEmpbyID(Long id,Employee employee);

    Employee getEmpbyID(Long id);

}
