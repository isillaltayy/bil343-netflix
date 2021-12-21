import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
public class GUI extends JFrame{
    public GUI() {
        Container c=getContentPane();
        GridLayout gy=new GridLayout(8,2,10,10);
        c.setLayout(gy);

        getContentPane().setBackground(new Color(111, 111, 111));//arkaplan renk

        setSize(1400,800);
        setLocation(100,20);
        //setSize(600,400);
        //setLocation(500,200);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
