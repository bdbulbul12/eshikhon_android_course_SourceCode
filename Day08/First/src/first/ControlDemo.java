
package first;

import java.util.Scanner;


public class ControlDemo {
    
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
      
        System.out.print("Enter your marks: ");
        
        int marks = sc.nextInt();
        
        if(marks>=33 && marks<40){
            System.out.println("Your gpa is C ");
        }else if(marks>=40 && marks<50){
            System.out.println("B");
        }else{
            System.out.println("Invalid marks");
        }

    }
    
}
