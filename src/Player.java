import javax.swing.*;
import java.awt.*;

public class Player extends JFrame {
    private String filmName;
    private ImageIcon imageIcon;
    private JLabel player,hd;
    private String quality;

    public Player(String filmName,String quality)
    {
        this.filmName=filmName;
        this.quality=quality;
        Container c=getContentPane();
        c.setLayout(null);
        imageIcon=new ImageIcon(getClass().getResource("films/player.jpg"));
        player = new JLabel(imageIcon);
        hd=new JLabel(quality);
        hd.setFont(new Font("Comic Sans",Font.BOLD,20));
        player.setSize(1200,600);
        player.setLocation(60,40);

        hd.setSize(300,50);
        hd.setLocation(1,2);

        c.add(hd);
        c.add(player);


        setSize(1400,800);
        setLocation(100,20);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle(filmName);
    }
}
