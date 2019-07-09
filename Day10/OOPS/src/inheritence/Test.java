
package inheritence;


public class Test {
    public static void main(String[] args) {
        
        Son s = new Son();
        
        s.setCar(10);
        s.setLand(20);
       
        System.out.println(s.getCar());
        System.out.println(s.getLand());
    }
}
