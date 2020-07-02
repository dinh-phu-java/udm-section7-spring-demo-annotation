package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("myTennisCoach")
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand for volley";
    }
}
