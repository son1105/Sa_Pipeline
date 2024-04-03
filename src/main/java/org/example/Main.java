package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Function<String, Integer[]> initArr = s -> initArr(s);
//        Function<Integer[], Integer[]> daoHam = s-> differentiatePolynomial(s);
//        Function<Integer[], String> toString = s -> finalStep(s);
//        Function<Integer[], String> pipeline = daoHam.andThen(toString);
//        Integer[] arr = {1,2,3,4,5}; // x^4 + 2x^3 + 3x^2 + 4x + 5
//        String result = pipeline.apply(arr);
//        System.out.println("result: "+ result);


        Function<String, List<String>> mang = s -> initArr(s);
        Function<List<String>, List<String>> daoHam = s -> differentiatePolynomial(s);
        Function<List<String>, String> toString = s -> finalStep(s);
        Function<String, List<String>> pipeline = mang
//                .andThen(daoHam)
//                .andThen(toString)
        ;
        List<String> result = pipeline.apply("5x^3 - 6x^4 + 6x^9 + 7x + 2");
        System.out.println("result: "+ result);
    }

    private static String finalStep(List<String> s) {
        String result = "";
        for(String str : s)
            result+= str + " + ";
        return result.substring(0,result.lastIndexOf("+ ")-1);
    }

    private static List<String> differentiatePolynomial(List<String> s) {
        List<String> result = new ArrayList<>();
        s.forEach(str -> result.add(differentiate(str)));
        return result;
    }

    private static List<String> initArr(String s) {
        return List.of(s.split(" + "));
    }

//    private static Integer[] initArr(String s) {
//        List<Integer> result = new ArrayList<>();
//        int begin = 0;
//        int end = s.indexOf("x")-1;
//        result.add(Integer.parseInt(s.substring(begin,end)));
//        s = s.substring(end+1);
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }

//    private static String finalStep(Integer[] s) {
//        String result = "";
//        for (int i = 0; i < s.length ; i++) {
//            if(i != s.length - 1){
//                result += s[i] + "x^" + (s.length - i - 1);
//                result += " + ";
//            }
//            else if (i == s.length - 1)
//                result += s[i];
//            else if (i == s.length -2)
//                result += s[i] + "x";
//        }
//        return result;
//    }



    private static String differentiate(String s){
//        Integer[] result = new Integer[s.length-1];
//        for (int i = 0; i <= s.length -2; i++) {
//            result[i] = s[i] * (s.length - i - 1);
//        }
//        return result;

        // 4x^2
        if(s.indexOf("x")==-1) return "";
        if(s.indexOf("^")==-1) return s.substring(0, s.indexOf("x")-1);
        int heSo = Integer.parseInt(s.substring(0, s.indexOf("x")-1));
        int soMu = Integer.parseInt(s.substring(s.indexOf("x")+2));
        return heSo*soMu+"x^"+(soMu-1);
    }
}