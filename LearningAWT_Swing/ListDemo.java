package com.awtlearning;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo implements ListSelectionListener {

    JList<String> jList;
    JLabel jLab;
    JScrollPane jsccrlp;

    String names[] = {"Sherry","James","Dylan","Gearoid","Connor","Shteve","Peter","Kevin"};

    ListDemo()
    {
        JFrame jfrm = new JFrame("ListDemo");

        jfrm.setLayout(new FlowLayout());

        jfrm.setSize(500,500);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList = new JList<>(names);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jsccrlp = new JScrollPane(jList);

        jsccrlp.setPreferredSize(new Dimension(200,400));

        jLab = new JLabel("Please choose a name");

        jList.addListSelectionListener(this);

        jfrm.add(jsccrlp);
        jfrm.add(jLab);

        jfrm.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int idx = jList.getSelectedIndex();

        if(idx != -1)
        {
            jLab.setText("Current Selection: "+names[idx]);
        }
        else{
            jLab.setText("Please choose a name");
        }
    }

    public  static  void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListDemo();
            }
        });
    }
}
