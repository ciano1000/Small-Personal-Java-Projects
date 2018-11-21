package com.awtlearning;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {


    public SwingDemo()
    {
        //create a new Jframe container
        JFrame jfrm = new JFrame("A simple swing application");
        //Give the frame an initial size
        jfrm.setSize(500,500);
        //terminate program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create a text based label
        JLabel jlab = new JLabel("Some bullshit");
        //Add the label to the frame
        jfrm.add(jlab);
        //Display the frame
        jfrm.setVisible(true);
    }

    public static  void main(String args[])
    {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingDemo();
            }
        });
    }
}
