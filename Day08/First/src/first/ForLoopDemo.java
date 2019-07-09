
package first;

import java.util.ArrayList;


public class ForLoopDemo {

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist  
        list.add("Ravi");//Adding object in arraylist  
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator  

        System.out.println(list);
    }
}
