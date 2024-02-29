package Views;

import Controller.RoundManager.Round_1;
import Controller.RoundManager.Round_Manager;
import Controller.Thraed.MyThread;
import Game.Arena;
import Game.File;
import Game.Game;
import Game.Node;
import Game.Team.TeamDefender.TeamDefender;
import Game.Team.TeamInvader.TeamInvader;
import Model.Object.Unit;
import Model.Problem.Problem;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Iterator;

public class GridFx {
    private GridPane gridPane;
    private Game game=new Game();
    private int end = 25;
    private int end2 = 40;
    TeamDefender teamDefenderMap = new TeamDefender();
    TeamInvader teamInvaderMap = new TeamInvader();



    public GridFx(Arena a) {
        Round_Manager round = new Round_1();
        File file = new File();
        file.Generate();
         a = new Arena();
        FromTeam(a);
        game.Generate();//توليد عدد اللاعبين
        ArrayList<ArrayList<Node>> temp = a.getArena();
        game.startGame(0);

      //  ThreadFx tf=new ThreadFx(gridPane,a);
       // tf.start();
//        ArrayList<Unit> teamDefender = new TeamDefender().MoveThing();
//        ArrayList<Unit> teamInvader = new TeamInvader().MoveThing();
        ggride(temp);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater=new Runnable() {
                    @Override
                    public void run() {
                        ggride(temp);
                    }
                };
                while (true){
                    try{
                        Thread.sleep(1000);

                    }catch (InterruptedException exception){

                    }
                    Platform.runLater(updater);

                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        //ggride(temp);





        //createGrid(temp);

//            for (int i = 0; i < teamInvader.size(); i++) {
//                for (int j = 0; j < teamDefender.size(); j++) {
//
//                    Thread x1 = new MyThread(teamInvader.get(i),game,a);
//                    Thread x2 = new MyThread(teamDefender.get(j),game,a);
//
//                    x1.start();
//                    x2.start();
//                    if (teamDefender.get(j).getHealth() <= 0) {
//                        teamDefender.remove(j);
//                    }
//
//
//                    if (teamInvader.get(i).getHealth() <= 0) {
//                        teamInvader.remove(i);
//                    }
//                }
                //ggride(temp);
            }


    public void createGrid(ArrayList<ArrayList<Node>> temp) {
        gridPane = new GridPane();

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 25; j++) {
                if ((temp.get(i).get(j).Wild.getName() == null) && (temp.get(i).get(j).Aerial.getName() == null)) {
                    Label label0 = new Label("...............");
                    label0.setFont(new Font("Cambria", 6));
                    label0.setPrefSize(40, 15);
                    //label0.setVisible(false);
                    gridPane.add(label0, j, i, 1, 1);
                }
                if (temp.get(i).get(j).Wild.getName() != null) {

                    Label label0 = new Label();
                    label0.setPrefSize(40, 15);
                    label0.setText(temp.get(i).get(j).Wild.getName() + temp.get(i).get(j).Wild.getId());
                    label0.setFont(new Font("Cambria", 6));
                    label0.setStyle("-fx-border-color:black");
                    if (temp.get(i).get(j).Wild.getType().equals("Problem") == true) {
                        if (temp.get(i).get(j).Wild.getName().equals("Bomb_Cars") == true) {
                            label0.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(1), Insets.EMPTY)));
                        } else if (temp.get(i).get(j).Wild.getName().equals("Bridges") == true) {
                            System.out.println(temp.get(i).get(j).Wild.getName());
                            label0.setBackground(new Background(new BackgroundFill(Color.BROWN, new CornerRadii(1), Insets.EMPTY)));
                        } else if (temp.get(i).get(j).Wild.getName().equals("River") == true) {
                            label0.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), Insets.EMPTY)));
                        } else if (temp.get(i).get(j).Wild.getName().equals("Vally") == true) {
                            label0.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(1), Insets.EMPTY)));
                        } else if (temp.get(i).get(j).Wild.getTypeUnit() == 1) {
                            System.out.print("KEY");

                        } else if (temp.get(i).get(j).Wild.getTypeUnit() == 2) {
                            System.out.print("KEY");

                        }
                        gridPane.add(label0, j, i, 1, 1);
                    }
                }
            }
        }

        teamDefenderMap = game.players.get(0).getObjectD();
        //teamDefenderMap.getTeam_defender();

        teamInvaderMap = game.players.get(1).getObjectI();
        //teamInvaderMap.getTeam_Invader();



        Iterator keyI = teamInvaderMap.getTeam_Invader().keySet().iterator();
        Iterator keyD =teamDefenderMap.getTeam_defender().keySet().iterator();


        while(keyD.hasNext()){
            Object key=keyD.next();
            for(int i=0;i<teamDefenderMap.getTeam_defender().get(key).size();i++){
                Label label1 = new Label();
                label1.setText(teamDefenderMap.getTeam_defender().get(key).get(i).getName());
                label1.setStyle("-fx-border-color:black");
                label1.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1), Insets.EMPTY)));

                label1.setPrefSize(40, 15);
                label1.setFont(new Font("Cambria", 6));

                int a = teamDefenderMap.getTeam_defender().get(key).get(i).getPosition().x;
                int b = teamDefenderMap.getTeam_defender().get(key).get(i).getPosition().y;
                gridPane.add(label1, b, a, 1, 1);
            }
        }

        while(keyI.hasNext()){
            Object key=keyI.next();
            for(int i=0;i<teamInvaderMap.getTeam_Invader().get(key).size();i++){
                Label label1 = new Label();
                label1.setText(teamInvaderMap.getTeam_Invader().get(key).get(i).getName());
                label1.setStyle("-fx-border-color:black");
                label1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(1), Insets.EMPTY)));

                label1.setPrefSize(40, 15);
                label1.setFont(new Font("Cambria", 6));

                int a = teamInvaderMap.getTeam_Invader().get(key).get(i).getPosition().x;
                int b = teamInvaderMap.getTeam_Invader().get(key).get(i).getPosition().y;
                gridPane.add(label1, b, a, 1, 1);
            }
        }
  /*
        for (int i = 0; i < keyD.size(); i++) {
            for (int j = 0; j < teamDefenderMap.getTeam_defender().get(keyD.get(i)).size(); j++) {
                if (teamDefenderMap.getTeam_defender().get(keyD.get(i)) != null) {
                    Label label1 = new Label();
                    label1.setFont(new Font("Cambria", 6));
                    label1.setText(teamDefenderMap.getTeam_defender().get(keyD.get(i)).get(j).getName());
                    label1.setStyle("-fx-border-color:black");
                    label1.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(1), Insets.EMPTY)));
                    int a = teamDefenderMap.getTeam_defender().get(keyD.get(i)).get(j).getPosition().x;
                    int b = teamDefenderMap.getTeam_defender().get(keyD.get(i)).get(j).getPosition().y;
                    gridPane.add(label1, a, b, 1, 1);
                }
            }
        }
        for (int i = 0; i < keyI.size(); i++) {
            for (int j = 0; j < teamInvaderMap.getTeam_Invader().get(keyI.get(i)).size(); j++) {
                if (teamInvaderMap.getTeam_Invader().get(keyI.get(i)) != null) {
                    Label label1 = new Label();
                    label1.setFont(new Font("Cambria", 6));
                    label1.setText(teamInvaderMap.getTeam_Invader().get(keyI.get(i)).get(j).getName());
                    label1.setStyle("-fx-border-color:black");
                    label1.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(1), Insets.EMPTY)));
                    int a = teamInvaderMap.getTeam_Invader().get(keyI.get(i)).get(j).getPosition().x;
                    int b = teamInvaderMap.getTeam_Invader().get(keyI.get(i)).get(j).getPosition().y;
                    gridPane.add(label1, a, b, 1, 1);
                }
            }
        }
*/

    }




       // gridPane.setHgap(5);
        //gridPane.setVgap(10);
        public  void ggride (ArrayList<ArrayList<Node>> temp){
            gridPane = new GridPane();
            for (int i = 0; i <40 ; i++) {
                for (int j = 0; j < 25; j++) {
                    if((temp.get(i).get(j).Wild.getName() == null)&&(temp.get(i).get(j).Aerial.getName() == null)) {
                        Label label0 = new Label("...............");
                        label0.setFont(new Font("Cambria", 6));
                        label0.setPrefSize(40,15);
                        label0.setVisible(false);
                        gridPane.add(label0, j, i, 1, 1);
                    }
                    else if(temp.get(i).get(j).Aerial.getName()!=null){
                        Label label1 = new Label();
                        label1.setFont(new Font("Cambria", 6));
                        label1.setText(temp.get(i).get(j).Aerial.getName()+temp.get(i).get(j).Aerial.getId());
                        label1.setPrefSize(40,15);
                        label1.setStyle("-fx-border-color:black");
                        label1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(1), Insets.EMPTY)));
                        gridPane.add(label1,j,i,1,1);
                    }
                    else if(temp.get(i).get(j).Wild.getName()!=null){

                        Label label2 = new Label();
                        label2.setPrefSize(40,15);
                        label2.setText(temp.get(i).get(j).Wild.getName() + temp.get(i).get(j).Wild.getId());
                        label2.setFont(new Font("Cambria", 6));
                        //System.out.println(temp.get(i).get(j).Wild.getName() );
                        label2.setStyle("-fx-border-color:black");
                        if(temp.get(i).get(j).Wild.getType().equals("Problem")==true) {
                            if (temp.get(i).get(j).Wild.getName().equals("Bomb_Cars")==true) {
                                label2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(1), Insets.EMPTY)));
                            }else if (temp.get(i).get(j).Wild.getName().equals("Bridges")==true) {
                                label2.setBackground(new Background(new BackgroundFill(Color.BROWN, new CornerRadii(1), Insets.EMPTY)));
                            }else if (temp.get(i).get(j).Wild.getName().equals("River")==true) {
                                label2.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(1), Insets.EMPTY)));
                            }else if(temp.get(i).get(j).Wild.getName().equals("Vally")==true) {
                                label2.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(1), Insets.EMPTY)));
                            }
                        }
                        else if(temp.get(i).get(j).Wild.getTypeUnit()==1) {
                            if (temp.get(i).get(j).Wild.getName().equals("Base") == true) {
                                label2.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(1), Insets.EMPTY)));
                            } else {
                                label2.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1), Insets.EMPTY)));
                            }
                        }
                        else if(temp.get(i).get(j).Wild.getTypeUnit()==2){
                            label2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(1), Insets.EMPTY)));
                        }
                        gridPane.add(label2,j,i,1,1);
                    }
                }
            }

    }

    public static void FromTeam (Arena arena){


        TeamDefender teamDefender = new TeamDefender();
        TeamInvader teamInvader = new TeamInvader();
        Problem problem = new Problem();
        arena.prod(teamDefender.Form());
        arena.prod(teamInvader.Form());
        arena.prod(problem.Generateproblem());
        arena.p();
    }

    public GridPane getGridPane () {
        return this.gridPane;
    }
}
