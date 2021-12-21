import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class WatchMovie extends JFrame {
    private ImageIcon imageIcon;
    private JButton[] movieButton=new JButton[24];
    private JMenuBar genreMenuBar;
    private JMenu genreText,qualityText,lockText,backText;
    private JMenuItem[] m=new JMenuItem[8];
    private JMenuItem lockItem,unlockItem,lowQuality,mediumQuality,highQuality,mainMenu;
    MyEventHandler myEventHandler=new MyEventHandler();
    private int highMoney=10,midMoney=5;
    FilmRepo filmRepo=new FilmRepo();
    private String personInfo;
    private String quality;

    public WatchMovie()
    {
        Login login=new Login();
        personInfo= login.getPersonInfo();
        login.dispose();
        System.out.println(personInfo);

        Container c=getContentPane();
        FlowLayout flowLayout=new FlowLayout();
        c.setLayout(flowLayout);

        setSize(1400,800);
        setLocation(100,20);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("All Movies");

        genreMenuBar = new JMenuBar();
        genreText = new JMenu("Genre");
        qualityText = new JMenu("Quality");
        lockText=new JMenu("Parental Controls");
        backText=new JMenu("Main Menu");

        m[0] = new JMenuItem("Action & Adventure");
        m[1] = new JMenuItem("Children & Family");
        m[2] = new JMenuItem("Comedies");
        m[3] = new JMenuItem("Documentaries");
        m[4] = new JMenuItem("Horror");
        m[5] = new JMenuItem("Romantic");
        m[6]= new JMenuItem("Sci-fi & Fantasy");
        m[7]=new JMenuItem("All");

        lockItem=new JMenuItem("Lock");
        unlockItem=new JMenuItem("Unlock");

        lowQuality=new JMenuItem("low quality (480p) $0");
        mediumQuality=new JMenuItem("medium quality (720p60) $2");
        highQuality=new JMenuItem("high quality (1080p60) $5");
        mainMenu=new JMenuItem("Back");
        quality=lowQuality.getText();
        int indx= quality.indexOf('$');
        quality = quality.substring(0,indx);


        int indexOf = personInfo.indexOf(' ');
        String accountType = personInfo.substring(0,indexOf);

        if(accountType.equals("Premium"))
        {
            highQuality.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        quality=highQuality.getText();
                        int indx= quality.indexOf('$');
                        quality = quality.substring(0,indx);
                }
            });
            mediumQuality.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    quality=mediumQuality.getText();
                    int indx= quality.indexOf('$');
                    quality = quality.substring(0,indx);
                }
            });
            lowQuality.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    quality=lowQuality.getText();
                    int indx= quality.indexOf('$');
                    quality = quality.substring(0,indx);
                }
            });

        }

        if(accountType.equals("Standard"))
        {
            highQuality.setBackground(Color.black);
                highQuality.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(highQuality.getBackground()==Color.white) {
                            quality=highQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                            return;
                        }

                        JPanel panel = new JPanel();
                        JLabel label = new JLabel("Pay $5 dollars");
                        panel.add(label);
                        String[] options = new String[]{"Pay", "Cancel"};
                        int option = JOptionPane.showOptionDialog(null, panel, "Upgrade Quality", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                        if(option == 0) { // pressing OK button
                            highQuality.setBackground(Color.white);
                            quality=highQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                        }
                    }
                });
                mediumQuality.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quality=mediumQuality.getText();
                        int indx= quality.indexOf('$');
                        quality = quality.substring(0,indx);
                    }
                });
        }
        if(accountType.equals("Low") || accountType.equals("Free"))
        {
            mediumQuality.setBackground(Color.black);
            highQuality.setBackground(Color.black);
                mediumQuality.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mediumQuality.getBackground()==Color.white)
                        {
                            quality=mediumQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                            return;
                        }

                        JPanel panel = new JPanel();
                        JLabel label = new JLabel("Pay $2 dollars");
                        panel.add(label);
                        String[] options = new String[]{"Pay", "Cancel"};
                        int option = JOptionPane.showOptionDialog(null, panel, "Upgrade Quality", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                        if(option == 0) {// pressing OK button
                            mediumQuality.setBackground(Color.white);
                            quality=mediumQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                        }
                    }
                });
                highQuality.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(highQuality.getBackground()==Color.white)
                        {
                            quality=highQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                            return;
                        }
                        JPanel panel = new JPanel();
                        JLabel label = new JLabel("Pay $5 dollars");
                        panel.add(label);
                        String[] options = new String[]{"Pay", "Cancel"};
                        int option = JOptionPane.showOptionDialog(null, panel, "Upgrade Quality", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                        if(option == 0) {// pressing OK button
                            mediumQuality.setBackground(Color.white);
                            quality=highQuality.getText();
                            int indx= quality.indexOf('$');
                            quality = quality.substring(0,indx);
                        }
                    }
                });
        }
        lowQuality.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quality=lowQuality.getText();
                int indx= quality.indexOf('$');
                quality = quality.substring(0,indx);
            }
        });

        for(int i=0;i<8;i++) {
            genreText.add(m[i]);
            m[i].addActionListener(myEventHandler);
        }
        genreMenuBar.add(genreText);
        genreMenuBar.add(qualityText);
        genreMenuBar.add(lockText);
        genreMenuBar.add(backText);

        lockText.add(lockItem);
        lockText.add(unlockItem);
        qualityText.add(lowQuality);
        qualityText.add(mediumQuality);
        qualityText.add(highQuality);
        backText.add(mainMenu);

        int counter=0;
        Iterator iterator=filmRepo.films.iterator();
        while (iterator.hasNext())
        {
            Films st=(Films)iterator.next();
            imageIcon=st.getImageIcon();
            movieButton[counter]=new JButton(imageIcon);
            c.add(movieButton[counter]);
            counter++;
        }

        //filmlere action listenerlar eklendi
        for (int i = 0; i < movieButton.length; i++)
            movieButton[i].addActionListener(myEventHandler);

        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfterLogin afterLogin=new AfterLogin();
                afterLogin.setVisible(true);
                dispose();
            }
        });

        lockItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lastIndex = personInfo.lastIndexOf(' ');
                String password=personInfo.substring(lastIndex+1,personInfo.length());
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Enter your password:");
                JPasswordField pass = new JPasswordField(20);
                panel.add(label);
                panel.add(pass);
                String[] options = new String[]{"OK", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, panel, "Lock", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if(option == 0) // OK butonuna basarsa
                {
                    char[] getPassword = pass.getPassword();
                    if(password.equals(new String(getPassword)))
                    {
                        int counter=0;
                        Iterator it=filmRepo.films.iterator();
                        while (it.hasNext())
                        {
                            Films st=(Films)it.next();
                            if(st.getLockControl()==false)
                                movieButton[counter].setEnabled(false);
                            counter++;

                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null,"invalid password");
                }
            }
        });
        unlockItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lastIndex = personInfo.lastIndexOf(' ');
                String password=personInfo.substring(lastIndex+1,personInfo.length());
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Enter your password:");
                JPasswordField pass = new JPasswordField(20);
                panel.add(label);
                panel.add(pass);

                String[] options = new String[]{"OK", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, panel, "Unlock", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if(option == 0) // OK butonuna basarsa
                {
                    char[] getPassword = pass.getPassword();
                    if(password.equals(new String(getPassword)))
                    {
                        int counter=0;
                        Iterator it=filmRepo.films.iterator();
                        while (it.hasNext())
                        {
                            Films st=(Films)it.next();
                            movieButton[counter].setEnabled(true);
                            counter++;
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null,"invalid password");
                }
            }
        });
        setJMenuBar(genreMenuBar);
    }
    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == m[0]) {
                setTitle("Action & Adventure");
                int counter=0;
                String title="Action & Adventure";
                Iterator iterator2=filmRepo.films.iterator();
                while (iterator2.hasNext())
                {
                    Films st=(Films)iterator2.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;

                }
            }
            else if (actionEvent.getSource() == m[1]) {
                setTitle("Children & Family");
                int counter=0;
                String title="Children & Family";
                Iterator iterator3=filmRepo.films.iterator();
                while (iterator3.hasNext())
                {
                    Films st=(Films)iterator3.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }

            else if (actionEvent.getSource() == m[2]) {
                setTitle("Comedies");
                int counter=0;
                String title="Comedies";
                Iterator iterator4=filmRepo.films.iterator();
                while (iterator4.hasNext())
                {
                    Films st=(Films)iterator4.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }

            else if (actionEvent.getSource() == m[3]) {
                setTitle("Documentaries");
                int counter=0;
                String title="Documentaries";
                Iterator iterator5=filmRepo.films.iterator();
                while (iterator5.hasNext())
                {
                    Films st=(Films)iterator5.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }
            else if (actionEvent.getSource() == m[4]) {
                setTitle("Horror");
                int counter=0;
                String title="Horror";
                Iterator iterator6=filmRepo.films.iterator();
                while (iterator6.hasNext())
                {
                    Films st=(Films)iterator6.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }
            else if (actionEvent.getSource() == m[5]) {
                setTitle("Romantic");
                int counter=0;
                String title="Romantic";
                Iterator iterator7=filmRepo.films.iterator();
                while (iterator7.hasNext())
                {
                    Films st=(Films)iterator7.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }
            else if (actionEvent.getSource() == m[6]) {
                setTitle("Sci-fi & Fantasy");
                int counter=0;
                String title="Sci-fi & Fantasy";
                Iterator iterator8=filmRepo.films.iterator();
                while (iterator8.hasNext())
                {
                    Films st=(Films)iterator8.next();
                    if(title.equals(st.getGenreName()))
                        movieButton[counter].setVisible(true);
                    else
                        movieButton[counter].setVisible(false);
                    counter++;
                }
            }
            else if (actionEvent.getSource() == m[7]) {
                setTitle("All Movies");
                for (int i = 0 ; i<movieButton.length;i++) {
                    movieButton[i].setVisible(true);
                }
            }
            for (int i=0;i<movieButton.length;i++)
            {
                if(actionEvent.getSource()==movieButton[i])
                {
                    String filmTitleName = new String();
                    int j=0;
                    Iterator iterator9=filmRepo.films.iterator();
                    while (j<i+1 && iterator9.hasNext())
                    {
                        Films st=(Films)iterator9.next();
                        filmTitleName = st.getFilmName();
                        j++;
                    }
                    Player player=new Player(filmTitleName,quality);
                }
            }
        }
    }
}
