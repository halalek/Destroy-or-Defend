package Controller.Attack.AttackStrategy;
import Game.Arena;
import Model.Object.*;
import filter.Filter;

import java.util.List;


public class HighestDamageAttackStrategy extends AttackStrategy {
    @Override
    public Unit attac(List<Unit> temp) {
        double max = 0.0;
        Unit temp1 = new Unit();
        for (int i = 0; i < temp.size(); i++) {
            if (max <= temp.get(i).getAttackDamage()) {
                max = temp.get(i).getAttackDamage();
                temp1 = temp.get(i);
            }
        }
        return temp1;
    }}