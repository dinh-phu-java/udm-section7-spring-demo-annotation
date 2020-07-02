package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

//    @Autowired
//    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println(">>Tennis Coach: inside default constructor");
    }

    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService){
//        System.out.println(">> Tennis Coach: inside setFortuneService() method");
//        this.fortuneService=fortuneService;
//    }


//    @Autowired
//    public TennisCoach(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }



    @Override
    public String getDailyWorkout() {
        return "Practice your backhand for volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
