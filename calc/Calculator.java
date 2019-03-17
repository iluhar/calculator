package com.hillel.iriazanov.calc;

import com.hillel.iriazanov.calc.actions.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;

public class Calculator {

    private Matcher matcher;
    private Map<String, Action> map;
    private final String regex = "\\s*([\\d.]+)\\s*([+\\-*\\/])\\s*([\\d.]+)\\s*";

    public Calculator()
    {
        map = new HashMap();
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
        map.put("/", new Divide());
        while (true)
        {
            System.out.println("Add new expression:");
            matcher = Pattern.compile(regex).matcher(new Scanner(System.in).nextLine());
            System.out.println(calculate());
        }
    }

    private String calculate()
    {
        return String.valueOf(map.get(matcher.replaceAll("$2"))
                .act(Double.parseDouble(matcher.replaceAll("$1")),
                        Double.parseDouble(matcher.replaceAll("$3"))));
    }

}
