package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        String a = "z";
        String b = "w";
        String c = "u";
        String d = "p";
        String e = "x";
        String f = "q";

        boolean dziala = checkInput(a, b, c, d, e, f);
        if (!dziala)
            System.out.println("siema");
    }

    public static boolean checkInput(String a, String b, String c, String d, String e, String f) {

        String words = a + b + c + d + e + f;
        for (int i = 0; i < words.length(); i++) {

            for (int j = 1 + i; j < words.length(); j++) {

                if (words.charAt(i) == words.charAt(j)) {
                    return false;
                }
            }
        }
        return true;

    }
}