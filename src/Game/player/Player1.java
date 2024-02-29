package Game.player;


import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Model.Object.Type;
import Model.Object.Unit;

import java.util.ArrayList;

public class Player1 extends Player {
    public TeamDefender defenders = new TeamDefender();

    @Override

    public void buyUnit(String name, int x, int y, int id, String name_stratege, boolean normal_attack) {
        Unit temp;
        Type z = new Type();

        if (name.equals("Sniper") == true)
            if (coins >= 5) {
                coins = coins - 5;
                temp = z.setSniper(x, y, id, 1, name_stratege, normal_attack);
                defenders.Generate(temp, "sniper");
            } else if (name.equals("Infantry") == true)
                if (coins >= 5) {
                    coins = coins - 3;
                    temp = z.setInfantry(x, y, id, 1, name_stratege, normal_attack);
                    defenders.Generate(temp, "Infantry");
                } else if (name.equals("Navy_seal") == true)
                    if (coins >= 10) {
                        coins = coins - 10;
                        temp = z.setNavy_seal(x, y, id, 1, name_stratege, normal_attack);
                        defenders.Generate(temp, "Navy_seal");
                    } else if (name.equals("Grizzly_tank") == true)
                        if (coins >= 50) {
                            coins = coins - 50;
                            temp = z.setGrizzly_Tank(x, y, id, 1, name_stratege, normal_attack);
                            defenders.Generate(temp, "Grizzly_tank");
                        } else if (name.equals("Pillbox") == true)
                            if (coins >= 150) {
                                coins = coins - 150;
                                temp = z.setPillbox(x, y, id, 1);
                                defenders.Generate(temp, "Pillbox");
                            } else if (name.equals("Prism_tower") == true)
                                if (coins >= 150) {
                                    coins = coins - 150;
                                    temp = z.setPrism_tower(x, y, id, 1);
                                    defenders.Generate(temp, "Prism_tower");
                                } else if (name.equals("Grand_cannon") == true)
                                    if (coins >= 200) {
                                        coins = coins - 200;
                                        temp = z.setGrand_cannon(x, y, id, 1);
                                        defenders.Generate(temp, "Grand_cannon");
                                    } else if (name.equals("Patriot_Missile_System") == true)
                                        if (coins >= 175) {
                                            coins = coins - 175;
                                            temp = z.setPatriot_Missile_System(x, y, id, 1);
                                            defenders.Generate(temp, "Patriot_Missile_System");
                                        } else if (name.equals("Tesla_tank") == true)
                                            if (coins >= 50) {
                                                coins = coins - 50;
                                                temp = z.setTesla_tank(x, y, id, 1, name_stratege, normal_attack);
                                                defenders.Generate(temp, "Tesla_tank");
                                            } else if (name.equals("Mirage_tank") == true)
                                                if (coins >= 70) {
                                                    coins = coins - 70;
                                                    temp = z.setMirage_tank(x, y, id, 1, name_stratege, normal_attack);
                                                    defenders.Generate(temp, "Mirage_tank");
                                                } else if (name.equals("Tank_destroyer") == true)
                                                    if (coins >= 50) {
                                                        coins = coins - 50;
                                                        temp = z.setTank_destroyer(x, y, id, 1, name_stratege, normal_attack);
                                                        defenders.Generate(temp, "Tank_destroyer");
                                                    } else if (name.equals("Prism_tank") == true)
                                                        if (coins >= 60) {
                                                            coins = coins - 60;
                                                            temp = z.setPrism_tank(x, y, id, 1, name_stratege, normal_attack);
                                                            defenders.Generate(temp, "Prism_tank");
                                                        } else if (name.equals("Black_Eagle") == true)
                                                            if (coins >= 75) {
                                                                coins = coins - 75;
                                                                temp = z.setBlack_Eagle(x, y, id, 1);
                                                                defenders.Generate(temp, "Black_Eagle");
                                                            }
    }

    @Override
    public TeamDefender getObjectD() {
        return defenders;
    }

    @Override
    public TeamInvader getObjectI() {
        return null;
    }


}
