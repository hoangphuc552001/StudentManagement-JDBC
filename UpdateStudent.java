import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateStudent extends JFrame implements ActionListener {
    JButton ok, btnOK, btnCancel, btnBack;
    JTextField jTextField, tf1, tf2, tf3, tf4;
    JTextField jIDf;

    UpdateStudent() throws IOException {
        Container con = this.getContentPane();
        // Setting con
        con.setLayout(new BorderLayout());
        //label Panel
        JPanel jTopTop1 = new JPanel();
        jTopTop1.setLayout(new BoxLayout(jTopTop1, BoxLayout.PAGE_AXIS));
        JLabel jtop = new JLabel("Update Student", JLabel.CENTER);
        jtop.setForeground(new Color(222, 52, 49));
        jtop.setFont(new Font("Courier", Font.BOLD, 20));
        JPanel jpTop = new JPanel();
        jpTop.setLayout(new BoxLayout(jpTop, BoxLayout.PAGE_AXIS));
        JPanel jInfor = new JPanel();
        jInfor.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jId = new JLabel("ID");
        jIDf = new JTextField(10);
        jInfor.add(jId);
        jInfor.add(jIDf);
        jtop.setAlignmentX(CENTER_ALIGNMENT);
        jpTop.add(Box.createRigidArea(new Dimension(0, 30)));
        jpTop.add(jtop);
        jpTop.add(Box.createRigidArea(new Dimension(0, 50)));
        jpTop.add(jInfor);
        jInfor.setAlignmentX(Component.CENTER_ALIGNMENT);
        ok = new JButton("OK");
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        jInfor.add(ok);
        //toppanel
        JPanel jTopTop = new JPanel();
        jTopTop.setLayout(new BoxLayout(jTopTop, BoxLayout.PAGE_AXIS));
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
        btnBack = new JButton("Back");
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);
        btnBack.addActionListener(this);
        ok.addActionListener(this);
        botPanel.add(btnOK);
        botPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        botPanel.add(btnCancel);
        botPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        botPanel.add(btnBack);
        botPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        botRealPan.add(botPanel);
        botRealPan.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.setEnabled(false);
        botRealPan.add(Box.createRigidArea(new Dimension(0, 10)));
        botPanel.setAlignmentX(CENTER_ALIGNMENT);
        //--------
        JPanel jPanel=new JPanel();
        jPanel.setAlignmentX(CENTER_ALIGNMENT);
        String[][] data=ConnectToDatabase.getList();
        String[] column={"ID","Name","Grade","Image","Address","Notes"};
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable jtable=new JTable(model);
        JScrollPane sp = new JScrollPane(jtable);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
        jPanel.add(sp);
        //
        con.add(jpTop, BorderLayout.PAGE_START);
        con.add(jTopTop, BorderLayout.CENTER);
        con.add(botRealPan, BorderLayout.PAGE_END);
        con.add(jPanel,BorderLayout.LINE_END);
        // Setting JFrame
        this.setTitle("Update Student");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(800, 550));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateStudent frame = new UpdateStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCancel)) {
            this.dispose();
            UpdateStudent.GUI();
        } else if (e.getSource().equals(ok)) {
            String id = jIDf.getText().toString();
            try {
                if (ConnectToDatabase.checkStudent(id)) {
                    String[] data = ConnectToDatabase.inforUser(id);
                    jTextField.setText(data[1]);
                    tf1.setText(data[2]);
                    tf2.setText(data[3]);
                    tf3.setText(data[4]);
                    tf4.setText(data[5]);
                    ok.setEnabled(false);
                    btnOK.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "ID do not existed.", "Alert", JOptionPane.WARNING_MESSAGE);
                    jIDf.setText("");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource().equals(btnOK)) {
            try {
                //
                boolean check = true;
                String numberValue = tf1.getText().toString();
                Float value = Float.valueOf(numberValue).floatValue();
                if (value < 0 || value > 4) check = false;
                String fileF = tf2.getText().toString();
                File fileFF = new File(fileF);
                //
                if (check == true) {
                    if (fileFF.exists() && fileFF.isFile()) {
                        if (ConnectToDatabase.UpdateUser(jIDf.getText().toString(),
                                jTextField.getText().toString(), Float.valueOf(tf1.getText().toString()).floatValue(),
                                tf2.getText().toString(), tf3.getText().toString(), tf4.getText().toString())) {
                            JOptionPane.showMessageDialog(null, "Successfully Updated.", "Alert", JOptionPane.WARNING_MESSAGE);
                            this.dispose();
                            UpdateStudent.GUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed Updated.", "Alert", JOptionPane.WARNING_MESSAGE);
                            this.dispose();
                            UpdateStudent.GUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "File is not exist, please input correct file in computer! ");
                        this.dispose();
                        UpdateStudent.GUI();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong type for grade! Input again");
                    this.dispose();
                    UpdateStudent.GUI();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource().equals(btnBack)) {
            this.dispose();
            Menu.GUI();
        }
    }

}
