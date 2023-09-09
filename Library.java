
package Common;

import java.util.Random;
import java.util.Scanner;


public class Library {
    public int getInt(String promt, int m, int n) {
        int a = -1;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(promt + ":");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if(a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter number again between " + m + "and" + n + ":");
            }
        }
        return a;
        
    }
    
    
    public int[] createArr(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        for(int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }
    
    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(i < array.length - 1) {
                System.out.println(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
        System.out.println("");
    }

    
}
