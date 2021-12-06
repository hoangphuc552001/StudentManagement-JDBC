import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteStudent extends JFrame implements ActionListener{
    JTable jtable;
    JButton ok,Cancel;
    JTextField jIDf;
    DeleteStudent() throws IOException {
        Container con = this.getContentPane();
        //top
        JPanel jTopTop=new JPanel();
        jTopTop.setLayout(new BoxLayout(jTopTop,BoxLayout.PAGE_AXIS));
        JLabel jtop=new JLabel("Delete Student",JLabel.CENTER);
        jtop.setForeground(new Color(222, 52, 49));
        jtop.setFont(new Font("Courier",Font.BOLD,20));
        JPanel jpTop=new JPanel();
        jpTop.setLayout(new BoxLayout(jpTop,BoxLayout.PAGE_AXIS));
        JPanel jInfor=new JPanel();
        jInfor.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jId=new JLabel("ID");
        jIDf=new JTextField(10);
        jInfor.add(jId);jInfor.add(jIDf);
        jtop.setAlignmentX(CENTER_ALIGNMENT);
        jpTop.add(jtop);
        jpTop.add(jInfor);
        jInfor.setAlignmentX(Component.CENTER_ALIGNMENT);
        ok=new JButton("OK");
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        jInfor.add(ok);
        //
        JPanel jPanel=new JPanel();
        jPanel.setAlignmentX(CENTER_ALIGNMENT);
        String[][] data=ConnectToDatabase.getList();
        String[] column={"ID","Name","Grade","Image","Address","Notes"};
        DefaultTableModel model = new DefaultTableModel(data, column);
        jtable=new JTable(model);
        JScrollPane sp = new JScrollPane(jtable);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
        jPanel.add(sp);
        //
        Cancel=new JButton("Back");
        Cancel.setAlignmentX(CENTER_ALIGNMENT);
        Cancel.setFocusable(false);
        Cancel.setBackground(new Color(68, 25, 25));
        Cancel.setForeground(Color.white);
        Cancel.setUI(new stylebutton());
        Dimension size = new Dimension(160, 25);
        Cancel.setMaximumSize(size);
        Cancel.setPreferredSize(size);
        Cancel.setMaximumSize(size);
        Cancel.addActionListener(this);
        ok.addActionListener(this);
        JPanel boxl=new JPanel();
        boxl.setLayout(new BoxLayout(boxl,BoxLayout.PAGE_AXIS));
        boxl.add(Cancel);
        boxl.add(Box.createRigidArea(new Dimension(0, 5)));
        // Setting con
        con.setLayout(new BorderLayout());
        con.add(jpTop, BorderLayout.PAGE_START);
        con.add(jPanel, BorderLayout.CENTER);
        con.add(boxl, BorderLayout.PAGE_END);
        con.add(Box.createRigidArea(new Dimension(20,0)), BorderLayout.LINE_START);
        con.add(Box.createRigidArea(new Dimension(20,0)), BorderLayout.LINE_END);
        // Setting JFrame
        this.setTitle("View Student");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.pack();
        this.setSize(new Dimension(700,500));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteStudent frame = new DeleteStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Cancel)){
            this.dispose();
            Menu.GUI();
        }
        else if (e.getSource().equals(ok)){
            String id=jIDf.getText().toString();
            try {
                if (ConnectToDatabase.checkStudent(id)){
                    int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
                    if(a==JOptionPane.YES_OPTION){
                        ConnectToDatabase.DeleteStudent(id);
                        JOptionPane.showMessageDialog(null,"Successfully Deleting");
                        this.dispose();
                        DeleteStudent.GUI();
                    }
                    else if (a==JOptionPane.NO_OPTION){
                        jIDf.setText("");
                    }
                    else if (a==JOptionPane.CANCEL_OPTION){
                        jIDf.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Do not existed id in system.","Alert",JOptionPane.WARNING_MESSAGE);
                    jIDf.setText("");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}