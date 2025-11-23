package org.example.withoutStream.day2;

public class Palindrome {
    public static void main(String[] args) {
        String string =  "madam";
        String stringBuilder = new StringBuilder(string).reverse().toString();

        if (stringBuilder.equals(string)){
            System.out.println("pallindrom");
        }
        else{
            System.out.println("not pallindrom");
        }
    }
}
