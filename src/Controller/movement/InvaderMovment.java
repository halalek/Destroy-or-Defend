package Controller.movement;

import Game.Arena;
import Game.Team.TeamDefender.Base;
import Model.Object.Unit;
import filter.Filter;
import filter.List_Filter;

import static java.lang.Thread.sleep;

public class InvaderMovment extends Movement {

    public InvaderMovment() {

    }

    public void movement() {

    }



    public void move( Unit w, Arena a, Unit b) {
        int p = 0;
        //استدعي تابع هجوم ازا يساوس صح معناتها انتقل وازا خطا معناتها اضرب ولا تنتقل *-------*
        int temp_x = w.getPosition().x;
        int temp_y = w.getPosition().y;


        if (w.getPosition().x < b.getPosition().x) {
                if (w.getPosition().y < b.getPosition().y) {
                    if ((temp_x + 1 != a.end) && (temp_y + 1 != a.end2)) {

                        if ((check_move(w, temp_x + 1, temp_y + 1, a) == true)) {
                            move_step(w, temp_x + 1, temp_y + 1, a);
                           // System.out.println("check_move");
                        }
                    }

                } else if (w.getPosition().y == b.getPosition().y) {

                    if (temp_x + 1 != a.end) {

                        if ((check_move(w, temp_x + 1, temp_y, a) == true)) {

                            move_step(w, temp_x + 1, temp_y, a);
                           // System.out.println("check_move");
                        }
                    }
                } else if (w.getPosition().y > b.getPosition().y) {
                    if ((temp_x + 1 != a.end) && (temp_y - 1 != 0))
                        if ((check_move(w, temp_x + 1, temp_y - 1, a) == true)) {

                            move_step(w, temp_x + 1, temp_y - 1, a);
                           // System.out.println("check_move");
                        }
                }
            }
            if (w.getPosition().x > b.getPosition().x) {

                if (w.getPosition().y < b.getPosition().y) {

                    if ((temp_x - 1 != 0) && (temp_y + 1 != a.end2)) {
                        if ((check_move(w, temp_x - 1, temp_y + 1, a) == true)) {
                            move_step(w, temp_x - 1, temp_y + 1, a);
                           // System.out.println("check_move");
                        }
                    }
                } else if (w.getPosition().y == b.getPosition().y) {

                    if (temp_x - 1 != 0) {
                        if ((check_move(w, temp_x - 1, temp_y, a) == true)) {
                           // System.out.println("check_move");
                            move_step(w, temp_x - 1, temp_y, a);
                        }
                    }
                } else if (w.getPosition().y > b.getPosition().y) {
                    if ((temp_x - 1 != 0) && (temp_y - 1 != 0)) {

                        if ((check_move(w, temp_x - 1, temp_y - 1, a) == true)) {
                          //  System.out.println("check_move");
                            move_step(w, temp_x - 1, temp_y - 1, a);
                        }
                    }
                }
            }
            if (w.getPosition().x == b.getPosition().x) {

                if (w.getPosition().y < b.getPosition().y) {

                    if (temp_y + 1 != a.end2)
                        if ((check_move(w, temp_x, temp_y + 1, a) == true)) {

                            move_step(w, temp_x, temp_y + 1, a);
                          //  System.out.println("check_move");
                        }

                } else if (w.getPosition().y > b.getPosition().y) {

                    if (temp_y - 1 != 0)
                        if ((check_move(w, temp_x, temp_y - 1, a) == true)) {

                            move_step(w, temp_x, temp_y - 1, a);
                           // System.out.println("check_move");
                        }

                }



        }p++;
    }}


