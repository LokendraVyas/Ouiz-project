import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup groupoptions;
    JButton next, ll, submit;
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1000, 750);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(icon);
        image.setBounds(0, 0, 1000, 350);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(130, 400, 800, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);

        questions[0][0] = "What is actually electricity ?";
        questions[0][1] = "A flow of water";
        questions[0][2] = "A flow of air";
        questions[0][3] = "A flow of electrons";
        questions[0][4] = "A flow of Atoms";

        questions[1][0] = "Which of the following is not an international organisation?";
        questions[1][1] = "FIFA";
        questions[1][2] = "FBI";
        questions[1][3] = "ASEAN";
        questions[1][4] = "NATO";

        questions[2][0] = "Which of the following disorders is the fear of being alone?";
        questions[2][1] = "Agoraphobia";
        questions[2][2] = "Aerophobia";
        questions[2][3] = "Acrophobia";
        questions[2][4] = "Arachnophobia";

        questions[3][0] = "Which of the following animals can run the fastest?";
        questions[3][1] = "Panther";
        questions[3][2] = "Cheetah";
        questions[3][3] = "Tiger";
        questions[3][4] = "Lion";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "What is the main component of the sun?";
        questions[5][1] = "Liquid lava";
        questions[5][2] = "Gas";
        questions[5][3] = "Molten iron";
        questions[5][4] = "Rock";

        questions[6][0] = "What was the first country to use tanks in combat during World War I?";
        questions[6][1] = "France";
        questions[6][2] = "Japan";
        questions[6][3] = "Germany";
        questions[6][4] = "Britain";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "What do we call a newly hatched butterfly?";
        questions[8][1] = "A moth";
        questions[8][2] = "A butter";
        questions[8][3] = "A chrysalis";
        questions[8][4] = "A caterpillar";

        questions[9][0] = "What is the speed of sound?";
        questions[9][1] = "1,200 km/h";
        questions[9][2] = "120 km/h";
        questions[9][3] = "400 km/h";
        questions[9][4] = "700 km/h";

        answers[0][1] = "A flow of electrons";
        answers[1][1] = "FBI";
        answers[2][1] = "Agoraphobia";
        answers[3][1] = "Cheetah";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Gas";
        answers[6][1] = "Britain";
        answers[7][1] = "Java Archive";
        answers[8][1] = "A caterpillar";
        answers[9][1] = "1,200 km/h";

        option1 = new JRadioButton();
        option1.setBounds(130, 450, 500, 30);
        option1.setBackground(Color.white);
        option1.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(option1);
        option2 = new JRadioButton();
        option2.setBounds(130, 490, 500, 30);
        option2.setBackground(Color.white);
        option2.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(option2);
        option3 = new JRadioButton();
        option3.setBounds(130, 530, 500, 30);
        option3.setBackground(Color.white);
        option3.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(option3);
        option4 = new JRadioButton();
        option4.setBounds(130, 570, 500, 30);
        option4.setBackground(Color.white);
        option4.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(option4);

        groupoptions = new ButtonGroup();
        groupoptions.add(option1);
        groupoptions.add(option2);
        groupoptions.add(option3);
        groupoptions.add(option4);

        next = new JButton("Next");
        next.setBounds(650, 500, 150, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 15));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        ll = new JButton("50-50 lifeline");
        ll.setBounds(650, 550, 150, 30);
        ll.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ll.setBackground(new Color(30, 144, 255));
        ll.setForeground(Color.WHITE);
        ll.addActionListener(this);
        add(ll);

        submit = new JButton("Submit");
        submit.setBounds(650, 600, 150, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";

            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        } else if (ae.getSource() == ll) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                option2.setEnabled(false);
                option3.setEnabled(false);
            } else {
                option1.setEnabled(false);
                option4.setEnabled(false);
            }
            ll.setEnabled(false);

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " Seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 680, 500);
        } else {
            g.drawString("Times end", 680, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {// next button

                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);

        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);

        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);

        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();

    }

    public static void main(String[] args) {
        new Quiz("user"); // when we create class object then class constructor will be called.
    }
}
