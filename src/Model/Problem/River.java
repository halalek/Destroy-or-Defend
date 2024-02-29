package Model.Problem;
import Model.Object.*;

public class River extends Problem {

    public River() {
    }

    public River(int id, int x, int y) {
        this.name = "River";
        this.id = id;
        this.setSite(x, y, 2.5);
        this.Type = "Problem";
        this.AttackDamage = 5;
    }

    public Unit processor()
    {
        Unit car= new River(6,8,5);
       return car;
        }
}

//    public boolean  processor(Unit unit, Arena a)
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
//                        double s = unit.getMovementspeed();
//                        s-=10.0;
//                        unit.setMovementspeed((int) s);
//                        return true;
//                    }
//
//                }
//            }
//        }
//        return false;
//    }
//}