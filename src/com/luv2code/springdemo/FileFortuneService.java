package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService{
    private String fileName="fortune-data.txt";
    private List<String> theFortunes;

    private Random myRandom=new Random();

    public FileFortuneService(){
        File theFile=new File(fileName);

        System.out.println("Read data from file: "+fileName);
        System.out.println("File exist: "+theFile.exists());

        theFortunes=new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader(theFile))){
            String tempLine;
            while( (tempLine=reader.readLine())!=null){
                theFortunes.add(tempLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index=myRandom.nextInt(theFortunes.size());
        String tempString=theFortunes.get(index);
        return tempString;
    }
}
