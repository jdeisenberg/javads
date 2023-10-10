import java.util.Scanner;
import java.io.File;

public class FileInfo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter path name: ");
        String pathName = input.nextLine();
        
        File f = new File(pathName);
        
        System.out.println("File exists: " + f.exists());
        System.out.println("File size:   " + f.length());
        System.out.println("Readble:     " + f.canRead());
        System.out.println("Writeable:   " + f.canWrite());
        System.out.println("Executable:  " + f.canExecute());
        System.out.println("Directory:   " + f.isDirectory());
        System.out.println("Normal file: " + f.isFile());
        System.out.println("Hidden file: " + f.isHidden());
    }
}
