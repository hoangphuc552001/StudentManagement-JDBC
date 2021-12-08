import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.FileSystems;
import javax.swing.*;
public class ExportCSV extends JFrame {
    ExportCSV() throws IOException {
        String file=JOptionPane.showInputDialog(this,"Enter file name to export. For example: file.csv");
        File f=new File(FileSystems.getDefault().getPath("FileCSV").toAbsolutePath()
                .toString()+"\\" +file);
        if (file!=null){
            StudentList studentList=new StudentList();
            String[][] data=ConnectToDatabase.getList();
            for (int i=0;i<data.length;i++){
                Student st=new Student(data[i][0],
                        data[i][1],Float.valueOf(data[i][2]).floatValue(),data[i][3],data[i][4],data[i][5]);
                studentList.addStudent(st);
            }
            if (f.exists()&&f.isFile()){
                int a=JOptionPane.showConfirmDialog(null,"File Existed! Do you want to override file?");
                if (a==JOptionPane.YES_OPTION){
                    studentList.exportFileCSV(f.getAbsolutePath());
                    JOptionPane.showMessageDialog(null,"Exported Successfully.");
                    this.dispose();
                    Menu.GUI();
                }
                else{
                    Menu.GUI();
                }
            }else{
                studentList.exportFileCSV(f.getAbsolutePath());
                JOptionPane.showMessageDialog(null,"Exported Successfully.");
                this.dispose();
                Menu.GUI();
            }
        }
        else{
            this.dispose();
            new Menu();
        }
    }
}
