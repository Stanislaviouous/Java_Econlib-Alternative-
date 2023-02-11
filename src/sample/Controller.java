package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

/*name.substring(i, i + 1).equals("0") || name.substring(i, i + 1).equals("1") ||
                        name.substring(i, i + 1).equals("2") || name.substring(i, i + 1).equals("3") ||
                        name.substring(i, i + 1).equals("4") || name.substring(i, i + 1).equals("5") ||
                        name.substring(i, i + 1).equals("6") || name.substring(i, i + 1).equals("7") ||
                        name.substring(i, i + 1).equals("8") || name.substring(i, i + 1).equals("9") || name.substring(i, i + 1).equals("."))*/

public class Controller {
    public static float A[] = new float[1000];
    int orp = 0;
    String name = new String();
    String input = new String();// Для параметров функции
    float zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen;
    float fourteen, fifteen, sixteen, seventeen, eighteen, nineteen;
    int initium, finis; // Начало и конец вхождения
    double vihod;
    String number = new String(); // Для имени функции
    Econlib t = new Econlib();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Conclusion1;

    @FXML
    public TextArea Inlet;

    @FXML
    private TextArea Conclusion;

    @FXML
    private Button Equally;

    @FXML
    private LineChart<Number, Number> LineChart;

    @FXML
    private Button Epp;

    void Sin(){
        Conclusion.appendText("Правила заполнения:" + "\n" +
                "*После функции снос" + "\n" +
                "*Между значениями пробел" + "\n" +
                "Пример:" + "\n" +
                "E_pd" + "\n" +
                "80 10 90 20" + "\n" +
                "Ниже ваши результаты:" +
                "\n");
    }

    @FXML
    void ClickGrafics(MouseEvent event) {
        // теперь работает, line chart должен знать с чем он работает, поэтому указываем number
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 23));
        LineChart.getData().add(series);
        //
    }
    @FXML
    void signUpBtClick(MouseEvent event) throws InterruptedException {
        name = Inlet.getText().trim();

        String name_protect = new String();
        name_protect = name;
        name_protect = name_protect.replaceAll("\\s+", "");
        if (name_protect.isEmpty()) {
            Conclusion.appendText("Вы оставили поле пустым!" + "\n");
            Inlet.setStyle("-fx-border-color:red");
            Inlet.clear();

        } else{
            name = name.replaceAll("\n", " ");
            for (int i = 0; i < name.length(); i++) {
                if (name.substring(i, i + 1).equals(" ")) {
                    orp++;
                }
            }
            if(orp % 2 != 0){
                Conclusion.appendText("Заполнено не правильно!" + "\n");
                Inlet.setStyle("-fx-border-color:red");
                Inlet.clear();
            }
            else {
                name = name.replaceAll("\n", " ");
                for (int i = 0; i < name.length(); i++) {
                    if (name.substring(i, i + 1).equals(" ")) {
                        initium = i + 1;
                        break;
                    }
                }

                for (int i = name.length() - 1; i > 0; --i) {
                    if (name.substring(i, i + 1).equals("0") || name.substring(i, i + 1).equals("1") ||
                            name.substring(i, i + 1).equals("2") || name.substring(i, i + 1).equals("3") ||
                            name.substring(i, i + 1).equals("4") || name.substring(i, i + 1).equals("5") ||
                            name.substring(i, i + 1).equals("6") || name.substring(i, i + 1).equals("7") ||
                            name.substring(i, i + 1).equals("8") || name.substring(i, i + 1).equals("9") || name.substring(i, i + 1).equals(".")) {
                        finis = i + 1;
                        break;
                    }
                }
                input = name.substring(initium, finis); // Получилась строка со значеними для функции
                name = name.replace(input, "");
                name = name.replaceAll("\\s+", ""); // Получилась строка с именем функции

                input = input.trim();
                input = input + " ";
                String yt = new String();
                int j = 0;
                int proch = 0;
                for (int p = 0; p < input.length(); p++) {
                    if (input.substring(p, p + 1).equals(" ")) {
                        input.substring(proch, p).replaceAll("\\s+", "");
                        A[j] = Float.parseFloat(input.substring(proch, p));
                        j++;
                        proch = p;
                    }
                }
                vihod = t.Answer(name);
                if(vihod == (float) 3.1415){
                    Conclusion.appendText(name +"-" + "\n" +"Такой функции нет!" + "\n");
                    Conclusion.appendText("Или вы ошиблись при вводе!" + "\n");
                    Conclusion.appendText("Ниже ваши результаты:" + "\n");
                    Inlet.setStyle("-fx-border-color:red");
                    Inlet.clear();
                }else {
                    Inlet.clear();
                    Conclusion.appendText(name);
                    number = Double.toString(vihod);
                    Conclusion.appendText("\n" + number + "\n");
                }
            }
        }
    }

    @FXML
    void initialize() {
        Sin();
    }

}









 /*   @FXML
    private Button myButton;

    public void createLine(ActionEvent event) {

    }*/