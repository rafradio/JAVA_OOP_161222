package Save_3_files;

import java.util.*;
import java.io.IOException;  
import java.nio.file.*; 
import java.io.FileWriter; 

public class SaveToJSON extends SaveToFile {
    private Set<String> setJson = new HashSet<String>();

    public SaveToJSON(HashMap<String, Float> students) {
        super(students);
        
    }

    @Override
    public void createFile() {
        Path path = Paths.get("students.json");
        try 
            {  
                Path p= Files.createFile(path);   
            } 
        catch (IOException e) {}
        
    }

    private void creatJSonType() {
        for (Map.Entry<String, Float> map: this.GetStudents().entrySet()) {
            this.setJson.add("\"" + map.getKey() + "\"" + ":" + map.getValue());
        }
    }

    @Override
    public void printToFile() {
        this.creatJSonType();
       
        Iterator<String> iterator = this.setJson.iterator();

        try {
            FileWriter myWriter = new FileWriter("students.json");
            myWriter.write("{" + "\n");
            while (iterator.hasNext()) { 
                myWriter.write(iterator.next());
                if (iterator.hasNext()) {
                    myWriter.write("," + "\n");
                } else {
                    myWriter.write("\n");
                }
            }
            myWriter.write("}");
            myWriter.close();
        } catch (IOException e) {}  
        
    }
    
}
