package Game;

import java.util.*;

import Model.Object.*;


public class Arena {
    public int end = 40;//40
    public int end2 = 25;//25
    public static ArrayList<ArrayList<Node>> Arena = new ArrayList<>();
    ArrayList<ArrayList<Unit>> store = new ArrayList<>();
    public Map<Integer, List<Unit>> team = new HashMap<>();
    public int key;

    public ArrayList<ArrayList<Node>> getArena() {
        return Arena;
    }

    public static void Generate() {

        for (int i = 0; i < 1000; i++) {
            ArrayList<Node> s = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                s.add(new Node());
            }
            Arena.add(s);
        }


    }

    public void prod(ArrayList<Unit> list) {
        for (int i = 0; i < list.size(); i++) {
            prodcest(list.get(i));
        }
    }

    //تابع بينشرها ع رقعة حسب عنصر*----*
    public void prodcest(Unit unit) {
        double k, l;

        if (unit.getPosition().x > unit.getPosition().reduis)
            k = unit.getPosition().x - unit.getPosition().reduis;
        else
            k = unit.getPosition().reduis - unit.getPosition().x;

        if (unit.getPosition().y > unit.getPosition().reduis)
            l = unit.getPosition().y - unit.getPosition().reduis;
        else
            l = unit.getPosition().reduis - unit.getPosition().y;

        double n = unit.getPosition().reduis + unit.getPosition().x;
        double m = unit.getPosition().reduis + unit.getPosition().y;
        Node h = new Node();
        if (n != end && m != end2) {
            for (int i = (int) k; i <= n; i++) {
                for (int j = (int) l; j <= m; j++) {
                    if (unit.getType().equals("Airplane")) {
                        //     System.out.println(unit.getName());
                        h.Aerial = unit;
                    } else {
                        h.Wild = unit;
                    }
                    Arena.get(i).set(j, h);
                }

            }
        }
    }

    public void p() {
        for (int i = 0; i < 40; i++)//40
        {
            for (int j = 0; j < 25; j++)//25
            {

                System.out.print(Arena.get(i).get(j).Wild.getName() + " ");

            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }


    public void printexample() {
        for (int i = 0; i < 10; i++)//40
        {
            for (int j = 0; j < 10; j++)//25
            {

                System.out.print(Arena.get(i).get(j).Wild.getName() + " ");

            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }


    //تابع بصفر منطقى كل ما انتقل*-------*
    public void clear(Unit unit) {
        double k, l;
        if (unit.getPosition().x > unit.getPosition().reduis)
            k = unit.getPosition().x - unit.getPosition().reduis;
        else
            k = unit.getPosition().reduis - unit.getPosition().x;

        if (unit.getPosition().y > unit.getPosition().reduis)
            l = unit.getPosition().y - unit.getPosition().reduis;
        else
            l = unit.getPosition().reduis - unit.getPosition().y;

        double n = unit.getPosition().reduis + unit.getPosition().x;
        double m = unit.getPosition().reduis + unit.getPosition().y;
        Node node = new Node();
        //node.Wild=null;
        for (int i = (int) k; i <= n; i++) {
            for (int j = (int) l; j <= m; j++) {
                Arena.get(i).set(j, node);
            }

        }
    }

    public boolean check_add(Unit unit, int temp_x, int temp_y, Arena a) {
        double k, l;
        if (temp_x > unit.getPosition().reduis)
            k = (temp_x - unit.getPosition().reduis);
        else
            k = unit.getPosition().reduis - temp_x;

        if (temp_y > unit.getPosition().reduis)
            l = temp_y - unit.getPosition().reduis;
        else
            l = unit.getPosition().reduis - temp_y;

        double n = unit.getPosition().reduis + temp_x;
        double m = unit.getPosition().reduis + temp_y;


        for (int i = (int) k; i <= n; i++) {
            for (int j = (int) l; j <= m; j++) {
                if (a.Arena.get(i).get(j).Wild.getName() != null) {
                    return false;}
            }
        }
        return true;
    }

}
