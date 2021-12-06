import java.io.File;

public class Main {
    public static void main(String[] args){
        File f = new File(Login.FileConfig);
        if (!f.exists()) {
            Login.GUI();
        }
        else{
            Menu.GUI();
        }
    }
}
