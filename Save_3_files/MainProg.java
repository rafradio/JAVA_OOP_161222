package Save_3_files;

import java.util.*;
import java.util.HashMap;

public class MainProg {
    public static void main(String[] args) {


        HashMap<String, Float> students = new HashMap<>();
        students.put("Иван Иванов", 4.8f);
        students.put("Мария Кузнецова", 5.0f);
        students.put("Степан Кузьмин", 3.6f);

        ArrayList<SaveToFile> obj = new ArrayList<>();

        obj.add(new SaveToText(students));
        obj.add(new SaveToJSON(students));
        obj.add(new SaveToXML(students));

        for (int i = 0; i < obj.size(); i++) {
            obj.get(i).createFile();
            obj.get(i).printToFile();
        }

    }
}