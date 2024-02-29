package Model.Problem;
import Game.Arena;
import Model.Object.*;
public class Valley  extends Problem{

    public Valley(){}
    public Valley(int id,int x,int y)
    {
        this.name="Vally" ;
        this.id=id;
        this.setSite(x,y,0.5);//size=16
        this.Type="Problem";
    }

    public boolean  processor(Unit unit, Arena a)
    {
        int start ;
        int start2 ;
        int end ;
        int end2 ;
        int x =0 ;
        int y=0 ;
        if(unit.getPosition().x<unit.getAttackRange())
            start =unit.getAttackRange()-unit.getPosition().x ;
        else
            start =unit.getPosition().x -unit.getAttackRange();

        if(unit.getPosition().y<unit.getAttackRange())
            start2 =unit.getAttackRange()-unit.getPosition().y ;
        else
            start2 =unit.getPosition().y -unit.getAttackRange();
        end=unit.getPosition().x +unit.getAttackRange();
        end2=unit.getPosition().y +unit.getAttackRange();

        for (int i=start ;i<=end ;i++) {
            for (int j = start2; j <= end2; j++) {
                if(a.Arena.get(i).get(j)!=null)
                {
                    if(a.Arena.get(i).get(j).Wild.getName()==this.getName())
                    {
                        return true;
                        // اذا استدعيتو ورجع صح لا يجب ان يتحرك اي لا استدعي تابع الحركة

                    }
                }
            }
        }
        return false;
    }
}
