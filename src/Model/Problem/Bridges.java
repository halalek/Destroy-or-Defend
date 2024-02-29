package Model.Problem;
import Game.Arena;
import Model.Object.*;

import java.util.ArrayList;
import java.util.List;

public class Bridges extends Problem {

    double health;
    public Bridges() {}
    public Bridges(int id,int x,int y) {
        this.name="Bridges" ;
        this.id=(id);
        this.health=200;
        this.setSite(x,y,0.5);//size=4
        this.Type="Bridges";
        this.AttackDamage=1000 ;
    }
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

//    @Override
//   public boolean  processor(Unit unit, Arena a)
//    {
//        int start ;
//        int start2 ;
//        int end ;
//        int end2 ;
//        int x =0 ;
//        int y=0 ;
//        if(unit.getPosition().x<unit.getAttackRange())
//            start =unit.getAttackRange()-unit.getPosition().x ;
//        else
//            start =unit.getPosition().x -unit.getAttackRange();
//
//        if(unit.getPosition().y<unit.getAttackRange())
//            start2 =unit.getAttackRange()-unit.getPosition().y ;
//        else
//            start2 =unit.getPosition().y -unit.getAttackRange();
//        end=unit.getPosition().x +unit.getAttackRange();
//        end2=unit.getPosition().y +unit.getAttackRange();
//
//        for (int i=start ;i<=end ;i++) {
//            for (int j = start2; j <= end2; j++) {
//                if(a.Arena.get(i).get(j)!=null)
//                {
//                    if(a.Arena.get(i).get(j).Wild.getName()==this.getName())
//                    {
//                        List<String>s=new ArrayList<>();
//                        s.add(this.getName());
//                        unit.setCanTarget(s);
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public Unit processor()
    {
        Unit car= new Bridges(4,5,4);
        return car;
    }
}