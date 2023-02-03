
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rule extends JFrame implements ActionListener {

    String name;
    JButton back, start;

    Rule(String name) {
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " :Read rules carefully");
        heading.setBounds(30, 30, 700, 25);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
        heading.setForeground(new Color(30, 144, 253));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(30, 30, 900, 450);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rules.setText(
                "<html>" +
                        "1. Welcome to Quiz Game. you have to answer every question"
                        + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer"
                        + "<br><br>" +
                        "3. For giving answer you have to check on mark" + "<br><br>"
                        +
                        "4. Each question have 4 options, click on right one" + "<br><br>" +
                        "5. At last the result will be displayed " + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di"
                        + "<br><br>" +
                        "7. Good Luck !!!! Enjoy" + "<br><br>" +
                        "<html>");
        add(rules);

        back = new JButton("BACK");
        back.setBounds(250, 400, 100, 25);
        back.setBackground(new Color(30, 144, 253));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("START");
        start.setBounds(400, 400, 100, 25);
        start.setBackground(new Color(30, 144, 253));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);

        } else {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new Rule("User"); // by default user not give any name
    }
}
