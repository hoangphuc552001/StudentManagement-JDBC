import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class Menu extends JFrame implements ActionListener{
    JButton btnAdd,btnDelete,btnUpdate,btnView,btnExport,btnImport,btnExit;
    Menu(){
        stylepanel spn=new stylepanel();
        Container container1 = this.getContentPane();
        Container container=new Container();
        Dimension size = new Dimension(160, 25);
        //Top Pannel
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("MENU");
        titleLabel.setForeground(new Color(222, 52, 49));
        titleLabel.setFont(new Font("Monaco", Font.PLAIN, 30));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        JPanel jPaneltitle=new JPanel();
        jPaneltitle.setSize((new Dimension(50, 50)));
        jPaneltitle.setLayout(new BoxLayout(jPaneltitle, BoxLayout.LINE_AXIS));
        jPaneltitle.add(titleLabel);
        jPaneltitle.setBackground(new Color(247, 245, 245));
        jPaneltitle.setAlignmentX(CENTER_ALIGNMENT);
        //
        JPanel jpEnd=new JPanel();
        jpEnd.setLayout(new BoxLayout(jpEnd, BoxLayout.PAGE_AXIS));
        jpEnd.add(jPaneltitle);
        jpEnd.add(Box.createRigidArea(new Dimension(0, 5)));
        jpEnd.setBackground(new Color(147, 176, 194));
        jpEnd.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.add(jpEnd);
        topPanel.setAlignmentX(CENTER_ALIGNMENT);
        //topPanel.add(jlb);
        //mid pannel
        btnAdd=new JButton("Add Student");
        btnAdd.setAlignmentX(CENTER_ALIGNMENT);
        btnAdd.setFocusable(false);
        btnAdd.setBackground(new Color(245, 66, 87));
        btnAdd.setForeground(Color.white);
        btnAdd.setUI(new stylebutton());
        btnAdd.setMaximumSize(size);
        btnAdd.setPreferredSize(size);
        btnAdd.setMaximumSize(size);
        //
        btnUpdate=new JButton("Update Information");
        btnUpdate.setAlignmentX(CENTER_ALIGNMENT);
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(new Color(245, 66, 87));
        btnUpdate.setForeground(Color.white);
        btnUpdate.setUI(new stylebutton());
        btnUpdate.setMaximumSize(size);
        btnUpdate.setPreferredSize(size);
        btnUpdate.setMaximumSize(size);
        //
        btnDelete=new JButton("Delete a Student");
        btnDelete.setAlignmentX(CENTER_ALIGNMENT);
        btnDelete.setFocusable(false);
        btnDelete.setBackground(new Color(245, 66, 87));
        btnDelete.setForeground(Color.white);
        btnDelete.setUI(new stylebutton());
        btnDelete.setMaximumSize(size);
        btnDelete.setPreferredSize(size);
        btnDelete.setMaximumSize(size);
        //
        btnView=new JButton("View List Student");
        btnView.setAlignmentX(CENTER_ALIGNMENT);
        btnView.setFocusable(false);
        btnView.setBackground(new Color(245, 66, 87));
        btnView.setForeground(Color.white);
        btnView.setUI(new stylebutton());
        btnView.setMaximumSize(size);
        btnView.setPreferredSize(size);
        btnView.setMaximumSize(size);
        //
        btnExport=new JButton("Export to CSV");
        btnExport.setAlignmentX(CENTER_ALIGNMENT);
        btnExport.setFocusable(false);
        btnExport.setBackground(new Color(245, 66, 87));
        btnExport.setForeground(Color.white);
        btnExport.setUI(new stylebutton());
        btnExport.setMaximumSize(size);
        btnExport.setPreferredSize(size);
        btnExport.setMaximumSize(size);
        //
        btnImport=new JButton("Import from CSV");
        btnImport.setAlignmentX(CENTER_ALIGNMENT);
        btnImport.setFocusable(false);
        btnImport.setBackground(new Color(245, 66, 87));
        btnImport.setForeground(Color.white);
        btnImport.setUI(new stylebutton());
        btnImport.setMaximumSize(size);
        btnImport.setPreferredSize(size);
        btnImport.setMaximumSize(size);
        //
        btnExit=new JButton("Exit");
        btnExit.setAlignmentX(CENTER_ALIGNMENT);
        btnExit.setFocusable(false);
        btnExit.setBackground(new Color(66, 245, 218, 128));
        btnExit.setForeground(new Color(243, 9, 42));
        btnExit.setUI(new stylebutton());
        btnExit.setMaximumSize(size);
        btnExit.setPreferredSize(size);
        btnExit.setMaximumSize(size);
        // Add to container
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(topPanel);
        container.add((Box.createRigidArea(new Dimension(0,20))));
        container.add(btnAdd);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnDelete);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnUpdate);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnView);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnExport);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnImport);
        container.add((Box.createRigidArea(new Dimension(0,30))));
        container.add(btnExit);
        //
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnView.addActionListener(this);
        btnImport.addActionListener(this);
        btnExport.addActionListener(this);
        btnExit.addActionListener(this);
        //
        spn.setLayout(new BorderLayout());
        spn.add(container,BorderLayout.CENTER);
        container1.add(spn);
        // Setting Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu");
        this.setVisible(true);
        this.setSize(400, 400);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
    public static void GUI(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAdd)){
            AddStudent.GUI();
            this.dispose();
        }
        else if (e.getSource().equals(btnDelete)){
           DeleteStudent.GUI();
            this.dispose();
        }
        else if (e.getSource().equals(btnView)){
           ViewStudent.GUI();
            this.dispose();
        }
        else if (e.getSource().equals(btnUpdate)){
            UpdateStudent.GUI();
            this.dispose();
        }
        else if (e.getSource().equals(btnExport)){
            try {
                this.dispose();
                new ExportCSV();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource().equals(btnImport)){
            ImportCSV.GUI();
            this.dispose();
        }
        else if (e.getSource().equals(btnExit)){
            this.dispose();
        }
    }
}
