package Game;
//اللعبة
import Controller.Thraed.TimerTest;
import Game.Team.TeamDefender.Base;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Game.player.Player;
import Game.player.Player1;
import Game.player.Player2;
import Model.Object.Unit;
import Model.Problem.Problem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Game {
    Arena arena=new Arena();

    public List<Player> players=new ArrayList<Player>();
    TeamDefender teamDefender=new TeamDefender();
    TeamInvader teamInvader=new TeamInvader();
    TimerTest time=new TimerTest();

    private boolean end=false;

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public TeamDefender getTeamDefender() {
        return teamDefender;
    }

    public void setTeamDefender(TeamDefender teamDefender) {
        this.teamDefender = teamDefender;
    }

    public TeamInvader getTeamInvader() {
        return teamInvader;
    }

    public void setTeamInvader(TeamInvader teamInvader) {
        this.teamInvader = teamInvader;
    }


    public Game(){}
    public boolean grtend()
    {
        return end;
    }
    public void Generate()
    {
        players.add(new Player1());
        players.add(new Player2());
    }
    public boolean EndGame() {
        Player2 p=new Player2();
        Unit base=new Base().getBase();

        for (int i = 0; i<teamInvader.getListmoveInvader().size(); i++) {
            if (teamInvader.getListmoveInvader().get(i).getHealth()<0){
                teamInvader.getListmoveInvader().remove(i);
               // System.out.println("DeleteInvender" + teamInvader.getListmoveInvader().size());

            }
        }
        for (int i = 0;i<teamDefender.getListmoveDefender().size();i++) {
            if (teamDefender.getListmoveDefender().get(i).getHealth()<0){
                teamDefender.getListmoveDefender().remove(i);
               // System.out.println("DeleteDefender" + teamDefender.getListmoveDefender().size());
            }
        }
        if(base.getHealth()<=0)
        {
            if (!end){
                end=true;
               // arena.p();
              //  arena.printStore();
                //new LogFile().main(args);
                time.EndTimerTest();
                System.out.println(Game_State.AttackerWon);

            }

            return true;
        }
        else if(teamInvader.getListmoveInvader().size()==0)
        {
            if (!end){
                end=true;
                time.EndTimerTest();
                System.out.println(Game_State.DeffenderWon);
            }


            return true;
        }
        else if(time.isTime())
        {
            System.out.println(Game_State.DeffenderWon);
            return true;
        }


        return  false;
    }

    public void startGame(int t)
    {
        time=new TimerTest(t);
        System.out.println(Game_State.Running);

    }
    public  void FromTeam(){

        Problem problem=new Problem();
        arena.prod(teamDefender.Form());
        arena.prod(teamInvader.Form());
        arena.prod(problem.Generateproblem());
    }

    void Buyunit(Unit temp,Arena a)
    {
        if(a.check_add(temp,temp.getPosition().x,temp.getPosition().y,a)==true)
            a.prodcest(temp);
    }

}
