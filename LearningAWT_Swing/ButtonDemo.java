package com.awtlearning;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo implements ActionListener{

    JLabel jLabel;

    ButtonDemo(){
        JFrame jfrm = new JFrame("ButtonDemo");
        //set a FlowLayout for the layout manager
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jbtnUp = new JButton("Up");
        JButton jbtnDwn = new JButton("Down");

        //action listeners for buttons
        jbtnUp.addActionListener(this);
        jbtnDwn.addActionListener(this);

        //add the buttons to the content pane
        jfrm.add(jbtnUp);
        jfrm.add(jbtnDwn);

        //create a label
        jLabel = new JLabel("Press a button");

        jfrm.add(jLabel);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Up"))
        {
            jLabel.setText("You Pressed Up");
        }
        else
        {
            jLabel.setText("You pressed down");
        }
    }

    public static  void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
