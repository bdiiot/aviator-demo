package com.bdiiot.aviator.java.main;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

public class MainJava {
    public static void main(String[] args) {
        String expression = "((1 != 1) || (2 == 2)) && 3 == 3";
        System.out.println(AviatorEvaluator.execute(expression));
        // true

        String yourName = "World!";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourName", yourName);
        System.out.println(AviatorEvaluator.execute("'Hello ' + yourName", env));
        // Hello World!

        System.out.println(AviatorEvaluator.exec("'Hello ' + yourName", yourName));
        // Hello World!

        expression = "status == 0 && user_id != 10646 && order_id != 10648";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        env = new HashMap<String, Object>();
        env.put("status", 0);
        env.put("user_id", 10000);
        env.put("order_id", 10000);
        System.out.println(compiledExp.execute(env));
        // true
    }
}
