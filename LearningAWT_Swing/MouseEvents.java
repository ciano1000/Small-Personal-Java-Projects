package com.awtlearning;

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0,mouseY =0;

    public void init()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //handle mouse clicked
    public void mouseClicked(MouseEvent me)
    {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse clicked";
        repaint();
    }

    //handle mouse entered
    public void mouseEntered(MouseEvent me)
    {
        mouseX = 0;
        mouseY = 10;
        msg="Mouse Entered";
        repaint();
    }
    public void mouseExited(MouseEvent me)
    {
        mouseY = 10;
        mouseX = 0;
        msg = "Mouse Exited";
        repaint();
    }
    public void mousePressed(MouseEvent me)
    {
        mouseX = me.getX();
        mouseY = me.getY();
        msg="Down";
        repaint();
    }
    public void mouseReleased(MouseEvent me)
    {
        mouseX = me.getX();
        mouseY = me.getY();
        msg="Released";
        repaint();
    }
    public void mouseDragged(MouseEvent me)
    {
        mouseX = me.getX();
        mouseY = me.getY();
        msg="*";
        showStatus("Dragging mouse at"+mouseX+","+mouseY);
        repaint();
    }

    public void mouseMoved(MouseEvent me)
    {
        mouseY = me.getY();
        mouseX = me.getX();
        showStatus("Moving mouse at"+mouseX+","+mouseY);
    }

    public void paint(Graphics g)
    {
        g.drawString(msg,mouseX,mouseY);
    }
}
