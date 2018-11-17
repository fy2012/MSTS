import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;

public class Main extends Application {

    Stage window;

    Connection connection;

    TextField trackingNumberField = new TextField();
    Button enterButton = new Button("ENTER");

    Button minusDefault = new Button("-");
    Button plusDefault = new Button("+");
    TextField defaultNumberField = new TextField();
    ObservableList<String> conditionOptions =
            FXCollections.observableArrayList(
                    "全新",
                    "破损",
                    "缺失",
                    "其他"
            );
    ComboBox conditionBox = new ComboBox(conditionOptions);
    TextField defaultNameField = new TextField();

    ArrayList<Unit> unitsReceived = new ArrayList<>();

    ArrayList<HBox> listPlaceHolder = new ArrayList<>();
    ArrayList<HBox> IDHolder= new ArrayList();
    ArrayList<HBox> carrierHolder= new ArrayList();
    ArrayList<HBox> trackingHolder= new ArrayList();
    ArrayList<HBox> nameHolder= new ArrayList();
    ArrayList<HBox> numberHolder= new ArrayList();
    ArrayList<HBox> conditionHolder = new ArrayList<>();
    ArrayList<HBox> commentHolder= new ArrayList();

    ArrayList<TextField> listID = new ArrayList<>();
    ObservableList<String> Carrier =
            FXCollections.observableArrayList(
                    "UPS",
                    "USPS",
                    "FedEx",
                    "其他"
            );
    ArrayList<ComboBox> listCarrier = new ArrayList<>();
    ArrayList<TextField> listTracking = new ArrayList<>();
    ArrayList<TextField> listName = new ArrayList<>();
    ArrayList<TextField> listNumber = new ArrayList<>();
    ArrayList<Button> listPlus = new ArrayList<>();
    ArrayList<Button> listMinus = new ArrayList<>();
    ArrayList<ComboBox> listCondition= new ArrayList<>();
    ArrayList<TextField> listComment = new ArrayList<>();
    VBox listBox = new VBox();

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

        addClickEvent();
    }

    public void addClickEvent(){
        enterButton.setOnAction(event -> {
            addUnit();
            displayNewUnit(unitsReceived.size()-1);
        });
        minusDefault.setOnAction(event -> {
            int i = Integer.parseInt(defaultNumberField.getText())-1;
            defaultNumberField.setText(""+i);
        });
        plusDefault.setOnAction(event -> {
            int i = Integer.parseInt(defaultNumberField.getText())+1;
            defaultNumberField.setText(""+i);
        });
        trackingNumberField.setOnKeyPressed(event -> {

        });
    }

    public void addUnit(){
        String trc = trackingNumberField.getText();
        unitsReceived.add(new Unit(unitsReceived.size(), trc, defaultNameField.getText(),
                Integer.parseInt(defaultNumberField.getText()), (String)conditionBox.getValue(), ""));
    }

    public void displayNewUnit(int i){
        IDHolder.add(new HBox());
        carrierHolder.add(new HBox());
        trackingHolder.add(new HBox());
        nameHolder.add(new HBox());
        numberHolder.add(new HBox());
        conditionHolder.add(new HBox());
        commentHolder.add(new HBox());

        listID.add(new TextField());
        listID.get(i+1).setText("" + unitsReceived.get(i).getID());
        listCarrier.add(new ComboBox(Carrier));
        listCarrier.get(i+1).setValue(unitsReceived.get(i).getCarrier());
        listTracking.add(new TextField());
        listTracking.get(i+1).setText(unitsReceived.get(i).getTracking());
        listName.add(new TextField());
        listName.get(i+1).setText(unitsReceived.get(i).getName());
        listNumber.add(new TextField());
        listNumber.get(i+1).setText("" + unitsReceived.get(i).getNumber());
        listMinus.add(new Button("-"));
        listPlus.add(new Button("+"));
        listMinus.get(i).setOnAction(event -> {
            unitsReceived.get(i).setNumber(unitsReceived.get(i).getNumber()-1);
            listNumber.get(i).setText(""+unitsReceived.get(i).getNumber());
        });
        listPlus.get(i).setOnAction(event -> {
            unitsReceived.get(i).setNumber(unitsReceived.get(i).getNumber()+1);
            listNumber.get(i).setText(""+unitsReceived.get(i).getNumber());
        });
        listCondition.add(new ComboBox(conditionOptions));
        listCondition.get(i+1).setValue(unitsReceived.get(i).getCondition());
        listComment.add(new TextField());
        listComment.get(i+1).setText(unitsReceived.get(i).getComment());

        IDHolder.get(i+1).getChildren().add(listID.get(i+1));
        carrierHolder.get(i+1).getChildren().add(listCarrier.get(i+1));
        trackingHolder.get(i+1).getChildren().add(listTracking.get(i+1));
        nameHolder.get(i+1).getChildren().add(listName.get(i+1));
        numberHolder.get(i+1).getChildren().addAll(listNumber.get(i+1), listMinus.get(i+1),listPlus.get(i+1));
        conditionHolder.get(i+1).getChildren().add(listCondition.get(i+1));
        commentHolder.get(i+1).getChildren().add(listComment.get(i+1));

        listID.get(i+1).setEditable(Boolean.FALSE);
        //listID.get(0).setDisable(Boolean.TRUE);
        IDHolder.get(i+1).setMinWidth(50);
        IDHolder.get(i+1).setMaxWidth(50);
        IDHolder.get(i+1).setAlignment(Pos.CENTER);

        listCarrier.get(i+1).setMaxWidth(110);
        listCarrier.get(i+1).setMinWidth(110);
        carrierHolder.get(i+1).setMinWidth(110);
        carrierHolder.get(i+1).setMaxWidth(110);

        trackingHolder.get(i+1).setMinWidth(240);
        trackingHolder.get(i+1).setMaxWidth(240);

        listName.get(i+1).setMaxWidth(300);
        listName.get(i+1).setMinWidth(300);
        nameHolder.get(i+1).setMaxWidth(300);
        nameHolder.get(i+1).setMinWidth(300);

        numberHolder.get(i+1).setMinWidth(110);
        numberHolder.get(i+1).setMaxWidth(110);

        listCondition.get(i+1).setMinWidth(90);
        listCondition.get(i+1).setMaxWidth(90);
        conditionHolder.get(i+1).setMinWidth(90);
        conditionHolder.get(i+1).setMaxWidth(90);

        listComment.get(i+1).setMinWidth(445);
        listComment.get(i+1).setMaxWidth(445);
        commentHolder.get(i+1).setMinWidth(445);
        commentHolder.get(i+1).setMaxWidth(445);

        listPlaceHolder.add(new HBox());
        listPlaceHolder.get(i+1).getChildren().add(IDHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(carrierHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(trackingHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(nameHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(numberHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(conditionHolder.get(i+1));
        listPlaceHolder.get(i+1).getChildren().add(commentHolder.get(i+1));

        listBox.getChildren().addAll(listPlaceHolder.get(i+1));
    }

    public Scene home(){
        BorderPane mainLayout = new BorderPane();
        BorderPane topLayout = new BorderPane();
        topLayout.setStyle("-fx-font-size: 5em;");
        topLayout.setCenter(trackingNumberField);
        topLayout.setRight(enterButton);

        HBox defaultBar = new HBox();
        defaultBar.setStyle("-fx-font-size: 2em;");
        defaultNumberField.setMaxWidth(55);
        defaultNumberField.setText("1");
        conditionBox.getSelectionModel().selectFirst();
        defaultNameField.setMaxWidth(200);
        minusDefault.setStyle("-fx-font-size: 1em;");
        minusDefault.setMaxHeight(10);
        minusDefault.setMaxWidth(10);
        defaultBar.getChildren().addAll(
                new Label("\t产品 "), defaultNameField,
                new Label("\t数量"), defaultNumberField, minusDefault, plusDefault,
                new Label("\t状况 "), conditionBox);
        BorderPane centerPanel = new BorderPane();
        centerPanel.setTop(defaultBar);
        defaultBar.setAlignment(Pos.CENTER);

        ScrollPane listPane = new ScrollPane();
        listPane.setStyle("-fx-font-size: 1.5em;");

        //listBox.getChildren().add(new Label("ID\t快递\t\t    单号\t\t\t\t\t产品\t\t\t\t数量\t\t状况\t\t注备"));

        IDHolder.add(new HBox());
        carrierHolder.add(new HBox());
        trackingHolder.add(new HBox());
        nameHolder.add(new HBox());
        numberHolder.add(new HBox());
        conditionHolder.add(new HBox());
        commentHolder.add(new HBox());

        listID.add(new TextField());
        listID.get(0).setText("88");
        listCarrier.add(new ComboBox(Carrier));
        listTracking.add(new TextField());
        listTracking.get(0).setText("1Z999AA10123456784");
        listName.add(new TextField());
        listName.get(0).setText("Something Crap Camera");
        listNumber.add(new TextField());
        listNumber.get(0).setText("1");
        listMinus.add(new Button("-"));
        listPlus.add(new Button("+"));
        listCondition.add(new ComboBox(conditionOptions));
        listComment.add(new TextField());
        listComment.get(0).setText("This thing is a crap");

        IDHolder.get(0).getChildren().add(new Label("ID"));
        carrierHolder.get(0).getChildren().add(new Label("快递"));
        trackingHolder.get(0).getChildren().add(new Label("单号"));
        nameHolder.get(0).getChildren().add(new Label("产品"));
        numberHolder.get(0).getChildren().add(new Label("数量"));
        conditionHolder.get(0).getChildren().add(new Label("状况"));
        commentHolder.get(0).getChildren().add(new Label("注备"));

        //listID.get(0).setEditable(Boolean.FALSE);
        //listID.get(0).setDisable(Boolean.TRUE);
        IDHolder.get(0).setMinWidth(50);
        IDHolder.get(0).setMaxWidth(50);
        IDHolder.get(0).setAlignment(Pos.CENTER);

        //listCarrier.get(0).setMaxWidth(110);
        //listCarrier.get(0).setMinWidth(110);
        carrierHolder.get(0).setMinWidth(110);
        carrierHolder.get(0).setMaxWidth(110);

        trackingHolder.get(0).setMinWidth(240);
        trackingHolder.get(0).setMaxWidth(240);

        //listName.get(0).setMaxWidth(300);
        //listName.get(0).setMinWidth(300);
        nameHolder.get(0).setMaxWidth(300);
        nameHolder.get(0).setMinWidth(300);

        numberHolder.get(0).setMinWidth(110);
        numberHolder.get(0).setMaxWidth(110);

        //listCondition.get(0).setMinWidth(90);
        //listCondition.get(0).setMaxWidth(90);
        conditionHolder.get(0).setMinWidth(90);
        conditionHolder.get(0).setMaxWidth(90);

        //listComment.get(0).setMinWidth(460);
        //listComment.get(0).setMaxWidth(460);
        commentHolder.get(0).setMinWidth(445);
        commentHolder.get(0).setMaxWidth(445);

        listPlaceHolder.add(new HBox());
        listPlaceHolder.get(0).getChildren().add(IDHolder.get(0));
        listPlaceHolder.get(0).getChildren().add(carrierHolder.get(0));
        listPlaceHolder.get(0).getChildren().add(trackingHolder.get(0));
        listPlaceHolder.get(0).getChildren().add(nameHolder.get(0));
        listPlaceHolder.get(0).getChildren().add(numberHolder.get(0));
        listPlaceHolder.get(0).getChildren().add(conditionHolder.get(0));
        listPlaceHolder.get(0).getChildren().add( commentHolder.get(0));

        /*
        for(int i = 1; i <= 30; i ++){

        }*/

        listBox.getChildren().addAll(listPlaceHolder.get(0));
        listPane.setContent(listBox);

        HBox bottomBar = new HBox();
        bottomBar.setStyle("-fx-font-size: 1.2em;");
        bottomBar.getChildren().addAll(new Label("总箱数："), new Label("1"), new Label("\t总产品数："), new Label("1"));

        centerPanel.setCenter(listPane);
        mainLayout.setTop(topLayout);
        mainLayout.setCenter(centerPanel);
        mainLayout.setBottom(bottomBar);
        Scene home = new Scene(mainLayout,1366,768);
        return home;
    }
}
