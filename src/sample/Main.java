//package sample;
//
//import Game.Arena;
//import Game.File;
//import Game.Team.TeamDefender.TeamDefender;
//import Game.Team.TeamInvader.TeamInvader;
//import Model.Object.*;
//
//import java.util.ArrayList;
//
//public class Main {

//    public static void printmap() {
//        Unit s=new Unit();
//        Type z=new Type();
//        Arena a = new Arena();
//        Unit tan = z.setTesla_tank( 1, 1, 1, 1);
//        System.out.println(tan.getName());
//        System.out.println(tan.getHealth());
//        Unit tan1 = z.setMirage_tank( 2, 1, 1, 1);
//        System.out.println(tan1.getName());
//        System.out.println(tan1.getHealth());
//        Unit nn = z.setInfantry( 1, 2, 1, 1);
//        Unit n = z.setSniper(1, 2, 1, 1);
//        TeamDefender d = new TeamDefender();
//        d.Generate(nn, nn.getName());
//        d.Generate(nn, nn.getName());
//        d.Generate(n, n.getName());
//        d.print();
//        TeamInvader i = new TeamInvader();
//        i.Generate(n, n.getName());
//        i.Generate(n, n.getName());
//        i.print();
//    }

//    public static void main(String[] args) {
//     //   printmap();
//        Arena a1=new Arena();
//        a1.Generate();
//        File a = new File();
//        a.Generate();
//        Unit q=new Unit() {};
//        TeamDefender team1=new TeamDefender();
//       // team1.Form();
//      // team1.print();
//        TeamInvader team=new TeamInvader();
//       // team.Form();
//     //   team.print();
//        a1.prod(team.Form());
//        a1.prod(team1.Form());
//        Type w=new Type();
//        Unit snip1= new Type().setSniper(1,1,33,1);
//        Unit snip2= new Type().setSniper(1,5,35,1);
//        Unit snip= w.setInfantry(4,4,34,1);
//
////        System.out.println(snip1.getId());
////        System.out.println(snip1.getPosition().x);
////        System.out.println(snip1.getPosition().y);
////        System.out.println(snip2.getId());
////        System.out.println(snip2.getPosition().x);
////        System.out.println(snip2.getPosition().y);
////        a1.prodcest(snip1);
////        a1.prodcest(snip2);
////        a1.prodcest(snip);
//           a1.p();
//      //  team.print();
//    //  a1.p();
////       Type z=new Type();
////       Unit s=z.setSniper(1,1,10,1);
////        System.out.println(s.getName());
////        System.out.println(s.getId());      //  System.out.println(q1.getHealth());
////        Unit s1=z.setPillbox(1,1,10,1);
////        System.out.println(s1.getName());
////        System.out.println(s1.getId());
////        Unit s2=z.setBase(1,1,10,1);
////        System.out.println(s2.getName());
////        System.out.println(s2.getId());
////        Unit s3=z.setGrand_cannon(1,1,10,1);
////        System.out.println(s3.getName());
////        System.out.println(s3.getId());
//
//    }
//}

     package sample;

import Controller.Attack.AttackStrategy.AttackRandom;
import Controller.Attack.AttackStrategy.AttackStrategy;
import Controller.Attack.AttackStrategy.LowestHealthAttackStrategy;

import Controller.RoundManager.Round_1;
import Controller.RoundManager.Round_Manager;
import Controller.Thraed.MyThread;
import Controller.Thraed.TimerTest;
import Controller.movement.DefenderMovement;
import Controller.movement.InvaderMovment;
import Game.Arena;
import Game.File;
import Game.Game;
import Game.Node;

import Game.Team.TeamDefender.Base;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Model.Object.*;
import Model.Problem.*;
import Views.StartGame;
import filter.Filter;
import filter.List_Filter;
import javafx.application.Application;
import javafx.stage.Stage;
import Game.*;

import javax.swing.Timer;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main extends Application {


    public static void mmain(){
         MMain m=new MMain();
         m.Main();

    }

    public static void AttackStrategy() {
            String attack;
        Scanner input = new Scanner(System.in);
        char i = 'a';
        System.out.println("\n" + "choose : ");
        System.out.println("A- AttackRandom  : ");
        System.out.println("  * AttackPriority * ");
        System.out.println("b- HighestDamageAttackStrategy : ");
        System.out.println("c- LowestHealthAttackStrategy : ");
            i = input.next().charAt(0);
            switch (i) {
                case 'a':
                  attack="AttackRandom";
                    Attack(attack);
                    ;
                    break;

                case 'b':
                    attack="HighestDamageAttackStrategy";
                    Attack(attack);
                     break;
                case 'c':
                    attack="LowestHealthAttackStrategy";
                    Attack(attack);
                    break;

                case 'e':
                    System.out.println("Exit the program ^-^");
                    break;


            }
        }






    public static void Attack(String attack)
    {
        File file = new File();
        file.Generate();
        Arena a = new Arena();
        a.Generate() ;
        Type z=new Type();
        DefenderMovement temp1=new DefenderMovement(true,4) ;
        Filter filter= new List_Filter() ;
        Node Unit1 = new Node();
        Node Unit6= new Node();
        Unit b=z.setBase(7,7,6,1) ;
        Unit6.Wild=b ;
        Node Unit2= new Node();
        Node Unit3= new Node();
        Unit1.Wild  = z.setTesla_tank( 3, 3, 1, 2,attack,true);
        Unit3.Wild = z.setInfantry(  6, 4, 3, 1," ",true);
        a.prodcest(Unit1.Wild );
        a.prodcest(Unit3.Wild );
        a.prodcest(Unit6.Wild);
        a.printexample();


        Unit1.Wild.getMovement().move(Unit1.Wild,  a,  b);
         Unit3.Wild.getMovement().move(Unit3.Wild,  a,  b);
         //Unit1.Wild.getMovement().move(Unit1.Wild,  a,  b);
        // Unit1.Wild.getUnitattack().PerformAttack(Unit1.Wild,filter,a) ;
         Unit1.Wild.getUnitattack().PerformAttack(Unit1.Wild,filter,a) ;
         a.printexample();






    }
public static void problem()
{
    String attack;
    Scanner input = new Scanner(System.in);
    char i = 'a';
    System.out.println("\n" + "choose : ");
    System.out.println(" * Problem *  ");
    System.out.println(" a- vally ");
    System.out.println(" b- River : ");
    System.out.println(" c- Bridge : ");
    i = input.next().charAt(0);
    switch (i) {
        case 'a':
            Avally();
            break;

        case 'b':
            Ariver();
            break;
        case 'c':
            Abridg();
            break;



    }
}

    public static void Ariver()
    {
        File file = new File();
        file.Generate();
        Arena a = new Arena();
        a.Generate() ;
        Type z=new Type();
        DefenderMovement temp1=new DefenderMovement(true,4) ;
        Filter filter= new List_Filter() ;
        Node Unit1 = new Node();
        Node Unit6= new Node();
        Unit b=z.setBase(7,7,6,1) ;
        // Unit6.Wild=b ;
        Node Unit3= new Node();
        Problem river=new River(8, 8, 5);
        Unit1.Wild=river;
        Unit3.Wild = z.setInfantry(  2, 2, 3, 1," ",true);
        a.prodcest(Unit1.Wild );
        a.prodcest(Unit3.Wild );
        // a.prodcest(Unit6.Wild);
        System.out.println(" BEFORE "+Unit3.Wild.getMovementspeed());
        a.printexample();
        Unit3.Wild.getMovement().move(Unit3.Wild,  a,  b);
        System.out.println(" AFTER"+Unit3.Wild.getMovementspeed());
        a.printexample();

    }

    public static void Avally()
    {
        File file = new File();
        file.Generate();
        Arena a = new Arena();
        a.Generate() ;
        Type z=new Type();
        DefenderMovement temp1=new DefenderMovement(true,4) ;
        Filter filter= new List_Filter() ;
        Node Unit1 = new Node();
        Node Unit6= new Node();
        Unit b=z.setBase(7,7,6,1) ;
       // Unit6.Wild=b ;
        Node Unit3= new Node();
        Problem vally=new Valley(8, 7, 4);
        Unit1.Wild=vally;
       // Unit1.Wild  = z.setTesla_tank( 3, 3, 1, 2,"AttackRandom",true);
        Unit3.Wild = z.setInfantry(  4, 4, 3, 1," ",true);
        a.prodcest(Unit1.Wild );
        a.prodcest(Unit3.Wild );
       // a.prodcest(Unit6.Wild);
        a.printexample();
        Unit3.Wild.getMovement().move(Unit3.Wild,  a,  b);
        a.printexample();

    }


    public static void Abridg()
    {
        File file = new File();
        file.Generate();
        Arena a = new Arena();
        a.Generate() ;
        Type z=new Type();
        DefenderMovement temp1=new DefenderMovement(true,4) ;
        Filter filter= new List_Filter() ;
        Node Unit1 = new Node();
        Node Unit6= new Node();
        Unit b=z.setBase(7,7,6,1) ;
        // Unit6.Wild=b ;
        Node Unit3= new Node();
        Problem bridge=new Bridges(8, 5, 4);
        Unit1.Wild=bridge;
        // Unit1.Wild  = z.setTesla_tank( 3, 3, 1, 2,"AttackRandom",true);
        Unit3.Wild = z.setInfantry(  1, 4, 3, 1," ",true);
        a.prodcest(Unit1.Wild );
        a.prodcest(Unit3.Wild );
        // a.prodcest(Unit6.Wild);
        a.printexample();
        Unit3.Wild.getMovement().move(Unit3.Wild,  a,  b);
        a.printexample();





    }
        public static void main(String[] args) {
            launch(args);
            Scanner input = new Scanner(System.in);
            char i = 'a';
                System.out.println("\n" + "choose : ");
                System.out.println("A- Start Game : ");
                System.out.println("B- AttackStrategy: ");
                System.out.println("C- Problem : ");
                System.out.println("E- Exit the program : ");
                i = input.next().charAt(0);
                switch (i) {
                    case 'a':
                        mmain();;
                        break;

                    case 'b':
                       AttackStrategy();
                        break;

                    case 'c':
                        problem();
                        break;

                    case 'e':
                        System.out.println("Exit the program ^-^");
                        break;


                }
            }


        @Override
        public void start(Stage primaryStage) throws Exception {
            // GameFx gameFx=new GameFx(primaryStage);
            StartGame startGame=new StartGame(primaryStage);
            primaryStage.show();
        }

    }