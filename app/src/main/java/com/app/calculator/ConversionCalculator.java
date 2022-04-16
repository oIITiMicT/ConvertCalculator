package com.app.calculator;

import java.util.ArrayList;

public class ConversionCalculator {

    public ConversionCalculator() {

    }

    private char getCode(int value, int requestNotation) {
        return value % requestNotation > 9 ? (char) (value % requestNotation + 7 + '0') : (char) (value % requestNotation + '0');
    }

    private char getNumber(char now) {
        return (char) (now > '9' ? now - '0' - 7 : now - '0');
    }

    String convert(String parentValue, int parentNotation, int requestNotation) {
        int value = normalize(parentValue, parentNotation);
        ArrayList<Character> tmp = new ArrayList<>();
        while (value > 0) {
            tmp.add(getCode(value, requestNotation));
            value /= requestNotation;
        }
        StringBuilder result = new StringBuilder();
        for (int i = tmp.size() - 1; i >= 0; i--) {
            char now = tmp.get(i);
            result.append(now);
        }
        return result.toString();
    }

    private int normalize(String parentValue, int parentNotation) {
        int result = 0, power = 1;
        for (int i = parentValue.length() - 1; i >= 0; i--) {
            result += getNumber(parentValue.charAt(i)) * power;
            power *= parentNotation;
        }
        return result;
    }
}
