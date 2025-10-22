package step4;

import java.util.*;

class DivideByZeroException extends Exception{
    DivideByZeroException(String msg){
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;

            if(a==0){
                throw new DivideByZeroException("Divide by Zero");
            }
            //int[] c = { 1 };
            //c[42] = 99;
        } catch(DivideByZeroException e){
            System.out.println(e);
        }  
        catch(ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array oob: " + e);
        } finally{
            System.out.println("finally");
        }
    }
}
