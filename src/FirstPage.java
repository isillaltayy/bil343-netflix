import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends GUI{
    private JLabel wSentence;
    private JButton signUp,login;
    MyEventHandler myEventHandler=new MyEventHandler();

    public FirstPage()
    {
        super();
        setTitle("Iflix Application");
        wSentence=new JLabel("Welcome");
        wSentence.setForeground(Color.WHITE);
        wSentence.setFont(new Font("Comic Sans",Font.BOLD,25));

        signUp =new JButton("Sign up");
        signUp.setFont(new Font("Comic Sans",Font.BOLD,25));
        signUp.setForeground(Color.WHITE);
        signUp.setBackground(Color.gray);
        login=new JButton("Login");
        login.setFont(new Font("Comic Sans",Font.BOLD,25));
        login.setForeground(Color.WHITE);
        login.setBackground(Color.gray);

        super.getContentPane().add(wSentence);
        super.getContentPane().add(signUp);
        super.getContentPane().add(login);

        setVisible(true);
        signUp.addActionListener(myEventHandler);
        login.addActionListener(myEventHandler);

    }
    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
           if(actionEvent.getSource()==signUp)
           {
               Subscribe subscribe=new Subscribe();
               subscribe.setVisible(true);
               dispose();
           }
           if (actionEvent.getSource()==login)
           {
                Login login=new Login();
                login.setVisible(true);
                dispose();
           }
        }
    }
}
