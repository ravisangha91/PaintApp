
package paintapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;


public class PaintSplash extends JWindow {
    JPanel p;
    JProgressBar jb;

    public PaintSplash() {
        p=new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                try{
            URL urlimg=new URL(this.getClass().getResource("123.jpg"),"123.jpg");
            Image img=ImageIO.read(urlimg);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                 }
                catch(Exception e){}
            }
        };
        
        //try{
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //}
        //catch(Exception e){}
        
        p.setLayout(null);
        jb=new JProgressBar(0,1500);
        jb.setStringPainted(true);
        jb.setForeground(Color.BLUE);
        
        jb.setValue(400);
        jb.setBounds(40,370,420,20);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout());
        this.add(p);
        p.add(jb);
        
    }

    public void iterate(){
        for(int i=0;i<=1500;i+=20)
        {
            jb.setValue(i);
            try{
                Thread.sleep(30);
            }
            catch(Exception e){}
        }
        
    }
}