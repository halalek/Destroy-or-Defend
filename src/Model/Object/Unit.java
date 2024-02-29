package Model.Object;

import Controller.Attack.AttackStrategy.AttackRandom;
import Controller.Attack.AttackStrategy.AttackStrategy;
import Controller.Attack.AttackStrategy.HighestDamageAttackStrategy;
import Controller.Attack.AttackStrategy.LowestHealthAttackStrategy;
import Controller.Attack.Unit_Attack.AreaofDestructionUnitAttack;
import Controller.Attack.Unit_Attack.NormalunitAttack;
import Controller.Attack.Unit_Attack.Unitattack;
import Controller.movement.DefenderMovement;
import Controller.movement.InvaderMovment;
import Controller.movement.Movement;
import Game.Arena;
import Model.Problem.Bomb_Cars;
import Model.Problem.Bridges;
import Model.Problem.River;
import Model.Problem.Valley;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

//كلاس العنصر
public class Unit {
    protected String name;
    protected int id = -1;
    protected double health = 0.0;
    protected double armor;
    protected int typeUnit;
    protected String Type;
    protected int AttackRange;
    protected double AttackFrequency = 1;
    protected int AttackDamage;
    protected int Movementspeed = 1;
    protected boolean move = true;
    protected AttackStrategy strategy_unit = new LowestHealthAttackStrategy();
    protected Unitattack unitattack = new NormalunitAttack();
    protected Position position = new Position();
    protected int UnitPrice;
    protected Movement movement;
    protected Type T = new Type();
    public List<String> CanTarget = new ArrayList<>();
    public List<String> Target = new ArrayList<>();


    public Unit() {
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean getMove() {
        return move;
    }

    public Unitattack getUnitattack() {

        return unitattack;
    }

    public void setUnitattack(boolean normal_attack) {

        if (normal_attack == true) {
            unitattack = new NormalunitAttack();
        } else if (normal_attack == false) {
            unitattack = new AreaofDestructionUnitAttack();
        }

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position setPosition() {
        return position;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setSite(int x, int y, double r) {
        position.x = x;
        position.y = y;
        position.reduis = r;
    }


    public int getAttackRange() {

        return AttackRange;
    }

    public double getAttackFrequency() {
        return AttackFrequency;
    }


    public void setMovementspeed(int movementspeed) {
        this.Movementspeed = movementspeed;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setAttackFrequency(double attackFrequency) {
        this.AttackFrequency = attackFrequency;
    }

    public Position getPosition() {
        return position;
    }

    public void setAttackRange(int attackRange) {
        this.AttackRange = attackRange;
    }

    public void setUnitPrice(int unitPrice) {
        this.UnitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public int getMovementspeed() {
        return Movementspeed;
    }

    public double getArmor() {
        return armor;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return Movementspeed;
    }


    public int getAttackDamage() {
        return AttackDamage;
    }

    public int getTypeUnit() {
        return typeUnit;
    }


    public List<String> getCanTarget() {
        return CanTarget;
    }

    public String getName() {
        return name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setArmor(double safe) {
        this.armor = safe;
    }

    public void setSpeed(int Movementspeed) {
        this.Movementspeed = Movementspeed;
    }

    public void setAttackDamage(int AttackDamage) {
        this.AttackDamage = AttackDamage;
    }

    public void setTypeUnit(int typeUnit) {
        this.typeUnit = typeUnit;
        if (typeUnit == 1)
            movement = new DefenderMovement(true, 4);
        else
            movement = new InvaderMovment();
    }

    public void setStrategy_unit(String name_strateg) {
        if (name_strateg.equals("AttackRandom") == true)
            strategy_unit = new AttackRandom();
        else if (name_strateg.equals("HighestDamageAttackStrategy") == true)
            strategy_unit = new HighestDamageAttackStrategy();
        else if (name_strateg.equals("LowestHealthAttackStrategy") == true) {
            strategy_unit = new LowestHealthAttackStrategy();
        }

    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void setCanTarget(List<String> CanTarget) {
        this.CanTarget = CanTarget;
    }

    public boolean processor(Unit unit, Arena a) {
        boolean b = false;
        if (unit.getName() == "Bomb_Cars") {
            Bomb_Cars bomb_cars = new Bomb_Cars();
            b = bomb_cars.processor(unit, a);
        }

        if (unit.getName() == "Bridges") {
            Bridges bridges = new Bridges();
            b = bridges.processor(unit, a);
        }

        if (unit.getName() == "River") {
            River river = new River();
            b = river.processor(unit, a);
        }

        if (unit.getName() == " Valley") {
            Valley valley = new Valley();
            b = valley.processor(unit, a);
        }
        return b;
    }

    public Movement getMovement() {
        return movement;
    }

    public AttackStrategy getAttackStrategy() {
        return strategy_unit;
    }
}
