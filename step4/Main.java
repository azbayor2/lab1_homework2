package step4;

import java.util.*;

class DivideByZeroException extends Exception{
    DivideByZeroException(){
    
    }

    @Override
    public String toString(){
        return "Divide by Zero exception";
    }
}

class doMath{
    static int divide(int a, int b) throws Exception{
        if(b==0) throw new DivideByZeroException();

        return a/b;
    }
}

// class User{
//     public User(int age){
//         if(age<0) throw new DivideByZeroException();
//     }
// }

public class Main {
    public static void main(String[] args) {
        try {
            //int a = 0;
            //int b = 42 / a;

            // if(a==0){
            //     throw new DivideByZeroException("Divide by Zero");
            // }
            // int[] c = { 1,2,3 };
            // c[42] = 99;

            doMath.divide(10,0);
        }

        //catch(DivideByZeroException e){
        //     System.out.println(e);
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        catch(ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array oob: " + e);
        }
        catch(Exception e){
            System.out.println("예외발생: "+ e);
        }
        finally{
            System.out.println("finally");
        }
    }
}
