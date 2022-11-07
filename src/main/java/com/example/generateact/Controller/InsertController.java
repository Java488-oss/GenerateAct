package com.example.generateact.Controller;

import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class InsertController {
    @PersistenceContext
    private EntityManager entityManager;
}
