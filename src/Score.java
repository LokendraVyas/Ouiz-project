import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int Score) {
        setBounds(400, 200, 800, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Thank you " + name + " For playing");
        heading.setBounds(50, 50, 800, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
        add(heading);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = icon.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel scor = new JLabel("Your Score is : " + Score);
        scor.setBounds(500, 100, 800, 30);
        scor.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(scor);

        JButton playAg = new JButton("Play Again");
        playAg.setBounds(550, 170, 150, 30);
        playAg.setFont(new Font("Tahoma", Font.PLAIN, 15));
        playAg.setBackground(new Color(30, 144, 255));
        playAg.setForeground(Color.WHITE);
        playAg.addActionListener(this);
        add(playAg);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }

}
