import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static String FileConfig = "config.txt";;
    Container container = getContentPane();
    JLabel serverdb = new JLabel("SERVER");
    JLabel namedb = new JLabel("DATABASE");
    JLabel loginLabel = new JLabel("LOGIN");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JTextField serverdbTextField = new JTextField();
    JTextField namedbTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JCheckBox showPassword = new JCheckBox("Show Password");

    Login() {
        container.setLayout(null);
        //
        loginLabel.setFont(new Font("Courier", Font.BOLD, 25));
        container.add(loginLabel);
        container.add(serverdb);
        container.add(namedb);
        container.add(serverdbTextField);
        container.add(namedbTextField);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        loginLabel.setBounds(160, 40, 100, 30);
        serverdb.setBounds(50, 100, 100, 30);
        serverdbTextField.setBounds(150, 100, 150, 30);
        namedb.setBounds(50, 140, 100, 30);
        namedbTextField.setBounds(150, 140, 150, 30);
        userLabel.setBounds(50, 180, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 180, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(150, 300, 100, 30);
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
        serverdbTextField.setText("localhost");
        userTextField.setText("sa");
        // Setting JFrame
        this.setTitle("Login");
        this.setVisible(true);
        this.setBounds(10, 10, 370, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 400));
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginButton)) {
                String serverdb = serverdbTextField.getText().toString();
                String namedb = namedbTextField.getText().toString();
                String user = userTextField.getText().toString();
                String password = passwordField.getText().toString();
                String annoucement = ConnectToDatabase.Connect(serverdb, namedb, user, password);
                if (annoucement.equals("Connected Succesfully")) {
                    BufferedWriter buffer = null;
                    try {
                        buffer = new BufferedWriter(new FileWriter(FileConfig));
                        String config = serverdb + "@" + namedb + "@" + user + "@" + password;
                        buffer.write(config);
                        buffer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, annoucement);
                    this.dispose();
                    Menu.GUI();
                } else {
                    JOptionPane.showMessageDialog(null, annoucement, "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        else if (e.getSource().equals(showPassword)) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }
}
