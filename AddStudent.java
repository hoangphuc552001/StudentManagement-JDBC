import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class AddStudent extends JFrame implements ActionListener {
    JButton btnOK, btnCancel;
    JTextField jTextFieldid, jTextField, tf1, tf2, tf3, tf4;

    AddStudent() throws IOException {
        Container con = this.getContentPane();
        // Setting con
        con.setLayout(new BorderLayout());
        //label Panel
        JLabel lb = new JLabel("Add Student", JLabel.CENTER);
        lb.setForeground(new Color(222, 52, 49));
        lb.setFont(new Font("Monaco", Font.PLAIN, 30));
        //toppanel
        JPanel jTopTop = new JPanel();
        jTopTop.setLayout(new BoxLayout(jTopTop, BoxLayout.PAGE_AXIS));
        //
        JPanel jLineID = new JPanel();
        jLineID.setLayout(new BoxLayout(jLineID, BoxLayout.LINE_AXIS));
        JLabel ID = new JLabel("ID:");
        jLineID.add(Box.createRigidArea(new Dimension(41, 0)));
        jTextFieldid = new JTextField();
        jTextFieldid.setPreferredSize(new Dimension(0, 20));
        jTextFieldid.setText(ConnectToDatabase.idGetter());
        jTextFieldid.setEditable(false);
        jLineID.add(ID);
        jLineID.add(Box.createRigidArea(new Dimension(30, 0)));
        jLineID.add(jTextFieldid);
        jLineID.add(Box.createRigidArea(new Dimension(10, 0)));
        //
        JPanel jLine1 = new JPanel();
        jLine1.setLayout(new BoxLayout(jLine1, BoxLayout.LINE_AXIS));
        JLabel studentName = new JLabel("Name:");
        jLine1.add(Box.createRigidArea(new Dimension(20, 0)));
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(0, 20));
        jLine1.add(studentName);
        jLine1.add(Box.createRigidArea(new Dimension(30, 0)));
        jLine1.add(jTextField);
        jLine1.add(Box.createRigidArea(new Dimension(10, 0)));
        //-------
        JPanel jLine2 = new JPanel();
        jLine2.setLayout(new BoxLayout(jLine2, BoxLayout.LINE_AXIS));
        jLine2.add(Box.createRigidArea(new Dimension(20, 0)));
        JLabel gradeLb = new JLabel("Grade:");
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(0, 20));
        int distance = studentName.getPreferredSize().width - gradeLb.getPreferredSize().width;
        jLine2.add(Box.createRigidArea(new Dimension(distance, 0)));
        jLine2.add(gradeLb);
        jLine2.add(Box.createRigidArea(new Dimension(30, 0)));
        jLine2.add(tf1);
        jLine2.add(Box.createRigidArea(new Dimension(10, 0)));
        //--------
        JPanel jLine3 = new JPanel();
        jLine3.setLayout(new BoxLayout(jLine3, BoxLayout.LINE_AXIS));
        jLine3.add(Box.createRigidArea(new Dimension(20, 0)));
        JLabel imagelb = new JLabel("Image:");
        tf2 = new JTextField();
        tf2.setText("C://");
        tf2.setPreferredSize(new Dimension(0, 20));
        jLine3.add(imagelb);
        jLine3.add(Box.createRigidArea(new Dimension(28, 0)));
        jLine3.add(tf2);
        jLine3.add(Box.createRigidArea(new Dimension(10, 0)));
        //
        JPanel jLine4 = new JPanel();
        jLine4.setLayout(new BoxLayout(jLine4, BoxLayout.LINE_AXIS));
        jLine4.add(Box.createRigidArea(new Dimension(20, 0)));
        JLabel addressLb = new JLabel("Address:");
        tf3 = new JTextField();
        tf3.setPreferredSize(new Dimension(0, 20));
        jLine4.add(addressLb);
        jLine4.add(Box.createRigidArea(new Dimension(16, 0)));
        jLine4.add(tf3);
        jLine4.add(Box.createRigidArea(new Dimension(10, 0)));
        //
        JPanel jLine5 = new JPanel();
        jLine5.setLayout(new BoxLayout(jLine5, BoxLayout.LINE_AXIS));
        jLine5.add(Box.createRigidArea(new Dimension(20, 0)));
        JLabel noteLb = new JLabel("Notes:");
        tf4 = new JTextField();
        tf4.setPreferredSize(new Dimension(0, 20));
        jLine5.add(noteLb);
        jLine5.add(Box.createRigidArea(new Dimension(30, 0)));
        jLine5.add(tf4);
        jLine5.add(Box.createRigidArea(new Dimension(10, 0)));

        //--------
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLineID);
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLine1);
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLine2);
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLine3);
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLine4);
        jTopTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jTopTop.add(jLine5);
        //bottom panel
        JPanel botRealPan = new JPanel();
        botRealPan.setLayout(new BoxLayout(botRealPan, BoxLayout.PAGE_AXIS));
        JPanel botPanel = new JPanel();
        botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.LINE_AXIS));
        botRealPan.add(Box.createRigidArea(new Dimension(0, 10)));
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancle");
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);
        botPanel.add(btnOK);
        botPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        botPanel.add(btnCancel);
        botRealPan.add(botPanel);
        botRealPan.add(Box.createRigidArea(new Dimension(0, 10)));
        botPanel.setAlignmentX(CENTER_ALIGNMENT);
        //--------
        con.add(lb, BorderLayout.PAGE_START);
        con.add(jTopTop, BorderLayout.CENTER);
        con.add(botRealPan, BorderLayout.PAGE_END);
        // Setting JFrame
        this.setTitle("Add Student");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(450, 450));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudent frame = new AddStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOK)) {
            boolean check = true;
            String numberValue = tf1.getText().toString();
            Float value=Float.valueOf(numberValue).floatValue();
            if (value<0 || value>4) check=false;
            String fileF = tf2.getText().toString();
            File fileFF=new File(fileF);
            if (fileFF.isFile()&&fileFF.exists()) {
                if (check == true) {
                    if (jTextField.getText().isBlank() || tf1.getText().isBlank()
                            || tf2.getText().isBlank() || tf3.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Blank Input", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            ConnectToDatabase.AddStudent(jTextFieldid.getText().toString(), jTextField.getText().toString(),
                                    Float.valueOf(tf1.getText().toString()).floatValue(), tf2.getText().toString(),
                                    tf3.getText().toString(), tf4.getText().toString());
                            JOptionPane.showMessageDialog(null, "Inserted Successfully.");
                            this.dispose();
                            AddStudent.GUI();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Inserted Fail.");
                            this.dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong type for grade! Input again");
                    this.dispose();
                    AddStudent.GUI();
                }
            }else{
                JOptionPane.showMessageDialog(null, "File is not exist, please input correct file in computer! ");
                this.dispose();
                AddStudent.GUI();
            }
        } else if (e.getSource().equals(btnCancel)) {
            this.dispose();
             Menu.GUI();
        }
    }
}
