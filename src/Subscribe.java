import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscribe extends GUI{
    private JButton parentButton,studentButton, premiumButton, freeButton,backButton;
    private JLabel subscribeType,paymentType,paymentType2;
    private MyEventHandler myEventHandler=new MyEventHandler();

    public Subscribe() {
        super();
        setTitle("Payment Options");

        //bellekte nesneleri yaratma
        paymentType=new JLabel("INFORMATION: After choosing your account, you can change your subscription type. ");
        paymentType.setFont(new Font("Comic Sans",Font.BOLD,20));
        paymentType2=new JLabel("If you choose a low package, you can upgrade the screen quality for a fee.");
        paymentType2.setFont(new Font("Comic Sans",Font.BOLD,20));

        subscribeType=new JLabel("Choose your subscribe type");
        subscribeType.setFont(new Font("Comic Sans",Font.BOLD,20));

        premiumButton=new JButton("Premium account $30 dollars (1080p60)");
        premiumButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        premiumButton.setForeground(Color.WHITE);
        premiumButton.setBackground(Color.gray);
        parentButton=new JButton("Standard account $20 dollars (720p60)");
        parentButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        parentButton.setForeground(Color.WHITE);
        parentButton.setBackground(Color.gray);
        studentButton=new JButton("Low account $10 dollars (480p)");
        studentButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        studentButton.setForeground(Color.WHITE);
        studentButton.setBackground(Color.gray);
        freeButton=new JButton("Free account (480p)");
        freeButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        freeButton.setForeground(Color.WHITE);
        freeButton.setBackground(Color.gray);
        backButton=new JButton("Back");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);

        //container'a ekleme
        super.getContentPane().add(paymentType);
        super.getContentPane().add(subscribeType);
        super.getContentPane().add(premiumButton);
        super.getContentPane().add(parentButton);
        super.getContentPane().add(studentButton);
        super.getContentPane().add(freeButton);
        super.getContentPane().add(backButton);
        super.getContentPane().add(paymentType2);

        premiumButton.addActionListener(myEventHandler);
        parentButton.addActionListener(myEventHandler);
        studentButton.addActionListener(myEventHandler);
        freeButton.addActionListener(myEventHandler);
        backButton.addActionListener(myEventHandler);
    }

    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println("Current Date " + dateFormat.format(date));
            if(actionEvent.getSource()==parentButton) {
                try {
                    FileWriter fw = new FileWriter("test.txt",true);
                    fw.write("Parent"+ " " + "$20 "+ dateFormat.format(date) + " ");
                    fw.close();
                }catch (IOException ie){ie.printStackTrace();
                }catch (Exception e){e.printStackTrace();}

                Signup signup =new Signup();
                signup.setVisible(true);
                dispose();
            }
            else if(actionEvent.getSource()==premiumButton)
            {

                try {
                    FileWriter fw = new FileWriter("test.txt",true);
                    fw.write("Premium"+ " " + "$30 "+ dateFormat.format(date) + " ");
                    fw.close();
                }catch (IOException ie){ie.printStackTrace();
                }catch (Exception e){e.printStackTrace();}

                Signup signup =new Signup();
                signup.setVisible(true);
            }
            else if(actionEvent.getSource()==studentButton){
                try {
                    FileWriter fw = new FileWriter("test.txt",true);
                    fw.write("Student" + " " + "$10 "+ dateFormat.format(date) + " ");
                    fw.close();
                }catch (IOException ie){ie.printStackTrace();
                }catch (Exception e){e.printStackTrace();}

                Signup signup =new Signup();
                signup.setVisible(true);
                dispose();
            }
            else if(actionEvent.getSource()==freeButton){
                try {
                    FileWriter fw = new FileWriter("test.txt",true);
                    fw.write("Free" + " " + "$0 "+ dateFormat.format(date) + " ");
                    fw.close();
                }catch (IOException ie){ie.printStackTrace();
                }catch (Exception e){e.printStackTrace();}

                Signup signup =new Signup();
                signup.setVisible(true);
                dispose();
            }
            else if (actionEvent.getSource()==backButton)
            {
                FirstPage firstPage=new FirstPage();
                firstPage.setVisible(true);
                dispose();
            }
        }
    }
}
