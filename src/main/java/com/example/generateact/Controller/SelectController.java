package com.example.generateact.Controller;

import com.example.generateact.Entity.EmployeeList.EmployeeList;
import com.example.generateact.Entity.IssuedSmartphones.IssuedSmartphones;
import com.example.generateact.Entity.Test;
import com.example.generateact.Entity.UserList.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.PrinterJob;
import java.util.Date;
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

        List<IssuedSmartphones> issuedList = entityManager.createNamedStoredProcedureQuery("GetIssuedSmartphones").getResultList();

        model.addAttribute("issuedList", issuedList);

        return "IssuedSmartphones";
    }

    @RequestMapping(value = "/inAct", method = RequestMethod.POST)
    public String inAct(Model model, @RequestParam String fio, String imei1, String imei2, int numAct) {

        String[] fioArr =fio.split(" ");

        List<UserList> UserList = entityManager.createNamedStoredProcedureQuery("GetUser")
                .setParameter("AREA", fioArr[fioArr.length-2]+" "+fioArr[fioArr.length-1]).getResultList();

        //Запись в бд
        entityManager.createNamedStoredProcedureQuery("InsertIssuedSmartphones")
                .setParameter("Area",fioArr[fioArr.length-2]+" "+fioArr[fioArr.length-1])
                .setParameter("NumAct",numAct)
                .setParameter("Empl",fioArr[0]+" "+fioArr[1]+" "+fioArr[2])
                .setParameter("Imei1",imei1)
                .setParameter("Imei2",imei2)
                .setParameter("DateCreate",new Date())
                .setParameter("Type","Выдача")
                .setParameter("Reason","")
                .execute();

        return "IssuedSmartphones";
    }

    @RequestMapping(value = "/outAct", method = RequestMethod.POST)
    public String outAct(Model model, @RequestParam String fio, String imei1, String imei2, int numAct, String reason) {

        String[] fioArr =fio.split(" ");

        List<UserList> UserList = entityManager.createNamedStoredProcedureQuery("GetUser")
                .setParameter("AREA", fioArr[fioArr.length-2]+" "+fioArr[fioArr.length-1]).getResultList();

        //Запись в бд
        entityManager.createNamedStoredProcedureQuery("InsertIssuedSmartphones")
                .setParameter("Area",fioArr[fioArr.length-2]+" "+fioArr[fioArr.length-1])
                .setParameter("NumAct",numAct)
                .setParameter("Empl",fioArr[0]+" "+fioArr[1]+" "+fioArr[2])
                .setParameter("Imei1",imei1)
                .setParameter("Imei2",imei2)
                .setParameter("DateCreate",new Date())
                .setParameter("Type","Сдача")
                .setParameter("Reason",reason)
                .execute();

        return "IssuedSmartphones";
    }


}
