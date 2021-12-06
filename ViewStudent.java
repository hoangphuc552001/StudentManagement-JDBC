import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame implements ActionListener{
    JTable jtable;
    JRadioButton radioBtn1,radioBtn2;
    JButton Cancel;
    ViewStudent() throws IOException {
        Container con = this.getContentPane();
        //top
        JLabel jtop=new JLabel("View List",JLabel.CENTER);
        jtop.setForeground(new Color(222, 52, 49));
        jtop.setFont(new Font("Courier",Font.BOLD,20));
        JPanel jpTop=new JPanel();
        jpTop.add(jtop);
        //
        radioBtn1 = new JRadioButton("ID ascending");
        radioBtn2 = new JRadioButton("Grade ascending");
        ButtonGroup bg=new ButtonGroup();
        bg.add(radioBtn1);bg.add(radioBtn2);
        radioBtn1.addActionListener(this);
        radioBtn2.addActionListener(this);
        JPanel boxl=new JPanel();
        boxl.setLayout(new BoxLayout(boxl,BoxLayout.PAGE_AXIS));
        JPanel jPanelmid=new JPanel();
        jPanelmid.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelmid.add(radioBtn1);
        jPanelmid.add(Box.createRigidArea(new Dimension(30,0)));
        jPanelmid.add(radioBtn2);
        boxl.add(jPanelmid);
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
        Frame t=this;
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.dispose();
                Menu.GUI();
            }
        });
        boxl.add(Cancel);
        boxl.add(Box.createRigidArea(new Dimension(0, 5)));
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
        // Setting con
        con.setLayout(new BorderLayout());
        con.add(jpTop, BorderLayout.PAGE_START);
        con.add(boxl, BorderLayout.PAGE_END);
        con.add(jPanel, BorderLayout.CENTER);
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
                    ViewStudent frame = new ViewStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (radioBtn1.isSelected()){
            String[][]data= new String[0][];
            try {
                data = ConnectToDatabase.getListAscID();
                String[] column={"ID","Name","Grade","Image","Address","Notes"};
                DefaultTableModel model = new DefaultTableModel(data, column);
                jtable.setModel(model);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (radioBtn2.isSelected()){
            String[][]data= new String[0][];
            try {
                data = ConnectToDatabase.getListAscGrade();
                String[] column={"ID","Name","Grade","Image","Address","Notes"};
                DefaultTableModel model = new DefaultTableModel(data, column);
                jtable.setModel(model);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
