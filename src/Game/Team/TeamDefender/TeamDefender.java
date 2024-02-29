package Game.Team.TeamDefender;

import java.util.*;

import Game.Game;
import Model.Object.*;

//int typeUnit;1
//مدافع
public class TeamDefender {

    public String key;
    public Unit base = new Unit();
    public static Map<String, List<Unit>> team_defender = new HashMap<>();
    ArrayList<Unit> listmoveDefender = new ArrayList();

    public TeamDefender() {

    }

    public ArrayList<Unit> getListmoveDefender() {
        return listmoveDefender;
    }

    public Map<String, List<Unit>> getTeam() {
        return this.team_defender;
    }

    public Map<String, List<Unit>> getTeam_defender() {
        return team_defender;
    }


    public ArrayList<Unit> Form() {
        ArrayList<Unit> list = new ArrayList();
        Unit s ;
        Type z = new Type();
        s = z.setSniper(8, 7, 11, 1, "AttackRandom", false);
        list.add(s);
        s = z.setInfantry(12, 5, 12, 1, "HighestDamageAttackStrategy", true);
        list.add(s);
        s = z.setInfantry(26, 7, 14, 1, "HighestDamageAttackStrategy", true);
        list.add(s);
        s = z.setBase(20, 3, 15, 1);//20//3
        list.add(s);
        new Base().setBase(s);
        s = z.setInfantry(17, 7, 13, 1, "HighestDamageAttackStrategy", true);
        list.add(s);
        s = z.setPrism_tower(20, 11, 16, 1);
        list.add(s);
        s = z.setPatriot_Missile_System(35, 3, 17, 1);
        list.add(s);

        s = z.setTank_destroyer(5, 10, 18, 1, "HighestDamageAttackStrategy", false);
        list.add(s);


        for (int i = 0; i < list.size(); i++) {
            Generate(list.get(i), list.get(i).getName());
        }
        MoveThing();
        return list;
    }

    public void Generate(Unit o, String name) {

        key = name;
        List<Unit> L = new ArrayList<Unit>();

        if (team_defender.get(key) == null) {
            team_defender.put(key, L);
        }


        team_defender.get(key).add(o);

    }

    public void MoveThing() {
        Iterator key = team_defender.keySet().iterator();

        // أي وضعنا أسماء البلاد فيه .values بداخل الكائن h هنا قمنا بتخزين جميع قيم الكائن
        Iterator value = team_defender.values().iterator();
        while (key.hasNext()) {
            Object k = key.next();

            for (int i = 0; i < team_defender.get(k).size(); i++) {
                if (team_defender.get(k).get(i).getType().equals("Solider") || team_defender.get(k).get(i).getType().equals("Tank")) {

                    listmoveDefender.add(i, team_defender.get(k).get(i));

                }
                //   System.out.println();
            }
        }

    }


    public void print() {
        Iterator keys = team_defender.keySet().iterator();

        Iterator values = team_defender.values().iterator();
        while (keys.hasNext()) {
            Object k = keys.next();
            System.out.print(k + "\t | ");
            for (int i = 0; i < team_defender.get(k).size(); i++)
            {
                System.out.print(" " + team_defender.get(k).get(i).getHealth());
            }
            System.out.println();
        }
    }

}
