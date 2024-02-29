package Views;

import javafx.scene.image.ImageView;

public class AirePlaneFx {
    private ImageView imageView;
    public AirePlaneFx(double x,double y)
    {
        imageView=new ImageView("Views/res/holicaptor.png");
        imageView.setScaleX(0.3);
        imageView.setScaleY(0.3);
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
