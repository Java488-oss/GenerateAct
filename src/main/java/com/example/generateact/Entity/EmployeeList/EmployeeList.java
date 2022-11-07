package com.example.generateact.Entity.EmployeeList;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(name = "GetEmployee", procedureName = "GetEmployee", resultClasses = EmployeeList.class)
public class EmployeeList {

    public EmployeeList() {
    }

    @Id
    @Column(name = "EmplId", nullable = false)
    private Long EmplId; //1
    private String FIO; //2
    private int EmplTabnum; //3

    private String AREA_DESCR_SHORT; //4
    private String PROF_DESCR; //5

    public Long getEmplId() {
        return EmplId;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPROF_DESCR() {
        return PROF_DESCR;
    }

    public int getEmplTabnum() {
        return EmplTabnum;
    }

    public String getAREA_DESCR_SHORT() {
        return AREA_DESCR_SHORT;
    }
}
