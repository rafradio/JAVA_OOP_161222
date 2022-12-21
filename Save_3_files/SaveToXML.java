package Save_3_files;

import java.util.*;
import java.io.IOException;  
import java.nio.file.*; 
import java.io.FileWriter; 

public class SaveToXML extends SaveToFile {
    private ArrayList<String[]> xmlStructure;
    // private FileWriter myWriter;
    private StringBuilder xmlContent = new StringBuilder("");

    public SaveToXML(HashMap<String, Float> students) {
        super(students);
        this.xmlStructure = new ArrayList<>(Arrays.asList(
            new String[] {"student"},
            new String[] {"name", "grade"})
        );
        
    }

    @Override
    public void createFile() {
        Path path = Paths.get("students.xml");
        try 
            {  
                Path p= Files.createFile(path);   
            } 
        catch (IOException e) {}
        
    }

    @Override
    public void printToFile() {
        this.xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        this.xmlContent.append("<students>\n");
        
        try {
            FileWriter myWriterCreate = new FileWriter("students.xml");
            myWriterCreate.write(this.xmlContent.toString());

            for (Map.Entry<String, Float> map: this.GetStudents().entrySet()) {
                this.xmlContent = this.xmlContent.delete(0, this.xmlContent.length());
                this.printToXML(0,"\t", map.getKey(), map.getValue());
                myWriterCreate.write(this.xmlContent.toString());
                
            }
            
            myWriterCreate.write("</students>");
            myWriterCreate.close();

        } catch (IOException e) {}
        

    }

    public void printToXML(int index, String tab, String name, Float grad) {
        
        if (index == this.xmlStructure.size()-1) {

            String[] values = new String[] {name, grad.toString()};
            for (int i = 0; i < this.xmlStructure.get(index).length; i++) {
                this.xmlContent.append(tab + this.createToXMLTag(this.xmlStructure.get(index)[i], 0) + values[i]);
                this.xmlContent.append(this.createToXMLTag(this.xmlStructure.get(index)[i], 1) + "\n");
        
            }
            return;
        }
        if (index < this.xmlStructure.size()-1) {
            this.xmlContent.append(tab + this.createToXMLTag(this.xmlStructure.get(index)[0], 0) + "\n");

            this.printToXML(index+1, tab+"\t", name, grad);

            this.xmlContent.append(tab + this.createToXMLTag(this.xmlStructure.get(index)[0], 1) + "\n");
            return;
        }
    }

    public String createToXMLTag(String tag, int tagFlag) {
        if (tagFlag == 0) {
            return "<" + tag + ">";
        } else {
            return "</" + tag + ">";
        }
    }

}
