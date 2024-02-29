package Controller.Attack.AttackStrategy;
import Game.Arena;
import Model.Object.*;
import filter.Filter;

import java.util.List;

public  class LowestHealthAttackStrategy  extends AttackStrategy {
    @Override
    public Unit attac(List<Unit> temp) {
        double min = 1000.0;
        Unit temp1 = new Unit();
        for (int i = 0; i < temp.size(); i++) {
            if (min >=temp.get(i).getHealth()) {
                min = temp.get(i).getHealth() ;
                temp1 = temp.get(i) ;
            }
        }

        return  temp1 ;
    }
}
