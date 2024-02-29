package Controller.Attack.AttackStrategy;
import Game.Arena;
import Game.Team.TeamDefender.Base;
import Model.Object.Unit;
import filter.Filter;
import filter.IFilterable;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AttackRandom extends AttackStrategy
{
    public Unit attac(List<Unit>temp) {
        Random rand = new Random();
        return temp.get(rand.nextInt(temp.size()));
    }
}
