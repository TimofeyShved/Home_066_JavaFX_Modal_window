package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Наш window"); // заголовок формы

        // наша панель
        Pane root = new Pane();

        // добавляем кнопку и событие на нажатие, для открытия статического метода из класса
        Button button = new Button("New window");
        button.setOnAction(event -> MyModalWindows.newWindows("New window"));


        // добавить на панель
        root.getChildren().addAll(button);

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

// модалоное окно, будет новая форма(окошко), не даёт работать с предыдущим окном
class MyModalWindows{
    public static void newWindows(String title){
        // создаём наше окно, форму
        Stage windows = new Stage();
        windows.initModality(Modality.APPLICATION_MODAL); // для того что-бы заблокировать доступ к предыдущему окну
        windows.setTitle(title); // заголовок формы

        // наша новая панель
        Pane root2 = new Pane();

        // добавляем кнопку и событие на нажатие,
        Button button = new Button("закрыть");
        button.setOnAction(event -> windows.close());

        // добавить на панель
        root2.getChildren().addAll(button);

        // добавление на сцены | на форму
        Scene scene = new Scene(root2, 400, 100);
        windows.setScene(scene);  // размер формы и сцена
        windows.show(); // отобразить
    }
}
