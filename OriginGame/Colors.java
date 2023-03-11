package OriginGame;

public class Colors {
    public static String red(){
        String color = "\u001b[31m";
        return color;
    }
    public static String green(){
        String color = "\u001b[32m";
        return color;
    }
    public static String blue(){
        String color = "\u001b[34m";
        return color;
    }
    public static String gray(){
        String color = "\u001B[37m";
        return color;
    }
    public static String purple(){
        String color = "\u001b[35m";
        return color;
    }
    public static String reset(){
        String color = "\u001b[0m";
        return color;
    }
}
