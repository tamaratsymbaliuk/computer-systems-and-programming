package enums;

public class LevelDemo {
    Level myVar = Level.MEDIUM; // access one enum

    public static void main(String[] args) {


        for (Level myVar : Level.values()) { // loop through all enum values
            System.out.println(myVar);

        }
    }
}


