package Game.FILE;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;

import Model.Object.Unit;
import org.json.simple.JSONObject;
public class LogFile {


        public void store(Unit unit) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", unit.getId());
            jsonObject.put("Movement x",unit.getPosition().x);
            jsonObject.put("Movement y",unit.getPosition().y);
            jsonObject.put("Kill",unit.Target);
            try {
                FileWriter file = new FileWriter("output.json");
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(unit.getName()+jsonObject);
        }
    }

