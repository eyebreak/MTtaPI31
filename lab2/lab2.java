package lab2;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) { 
        tree(args);
        System.out.println();
        massiv();
    }

    public static void massiv () {
        int[][] arr = new int[3][6];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j-1] + 3;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void paint (int space, int star) {
        int o;
    
        for (o=0; o<space; o++) {
            System.out.print(" ");
        }
        for (o=0; o<star; o++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void tree(String[] args) {
        Scanner console = new Scanner(System.in);
        {
            System.out.print("Enter high of tree: ");
            int height = console.nextInt(); //ввести висоту ялинки 
            int i;

            for (i=1; i<=height; i++) {
            paint(height - i, i*2 - 1);
            }
        }
        console.close(); 
    }
}