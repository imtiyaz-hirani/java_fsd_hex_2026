package com.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DemoTest {
    Demo demo = new Demo();
    @Test
    public void sumTest(){
        Assertions.assertEquals(5, demo.sum(2,3));
        Assertions.assertEquals(1, demo.sum(-2,3));
        Assertions.assertEquals(-5, demo.sum(-2,-3));
        Assertions.assertEquals(0, demo.sum(0,0));
    }

    @Test
    public void computeGradeTest(){
        // prepare the input
        List<Double> student1 = List.of(96d,94.5d,78d,85d);
        List<Double> student2 = List.of(96d,94.5d,178d,85d);
        List<Double> student3 = List.of(96d,94.5d,78d,-15d);
        List<Double> student4 = List.of(66d,64.5d,78d,60d);
        List<Double> student5 = List.of(56d,64.5d,58d,50d);
        // Use Case : Grade A
        Assertions.assertEquals("A", demo.computeGrade(student1));
        // Use Case : Grade B
        Assertions.assertEquals("B", demo.computeGrade(student4));
        // Use Case : Grade C
        Assertions.assertEquals("C", demo.computeGrade(student5));
        // Use Case : Marks > 100 exception
        RuntimeException e =  Assertions.assertThrows(RuntimeException.class, ()->demo.computeGrade(student2));
        Assertions.assertEquals("Subject Marks > 100 detected.", e.getMessage());
        // Use Case : negative exception
        RuntimeException e1 =  Assertions.assertThrows(RuntimeException.class, ()->demo.computeGrade(student3));
        Assertions.assertEquals("Subject Marks < 0 detected.", e1.getMessage());
    } //JIRA 3345
}
