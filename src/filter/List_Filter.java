package filter;

import Game.Arena;
import Model.Object.Unit;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class List_Filter extends Filter {

    boolean check_goal(Unit unit, Unit unit2){

        for (int i = 0; i < unit.getCanTarget().size(); i++) {
            if (unit.getCanTarget().get(i).equals(unit2.getType()))
                {
                        return true;

            }
        }
        return false;
    }
    @Override
    public ArrayList<Unit> isAccepted(Arena a, Unit unit) {
        Object1=new ArrayList<>();
        int start=0;
        int start2=0;
        int end=0;
        int end2=0;
        int x = 0;
        int y = 0;
        if (unit.getPosition().x < unit.getAttackRange())
            start = unit.getAttackRange() - unit.getPosition().x;
        else
            start = unit.getPosition().x - unit.getAttackRange();

        if (unit.getPosition().y < unit.getAttackRange())
            start2 = unit.getAttackRange() - unit.getPosition().y;
        else
            start2 = unit.getPosition().y - unit.getAttackRange();
        end = unit.getPosition().x + unit.getAttackRange();
        end2 = unit.getPosition().y + unit.getAttackRange();
        for (int i = start; i <= end; i++) {
            for (int j = start2; j <= end2; j++) {


                if(a.Arena.get(i).get(j).Wild!=null) {

                    if (a.Arena.get(i).get(j).Wild.getTypeUnit() != unit.getTypeUnit())
                    {
                        if (check_goal(unit, a.Arena.get(i).get(j).Wild) == true) {
                           // System.out.println("llllllllllllllllllllllllllll");
                            Object1.add( a.Arena.get(i).get(j).Wild);//startlist
                            start_list++;
                        }
                        }
                    }

            }

        }
        return Object1;
    }

}


