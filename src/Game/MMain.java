package Game;

import Controller.RoundManager.Round_1;
import Controller.RoundManager.Round_Manager;

import java.util.Scanner;

public class MMain {


    Game game = new Game();
    Round_Manager round = new Round_1();

    public void Main() {
        Scanner input = new Scanner(System.in);
        int i;
        File file = new File();
        file.Generate();

        game.getArena().Generate();
        game.FromTeam();

        game.Generate();//توليد عدد اللاعبين
        System.out.println(" *  Enter Game Time *");
        i = input.nextInt();
        game.startGame(i);
        game.getArena().p();
        round.Run(game, game.getArena());

    }


}

