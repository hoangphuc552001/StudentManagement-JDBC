import java.io.*;
import java.sql.*;

public class ConnectToDatabase {
    public static String server = "";
    public static String database = "";
    public static String user = "";
    public static String pass = "";

    public static String Connect(String server, String database, String user, String pass) {
        Connection con = null;
        String result = "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            con.close();
            return "Connected Succesfully";
        } catch (Exception ex) {
            result = "Error: " + ex.getMessage();
            System.out.println("Error: " + ex.getMessage());
        }
        return result;
    }

    public static String idGetter() throws IOException {
        String result = "";
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select id from Student order by id DESC");
            ResultSet rs = stmt.executeQuery();
            String s = "";
            while (rs.next()) {
                s = rs.getString(1);
                break;
            }
            con.close();
            return String.valueOf(Integer.valueOf(s) + 1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return "";
    }

    public static int lengthList() throws IOException {
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select id from Student");
            ResultSet rs = stmt.executeQuery();
            int s = 0;
            while (rs.next()) {
                s++;
            }
            con.close();
            return s;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return -1;
    }

    public static boolean deleteStudent(String idDelete) throws IOException {
        String result = "";
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select id,name from Student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                if (id.equals(idDelete)) {
                    con.close();
                    return true;
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }

    public static void setConnection() throws IOException {
        if (server == "" || database == "" || user == "" || pass == "") {
            File f = new File(Login.FileConfig);
            if (f.exists()) {
                BufferedReader buffer = null;
                buffer = new BufferedReader(new FileReader(f.getName()));
                String[] data = buffer.readLine().toString().split("@");
                server = data[0];
                database = data[1];
                user = data[2];
                pass = data[3];
                buffer.close();
            }
        }
    }

    public static boolean checkStudent(String id) throws IOException {
        String result = "";
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select Student.id from Student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String studentID = rs.getString(1);
                if (id.equals(studentID)) return true;
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }

    public static boolean AddStudent(String id, String name, float grade, String image, String address, String notes) throws IOException {
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("Insert into Student " +
                    "values(?,?,?,?,?,?)");
            stmt.setString(1, id);//1 specifies the first parameter in the query
            stmt.setString(2, name);
            stmt.setFloat(3, grade);//1 specifies the first parameter in the query
            stmt.setString(4, image);
            stmt.setString(5, address);//1 specifies the first parameter in the query
            stmt.setString(6, notes);
            stmt.execute();
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }

    public static void DeleteStudent(String id) throws IOException {
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            String strCmdDelete = "Delete from Student where id=?";
            PreparedStatement ps = con.prepareStatement(strCmdDelete);
            ps.setString(1, id);
            ps.execute();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static String[][] getList() throws IOException {
        String[][] result = new String[lengthList()][6];
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select * from Student");
            ResultSet rs = stmt.executeQuery();
            String id = "", name = "", img = "", address = "", note = "";
            float grade = 0;
            int i = 0;
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                grade = rs.getFloat(3);
                img = rs.getString(4);
                address = rs.getString(5);
                note = rs.getString(6);
                result[i][0] = id;
                result[i][1] = name;
                result[i][2] = String.valueOf(grade).toString();
                result[i][3] = img;
                result[i][4] = address;
                result[i][5] = note;
                i++;
            }
            con.close();
            return result;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public static String[][] getListAscID() throws IOException {
        String[][] result = new String[lengthList()][6];
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select * from Student order by id ASC");
            ResultSet rs = stmt.executeQuery();
            String id = "", name = "", img = "", address = "", note = "";
            float grade = 0;
            int i = 0;
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                grade = rs.getFloat(3);
                img = rs.getString(4);
                address = rs.getString(5);
                note = rs.getString(6);
                result[i][0] = id;
                result[i][1] = name;
                result[i][2] = String.valueOf(grade).toString();
                result[i][3] = img;
                result[i][4] = address;
                result[i][5] = note;
                i++;
            }
            con.close();
            return result;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public static String[][] getListAscGrade() throws IOException {
        String[][] result = new String[lengthList()][6];
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select * from Student order by grade ASC");
            ResultSet rs = stmt.executeQuery();
            String id = "", name = "", img = "", address = "", note = "";
            float grade = 0;
            int i = 0;
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                grade = rs.getFloat(3);
                img = rs.getString(4);
                address = rs.getString(5);
                note = rs.getString(6);
                result[i][0] = id;
                result[i][1] = name;
                result[i][2] = String.valueOf(grade).toString();
                result[i][3] = img;
                result[i][4] = address;
                result[i][5] = note;
                i++;
            }
            con.close();
            return result;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public static String[] inforUser(String idUser) throws IOException {
        String[] result = new String[6];
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select * from Student where id=?");
            stmt.setString(1, idUser);
            ResultSet rs = stmt.executeQuery();
            String id = "", name = "", img = "", address = "", note = "";
            float grade = 0;
            while (rs.next()) {
                result[0] = rs.getString(1);
                result[1] = rs.getString(2);
                result[2] = String.valueOf(rs.getFloat(3)).toString();
                result[3] = rs.getString(4);
                result[4] = rs.getString(5);
                result[5] = rs.getString(6);
            }
            con.close();
            return result;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public static boolean UpdateUser(String id,String name, float grade, String img, String address, String note) throws IOException {
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            String strCmdUpdate = "Update Student set name=?,grade=?,image=?,address=?,notes=? where id=?";
            PreparedStatement ps = con.prepareStatement(strCmdUpdate);
            ps.setString(1, name);
            ps.setFloat(2, grade);
            ps.setString(3, img);
            ps.setString(4, address);
            ps.setString(5, note);
            ps.setString(6, id);
            ps.execute();
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }
    public static void PustDb(StudentList studentList) throws IOException {
        setConnection();
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connection_ = String.format("jdbc:sqlserver://%s:1433;" +
                    "databaseName=%s;user=%s;password=%s", server, database, user, pass);
            con = DriverManager.getConnection(connection_);
            PreparedStatement stmt = con.prepareStatement("select id from Student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String strCmdDelete="Delete from Student where id=?";
                PreparedStatement ps=con.prepareStatement(strCmdDelete);
                ps.setString(1,rs.getString(1));
                ps.execute();
            }
            for (int i=0;i<studentList.lengthList();i++){
                String id=studentList.getIdIndex(i);
                String name=studentList.getNameIndex(i);
                float gpa=studentList.getGPAindex(i);
                String img=studentList.getImageIndex(i);
                String address=studentList.getAddressIndex(i);
                String note=studentList.getNoteIndex(i);
                PreparedStatement st=con.prepareStatement("Insert into Student values(?,?,?,?,?,?)");
                st.setString(1, id);//1 specifies the first parameter in the query
                st.setString(2,name);
                st.setFloat(3, gpa);
                st.setString(4,img);
                st.setString(5,address);
                st.setString(6,note);
                st.execute();
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
