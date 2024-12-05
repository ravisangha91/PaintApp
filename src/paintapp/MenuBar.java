
package paintapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuBar extends JComponent {
    JMenuBar mb;
    JMenu itm1,itm2,itm3,itm4,itm5;
    JMenuItem m1,m2,m3,m4,m5,m6,m7;
       
    
    public MenuBar() {
        
        mb=new JMenuBar();
        mb.setOpaque(true);
        mb.setPreferredSize(new Dimension(800, 20));
        
        itm1=new JMenu("Menu");
        itm2=new JMenu("Edit");
        itm3=new JMenu("View");
        itm4=new JMenu("Tools");
        itm5=new JMenu("Help");
        
        m1=new JMenuItem("New");
        m2=new JMenuItem("Exit");
        m2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        m3=new JMenuItem("Undo");
        m4=new JMenuItem("Full Screen");
        m5=new JMenuItem("Options");
        m6=new JMenuItem("Help Contents");
        m7=new JMenuItem("About");
                
        
        
        itm1.add(m1);
        itm1.add(m2);
        itm2.add(m3);
        itm3.add(m4);
        itm4.add(m5);
        itm5.add(m6);
        itm5.add(m7);
        
        mb.add(itm1);
        mb.add(itm2);
        mb.add(itm3);
        mb.add(itm4);
        mb.add(itm5);
        
               
        
    }
    
    
}
