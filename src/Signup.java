import javax.naming.ldap.PagedResultsControl;
import javax.swing.*; // Buttons, text fields, ...
import java.awt.*; // Container, Color,
import java.awt.event.*;//ActionListener
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Signup extends GUI{
    private JButton enrollButton,backButton;
    private JLabel nameLabel,surnameLabel,userNameLabel,passwordLabel,passwordLabel2;
    private JTextField nameText,surnameText,userNameText;
    private JPasswordField passwordField,passwordField2;

    public Signup() {
        super();

        nameLabel=new JLabel("Name:");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
        surnameLabel=new JLabel("Surname:");
        surnameLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
        userNameLabel=new JLabel("Username");
        userNameLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordLabel=new JLabel("Password");
        passwordLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordLabel2=new JLabel("Password Again");
        passwordLabel2.setFont(new Font("Comic Sans",Font.BOLD,25));

        nameText=new JTextField(20);
        nameText.setFont(new Font("Comic Sans",Font.BOLD,25));
        nameText.setForeground(Color.WHITE);
        nameText.setBackground(Color.gray);
        surnameText=new JTextField(20);
        surnameText.setFont(new Font("Comic Sans",Font.BOLD,25));
        surnameText.setForeground(Color.WHITE);
        surnameText.setBackground(Color.gray);
        userNameText=new JTextField(20);
        userNameText.setFont(new Font("Comic Sans",Font.BOLD,25));
        userNameText.setForeground(Color.WHITE);
        userNameText.setBackground(Color.gray);
        passwordField=new JPasswordField(20);
        passwordField.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.gray);
        passwordField2=new JPasswordField(20);
        passwordField2.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordField2.setForeground(Color.WHITE);
        passwordField2.setBackground(Color.gray);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);
        enrollButton=new JButton("Enroll");
        enrollButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        enrollButton.setForeground(Color.WHITE);
        enrollButton.setBackground(Color.gray);

        super.getContentPane().add(nameLabel);
        super.getContentPane().add(nameText);
        super.getContentPane().add(surnameLabel);
        super.getContentPane().add(surnameText);
        super.getContentPane().add(userNameLabel);
        super.getContentPane().add(userNameText);
        super.getContentPane().add(passwordLabel);
        super.getContentPane().add(passwordField);
        passwordField.setEchoChar('*');
        super.getContentPane().add(passwordLabel2);
        super.getContentPane().add(passwordField2);
        passwordField2.setEchoChar('*');
        super.getContentPane().add(enrollButton);
        super.getContentPane().add(backButton);



        backButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //setVisible(false);
                        dispose();
                        Subscribe subscribe=new Subscribe();
                        subscribe.setVisible(true);
                    }
                }
        );


        enrollButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        String userName=nameText.getText();
                        String userSurname=surnameText.getText();
                        String username=userNameText.getText();
                        String password=passwordField.getText();
                        String password2=passwordField2.getText();


                        if (userName.isEmpty() || userSurname.isEmpty() || username.isEmpty()|| password.isEmpty() || password2.isEmpty() ) {
                            JOptionPane.showMessageDialog(null,"Please fill in the blanks.");
                        }
                        else if (!password.equals(password2)) {
                            JOptionPane.showMessageDialog(null,"Sorry, your passwords do not match. Please try again.");
                        }
                        else if(password.length()<8)
                        {
                            JOptionPane.showMessageDialog(null,"Password must be longer than 8 characters");
                        }
                        else {
                            try {
                                int idNumber=(int)(Math.random()*((999999-100000)+1))+100000;
                                FileWriter fw = new FileWriter("test.txt",true);
                                fw.write(idNumber+ " " + username + " " + password);
                                fw.append("\n");
                                fw.close();
                            } catch (Exception e) {System.out.println(e);}

                            FirstPage firstPage=new FirstPage();
                            firstPage.setVisible(true);
                            //setVisible(false);
                            dispose();
                        }
                    }
                }
        );
    }
}
