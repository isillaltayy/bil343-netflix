import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RenewSubscription extends GUI{
    private JButton premiumButton,standartButton,lowButton,freeButton,backButton;// parentButton,studentButton, familyButton, freeButton,backButton;
    private JLabel subscribeType,paymentType;
    private MyEventHandler myEventHandler=new MyEventHandler();
    private String personInfo;

    public RenewSubscription(){
        super();
        setTitle("Change Payment Options");

        Login login=new Login();
        personInfo= login.getPersonInfo();
        login.dispose();

        //bellekte nesneleri yaratma
        paymentType=new JLabel("Payment Options");
        paymentType.setFont(new Font("Comic Sans",Font.BOLD,25));
        subscribeType=new JLabel("Choose your subscribe type");
        subscribeType.setFont(new Font("Comic Sans",Font.BOLD,25));

        premiumButton=new JButton("Premium account $30 dollars");
        standartButton=new JButton("Standard $20 dollars");
        lowButton=new JButton("Low account $10 dollars");
        freeButton=new JButton("Free account");
        backButton=new JButton("Back");

        //container'a ekleme
        super.getContentPane().add(paymentType);
        super.getContentPane().add(subscribeType);
        super.getContentPane().add(premiumButton);
        super.getContentPane().add(standartButton);
        super.getContentPane().add(lowButton);
        super.getContentPane().add(freeButton);
        super.getContentPane().add(backButton);

        premiumButton.addActionListener(myEventHandler);
        premiumButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        premiumButton.setForeground(Color.WHITE);
        premiumButton.setBackground(Color.gray);
        standartButton.addActionListener(myEventHandler);
        standartButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        standartButton.setForeground(Color.WHITE);
        standartButton.setBackground(Color.gray);
        lowButton.addActionListener(myEventHandler);
        lowButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        lowButton.setForeground(Color.WHITE);
        lowButton.setBackground(Color.gray);
        freeButton.addActionListener(myEventHandler);
        freeButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        freeButton.setForeground(Color.WHITE);
        freeButton.setBackground(Color.gray);
        backButton.addActionListener(myEventHandler);
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);
    }
    //eski personInfo Stringinin textFile'daki line değerini alarak yeni String ile değiştirecek.
    public static void setVariable(int lineNumber, String data) throws IOException {
        Path path = Paths.get("test.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
            int counter=0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            if(actionEvent.getSource()==standartButton) {
                String newPersonInfo= personInfo.replace(personInfo,"Standard"+ " " + "$20 "+ dateFormat.format(date) + " " +personInfo);
                try {
                    FileReader fileReader = new FileReader("test.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //personInfo Stringinin File'daki line değerini bulacak
                    while (!personInfo.equals(bufferedReader.readLine().toString())) {
                        counter++;
                    }
                    fileReader.close();
                    bufferedReader.close();
                }catch (FileNotFoundException fne) {System.out.println(fne);
                }catch (IOException e) {e.printStackTrace();}

                try {
                    setVariable(counter,newPersonInfo);
                }catch (IOException e) {e.printStackTrace();}
                //ekrana bilgi veren mesaj basılmalı
                JOptionPane.showMessageDialog(null,"New Subscription Type is Parent"+ " " + "$20 "+ dateFormat.format(date) +"\n"+ " Old Subscription Type is "+personInfo.substring(0,21));
                JOptionPane.showMessageDialog(null,"Enter your username and password again.");
                Login login=new Login();
                login.setVisible(true);
                dispose();
            }
            else if(actionEvent.getSource()==premiumButton)
            {
                String newPersonInfo= personInfo.replace(personInfo,"Premium"+ " " + "$30 "+ dateFormat.format(date) + " " +personInfo);
                try {
                    FileReader fileReader = new FileReader("test.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //personInfo Stringinin File'daki line değerini bulacak
                    while (!personInfo.equals(bufferedReader.readLine().toString())) {
                        counter++;
                    }
                    fileReader.close();
                    bufferedReader.close();
                }catch (FileNotFoundException fne) {System.out.println(fne);
                }catch (IOException e) {e.printStackTrace();}

                try {
                    setVariable(counter,newPersonInfo);
                }catch (IOException e) {e.printStackTrace();}
                //ekrana bilgi veren mesaj basılmalı
                JOptionPane.showMessageDialog(null,"New Subscription Type is Premium"+ " " + "$30 "+ dateFormat.format(date) +"\n"+ " Old Subscription Type is "+personInfo.substring(0,21));
                JOptionPane.showMessageDialog(null,"Enter your username and password again.");
                Login login=new Login();
                login.setVisible(true);
                dispose();
            }
            else if(actionEvent.getSource()==lowButton){
                String newPersonInfo= personInfo.replace(personInfo,"Low"+ " " + "$10 "+ dateFormat.format(date) + " " + personInfo);

                try {
                    FileReader fileReader = new FileReader("test.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //personInfo Stringinin File'daki line değerini bulacak
                    while (!personInfo.equals(bufferedReader.readLine().toString())) {
                        counter++;
                    }
                    fileReader.close();
                    bufferedReader.close();
                }catch (FileNotFoundException fne) {System.out.println(fne);
                }catch (IOException e) {e.printStackTrace();}

                try {
                    setVariable(counter,newPersonInfo);
                }catch (IOException e) {e.printStackTrace();}
                JOptionPane.showMessageDialog(null,"New Subscription Type is Low"+ " " + "$10 "+ dateFormat.format(date) +"\n"+ " Old Subscription Type is "+personInfo.substring(0,21));
                JOptionPane.showMessageDialog(null,"Enter your username and password again.");
                Login login=new Login();
                login.setVisible(true);
                dispose();
            }
            else if(actionEvent.getSource()==freeButton){
                String newPersonInfo= personInfo.replace(personInfo,"Free"+ " " + "$0 "+ dateFormat.format(date) + " "+personInfo);
                try {
                    FileReader fileReader = new FileReader("test.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //personInfo Stringinin File'daki line değerini bulacak
                    while (!personInfo.equals(bufferedReader.readLine().toString())) {
                        counter++;
                    }
                    fileReader.close();
                    bufferedReader.close();
                }catch (FileNotFoundException fne) {System.out.println(fne);
                }catch (IOException e) {e.printStackTrace();}

                try {
                    setVariable(counter,newPersonInfo);
                }catch (IOException e) {e.printStackTrace();}
                JOptionPane.showMessageDialog(null,"New Subscription Type is Free"+ " " + "$0 "+ dateFormat.format(date) +"\n"+ " Old Subscription Type is "+personInfo.substring(0,21));
                JOptionPane.showMessageDialog(null,"Enter your username and password again.");
                Login login=new Login();
                login.setVisible(true);
                dispose();

            }
            else if (actionEvent.getSource()==backButton)
            {
                AfterLogin afterLogin =new AfterLogin();
                afterLogin.setVisible(true);
                dispose();
            }
        }
    }
}
