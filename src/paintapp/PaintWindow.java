
package paintapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class PaintWindow extends MenuBar {
    JFrame f;
    JPanel pt,pt1;
    PadDraw drawPad;
    JToolBar toolbar;
           
    
    
    public PaintWindow() {
        
        f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setJMenuBar(mb);
        toolbar=new JToolBar();
                       
        
        pt=new JPanel();
        pt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pt1=new JPanel();
        pt1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pt1.setPreferredSize(new Dimension(100,200));
        
           
        
        drawPad=new PadDraw();
        drawPad.setPreferredSize(new Dimension(900, 600));
        drawPad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
                               
                      
        
                
        Container content = f.getContentPane();
        content.setLayout(new BorderLayout());
        
                        
        content.add(pt, BorderLayout.SOUTH);
        content.add(pt1, BorderLayout.WEST);
        content.add(drawPad, BorderLayout.CENTER);
               
                  
        pt1.add(toolbar);     
        
        
        
        f.setVisible(true);
        f.pack();
        f.setTitle("Paint");
        f.setResizable(true);
        
        
        
        pt.setBackground(Color.DARK_GRAY);
        pt1.setBackground(Color.LIGHT_GRAY);
           
              
        
        makeColorButton(Color.WHITE);
        makeColorButton(Color.ORANGE);
        makeColorButton(Color.CYAN);
        makeColorButton(Color.YELLOW);
        makeColorButton(Color.BLUE);
        makeColorButton(Color.MAGENTA);
        makeColorButton(Color.RED);
        makeColorButton(Color.GREEN);
        makeColorButton(Color.BLACK);
        makeColorButton(Color.PINK);
        makeColorButton(Color.LIGHT_GRAY);
        
        JRadioButton thinButton = new JRadioButton(new ImageIcon(PaintWindow.class.getResource("line1_16_16.gif")));
    thinButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.thin();
            }
        });
    JRadioButton mediumButton = new JRadioButton(new ImageIcon(PaintWindow.class.getResource("line3_16_16.gif")));
    mediumButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.medium();
            }
        });
    JRadioButton thickButton = new JRadioButton(new ImageIcon(PaintWindow.class.getResource("line5_16_16.gif")));
    thickButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.thick();
            }
        });
        
        //the above three buttons are for the thickness
    
        JButton sprayButton = new JButton(new ImageIcon(PaintWindow.class.getResource("Spray.png")));
        sprayButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.spray();
            }
        });
        sprayButton.setPreferredSize(new Dimension(36, 36));
        
        
        JButton zoomIn =new JButton(new ImageIcon(PaintWindow.class.getResource("zoom.png")));
        zoomIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.zoomIn();
            }
        });
        zoomIn.setPreferredSize(new Dimension(36, 36));
        
        
        JButton zoomOut =new JButton(new ImageIcon(PaintWindow.class.getResource("zoomout.png")));
        zoomOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.zoomOut();
            }
        });
        zoomOut.setPreferredSize(new Dimension(36, 36));
        
        
        JButton bucketButton = new JButton(new ImageIcon(PaintWindow.class.getResource("fill-icon.png")));
        bucketButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.bucket();
            }
        });
        bucketButton.setPreferredSize(new Dimension(36, 36));
        
        
        JButton eraseButton = new JButton(new ImageIcon(PaintWindow.class.getResource("eraser.png")));
        //creates the eraser button and sets the text as "Eraser"
        eraseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        drawPad.erase();
            }
        });
        eraseButton.setPreferredSize(new Dimension(36, 36));
        
        JButton rectButton = new JButton(new ImageIcon(PaintWindow.class.getResource("rect1.png")));
        rectButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
               drawPad.rect();
              }
          });
        rectButton.setPreferredSize(new Dimension(36, 36));
          
          JButton rect2Button = new JButton(new ImageIcon(PaintWindow.class.getResource("rectangle.png")));
        rect2Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               drawPad.rect2();
              }
          });
        rect2Button.setPreferredSize(new Dimension(36, 36));
          
          JButton ovalButton = new JButton(new ImageIcon(PaintWindow.class.getResource("hollow-circle.png")));
          ovalButton.addActionListener(new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent e){
                  drawPad.oval();
                  
              }
          });
          ovalButton.setPreferredSize(new Dimension(36, 36));
          
          JButton oval2Button = new JButton(new ImageIcon(PaintWindow.class.getResource("circle-32.png")));
          oval2Button.addActionListener(new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent e){
                  drawPad.oval2();
                
              }
          });
          oval2Button.setPreferredSize(new Dimension(36, 36));
            
          JButton penButton = new JButton(new ImageIcon(PaintWindow.class.getResource("pencil_1.png")));
        penButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.pen();
                drawPad.thin();
                drawPad.changeColor(Color.GRAY);
            }
        });
        penButton.setPreferredSize(new Dimension(36, 36));
        
        JButton brushButton = new JButton(new ImageIcon(PaintWindow.class.getResource("painbrush.png")));
        brushButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.brush();
                drawPad.medium();
              }
        });
        brushButton.setPreferredSize(new Dimension(36, 36));
        
          JButton lineButton = new JButton(new ImageIcon(PaintWindow.class.getResource("Line.png")));
        lineButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.line();
            }
        });
        lineButton.setPreferredSize(new Dimension(36, 36));
        
        JButton polygonButton = new JButton(new ImageIcon(PaintWindow.class.getResource("poly.png")));
        polygonButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPad.polygon();
            }
        });
        polygonButton.setPreferredSize(new Dimension(36, 36));

        //creates the clear button
    JButton clearButton = new JButton(new ImageIcon(PaintWindow.class.getResource("clear.png")));
    clearButton.addActionListener(new ActionListener()
    {
        
    @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPad.clear();
        }
        });
        clearButton.setPreferredSize(new Dimension(36,36));
        clearButton.setToolTipText("Click to clear the Canvas");
        
        
                
        ButtonGroup lineOption = new ButtonGroup();
        lineOption.add(thinButton);
        lineOption.add(mediumButton);
        lineOption.add(thickButton);  
        
        
        toolbar.setFloatable(false);
        toolbar.setRollover(false);
        toolbar.setLayout(new GridLayout(7, 2));
        
        toolbar.add(eraseButton);
        toolbar.add(penButton);
        toolbar.add(lineButton);
        toolbar.add(rectButton);
        toolbar.add(rect2Button);
        toolbar.add(ovalButton);
        toolbar.add(oval2Button);
        toolbar.add(polygonButton);
        toolbar.add(sprayButton);
        toolbar.add(bucketButton);
        toolbar.add(brushButton);
        toolbar.add(clearButton);
        toolbar.add(zoomIn);
        toolbar.add(zoomOut);
        pt1.add(thickButton);
        pt1.add(mediumButton);
        pt1.add(thinButton);
        
        
    }
    
    
    
    public void makeColorButton(final Color color)
    {
        JButton tempButton = new JButton();
        tempButton.setBackground(color);
        tempButton.setPreferredSize(new Dimension(20, 20));
        pt.add(tempButton);
        tempButton.addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPad.changeColor(color);
        }
        });
        
        
    }
    
    
    
    
    
}
