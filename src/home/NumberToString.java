package home;

import java.util.HashMap;
import java.util.Map;

public class NumberToString {

    static HashMap<Integer, String> units = new HashMap<>();
    static String zero = "zero";
    static String negative = "minus ";
    static String ten = "ten";

    public static void initUnits(){
        units.put(0, "");
        units.put(1, "one");
        units.put(2, "two");
        units.put(3, "three");
        units.put(4, "four");
        units.put(5, "five");
        units.put(6, "six");
        units.put(7, "seven");
        units.put(8, "eight");
        units.put(9, "nine");

        units.put(10, "teen");

        units.put(11, "eleven");
        units.put(12, "twelve");
        units.put(13, "thirteen");

        //Prefixes 10
        units.put(20, "twenty ");
        units.put(30, "thirty ");
        units.put(40, "forty ");
        units.put(50, "fifty ");
        units.put(60, "sixty ");
        units.put(70, "seventy ");
        units.put(80, "eighty ");
        units.put(90, "ninety ");

        units.put(100, "hundred");
        units.put(1000, "thousand");
        units.put(1000000, "million");
    }

    public static void main(String... args){

        initUnits();
        System.out.println(numberConverter(-99));
        /*System.out.println(numberConverter(0));
        System.out.println(numberConverter(1));
        System.out.println(numberConverter(10));
        System.out.println(numberConverter(13));
        System.out.println(numberConverter(15));*/

        System.out.println(numberConverter(20));
        System.out.println(numberConverter(21));
        System.out.println(numberConverter(30));
        System.out.println(numberConverter(33));
        System.out.println(numberConverter(40));
        System.out.println(numberConverter(49));
        System.out.println(numberConverter(50));
        System.out.println(numberConverter(58));
        System.out.println(numberConverter(66));
        System.out.println(numberConverter(88));
        System.out.println(numberConverter(90));
        System.out.println(numberConverter(99));
        System.out.println(numberConverter(100));
        System.out.println(numberConverter(101));
        System.out.println(numberConverter(300));

        System.out.println(numberConverter(555));

        System.out.println(numberConverter(900));
        System.out.println(numberConverter(999));

        System.out.println(numberConverter(1002));
        System.out.println(numberConverter(5555));
        System.out.println(numberConverter(5005));
        System.out.println(numberConverter(9999));

        System.out.println(numberConverter(-9999));

    }

    public static String numberConverter(int input){

        //Dumb brute force
        String output = "";
        //Single digits
        if(input == 0) return zero;
        if (input < 0){
            output += negative;
            input = input * -1;
        }

        //Special cases
        if(input < 10 ) return units.get(input);
        if(input == 10) return output += ten;
        if(input == 11 || input == 12 || input == 13) return units.get(input);
        //10
        if(input < 20){
            int digit = input % 10;
            return output += units.get(digit) + units.get(10);
        }
        //20
        if(input < 30){
            int digit = input % 20;
            if(digit == 0) return output += units.get(20);
            else return output += units.get(20) + units.get(digit);
        }
        //30's
        if(input < 40){
            int digit = input % 30;
            if(digit == 0) return output += units.get(30);
            else return output += units.get(30) + units.get(digit);
        }

        if(input < 50){
            int digit = input % 40;
            if(digit == 0) return output += units.get(40);
            else return output += units.get(40) + units.get(digit);
        }

        if(input < 60){
            int digit = input % 50;
            if(digit == 0) return output += units.get(50);
            else return output += units.get(50) + units.get(digit);
        }

        if(input < 70){
            int digit = input % 60;
            if(digit == 0) return output += units.get(60);
            else return output += units.get(60) + units.get(digit);
        }

        if(input < 80){
            int digit = input % 70;
            if(digit == 0) return output += units.get(70);
            else return output += units.get(70) + units.get(digit);
        }

        if(input < 90){
            int digit = input % 80;
            if(digit == 0) return output += units.get(80);
            else return output += units.get(80) + units.get(digit);
        }

        if(input < 100){
            int digit = input % 90;
            if(digit == 0) return output += units.get(90);
            else return output += units.get(90) + units.get(digit);
        }

        if(input < 1000){
            int digit = input / 100;
            if(input == 100 ) return output += "one hundred";
            else return output += units.get(digit) + " hundred " + numberConverter( input - digit*100);
        }

        if(input < 1000000){
            int digit = input / 1000;
            if(input == 1000 ) return output += "one thousand";
            else return output += units.get(digit) + " thousand "
                    + numberConverter( input - digit*1000) ;
                    //+ numberConverter( input - digit*100);
        }
        return output;
    }
}
