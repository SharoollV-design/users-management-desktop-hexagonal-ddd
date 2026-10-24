package com.jcaa.usersmanagement.domain.specification;

import com.jcaa.usersmanagement.domain.model.Examen;

public class ExamenValidoSpecification implements  Specification<Examen> {

    @Override 
    public boolean isSatisfiedBy(Examen examen){
        if (examen == null){
            return false;
        }

        double valorPonderacion = examen.getPonderacion();
        return valorPonderacion > 0.0 && valorPonderacion <= 100.0;
    }
    
}