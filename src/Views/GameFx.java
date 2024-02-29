package Views;

import Game.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Game.Arena;

//import javax.swing.text.html.ImageView;


public class GameFx {
    private Scene scene;
    private BorderPane root;
    private Game game;
    private double big=1;
    Arena ar = new Arena();

    public GameFx(Stage stage){
        ar.Generate();
        root = new BorderPane();
        ScrollPane arena=new ScrollPane();
        Pane store=new Pane();
        Pane wall = new Pane();
        ImageView imageview = new ImageView("Views/res/street.jpeg");
        imageview.setFitHeight(812.5);
        imageview.setFitWidth(1133);
        wall.getChildren().add(imageview);

        Button buttonClose=new Button("End Game");
        buttonClose.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, new CornerRadii(5), Insets.EMPTY)));
        buttonClose.setFont(new Font("Cambria", 20));
        buttonClose.setPrefSize(150, 50);
        buttonClose.setTranslateX(-485);
        buttonClose.setTranslateY(370);
        Button buttonZoom=new Button("ZOOM");
        buttonZoom.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, new CornerRadii(5), Insets.EMPTY)));
        buttonZoom.setFont(new Font("Cambria", 20));
        buttonZoom.setPrefSize(150, 50);
        buttonZoom.setTranslateX(-485);
        buttonZoom.setTranslateY(310);

        GridPane gridPane=new GridPane();
        GridFx gridFx=new GridFx(ar);
        gridPane=gridFx.getGridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        StackPane area=new StackPane(wall,gridPane,buttonClose);
        arena.setPrefSize(1133, 812.5);
        arena.setContent(area);
        Store storeS=new Store();
        store=storeS.getPane();
        store.setPrefSize(400, Double.MAX_VALUE);
        arena.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setCenter(arena);
        root.setRight(store);
        scene = new Scene(root, 1533, 812.5);

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent){
                switch (keyEvent.getCode()){
                    case D:
                    {
                        big=1;
                        area.setScaleX(1);
                        area.setScaleY(1);
                        break;
                    }
                    case A:
                        big=big+0.1;
                        area.setScaleX(big);
                        area.setScaleY(big);
                        break;

                    case S:
                    {
                        big=big/1.1;
                        area.setScaleX(big);
                        area.setScaleY(big);
                        break;
                    }
                }
            }
        });

        stage.setTitle("JavaFX BorderPane");
        stage.setScene(scene);

        buttonClose.setOnAction((ActionEvent e) -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Close Game");
            alert.setHeaderText("You are going to close your game.\nAre you sure ? ");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    stage.close();
                } else {
                    alert.close();
                }
            });
        });
        buttonZoom.setOnAction((ActionEvent e) -> {
            AnimatedZoomOperator animatedZoomOperator=new AnimatedZoomOperator();
            animatedZoomOperator.zoom(root,1.1,0,0);
        });
    }
}
