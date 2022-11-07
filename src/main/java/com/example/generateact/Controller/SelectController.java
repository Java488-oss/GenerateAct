package com.example.generateact.Controller;

import com.example.generateact.Entity.EmployeeList.EmployeeList;
import com.example.generateact.Entity.IssuedSmartphones.IssuedSmartphones;
import com.example.generateact.Entity.UserList.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class SelectController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/")
    public String getEmp(Model model) {
        List<EmployeeList> employees = entityManager.createNamedStoredProcedureQuery("GetEmployee").getResultList();
        model.addAttribute("allUsers", employees);

        return "index";
    }

    @GetMapping("/issued")
    public String Issued(Model model) {

//        List<EmployeeList> employees = entityManager.createNamedStoredProcedureQuery("GetEmployee").getResultList();
//
//        employees.forEach(employeeList -> {
//            model.addAttribute("allUsers", employees);
//
//
//        });

        List<IssuedSmartphones> issuedList = entityManager.createNamedStoredProcedureQuery("GetIssuedSmartphones")
                .setParameter("Empl",Long.parseLong("63")).getResultList();

        //Запись в бд
//        boolean ii = entityManager.createNamedStoredProcedureQuery("InsertIssuedSmartphones")
//                .setParameter("Area","ПГУ ГПР")
//                .setParameter("NumAct",1452)
//                .setParameter("Empl",55)
//                .setParameter("Imei1","355523/11/447896/7")
//                .setParameter("Imei2","355524/11/447896/2")
//                .setParameter("DateCreate",new Date())
//                .setParameter("Type","new LocalDate[0]")
//                .setParameter("Reason","new LocalDate[0]")
//                .execute();

        model.addAttribute("issuedList", issuedList);

        return "IssuedSmartphones";
    }

    @RequestMapping(value = "/area", method = RequestMethod.POST)
    public String saveProjectSubmission(Model model, @RequestParam("data") String data) {

        String[] area = data.split(" ");

        List<UserList> UserList = entityManager.createNamedStoredProcedureQuery("GetUser")
                .setParameter("AREA", area[area.length-2]+" "+area[area.length-1]).getResultList();

        //model.addAttribute("allUsers", UserList);
        System.out.println(data);

        return "index";
    }


}
