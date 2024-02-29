package Controller.Attack.Unit_Attack;
import Controller.Attack.AttackStrategy.AttackStrategy;
import Game.Arena;
import Model.Object.Unit;
import Model.Problem.Bridges;
import Model.Problem.River;
import filter.Filter;

import java.util.List;

public class NormalunitAttack extends Unitattack {

    @Override
    public  void PerformAttack(Unit unit, Filter filter, Arena a) {
      //  a.prodcest(new River().processor());
//        if(true)
//        {a.prodcest(new Bridges().processor());}
        temp =  addFilter(filter, a, unit);
        Unit temp1=unit.getAttackStrategy().attac(temp) ;
        unit.getAttackStrategy().result(temp1,unit,a,temp,filter);

    }
}


