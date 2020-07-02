package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${phu.email}")
    private String email;

    @Value("${phu.team}")
    private String team;

    public SwimCoach(){}

    @Autowired
    public SwimCoach(@Qualifier("fileFortuneService") FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
