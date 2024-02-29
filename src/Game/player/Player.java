package Game.player;

import Game.Game;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;

import java.util.List;

public abstract class Player {

    protected int coins=2000;
    public abstract void buyUnit(String name,int x,int y,int id,String name_stratege,boolean normal_attack) ;

    public abstract TeamDefender getObjectD();
    public abstract TeamInvader getObjectI();

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
