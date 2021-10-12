package codility;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Triangle extends JPanel {

public void paint(Graphics g) {
    g.drawLine(10, 10, 40, 10);
}

  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        Arrays.sort(arr);
        
        if (arr[0]+arr[1]>arr[2]){
            System.out.println("It's a triangle!");
            JFrame f = new JFrame("Monsieur triangle");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             f.getContentPane().add(new Triangle());
             f.setSize(290, 325);
             f.setLocation(550, 25);
             f.setVisible(true);
             }
             
        else{
            System.out.println("Oi nah");
        }
        
    }
}
