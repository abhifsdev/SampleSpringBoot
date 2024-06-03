package com.demoSpring.empservice;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EMPcontroller {
    // List<Employee> employees = new ArrayList();
    @Autowired
    EmpService empservicepro ;
    // EmpService empservicepro = new EmpserviceIMPL();

    @GetMapping("employee")
    public List<EmpEntity> getAllEmp() {

        return empservicepro.readAllEmployess();
    }
    @GetMapping("employee/{id}")
    public Employee getEmpbyID(@PathVariable Long id) {

        return empservicepro.getEmpbyID(id);
    }

    @PostMapping("employee")
    public String createEmp(@RequestBody Employee employee) {
        
        return empservicepro.createEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public String  delteEmployee(@PathVariable Long id){
        if(empservicepro.deleteEmployeeID(id))
        return "Delete Successfully";
        else return "Not Found";
    }

    @PutMapping("employee/{id}")
    public String updateEmp(@PathVariable Long id, @RequestBody Employee employee) {
        if(empservicepro.updatedEmpbyID(id,employee))
        return "Update Successfully";
        else return "Not Found";
    }

}
