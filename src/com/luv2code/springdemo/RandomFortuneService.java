package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    //create an array of String
    private String[] data={
            "Java",
            "Spring MVC",
            "Angular",
            "DevOp",
            "Linux",
            "AWS",
            "Cloud"
    };

    //create a random number generator
    private Random myRandom=new Random();

    @Override
    public String getFortune() {
        //pick a random string from array
        int index= myRandom.nextInt(data.length);

        String theFortune=data[index];

        return theFortune;
    }
}
