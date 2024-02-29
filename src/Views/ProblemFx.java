package Views;
import javafx.scene.image.ImageView;

public class ProblemFx {
    private ImageView imageView;

    public  ProblemFx (String name,double x,double y){
        switch (name)
        {
            case "Bridge":
            {
                imageView=new ImageView("Views/res/Bridge.png");
                imageView.setScaleX(0.1);
                imageView.setScaleY(0.1);
                imageView.setTranslateX(x);
                imageView.setTranslateY(y);
                break;
            }
            case "River":
            {
                imageView=new ImageView("Views/res/River.png");
                imageView.setScaleX(0.1);
                imageView.setScaleY(0.1);
                imageView.setTranslateX(x);
                imageView.setTranslateY(y);
                break;
            }
            case "Valley":
            {     imageView=new ImageView("Views/res/Vally.png");
                imageView.setScaleX(0.1);
                imageView.setScaleY(0.1);
                imageView.setTranslateX(x);
                imageView.setTranslateY(y);
                break;
            }
            case "Bomb_cars":
            {     imageView=new ImageView("Views/res/cars.png");
                imageView.setScaleX(0.1);
                imageView.setScaleY(0.1);
                imageView.setTranslateX(x);
                imageView.setTranslateY(y);
                break;
            }


        }

    }

    public ImageView getImageView() {
        return imageView;
    }
}
