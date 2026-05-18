package com.service;

import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public int sum(int x, int y){
        return x+y;
    }

    public String computeGrade(List<Double> list){
        //validate input
        list.forEach(mark-> {
            if(mark > 100) throw new RuntimeException("Subject Marks > 100 detected.");
            if(mark < 0 ) throw new RuntimeException("Subject Marks < 0 detected.");
        });

        // compute total marks
         double totalMarks = list.size()* 100;

        // compute percent
        // double marksSecured = list.stream().collect(Collectors.summingDouble((m)->m)).doubleValue();
        double marksSecured = list.stream().mapToDouble((m)-> m).sum();
        double percent = (marksSecured / totalMarks) * 100;

        // compute grade
        if(percent > 75)
            return "A";
        if(percent > 60)
            return "B";

        return "C";
    }
}
