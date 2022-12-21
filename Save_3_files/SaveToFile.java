package Save_3_files;

import java.util.*;

public abstract class SaveToFile {
    private HashMap<String, Float> students;
    
    public SaveToFile(HashMap<String, Float> students) {
        this.students = students;

    }

    public HashMap<String, Float> GetStudents() {
        return this.students;
    }

    public abstract void createFile();

    public abstract void printToFile();
    
}
