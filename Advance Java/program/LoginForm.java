import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main(String[] args) {
        new LoginFrame();
    }
}

class LoginFrame extends JFrame {
    JLabel labelUserid, labelPassword, labelAccountType;
    JTextField textFieldUserid;
    JPasswordField passwordField;
    JComboBox<String> comboBoxAccountType;
    JButton buttonOk;

    public LoginFrame() {
        super();
        setTitle("Login Form");
        setSize(400, 300);

        labelUserid = new JLabel("User ID:");
        labelPassword = new JLabel("Password:");
        labelAccountType = new JLabel("Account Type:");
        textFieldUserid = new JTextField(10);
        passwordField = new JPasswordField(10);
        comboBoxAccountType = new JComboBox<>(new String[]{"Admin", "User"});
        buttonOk = new JButton("Ok");

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(labelUserid, c);

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        add(textFieldUserid, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        add(labelPassword, c);

        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        add(labelAccountType, c);

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        add(comboBoxAccountType, c);

        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        add(buttonOk, c);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
