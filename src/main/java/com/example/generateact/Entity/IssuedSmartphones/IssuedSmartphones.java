package com.example.generateact.Entity.IssuedSmartphones;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NamedStoredProcedureQuery(name = "GetIssuedSmartphones", procedureName = "GetIssuedSmartphones",
        resultClasses = IssuedSmartphones.class)
//, parameters = {@StoredProcedureParameter(name = "Empl", mode = ParameterMode.IN, type = Long.class) })

//Запись в бд
@NamedStoredProcedureQuery(name = "InsertIssuedSmartphones", procedureName = "InsertIssuedSmartphones", resultClasses = IssuedSmartphones.class, parameters = {
        @StoredProcedureParameter(name = "Area", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "NumAct", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "Empl", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "Imei1", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "Imei2", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "DateCreate", mode = ParameterMode.IN, type = Date.class),
        @StoredProcedureParameter(name = "Type", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "Reason", mode = ParameterMode.IN, type = String.class)

})

public class IssuedSmartphones {

    public IssuedSmartphones() {
    }

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private int NumAct;
    private int EmplId;
    private String Imei1;
    private String Imei2;
    private String FIO;
    private String Area;
    private LocalDate DateCreate;
    private String Type;
    private String Reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumAct() {
        return NumAct;
    }

    public void setNumAct(int numAct) {
        NumAct = numAct;
    }

    public String getImei1() {
        return Imei1;
    }

    public void setImei1(String imei1) {
        Imei1 = imei1;
    }

    public String getImei2() {
        return Imei2;
    }

    public void setImei2(String imei2) {
        Imei2 = imei2;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public LocalDate getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        DateCreate = dateCreate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public int getEmplId() {
        return EmplId;
    }

    public void setEmplId(int emplId) {
        EmplId = emplId;
    }
}
