package enums;

public class LevelDemo {

    public static void main(String[] args) {
        Level myVar = Level.MEDIUM; // access one enum


       switch (myVar) {
           case LOW:
               System.out.println("Low level");
               break;
           case MEDIUM:
               System.out.println("Medium level");
               break;
           case HIGH:
               System.out.println("High level");
               break;

       }
    }
}


