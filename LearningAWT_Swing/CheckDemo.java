package com.awtlearning;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckDemo implements  ItemListener {

    JLabel jSelected;
    JLabel jChanged;
    JCheckBox jAlpha;
    JCheckBox jBeta;
    JCheckBox jGamma;

    public CheckDemo()
    {
        JFrame jfrm = new JFrame("CheckBox Demo");
        jfrm.setLayout(new FlowLayout());

        jfrm.setSize(500,500);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jSelected = new JLabel("");
        jChanged = new JLabel("");

        jAlpha = new JCheckBox("Alpha");
        jBeta = new JCheckBox("Beta");
        jGamma = new JCheckBox("Gamma");

        jAlpha.addItemListener(this);
        jBeta.addItemListener(this);
        jGamma.addItemListener(this);

        jfrm.add(jAlpha);
        jfrm.add(jBeta);
        jfrm.add(jGamma);
        jfrm.add(jChanged);
        jfrm.add(jSelected);

        jfrm.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";
        JCheckBox cb = (JCheckBox)e.getItem();

        if(cb.isSelected())
            jChanged.setText(cb.getText()+" was selected");
        else
            jChanged.setText(cb.getText()+" was cleared");

        if(jAlpha.isSelected())
        {
            str+="Alpha ";
        }
        if(jBeta.isSelected())
        {
            str+="Beta ";
        }
        if(jGamma.isSelected())
        {
            str+="Gamma ";
        }

        jSelected.setText("Selected check boxes: "+str);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckDemo();
            }
        });
    }
}
