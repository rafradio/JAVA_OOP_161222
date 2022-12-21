package Save_3_files;

import java.util.*;
import java.io.IOException;  
import java.nio.file.*; 
import java.io.FileWriter; 

public class SaveToText extends SaveToFile {
    
    public SaveToText(HashMap<String, Float> students) {
        super(students);
        
    }

    @Override
    public void createFile() {
        Path path = Paths.get("students.txt");
        try 
            {  
                Path p= Files.createFile(path);   
            } 
        catch (IOException e) {}
    }

    @Override
    public void printToFile() {
        try   
            {  
                FileWriter myWriter = new FileWriter("students.txt"); 
                for (Map.Entry<String, Float> map: this.GetStudents().entrySet()) {

                    myWriter.write(map.toString() + "\n");
                }
                myWriter.close();
            }   
        catch (IOException e) {}   
    }
    
}
