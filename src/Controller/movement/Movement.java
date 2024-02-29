package Controller.movement;

import Game.Arena;
import Game.FILE.LogFile;
import Model.Object.Unit;
import Model.Problem.Bridges;
import Model.Problem.Problem;
import Model.Problem.River;

public abstract class Movement {
    public boolean check_river;
    public boolean check_bridge;

    // public abstract void move(Unit unit);
    Movement() {

    }

    //اعتمدت انو كل حركة ابعتلو مكان قاعدة, ورقعة ليمشي عليها*------*
    public abstract void move(Unit unit, Arena a, Unit b);

    //تابع بشيك ع منطقة لاعرف انتقل ولا لا *------*
    public boolean check_move(Unit unit, int temp_x, int temp_y, Arena a) {

        Problem problem=new Problem();
        double k, l;
        if (temp_x > unit.getPosition().reduis)
            k = (temp_x - unit.getPosition().reduis);
        else
            k = unit.getPosition().reduis - temp_x;

        if (temp_y > unit.getPosition().reduis)
            l = temp_y - unit.getPosition().reduis;
        else
            l = unit.getPosition().reduis - temp_y;

        double n = unit.getPosition().reduis + temp_x;
        double m = unit.getPosition().reduis + temp_y;


        for (int i = (int) k; i <= n; i++) {
            for (int j = (int) l; j <= m; j++) {
                if (a.Arena.get(i).get(j).Wild.getName() != null) {
                    if (a.Arena.get(i).get(j).Wild.getId() != unit.getId()) {
                       // if (problem.processorRiver(a.Arena.get(i).get(j).Wild))

                        if (a.Arena.get(i).get(j).Wild.getName().equals("River"))
                        {check_river=true;
                        return true;}
                     //   else if (problem.processorBridges(a.Arena.get(i).get(j).Wild))

                        else if (a.Arena.get(i).get(j).Wild.getName().equals("Bridges"))
                        {check_bridge=true;
                            return true; }
                        return false;}

                }

            }
        }
        return true;
    }


    //تتابع ينقل عنصر*-------*
    void move_step(Unit unit, int temp_x, int temp_y, Arena a) {
        new LogFile().store(unit);
     //  System.out.println( unit.getName() +" " +unit.getId() +"  : move " + unit.getPosition().x + " " + unit.getPosition().y);
        a.clear(unit);
        if(check_river==true)
        {
            double s = unit.getMovementspeed();
            if(s>0)
                s-=2.0;
            unit.setMovementspeed((int)s);
            a.prodcest(new River().processor());
        }
        if(check_bridge==true)
        {   a.prodcest(new Bridges().processor()); }

        unit.getPosition().x = temp_x;
        unit.getPosition().y = temp_y;
        unit.setSite(temp_x,temp_y,unit.getPosition().reduis);
        a.prodcest(unit);
    }
}

