package Controller.Thraed;

import Controller.movement.DefenderMovement;
import Controller.movement.InvaderMovment;
import Game.Arena;
import Game.Game;
import Game.Team.TeamDefender.Base;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Model.Object.Unit;
import filter.List_Filter;

import java.util.ArrayList;

public class MyThread extends Thread  {

    private InvaderMovment invaderMovment;
    private  Unit unit;
    private  Arena a;
    private  Game game;
    private static Unit b=new Base().getBase();
    private DefenderMovement defenderMovement;


    public MyThread(Unit unit, Game game,Arena arena) {
        this.unit = unit;
        this.game=game;
        this.a=arena;
    }


    public Unit getUnit(){
        return unit;
    }
    public void setA(Arena a) {
        this.a = a;
    }

    public void setB(Base b) {
        this.b = b;
    }

//    public void important(Unit w, Arena a, Base b) {
//
//      //  this.invaderMovment = invaderMovment;
//        //   this.defenderMovement = defenderMovement;
//        this.invaderMovment.move(w,a,b);
//    }

//    @Override
//    public void run() {
//       int n1=0;
//
//  try {
////           while(unit.endgameUnit()){
////               if (unit.getTypeUnit() == 2) {
////                   if (unit.getMove() == true) {
////                       sleep(1000);
////                       new InvaderMovment().move(unit, a, b);
////                   } else if (unit.getMove() == false) {
////                       unit.getUnitattack().PerformAttack(unit, new List_Filter(), a);
////                   }
////               }
////           }
////           stop();!game.EndGame() &&
////!game.EndGame() &&&&unit.getHealth() > 0
//      while (n1<2) { n1++;
//          if (unit.getTypeUnit() == 2) {
//              if (unit.getMove() == true) {
//
//                  new InvaderMovment().move(unit, a, b);
//              } else if (unit.getMove() == false) {
//                  sleep((long) unit.getAttackFrequency());
//                  unit.getUnitattack().PerformAttack(unit, new List_Filter(), a);
//              }
//          }
//          if (unit.getTypeUnit() == 1) {
//              System.out.println("qqqqqqqqqqqq");
//           //   sleep(((long) unit.getAttackFrequency()));
//              if (unit.getMove() == true) {
//                  new DefenderMovement(true, 4).move(unit, a, b);
//              } else if (unit.getMove() == false) {
//                  sleep((long) unit.getAttackFrequency());
//                  unit.getUnitattack().PerformAttack(unit, new List_Filter(), a);
//              }
//              //System.out.println("lllllllllllllllllllllllll");
//          }
//
//      }
//      stop();
//     // System.out.println("sdaaklsmdlkasdlkasmdlkasml");
////      if(unit.getTypeUnit()==1&&unit.getHealth()<=0)
////      {
////        //  new TeamDefender().clrea(unit);
////          System.out.println("clear defender");
////
////      }
////      else if(unit.getTypeUnit()==2&&unit.getHealth()<=0)
////      {System.out.println("clear invender");
////        //  new TeamInvader().clrea(unit);
////       //listmove.remove(unit);
////      }
//
//  }
//
//
//          //  this.defenderMovement.movement();
//
//  catch (Exception ex) {
//        }
//
//
//}
    @Override
    public void run() {
        int n1 = 0;

        try {

//           stop();!game.EndGame() &&
//!game.EndGame() &&&&unit.getHealth() > 0
            while (unit.getHealth()>0&&!game.EndGame()) {
                n1++;

//                sleep(((long)(1/unit.getAttackFrequency())));
                if (unit.getTypeUnit() == 2) {
                  sleep(((long)(1/(unit.getAttackFrequency())*1000)));
                    if (unit.getMove() == true) {
                        sleep(((long)((1/unit.getMovementspeed())*1000)));
                        new InvaderMovment().move(unit, a, b);
                    }
                    unit.getUnitattack().PerformAttack(unit,new List_Filter(),a);
                }

                if (unit.getTypeUnit() == 1) {
                    sleep(((long) (1/(unit.getAttackFrequency())*1000)));
                    if (unit.getMove() == true) {
                        sleep(((long)((1/unit.getMovementspeed())*1000)));
                        new DefenderMovement(true, 4).move(unit, a, b);
                    }
                    unit.getUnitattack().PerformAttack(unit, new List_Filter(), a);
                }


            }
            stop();

            //System.out.println("lllllllllllllllllllllllll");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("ERROR: "+e.getLocalizedMessage());
        }
    }
}
     // System.out.println("sdaaklsmdlkasdlkasmdlkasml");
//      if(unit.getTypeUnit()==1&&unit.getHealth()<=0)
//      {
//        //  new TeamDefender().clrea(unit);
//          System.out.println("clear defender");
//
//      }
//      else if(unit.getTypeUnit()==2&&unit.getHealth()<=0)
//      {System.out.println("clear invender");
//        //  new TeamInvader().clrea(unit);
//       //listmove.remove(unit);

