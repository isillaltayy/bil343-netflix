import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends GUI{
    private JLabel usernameLabel,passwordLabel;
    private JTextField usernameText;
    private JButton login,backButton;
    private JPasswordField passwordField;

    MyEventHandler myEventHandler=new MyEventHandler();
    private static String personInfo;
    public void setPersonInfo(String personInfo)
    {
        this.personInfo=personInfo;
    }
    public String getPersonInfo()
    {
        return personInfo;
    }


    public Login()
    {
        super();
        setTitle("Login Page");

        usernameLabel=new JLabel("Username");
        usernameLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordLabel=new JLabel("Password");
        passwordLabel.setFont(new Font("Comic Sans",Font.BOLD,25));

        usernameText=new JTextField(20);
        usernameText.setFont(new Font("Comic Sans",Font.BOLD,25));
        usernameText.setForeground(Color.WHITE);
        usernameText.setBackground(Color.gray);
        passwordField=new JPasswordField(20);
        passwordField.setFont(new Font("Comic Sans",Font.BOLD,25));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.gray);

        login=new JButton("Login");
        login.setFont(new Font("Comic Sans",Font.BOLD,25));
        login.setForeground(Color.WHITE);
        login.setBackground(Color.gray);
        backButton=new JButton("Back");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);

        super.getContentPane().add(usernameLabel);
        super.getContentPane().add(usernameText);
        super.getContentPane().add(passwordLabel);
        super.getContentPane().add(passwordField);
        passwordField.setEchoChar('*');
        super.getContentPane().add(login);
        super.getContentPane().add(backButton);

        login.addActionListener(myEventHandler);
        backButton.addActionListener(myEventHandler);



    }
    public class MyEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            if(actionEvent.getSource()==login)
            {
                String username=usernameText.getText();
                String password=passwordField.getText();
                if (username.isEmpty()||password.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Fill in the blanks.");
                    return;
                }
                try {
                    FileReader fileReader=new FileReader("test.txt");
                    BufferedReader bufferedReader=new BufferedReader(fileReader);
                    String info=new String();
                    boolean found=false;
                    while ((info =bufferedReader.readLine())!=null && found==false)
                    {
                        //Founded username
                        if(info.indexOf(username)!=-1) {
                            //found password
                            if(info.indexOf(password)!=-1)
                            {
                                setPersonInfo(info);
                                found=true;
                            }
                        }
                    }
                    fileReader.close();
                    if(found==false) {
                        JOptionPane.showMessageDialog(null,"You have entered invalid username or password. Please try again");
                    }
                    if (found==true)
                    {
                        AfterLogin afterLogin =new AfterLogin();
                        afterLogin.setVisible(true);
                        dispose();
                    }
                }catch (IOException ie) {ie.printStackTrace();
                }catch (Exception e){e.printStackTrace();}
            }

            else if(actionEvent.getSource()==backButton)
            {
                FirstPage firstPage=new FirstPage();
                firstPage.setVisible(true);
                dispose();
            }

    }
}
}
