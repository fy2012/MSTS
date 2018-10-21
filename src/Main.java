import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    TextField trackingNumberField = new TextField();
    Label defaultLabel = new Label("Default:");
    Button enterButton = new Button("Enter");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Myway Shipment Tracking System");
        window.resizableProperty().setValue(Boolean.FALSE);

        Scene appScene = home();
        window.setScene(appScene);

        window.show();

        //addClickEvent();
    }

    public void addClickEvent(){

    }

    public Scene home(){
        BorderPane mainLayout = new BorderPane();
        HBox topLayout = new HBox();
        topLayout.getChildren().addAll(trackingNumberField, enterButton);
        mainLayout.setTop(topLayout);
        Scene home = new Scene(mainLayout,1024,768);
        return home;
    }
}
