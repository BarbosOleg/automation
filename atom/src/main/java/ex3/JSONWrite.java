package ex3;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSONWrite {
    public static void main(String[] args) {
        Map m = new LinkedHashMap();
        JSONObject obj = new JSONObject();
        m.put("plantName", "Columbine");
        m.put("botanical", "Aquilegia canadensis");
        m.put("zone", 2);
        m.put("price", "$2.44");

        obj.put("plant0", m);


        Map m1 = new LinkedHashMap();
        m1.put("plantName", "Bloodroot");
        m1.put("botanical", "Sanguinaria canadensis");
        m1.put("zone", 5);
        m1.put("price", "$6.54");

        obj.put("plant1", m1);


        Map m2 = new LinkedHashMap();
        m2.put("plantName", "Marsh Marigold");
        m2.put("botanical", "Caltha palustris");
        m2.put("zone", 3);
        m2.put("price", "$16.57");

        obj.put("plant2", m2);

        try (FileWriter file = new FileWriter("plant.json")) {
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}