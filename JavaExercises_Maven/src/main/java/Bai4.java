import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai4 extends JFrame implements ActionListener {
    private JTextField display = new JTextField("0");
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Bai4() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            if (display.getText().equals("0")) display.setText(cmd);
            else display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("0");
            num1 = num2 = result = 0;
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = cmd.charAt(0);
            display.setText("0");
        }
    }

    public static void main(String[] args) {
        new Bai4().setVisible(true);
    }
}