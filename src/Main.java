import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FirstPage firstPage=new FirstPage();

        File file=new File("test.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {e.printStackTrace();}
        }
    }
}
