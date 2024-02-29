package Controller.Attack.Unit_Attack;

import Game.Arena;
import Model.Object.Unit;
import Model.Problem.Bridges;
import Model.Problem.River;
import filter.Filter;

import java.util.List;

public class AreaofDestructionUnitAttack  extends Unitattack {

    @Override
    public void   PerformAttack(Unit unit, Filter filter, Arena a) {
      //  a.prodcest(new River().processor());
//        if(true)
//        {a.prodcest(new Bridges().processor());}
      //  System.out.println("temp.size12121()"+temp.size());
        temp =  addFilter(filter, a, unit);
        for (int i=start ;i<temp.size()  ;i++) {
            unit.getAttackStrategy().result(temp.get(i),unit,a,temp,filter);
        }

    }


}