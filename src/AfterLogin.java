import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLogin extends GUI{
    private JButton renewSubscription, paymentDetails, backButton,watchMovieButton;
    MyEventHandler myEventHandler = new MyEventHandler();

    public AfterLogin() {
        super();
        setTitle("Main Menu");

        watchMovieButton=new JButton("Watch movie");
        watchMovieButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        watchMovieButton.setForeground(Color.WHITE);
        watchMovieButton.setBackground(Color.gray);
        renewSubscription = new JButton("Renew Subscription");
        renewSubscription.setFont(new Font("Comic Sans",Font.BOLD,25));
        renewSubscription.setForeground(Color.WHITE);
        renewSubscription.setBackground(Color.gray);
        paymentDetails = new JButton("Payment Details");
        paymentDetails.setFont(new Font("Comic Sans",Font.BOLD,25));
        paymentDetails.setForeground(Color.WHITE);
        paymentDetails.setBackground(Color.gray);
        backButton = new JButton("Back");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);

        watchMovieButton.addActionListener(myEventHandler);
        renewSubscription.addActionListener(myEventHandler);
        paymentDetails.addActionListener(myEventHandler);
        backButton.addActionListener(myEventHandler);

        super.getContentPane().add(watchMovieButton);
        super.getContentPane().add(renewSubscription);
        super.getContentPane().add(paymentDetails);
        super.getContentPane().add(backButton);


    }

    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == watchMovieButton) {
                WatchMovie watchMovie=new WatchMovie();
                watchMovie.setVisible(true);
                dispose();
            }

            else if(actionEvent.getSource()==renewSubscription)
            {
                boolean openRenewPage=true;
                String personInfo=new String();
                Login login=new Login();
                personInfo= login.getPersonInfo();
                login.dispose();


                    int index = personInfo.indexOf('$');
                    String money = personInfo.substring(index + 1, index + 3);
                    if (!money.equals("0 ")) {
                        JOptionPane.showMessageDialog(null, "Please pay your debt");
                        Payments payments = new Payments();
                        payments.setVisible(true);
                        dispose();
                        openRenewPage = false;
                    }

                    if (openRenewPage == true) {
                        RenewSubscription renewSubscription = new RenewSubscription();
                        renewSubscription.setVisible(true);
                        dispose();
                    }




            }
            else if (actionEvent.getSource()==paymentDetails)
            {
                Payments payments=new Payments();
                payments.setVisible(true);
                dispose();
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
