package com.awtlearning;
import javax.print.DocFlavor;
import java.awt.*;
import java.applet.*;

public class SimpleApplet extends Applet implements  Runnable{

    String msg = "Java rules the web";
    Thread t;
    boolean stopFlag;

    @Override
    public void init()
    {
        t = null;
    }

    @Override
    public void start()
    {
        t= new Thread(this);
        stopFlag = false;
        t.start();
    }

    @Override
    public void run()
    {
        for(;;)
        {
            try{
                repaint();
                Thread.sleep(250);
                if(stopFlag)
                {
                    break;
                }
            }catch (InterruptedException exc){}
        }
    }

    @Override
    public void stop()
    {
        stopFlag = true;
        t =null;
    }

    @Override
    public void paint(Graphics g)
    {
        char ch = msg.charAt(0);
        msg = msg.substring(1,msg.length());
        msg+=ch;
        g.drawString(msg,50,30);
        showStatus("heeyyyyyyy");
    }

}
