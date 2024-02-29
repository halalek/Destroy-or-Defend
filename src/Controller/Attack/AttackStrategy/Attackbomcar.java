package Controller.Attack.AttackStrategy;

import Controller.Attack.AttackStrategy.AttackStrategy;
import Game.Arena;
import Model.Object.Unit;
import filter.Filter;

import java.util.List;

public class Attackbomcar extends AttackStrategy {
    @Override
    public Unit attac(List<Unit> temp) {
        Unit temp1 = new Unit();
      //  System.out.println("temp.size()"+temp.size());
        for (int i = 0; i < temp.size(); i++) {
            if ( temp.get(i).getName().equals("Bomb_Cars")==true) {
                temp1 = temp.get(i);
            }
        }
        return temp1;
    }
}