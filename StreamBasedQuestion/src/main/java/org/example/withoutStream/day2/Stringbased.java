package org.example.withoutStream.day2;

public class Stringbased {
    public static void main(String[] args) {
        String string =  "Anil";
        int index=0;
        int length = string.length();
        char[] str= new char[length];
        for(int i=length-1;i>=0;i--){
            str[index] = string.charAt(i);
            index++;

        }
        System.out.println(str);
    }
}
