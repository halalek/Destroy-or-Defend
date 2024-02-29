package Controller.movement;

import Game.Arena;
import Game.Team.TeamDefender.Base;
import Model.Object.Unit;
import Model.Problem.Bridges;
import filter.Filter;
import filter.List_Filter;

import static java.lang.Thread.sleep;

public class DefenderMovement extends Movement {
    private boolean periodic_movement;
    private int distance_step;
    private static int count = 0;
    private boolean front;

    public DefenderMovement(boolean periodic_movement1, int distance_step1) {
        periodic_movement = periodic_movement1;
        distance_step = distance_step1;
        front = true;
    }

    public DefenderMovement() {

    }

    public void movement() {
    }


    public void move(Unit w, Arena a, Unit b) {


        int pp = 0;
            while (pp<4) {
                int temp_x = w.getPosition().x;
                int temp_y = w.getPosition().y;


                if (periodic_movement == true) {
                    if (count == distance_step) {
                        front = false;
                        if (temp_x - 1 != 0) {
                            if (check_move(w, temp_x - 1, temp_y, a) == true)
                                move_step(w, temp_x - 1, temp_y, a);
                            count--;
                        }

                    } else if (count == 0) {
                        front = true;
                        if (temp_x + 1 != a.end) {
                            if (check_move(w, temp_x + 1, temp_y, a) == true)
                                move_step(w, temp_x + 1, temp_y, a);
                            count++;
                        }
                    } else if (front == true) {
                        if (count < distance_step) {
                            if (temp_x + 1 != a.end) {
                                if (check_move(w, temp_x + 1, temp_y, a) == true) {
                                    move_step(w, temp_x + 1, temp_y, a);
                                    count++;
                                }
                            }
                        }

                    } else {
                        if (count != 0)
                            if (temp_x - 1 != 0) {
                                if (check_move(w, temp_x - 1, temp_y, a) == true) {
                                    move_step(w, temp_x - 1, temp_y, a);
                                    count--;
                                }

                            }
                    }

                }
                pp++;
            }
        }
    }
