package Model.Problem;

import Controller.Attack.AttackStrategy.AttackRandom;
import Controller.Attack.AttackStrategy.Attackbomcar;
import Controller.Attack.AttackStrategy.HighestDamageAttackStrategy;
import Controller.Attack.Unit_Attack.AreaofDestructionUnitAttack;
import Game.Arena;
import Model.Object.Unit;

import java.util.ArrayList;
import java.util.List;

public class Bomb_Cars extends Problem {

    ArrayList<String> list= new ArrayList<>();
    public Bomb_Cars(){}
    public Bomb_Cars(int id,boolean move,int x,int y) {
        this.name="Bomb_Cars";
        this.id=id;
        this.typeUnit=1;
        this.health=500;
        this.move=move;
        this.setSite(x,y,0.5);//size=4
        this.Type="Problem";
        this.AttackDamage=1000;
        this.AttackRange=10;
        this.unitattack= new AreaofDestructionUnitAttack();
        this.strategy_unit=new HighestDamageAttackStrategy();
        this.setCanTarget(getList());
    }

    public ArrayList<String> getList() {
        list.add("Tank");
        list.add("Solider");
        list.add("Structure");
        return list;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public double getArmor() {
        return armor;
    }
    public boolean getMove()
    {return move;}

    public void setArmor(double armor) {
        this.armor = armor;
    }


   public boolean processor(Unit unit, Arena a)
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
                        // اذا رجع صح لازم تهاجو اول شي الو اولوية فوق كل شي حوليه
                        List<String>s=new ArrayList<>();
                        s.add(this.getName());
                        unit.setCanTarget(s);

                        return true;
                    }
                }
            }
        }
        return false;
    }
}