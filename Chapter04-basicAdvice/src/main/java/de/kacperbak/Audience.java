package de.kacperbak;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(** de.kacperbak.Performance.randomPerformance(..))")
    public void randomPerformance(){ }

    @Pointcut("execution(** de.kacperbak.Performance.controlledPerformance(..))")
    public void controlledPerformance(){ }

    @Before("randomPerformance()")
    public void takeSeats(){
        System.out.println("Taking seats.");
    }

    @Before("randomPerformance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones.");
    }

    @AfterReturning("randomPerformance()")
    public void applause(){
        System.out.println("CLAP! CLAP! CLAP!");
    }

    @AfterThrowing("randomPerformance()")
    public void demandRefund(){
        System.out.println("Demanding a refund.");
    }

    @Around("controlledPerformance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("Taking seats.");
            System.out.println("Silencing cell phones.");
            joinPoint.proceed();
            System.out.println("CLAP! CLAP! CLAP!");
        } catch(Throwable e){
            System.out.println("Demanding a refund.");
        }
    }
}
