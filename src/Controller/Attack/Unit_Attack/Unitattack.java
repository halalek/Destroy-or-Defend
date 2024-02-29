package Controller.Attack.Unit_Attack;

import Game.Arena;
import Model.Object.Unit;
import filter.Filter;
import filter.IFilterable;

import java.util.ArrayList;
import java.util.List;

public abstract class Unitattack implements IFilterable {
    ArrayList<Unit> temp=new ArrayList<>() ;
    int start ;
    int end  ;
    Unitattack()
    {
        start=0 ;
        end=100000 ;
    }
    public ArrayList<Unit> addFilter (Filter filter, Arena a, Unit unit){
        return  filter.isAccepted(a, unit);
    }
    public  abstract void PerformAttack(Unit unit, Filter filter, Arena a) ;
}

