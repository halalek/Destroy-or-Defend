package Controller.RoundManager;

import Controller.Thraed.MyThread;
import Game.Arena;
import Game.Game;
import Game.Team.TeamDefender.Base;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Model.Object.Unit;
import Model.Problem.Problem;

import java.util.ArrayList;
import java.util.Map;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Round_1 extends Round_Manager {


//    public void clrear(String a)
//    {
//
//        for(int j=0;j<teamInvader.size();j++)
//        {
//            System.out.println("aaaaaaaaaaa");
//            if(teamInvader.get(j).getName().equals(a))
//            System.out.println(teamInvader.remove(teamInvader.get(j)));
//        }
//        System.out.println(teamInvader.size() + " ss");
//
//    }

    @Override

    public void Run(Game game,Arena a) {

        TeamDefender teamDefender = game.getTeamDefender();
        TeamInvader teamInvader = game.getTeamInvader();

        ArrayList<Unit> listTeamDefender = teamDefender.getListmoveDefender();
        ArrayList<Unit> listTeamInvader = teamInvader.getListmoveInvader();

            for (int i = 0; i < listTeamDefender.size(); i++) {
                Thread x1 = new MyThread(listTeamDefender.get(i), game,a);
            x1.start();
            }

        for (int i = 0; i < listTeamInvader.size(); i++) {
            Thread x1 = new MyThread(listTeamInvader.get(i), game,a);
            x1.start();
        }

        }

    }
