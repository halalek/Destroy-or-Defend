package Model.Problem;
import Game.Arena;
import Game.Node;
import Model.Object.*;

import java.util.ArrayList;

public class   Problem extends Unit  {

   static ArrayList<Unit> prob=new ArrayList<>();

public  void setproblem(Unit p)
{
    prob.add(p);
}

    public  ArrayList getproblem()
    {
       return prob;
    }
    public  ArrayList<Unit> Generateproblem()
    {  ArrayList<Unit> problem=new ArrayList<>();

        Problem valley=new Valley(19,30,13);
       //  Problem bomb_cars=new Bomb_Cars(21,false,4,14);
         Problem bridges=new Bridges(20,15,13);
         Problem river=new River(22,20,16);
        problem.add(0,valley) ;
        problem.add(1,bridges) ;
       // problem.add(2,bomb_cars) ;
        problem.add(2,river) ;
      //  prob.add(bomb_cars);
        return problem;
    }

    public Problem()
    {}

    public void setSite(int x, int y,double r) {
        this.position.x = x;
        this.position.y = y;
        this.position.reduis = r;
    }


    public void setposition(Position site) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean processorRiver(Unit unit) {

       if(unit.getName().equals("River")==false)
            return false;
        else {
           return true;
        }

    }

    public boolean processorBridges(Unit unit) {

        if(unit.getName().equals("Bridges")==false)
            return false;
        else {
            return true;
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }



    public int getId() {
        return id;
    }
}