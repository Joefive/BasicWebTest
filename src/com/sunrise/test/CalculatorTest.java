package com.sunrise.test;

import com.sunrise.junit.Calculator;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void sumTest() {
        System.out.println("我执行成功了...!");
        Calculator c = new Calculator();
        int sum = c.sum(1, 2);
        System.out.println("sum : " + sum);

    }
}
