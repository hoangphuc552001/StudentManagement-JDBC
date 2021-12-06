import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.FileSystems;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ImportCSV extends JFrame implements ActionListener {
    JButton btnPabel, btnCancel;

    ImportCSV() {
        Container con = this.getContentPane();
        // Setting con
        con.setLayout(new BorderLayout());
        //label Panel
        JLabel lb = new JLabel("Import File CSV", JLabel.CENTER);
        lb.setForeground(new Color(222, 52, 49));
        lb.setFont(new Font("Monaco", Font.PLAIN, 30));
        //
        DefaultListModel<String> l1 = new DefaultListModel<>();
        File f = new File(FileSystems.getDefault().getPath("FileCSV").toAbsolutePath()
                .toString());
        String contents[] = f.list();
        for (int i = 0; i < contents.length; i++) {
            l1.addElement(contents[i]);
        }
        JList<String> list = new JList<>(l1);
        //
        btnPabel = new JButton("OK");
        btnCancel = new JButton("Cancel");
        btnPabel.addActionListener(this);
        btnCancel.addActionListener(this);
        JPanel botLabel = new JPanel();
        botLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botLabel.add(btnPabel);
        botLabel.add(btnCancel);
        //
        //
        JFrame fr=this;
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!list.getValueIsAdjusting()) {
                    int a=JOptionPane.showConfirmDialog(null,"Are you sure to export file "+
                            list.getSelectedValue()+"?");
                    if(a==JOptionPane.YES_OPTION){
                        StudentList studentList=new StudentList();
                        try {
                            File ff=new File(FileSystems.getDefault().getPath("FileCSV").toAbsolutePath()
                                    .toString()+"\\" +list.getSelectedValue());
                            studentList.importFileCSV(ff.getAbsolutePath());
                            ConnectToDatabase.PustDb(studentList);
                            JOptionPane.showMessageDialog(null,"Imported Successfully");
                            fr.dispose();
                            ImportCSV.GUI();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null,"Imported Failed.","Alert",JOptionPane.WARNING_MESSAGE);
                            fr.dispose();
                            Menu.GUI();
                            ex.printStackTrace();
                        }
                    }
                    else{
                        fr.dispose();
                        ImportCSV.GUI();
                    }
                }
            }

        });
        //
        con.add(lb, BorderLayout.PAGE_START);
        con.add(list, BorderLayout.CENTER);
        con.add(botLabel, BorderLayout.PAGE_END);
        // Setting JFrame
        this.
                setTitle("Add Student");
        this.

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.

                setVisible(true);
        this.

                setSize(new Dimension(450, 450));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.

                setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.

                        getSize().height / 2);
    }

    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImportCSV frame = new ImportCSV();
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
            Menu.GUI();
        }
    }
}
