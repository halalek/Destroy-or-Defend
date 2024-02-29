package Game.Team.TeamInvader;

import java.util.*;

import Game.Game;
import Model.Object.*;
import Game.*;

//int typeUnit;2
//مهاجم
public class TeamInvader {
    public String key;

    public static Map<String, List<Unit>> team_Invader = new HashMap<String, List<Unit>>();

    public Map<String, List<Unit>> getTeam_Invader() {
        return team_Invader;
    }

    ArrayList<Unit> listmoveInvader = new ArrayList();

    public ArrayList<Unit> getListmoveInvader() {
        return listmoveInvader;
    }

    public ArrayList<Unit> Form() {
        ArrayList<Unit> list = new ArrayList();
        Unit s = new Unit();
        Arena a = new Arena();
        Type z = new Type();
        s = z.setMirage_tank(26, 3, 7, 2, "LowestHealthAttackStrategy", false);//21//20
        list.add(s);
        s = z.setTesla_tank(30, 10, 7, 2, "HighestDamageAttackStrategy", true);//27//13
        list.add(s);
        s = z.setSniper(3, 17, 1, 2, "AttackRandom", false);
        list.add(s);
        Unit aa = new Type().setNavy_seal(9, 17, 3, 2, "LowestHealthAttackStrategy", true);
        list.add(aa);
        s = new Type().setNavy_seal(3, 15, 4, 2, "LowestHealthAttackStrategy", true);
        list.add(s);
        s = new Type().setNavy_seal(26, 22, 5, 2, "HighestDamageAttackStrategy", true);
        list.add(s);
        s = new Type().setNavy_seal(34, 17, 6, 2, "LowestHealthAttackStrategy", true);
        list.add(s);
        s = z.setMirage_tank(25, 11, 8, 2, "LowestHealthAttackStrategy", true);
        list.add(s);
        s = z.setGrizzly_Tank(14, 22, 9, 2, "HighestDamageAttackStrategy", true);
        list.add(s);
        s = z.setPrism_tank(7, 21, 10, 2, "HighestDamageAttackStrategy", true);
        list.add(s);
        for (int i = 0; i < list.size(); i++) {
            Generate(list.get(i), list.get(i).getName());
        }

//        MoveThing();
        listmoveInvader.addAll(list);
        return list;
    }

    public void Generate(Unit o, String name) {
        key = name;
        List<Unit> L = new ArrayList<Unit>();

        if (team_Invader.get(key) == null) {
            team_Invader.put(key, L);
        } else {
            team_Invader.get(key).add(o);
        }
    }


    public void MoveThing() {


        Iterator key = team_Invader.keySet().iterator();

        while (key.hasNext()) {
            Object k = key.next();
            for (int i = 0; i < team_Invader.get(k).size(); i++) {

                listmoveInvader.add(i, team_Invader.get(k).get(i));

            }
        }
    }


    public void print() {

        Iterator keys = team_Invader.keySet().iterator();

        Iterator values = team_Invader.values().iterator();
        while (keys.hasNext()) {
            Object k = keys.next();
            System.out.print(k + "\t | ");
            for (int i = 0; i < team_Invader.get(k).size(); i++)
            {
                System.out.print(" " + team_Invader.get(k).get(i).getHealth());
            }
            System.out.println();
        }

    }
}

