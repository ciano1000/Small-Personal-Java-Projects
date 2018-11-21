package com.awtlearning;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo implements ActionListener{

    JTextField jtf;
    JButton jbtnRev;
    JLabel jPrompt,jContents;

    public TextDemo(){
        JFrame jfrm = new JFrame("TextDemo");

        jfrm.setLayout(new FlowLayout());

        jfrm.setSize(500,500);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);

        jtf.setActionCommand("myTF");

        jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jPrompt = new JLabel("Enter text: ");
        jContents = new JLabel("");

        jfrm.add(jPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jContents);

        jfrm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reverse")){
            String orgStr = jtf.getText();
            String resStr = "";
            for(int i = orgStr.length()-1;i>=0;i--)
            {
                resStr += orgStr.charAt(i);
            }
            jtf.setText(resStr);
        }
        else{
            jContents.setText("You pressed ENTER. Text is: "+jtf.getText());
        }

    }

    public static  void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextDemo();
            }
        });
    }
}
