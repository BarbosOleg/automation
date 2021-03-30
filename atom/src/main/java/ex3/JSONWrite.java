package ex3;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONWrite {
    public static void main(String[] args) {
        JSONObject objG = new JSONObject();
        JSONArray listG = new JSONArray();

        JSONObject obj = new JSONObject();

        obj.put("plantName", "Columbine");
        obj.put("botanical", "Aquilegia canadensis");
        obj.put("zone", 2);
        obj.put("price", "$2.44");

        JSONObject obj2 = new JSONObject();

        obj2.put("plantName", "Bloodroot");
        obj2.put("botanical", "Sanguinaria canadensis");
        obj2.put("zone", 5);
        obj2.put("price", "$6.54");

        listG.add(obj);
        listG.add(obj2);
        objG.put("plantID 001", listG);


        JSONArray listB = new JSONArray();
        JSONObject obj3 = new JSONObject();

        obj3.put("plantName", "Marsh Marigold");
        obj3.put("botanical", "Caltha palustris");
        obj3.put("zone", 3);
        obj3.put("price", "$16.57");

        listB.add(obj3);
        objG.put("plantID 002", listB);
        try (FileWriter file = new FileWriter("plants2.json")) {
            file.write(objG.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}