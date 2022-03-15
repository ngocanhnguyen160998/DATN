package com;

public class test {
    public static void main(String[] args) {
        String reg = "[^\\s\"()]{1,}";
        String x = "abc)";
        System.out.println(x.matches(reg));
    }
}
