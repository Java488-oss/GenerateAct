package com.example.generateact.Entity.UserList;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(name = "GetUser", procedureName = "GetUser", resultClasses = {
        UserList.class }, parameters = {
        @StoredProcedureParameter(name = "AREA", mode = ParameterMode.IN, type = String.class) })
public class UserList {

    public UserList() {
    }
    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long USER_ID;
    private String ROLE_DESCRIPTION;
    private String USER_LOGIN;
    private String AREA_DESCR_SHORT;

    public Long getUSER_ID() {
        return USER_ID;
    }

    public String getROLE_DESCRIPTION() {
        return ROLE_DESCRIPTION;
    }

    public String getUSER_LOGIN() {
        return USER_LOGIN;
    }

    public String getAREA_DESCR_SHORT() {
        return AREA_DESCR_SHORT;
    }
}
