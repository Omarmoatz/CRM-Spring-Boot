package com.crm.crud.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {
    
    @Before("execution(public void doAnyThing())")
    public void beforeCreatingEmployee(){
        System.out.println(" =======> ----Before beforeCreatingEmployee methods---------------------------------");
    }
}
