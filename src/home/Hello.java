package home;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Hello {

    public static void main(String[] args) {

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }

        System.out.println(checkCombination("apple", "pela"));
        System.out.println(checkCombination("apples", "pela"));
        System.out.println(checkCombination("ramo", "omar"));
        System.out.println(checkCombination("ramo", "omaramora"));
        System.out.println(checkCombination("tramo", "omaramora"));

        String str = "ABC";
        int len = str.length();
        System.out.println("All the permutations of the string are: ");
        generatePermutation(str, 0, len);

        LinkedList<Character> ll=new LinkedList<Character>();
        ll.add('o');
        ll.add('r');
        ll.add('o');

        System.out.println("Is palindrome? " + ll.toString() + " " + checkPalindromeList(ll));

        Stack<Integer> sortMe = new Stack<Integer>();
        sortMe.push(2);
        sortMe.push(1);
        sortMe.push(5);
        sortMe.push(8);
        sortMe.push(3);

        System.out.println("Sort the stack " +sortMe.toString());
        sortStackWithStacks(sortMe);

        System.out.println(sortMe.toString());


    }


    /*Checks if the characters on a string are unique (no repeated chars)*/
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /*Check if two strings contains the same characters*/
    public static boolean checkCombination(String a, String b){
        HashMap<Character, Character> mapA = new HashMap<>();
        HashMap<Character, Character> mapB = new HashMap<>();

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        for (Character c: aArray) {
            mapA.put(c, c);
        }
        for (Character c: bArray) {
            mapB.put(c, c);
        }
        return mapA.keySet().equals(mapB.keySet());
    }

    /*Swap the position of left and rigth characters of input string*/
    public static String swapCharacters(String inputString, int left, int rigth) {
        char[] outputString = inputString.toCharArray();
        char iWillBeOnRight;
        iWillBeOnRight = outputString[left];
        outputString[left] = outputString[rigth];
        outputString[rigth] = iWillBeOnRight;
        return String.valueOf(outputString);
    }

    //Function for generating different permutations of the string
    public static void generatePermutation(String str, int start, int end)
    {
        //Prints the permutations
        if (start == end-1)
            System.out.println(str);
        else
        {
            for (int i = start; i < end; i++)
            {
                //Swapping the string by fixing a character
                str = swapCharacters(str,start,i);
                //Recursively calling function generatePermutation() for rest of the characters
                generatePermutation(str,start+1,end);
                //Backtracking and swapping the characters again.
                str = swapCharacters(str,start,i);
            }
        }
    }

    /*Checks if the characters on a linked list are palindrome*/
    public static boolean checkPalindromeList(LinkedList<Character> list){
        if(list.isEmpty()) return false;
        else if (list.size() == 2 && list.peekFirst().equals(list.peekLast())) return true;
        else {
            for (Character c: list) {
                if(!list.isEmpty() && list.size() > 2 && !(list.pollFirst().equals(list.pollLast()))) return false;
                else if (!list.isEmpty() && list.size() == 1) return true;
                else return false;
            }
            return true;
        }
    }

    public static void sortStackWithStacks(Stack<Integer> input){

        if(input.empty()) return;
        if(input.size() == 2) {
            //input.pop() == input.peek();
        }

        Stack<Integer> output = new Stack<Integer>();
        boolean continueSort = true;
        Integer pivot;
        Integer p;

        pivot = input.pop();

        do{
            p = input.pop();
            if (pivot <= p){
                pivot = p;
                continueSort = false;
                output.push(p);
            }else{
                output.push(p);
            }

            if(input.empty()){
                if (continueSort) return;
                else {
                    input = output;
                    output.clear();
                } ; //swap stacks//
            }
        }while(continueSort);
    }
}
