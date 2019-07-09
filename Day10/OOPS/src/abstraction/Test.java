
package abstraction;


public class Test {
    public static void main(String[] args) {
        
        Bank atmCard;
        
        atmCard = new Sakib();
        atmCard.atmBooth();
        
        atmCard = new Tamim();
        atmCard.atmBooth();
        
    }
}
