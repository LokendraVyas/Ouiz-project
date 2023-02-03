import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    // define button globally
    JButton submit, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(icon);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Quiz Application");
        heading.setBounds(650, 60, 500, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading.setForeground(new Color(30, 144, 253));
        add(heading);

        JLabel name = new JLabel("Enter Your Name:");
        name.setBounds(700, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(new Color(30, 144, 253));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(890, 150, 150, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        submit = new JButton("SUBMIT");
        submit.setBounds(750, 200, 100, 25);
        submit.setBackground(new Color(30, 144, 253));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBounds(870, 200, 100, 25);
        back.setBackground(new Color(30, 144, 253));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(50, 170);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String name = tfname.getText();
            setVisible(false);
            new Rule(name);

        } else if (ae.getSource() == back) {
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
