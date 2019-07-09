
package polymorphisim;


public class Test {
    public static void main(String[] args) {
        Animal a;
        
        a = new Cat();
        a.sound();
        
        a = new Dog();
        a.sound();
        
        
    }
}
