package org.example.withoutStream.day2;

public class ReverseString {
    public static void main(String[] args) {
        String string =  "hello";
        char[] charArray = string.toCharArray();
        StringBuilder builder = new StringBuilder(string);
        builder.reverse();
        System.out.println(builder);
        StringBuilder builder1 = new StringBuilder();
        for (int i=string.length(); i>0;i--){
            builder1.append(charArray[i-1]);
        }
        System.out.println(builder1);
    }
}
