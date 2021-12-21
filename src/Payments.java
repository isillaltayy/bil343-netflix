import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Payments extends GUI {
    static private JLabel amount;
    private JButton payButton,backButton;
    private String personInfo;
    MyEventHandler myEventHandler=new MyEventHandler();
    private String money;



    public Payments()
    {
        super();

        //dosyadaki satırı almak için getter setter
        Login login=new Login();
        personInfo= login.getPersonInfo();
        login.dispose();

        //find subscribe amount
        int index = personInfo.indexOf('$');
        money = personInfo.substring(index+1, index+3);

         if(money.equals("0 "))
             amount=new JLabel("There is no unpaid debt.");
         else
             amount=new JLabel("Amount: $"+money);

        payButton=new JButton("Pay");
        payButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(Color.gray);
        backButton=new JButton("Back");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,25));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.gray);

        super.getContentPane().add(amount);
        super.getContentPane().add(payButton);
        super.getContentPane().add(backButton);

        payButton.addActionListener(myEventHandler);
        backButton.addActionListener(myEventHandler);

    }
    //eski personInfo Stringinin textFile'daki line değerini alarak yeni String ile değiştirecek.
    public static void setVariable(int lineNumber, String data) throws IOException {
        Path path = Paths.get("test.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            int counter=0;
            if (actionEvent.getSource() == payButton) {
                amount.setText("Amount: $0");
                String newPersonInfo= personInfo.replace(money,"0");
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

                Login login=new Login();
                login.setPersonInfo(newPersonInfo);
                login.dispose();

            }
            else if(actionEvent.getSource()==backButton)
            {
                AfterLogin afterLogin =new AfterLogin();
                afterLogin.setVisible(true);
                dispose();
            }
        }
    }
}
