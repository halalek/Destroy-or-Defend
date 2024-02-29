package Controller.Attack.AttackStrategy;
import Game.Arena;
import Model.Object.*;
import filter.Filter;

import java.util.List;

public  abstract class AttackPriority extends AttackStrategy  {

    public abstract Unit attac(List<Unit> temp);
}