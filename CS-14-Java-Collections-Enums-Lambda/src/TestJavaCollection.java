import java.util.ArrayList;
import java.util.Iterator;

public class TestJavaCollection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Ravi");
        list.add("Toma");
        list.add("Tim");
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}