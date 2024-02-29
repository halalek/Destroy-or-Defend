package Model.Object;

import Game.Arena;
import Game.Team.TeamDefender.Base;

import java.util.ArrayList;

public class Type {
    public static ArrayList<Unit> Solider = new ArrayList<>();
    public static ArrayList<Unit> Tank = new ArrayList<>();
    public static ArrayList<Unit> Airplane = new ArrayList<>();
    public static ArrayList<Unit> Structure = new ArrayList<>();


    public Unit setSniper(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Solider.get(0);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setMove(false);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 0);//size=1
        return SoliderCopy;

    }

    public Unit setInfantry(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack)//المشاة
    {
        Unit SoliderCopy = new Unit() {};
        Unit SoliderBase = Solider.get(1);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 0);//size=1
        return SoliderCopy;

    }

    public Unit setNavy_seal(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Solider.get(2);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 0.5);//size=
        return SoliderCopy;

    }

    public Unit setTesla_tank(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Tank.get(0);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 0.5);//size=20//2
        return SoliderCopy;

    }

    public Unit setMirage_tank(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Tank.get(1);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 1);//size=16//1.5
        return SoliderCopy;

    }

    public Unit setGrizzly_Tank(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Tank.get(2);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 1);//size=20//2
        return SoliderCopy;

    }

    public Unit setTank_destroyer(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Tank.get(3);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setMove(false);
        SoliderCopy.setSite(x, y, 1.5);//size=20//2
        return SoliderCopy;

    }

    public Unit setPrism_tank(int x, int y, int id, int typeUnit,String name_strateg,boolean normal_attack) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Tank.get(4);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setStrategy_unit(name_strateg);
        SoliderCopy.setUnitattack(normal_attack);
        SoliderCopy.setSite(x, y, 1);//size=20//2
        return SoliderCopy;

    }

    public Unit setBlack_Eagle(int x, int y, int id, int typeUnit) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Airplane.get(0);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setSite(x, y, 0);//size=4
        return SoliderCopy;

    }

    public Unit setPillbox(int x, int y, int id, int typeUnit)//كوخ بقلبو عالم عم تقتل
    {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Structure.get(0);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setMove(false);
        SoliderCopy.setSite(x, y, 2.5);//size=40
        return SoliderCopy;

    }

    public Unit setPrism_tower(int x, int y, int id, int typeUnit) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Structure.get(1);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setMove(false);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setSite(x, y, 1);//size=30
        return SoliderCopy;

    }

    public Unit setGrand_cannon(int x, int y, int id, int typeUnit)//مدفع
    {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Structure.get(2);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setSite(x, y, 2.5);//size=40
        return SoliderCopy;

    }

    public Unit setBase(int x, int y, int id, int typeUnit) {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Structure.get(3);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setType("BASE");
        SoliderCopy.setId(id);
        SoliderCopy.setMove(false);
        new Base().setBase(SoliderCopy);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setSite(x, y, 2);//size=50//3
        return SoliderCopy;

    }

    public Unit setPatriot_Missile_System(int x, int y, int id, int typeUnit)//صواريخ للمدافعين بتقتل طائرات مهاجمين
    {
        Unit SoliderCopy = new Unit();
        Unit SoliderBase = Structure.get(4);
        SoliderCopy = Copy(SoliderCopy, SoliderBase);
        SoliderCopy.setId(id);
        SoliderCopy.setMove(false);
        SoliderCopy.setTypeUnit(typeUnit);
        SoliderCopy.setSite(x, y, 1.5);//size=30//2
        return SoliderCopy;

    }

    public Unit Copy(Unit SoliderCopy, Unit SoliderBase) {
        SoliderCopy.setType(SoliderBase.getType());
        SoliderCopy.setName(SoliderBase.getName());
        SoliderCopy.setUnitPrice(SoliderBase.getUnitPrice());
        SoliderCopy.setHealth(SoliderBase.getHealth());
        SoliderCopy.setAttackFrequency(SoliderBase.getAttackFrequency());
        SoliderCopy.setCanTarget(SoliderBase.getCanTarget());
        SoliderCopy.setAttackRange(SoliderBase.getAttackRange());
        SoliderCopy.setAttackDamage(SoliderBase.getAttackDamage());
        SoliderCopy.setArmor(SoliderBase.getArmor());
        SoliderCopy.setMovementspeed(SoliderBase.getMovementspeed());
        return SoliderCopy;

    }
}
