package Controller.Attack.AttackStrategy;
import Game.Arena;
import Game.FILE.LogFile;
import Model.Object.*;
import filter.Filter;

import java.util.ArrayList;
import java.util.List;

public  abstract class AttackStrategy {

    public abstract Unit attac(List<Unit> temp);

    public void result(Unit unit1, Unit unit, Arena a, ArrayList<Unit> temp,Filter filter) {
        ArrayList<Unit>tempcopy=temp;
        double healthy = 0.0;
       // System.out.println(temp.size());
        int start ;
        while (unit1.getName()!=null&&unit1.getHealth()>0)
        { if (unit1!=null) {
            if (unit1.getArmor() != 0) {
                healthy = (unit1.getArmor() * unit1.getHealth());
                unit1.setHealth((unit1.getHealth() + (healthy)) - unit.getAttackDamage());
                unit1.setArmor(0);
            } else {
                unit1.setHealth(unit1.getHealth() - unit.getAttackDamage());
            }
            if (unit1.getHealth() <= 0) {
                unit.Target.add(unit1.getName());
                new LogFile().store(unit);
            //   System.out.println(unit.getName()+ " " +unit.getId()+ " : "+ " kill " +unit1.getName()) ;
                a.clear(unit1);
                int x=temp.size();
                for (int i = 0; i < x; i++) {
                    if (temp.get(i).getId() == unit1.getId()) {
                       //tempcopy.remove(i);
                        start= filter.get_index() ;
                        start-- ;
                        filter.set_index(start);
                    }
                }
                unit.setAttackDamage((int) unit.getAttackDamage() + 10);
            }
            temp=new ArrayList<>();
        }

        }}
}


