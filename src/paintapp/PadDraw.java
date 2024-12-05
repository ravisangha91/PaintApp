
package paintapp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import sun.java2d.loops.FillPath;


public class PadDraw extends JComponent {
    Image image;
    Graphics2D graphics2D;
    int currentX,currentY,oldX,oldY,bx,by,brx,bry,sX,sY,x1,y1,x2,y2,w,h,a1,a2,b1,b2,c1,d1,c2,d2,e1,f1,e2,f2,r1,s1,ch,m1,n1,fl,k1,k2=1,cc1,dd1,cc2,dd2,aa1,aa2,bb1,bb2;;
        
    //public PadDraw() {
        public void pen()
    {
        k1=16;
        setDoubleBuffered(false);
        cursorchange();
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        //if the mouse is pressed it sets the oldX & oldY
        //coordinates as the mouses x & y coordinates
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                currentX = e.getX();
                currentY = e.getY();
                if(graphics2D != null && k1==16)
                    graphics2D.drawLine(oldX, oldY, currentX,currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
                repaint();
            }
 
        });
}
        
        public void brush()
    {
        k1=13;
        setDoubleBuffered(false);
        cursorchange();
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                brx = e.getX();
                bry = e.getY();
            }
        });
        //if the mouse is pressed it sets the oldX & oldY
        //coordinates as the mouses x & y coordinates
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                bx = e.getX();
                by = e.getY();
                if(graphics2D != null && k1==13)
                    graphics2D.drawLine(brx, bry, bx,by);
                    brx = bx;
                    bry = by;
                    repaint();
                
            }
 
        });
}
        
        //spray tool
        public void spray() {
            k1=10;
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    sX = e.getX();
                    sY = e.getY();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    int nRand = (int)(Math.random()*10);
                    double dTheta = Math.random()*628/100.0;
                    int nX = (int)(sX + nRand * Math.cos(dTheta));
                    int nY = (int)(sY + nRand * Math.sin(dTheta));
                    sX = e.getX();
                    sY = e.getY();
                    if(graphics2D != null && k1==10)
                    graphics2D.fillOval(nX, nY, 2, 2);
                    
                    repaint();
                }
            });
            addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    repaint();
                }
            });
        }
        
       
        //bucket tool
        public void bucket() {
            k1=11;
            setDoubleBuffered(false);
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        currentX=e.getX();
                        currentY=e.getY();
                        if(graphics2D != null && k1==11)
                        graphics2D.fillRect(currentX, currentY, getWidth(), getHeight());
                        repaint();
                    }
                    public void mouseReleased(MouseEvent e) {
                    repaint();
                }
            
                });
                
        }

        
        public void zoomIn() {
            k1=12;
            setDoubleBuffered(false);
                addMouseWheelListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        
                    }
                });
        }
        
        public void zoomOut() {
            k1=14;
            setDoubleBuffered(false);
                addMouseWheelListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        
                    }
                });
        }
        
        
        
public void line()
{
    k1=2;
setDoubleBuffered(false);
cursorchange();
        addMouseListener(new MouseAdapter()
        
          {
               public void mousePressed(MouseEvent m)
               {
               x1=m.getX();
               y1=m.getY();
               }
               public void mouseReleased(MouseEvent m)
               {
               x2=m.getX();
               y2=m.getY();               
                if(graphics2D != null && k1==2)
                graphics2D.drawLine(x1,y1, x2,y2);
                repaint();
             
            }
          });
}

 
public void rect()
        {
            k1=3;
            setDoubleBuffered(false);
            cursorchange();
                  addMouseListener(new MouseAdapter()
          {
             
               public void mousePressed(MouseEvent m)
               {
               a1=m.getX();
               b1=m.getY();
               repaint();
               }
        
               public void mouseReleased(MouseEvent m)
               {
               a2=m.getX();
               b2=m.getY();
                 if (a1>a2)
                 {
                int z=a1;
                 a1=a2;
                 a2=z;
                }
                if (b1>b2)
                 {
                int z=b1;
                 b1=b2;
                 b2=z;
                }
                w=a2-a1;
                h=b2-b1;
                if(graphics2D != null && k1==3)
                graphics2D.drawRect(a1,b1, w,h);
                    repaint();
                
}
          });
        
      }
 
      
      public void rect2()
        {
            k1=4;
            setDoubleBuffered(false);
            cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent m)
               {
               aa1=m.getX();
               bb1=m.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent m)
               {
               aa2=m.getX();
               bb2=m.getY();
                 if (aa1>aa2)
                 {
                int z=aa1;
                 aa1=aa2;
                 aa2=z;
                }
                if (bb1>bb2)
                 {
                int z=bb1;
                 bb1=bb2;
                 bb2=z;
                }
                w=aa2-aa1;
                h=bb2-bb1;
                if(graphics2D != null && k1==4)
                graphics2D.fillRect(aa1,bb1, w,h);
                    repaint();
                
}
          });
        
      }
 
      
      public void oval()
      {
          k1=5;
        setDoubleBuffered(false);
        cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent e)
               {
               c1=e.getX();
               d1=e.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent e)
               {
               c2=e.getX();
               d2=e.getY();
                 if (c1>c2)
                 {
                int z=c1;
                 c1=c2;
                 c2=z;
                }
                if (d1>d2)
                 {
                int z=d1;
                 d1=d2;
                 d2=z;
                }
                w=c2-c1;
                h=d2-d1;
                if(graphics2D != null && k1==5)
                    graphics2D.drawOval(c1,d1,w,h);
                repaint();
                }
          });
        }
        
        
        public void oval2()
      {
          k1=6;
        setDoubleBuffered(false);
        cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent m)
               {
               cc1=m.getX();
               dd1=m.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent m)
               {
               cc2=m.getX();
               dd2=m.getY();
                 if (cc1>cc2)
                 {
                int z=cc1;
                 cc1=cc2;
                 cc2=z;
                }
                if (dd1>dd2)
                 {
                int z=dd1;
                 dd1=dd2;
                 dd2=z;
                }
                w=cc2-cc1;
                h=dd2-dd1;
                if(graphics2D != null && k1==6)
                    graphics2D.fillOval(cc1,dd1, w,h);
                    repaint();
                }
          });
        }
        
        
        
        
        public void polygon()
{
    k1=8;
    k2=1;
setDoubleBuffered(false);
cursorchange();
        addMouseListener(new MouseAdapter()
        
          {
               public void mousePressed(MouseEvent m)
               {
               x1=m.getX();
               y1=m.getY();
               }
         final int r1=x1;
         final int s1=y1;
               public void mouseReleased(MouseEvent m)
               {
               x2=m.getX();
               y2=m.getY();
               if (x2==r1 && y2==s1)
               { graphics2D.drawLine(m1,n1, r1,s1);
               return;
            }
               else
               {
                   if(graphics2D != null && k1==8 && k2==1)
                    graphics2D.drawLine(x1,y1, x2,y2);
               
                if(graphics2D != null && k1==8 && k2!=1)
                graphics2D.drawLine(m1,n1, x2,y2);
                repaint();
                m1=x2;
                n1=y2;
                k2++;
                
            }
            
            }
          });
}
 
 
        //while the mouse is dragged it sets currentX & currentY as the mouses x and y
        //then it draws a line at the coordinates
        //it repaints it and sets oldX and oldY as currentX and currentY
        
    public void paintComponent(Graphics g){
        if(image == null){
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D)image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
 
        }
        g.drawImage(image, 0, 0, null);
    }
    //this is the painting bit
    //if it has nothing on it then
    //it creates an image the size of the window
    //sets the value of Graphics as the image
    //sets the rendering
    //runs the clear() method
    //then it draws the image
 
 
    public void clear()
    {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }
    //this is the clear
    //it sets the colors as white
    //then it fills the window with white
    //thin it sets the color back to black
    
    
    
     public void erase()
    {
        k1=1;
        
        cursorchange();
        graphics2D.setPaint(Color.white);
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                e1 = e.getX();
                f1 = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                e2 = e.getX();
                f2 = e.getY();
                if(graphics2D != null && k1==1)
                graphics2D.drawLine(e1, f1, e2, f2);
                repaint();
                e1 = e2;
                f1 = f2;
            }
        });
 
}
 
 
public void cursorchange()
{
  if (k1==25)
        {
            
        Toolkit toolkit = Toolkit.getDefaultToolkit();  
        Image img = toolkit.getImage("eraser.png"); 
        Point hotSpot = new Point(0,0);  
        Cursor cursor = toolkit.createCustomCursor(img, hotSpot, "Eraser");  
        setCursor(cursor);  
}
        
else 
setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 
}
 
// changing the cursor icons
 
 
public void open()
{
 
 
                
        
}
 
public void save()
{
   
   
   
        }  
     
    
 
 
 
 
public void thick(){
        graphics2D.setStroke(new BasicStroke (12));
}
public void thin(){
        graphics2D.setStroke(new BasicStroke (1));
}
public void medium(){
        graphics2D.setStroke(new BasicStroke (6));
}
//thickness
    
    public void changeColor(Color theColor){
        graphics2D.setPaint(theColor);
        repaint();
    }
    
    
        
        
    
    
    
}
