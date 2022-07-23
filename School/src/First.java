import javax.swing.*;

/**
 * @author ZJJ
 * #Description First
 * #Date: 2022/5/26 15:51
 */
public class First {
    private JPanel windows_1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("First");
        frame.setContentPane(new First().windows_1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
