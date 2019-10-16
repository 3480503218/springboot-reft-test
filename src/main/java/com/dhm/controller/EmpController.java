package com.dhm.controller;

import com.dhm.dao.DepartmentDao;
import com.dhm.dao.EmployeeDao;
import com.dhm.entities.Department;
import com.dhm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    //跳转到员工列表
    //@RequestMapping("/Emps")
    @GetMapping("/Emps")
    public String emps(Model model){
        //private String prefix = "classpath:/templates/";
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employee",all);
        return "Emp/list";
    }
//跳转到添加页面
    @GetMapping("/Emp")
    public String emp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
        model.addAttribute("depts",departments);
        return "Emp/add";
    }

    //添加员工
    @PostMapping("/Emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/Emps";
    }

}
