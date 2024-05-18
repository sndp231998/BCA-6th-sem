import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {

    // Fields for user inputs
    private JTextField nameField, mobileField, dobField, addressField;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox termsCheckBox;

    // Label to display user inputs
    private JLabel displayLabel;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels for the form
        JLabel nameLabel = new JLabel("Name:");
        JLabel mobileLabel = new JLabel("Mobile:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel dobLabel = new JLabel("DOB (dd/mm/yyyy):");
        JLabel addressLabel = new JLabel("Address:");
        JLabel termsLabel = new JLabel("I accept terms and conditions:");

        // Create text fields for user input
        nameField = new JTextField(20);
        mobileField = new JTextField(10);
        dobField = new JTextField(10);
        addressField = new JTextField(20);

        // Create radio buttons for gender selection
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Create checkbox for accepting terms and conditions
        termsCheckBox = new JCheckBox();

        // Create button for form submission and reset
        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Create label for displaying user input
        displayLabel = new JLabel();

        // Create layout for the form
        JPanel formPanel = new JPanel(null);

        nameLabel.setBounds(10, 20, 100, 25);
        formPanel.add(nameLabel);

        nameField.setBounds(120, 20, 200, 25);
        formPanel.add(nameField);

        mobileLabel.setBounds(10, 50, 100, 25);
        formPanel.add(mobileLabel);

        mobileField.setBounds(120, 50, 200, 25);
        formPanel.add(mobileField);

        genderLabel.setBounds(10, 80, 100, 25);
        formPanel.add(genderLabel);

        maleButton.setBounds(120, 80, 60, 25);
        formPanel.add(maleButton);

        femaleButton.setBounds(180, 80, 80, 25);
        formPanel.add(femaleButton);

        // dobLabel.setBounds(10, 110, 100, 25);
        // formPanel.add(dobLabel);

//-------------------------------------------------
dobLabel.setBounds(10, 110, 100, 25);
formPanel.add(dobLabel);

dobField = new JTextField(20);
dobField.setBounds(120, 110, 200, 25);
formPanel.add(dobField);

JLabel addressLabel = new JLabel("Address:");
addressLabel.setBounds(10, 150, 100, 25);
formPanel.add(addressLabel);

addressField = new JTextField(20);
addressField.setBounds(120, 150, 200, 25);
formPanel.add(addressField);

JLabel termsLabel = new JLabel("I accept terms and conditions:");
termsLabel.setBounds(10, 190, 200, 25);
formPanel.add(termsLabel);

termsCheckBox = new JCheckBox();
termsCheckBox.setBounds(220, 190, 20, 25);
formPanel.add(termsCheckBox);

JButton submitButton = new JButton("Submit");
submitButton.setBounds(100, 230, 80, 25);
submitButton.addActionListener(this);
formPanel.add(submitButton);

JButton resetButton = new JButton("Reset");
resetButton.setBounds(200, 230, 80, 25);
resetButton.addActionListener(this);
formPanel.add(resetButton);

displayLabel = new JLabel();
displayLabel.setBounds(10, 270, 400, 25);
formPanel.add(displayLabel);

add(formPanel);
setVisible(true);
}

// ActionListener implementation
public void actionPerformed(ActionEvent e) {
if (e.getActionCommand().equals("Submit")) {
    String name = nameField.getText();
    String mobile = mobileField.getText();
    String gender = maleButton.isSelected() ? "Male" : "Female";
    String dob = dobField.getText();
    String address = addressField.getText();
    String terms = termsCheckBox.isSelected() ? "Accepted" : "Not Accepted";

    String output = "Name: " + name + " | Mobile: " + mobile + " | Gender: " + gender +
            " | DOB: " + dob + " | Address: " + address + " | Terms and Conditions: " + terms;

    displayLabel.setText(output);
} else if (e.getActionCommand().equals("Reset")) {
    nameField.setText("");
    mobileField.setText("");
    maleButton.setSelected(true);
    dobField.setText("");
    addressField.setText("");
    termsCheckBox.setSelected(false);
    displayLabel.setText("");
}
}

public static void main(String[] args) {
new RegistrationForm();
}
}

