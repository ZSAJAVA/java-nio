import javax.swing.*;
import java.awt.*;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/6 - 8:39
 */
public class Main {


    public static void main(String[] args) {

        EventQueue.invokeLater(()->{


            JFrame frame = new JFrame("Welcome");
            frame.setSize(500,500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);


        });




    }


}
