package Game.Team.TeamDefender;

import Model.Object.*;

//القاعدة
public class Base extends Unit {
   static Unit base;

    public void setBase(Unit base) {
        this.base = base;
    }
    public Unit getBase()
    {return base;}

}
