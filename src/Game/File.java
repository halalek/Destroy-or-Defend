package Game;

import Model.Object.Type;
import Model.Object.Unit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class File {


    public void Generate() {

        Unit object = new Unit() {
        };
        String type = "";

        try {
            JSONParser parser = new JSONParser();
            JSONArray aas = (JSONArray) parser.parse(new FileReader("File.json"));
            for (Object o : aas) {
                JSONObject Student = (JSONObject) o;
                type = (String) Student.get("Type");
                object.setType((String) Student.get("Type"));
                object.setName((String) Student.get("Name"));
                object.setArmor((Double.parseDouble(Student.get("Armor").toString())));
                object.setAttackDamage((Integer.parseInt(Student.get("AttackDamge").toString())));
                object.setAttackRange((Integer.parseInt(Student.get("AttackRange").toString())));
                object.setAttackFrequency((Double.parseDouble(Student.get("AttackFrequency").toString())));
                object.setHealth((Double.parseDouble(Student.get("MaxHealth").toString())));
                object.setMovementspeed((Integer.parseInt(Student.get("MovementSpeed").toString())));
                object.setUnitPrice((Integer.parseInt(Student.get("UnitPrice").toString())));
                Collection<Object> o1 = Collections.singleton(((JSONObject) Student.get("CanTarget")).values());
                for (Object itemNum :
                        ((JSONObject) Student.get("CanTarget")).keySet()) {
                    object.CanTarget.add(((String) ((JSONObject) Student.get("CanTarget")).get(itemNum.toString())));
                }
                store(object, type);
                object = new Unit() {};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int i = 0;

    public void store(Unit unit, String type) {
        Type object = new Type();
        if ("Solider".equals(type)) {//جندي
            object.Solider.add(unit);
          // System.out.println(unit.getCanTarget());

        }
        if ("Tank".equals(type)) {//دبابة
            object.Tank.add(unit);
//            System.out.println(object.Tank.get(i).getName());
//            i++;
        }
        if ("Structure".equals(type)) {//بنية
            object.Structure.add(unit);
//            System.out.println(object.Structure.get(i).getName());
//            i++;
        }

        if ("Airplane".equals(type)) {//طائرة
            object.Airplane.add(unit);
//            System.out.println(object.Airplane.get(i).getName());
//            i++;
        }

    }

}

