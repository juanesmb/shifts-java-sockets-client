package vista_control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.*;

public class Cliente_GUI extends Application {

    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private Label label0;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    protected Cliente cliente1;
    protected Cliente cliente2;
    protected Cliente cliente3;
    protected Cliente cliente4;
    protected Cliente cliente5;
    int consultorio = 0;
    int turno = 0;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getRoot(), 600, 400);

        //manejo del evento del botón consultorio 1
        button1.setOnAction(event-> 
        {
            entrarSegundaInterfaz();
            consultorio = 1;
        });

        //manejo del evento del botón consultorio 2
        button2.setOnAction(event-> 
        {
            entrarSegundaInterfaz();
            consultorio = 2;
        });

        //manejo del evento del botón consultorio 3
        button3.setOnAction(event-> 
        {
            entrarSegundaInterfaz();
            consultorio = 3;
        });

        //manejo del evento del botón consultorio 4
        button4.setOnAction(event-> 
        {
            entrarSegundaInterfaz();
            consultorio = 4;
        });

        //manejo del evento del botón consultorio 5
        button5.setOnAction(event-> 
        {
            entrarSegundaInterfaz();
            consultorio = 5;
        });

        //manejo del evento del botón Volver
        button6.setOnAction(event-> 
        {
            entrarPrimeraInterfaz();
        });

        //manejo del evento del botón Aceptar
        button7.setOnAction(event -> 
        {
            String nombre = textField1.getText();
            int cedula = Integer.parseInt(textField2.getText());
            int edad = Integer.parseInt(textField3.getText());
            this.turno++;
            try {
                Persona p = new Persona(nombre, cedula, edad, turno);
                iniciarClientes();
                switch (this.consultorio) {
                    case 1:
                        cliente1.enviarMensaje(p.getDatos());
                        break;
                    case 2:
                        cliente2.enviarMensaje(p.getDatos());
                        break;
                    case 3:
                        cliente3.enviarMensaje(p.getDatos());
                        break;
                    case 4:
                        cliente4.enviarMensaje(p.getDatos());
                        break;
                    case 5:
                        cliente5.enviarMensaje(p.getDatos());
                        break;
                }

                System.out.println("");
                System.out.println("AGREGADO EXITÓSAMENTE");
                System.out.println("Sus datos son: ");
                System.out.println(p.toString());
                System.out.println("");
                entrarPrimeraInterfaz();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                label6.setVisible(true);
            }
        });

        primaryStage.setTitle("¡Bienvenido!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent getRoot() {
        Pane root = new Pane();

        /*Image img = new Image ("bosque rojo.jpg");
        ImageView logo = new ImageView (img); */
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();

        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();

        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();

        root.getChildren().addAll(textField1, textField2, textField3, label1, label2, label3, label4, label5, label6, label0, label7, button1, button2, button3, button4, button5, button6, button7);

        /*logo.setX(10);
        logo.setY(10);*/
        
        textField1.setLayoutX(225);
        textField1.setLayoutY(125);
        textField1.setText("");
        textField1.setVisible(false);

        textField2.setLayoutX(225);
        textField2.setLayoutY(200);
        textField2.setText("");
        textField2.setVisible(false);

        textField3.setLayoutX(225);
        textField3.setLayoutY(275);
        textField3.setText("");
        textField3.setVisible(false);

        button1.setLayoutX(150);
        button1.setLayoutY(100);
        button1.setPrefHeight(35);
        button1.setPrefWidth(300);
        button1.setText("Consultorio 1");

        button2.setLayoutX(150);
        button2.setLayoutY(150);
        button2.setPrefHeight(35);
        button2.setPrefWidth(300);
        button2.setText("Consultorio 2");

        button3.setLayoutX(150);
        button3.setLayoutY(200);
        button3.setPrefHeight(35);
        button3.setPrefWidth(300);
        button3.setText("Consultorio 3");

        button4.setLayoutX(150);
        button4.setLayoutY(250);
        button4.setPrefHeight(35);
        button4.setPrefWidth(300);
        button4.setText("Consultorio 4");

        button5.setLayoutX(150);
        button5.setLayoutY(300);
        button5.setPrefHeight(35);
        button5.setPrefWidth(300);
        button5.setText("Consultorio 5");

        button6.setLayoutX(225);
        button6.setLayoutY(325);
        button6.setText("Volver");
        button6.setVisible(false);

        button7.setLayoutX(315);
        button7.setLayoutY(325);
        button7.setText("Aceptar");
        button7.setVisible(false);

        label0.setLayoutX(500);
        label0.setLayoutY(20);
        label0.setText("1/2");
        label0.setFont(Font.font("Impact", 25));

        label1.setLayoutX(500);
        label1.setLayoutY(20);
        label1.setText("2/2");
        label1.setFont(Font.font("Impact", 25));
        label1.setVisible(false);

        label2.setLayoutX(200);
        label2.setLayoutY(20);
        label2.setText("¿Qué consultorio busca?");
        label2.setFont(Font.font("Impact", 20));

        label3.setLayoutX(225);
        label3.setLayoutY(100);
        label3.setText("Nombre Completo");
        label3.setFont(Font.font("Impact", 14));
        label3.setVisible(false);

        label4.setLayoutX(225);
        label4.setLayoutY(175);
        label4.setText("Cédula");
        label4.setFont(Font.font("Impact", 14));
        label4.setVisible(false);

        label5.setLayoutX(225);
        label5.setLayoutY(250);
        label5.setText("Edad");
        label5.setFont(Font.font("Impact", 14));
        label5.setVisible(false);

        label6.setLayoutX(400);
        label6.setLayoutY(275);
        label6.setText("X edad incorrecta");
        label6.setFont(Font.font("Impact", 14));
        label6.setTextFill(Color.web("#ff0000"));
        label6.setVisible(false);

        label7.setLayoutX(225);
        label7.setLayoutY(25);
        label7.setText("Ingrese sus datos");
        label7.setFont(Font.font("Impact", 20));
        label7.setVisible(false);

        return root;
    }

    public static void main(String[] args) {
        //launch(args);
        new Cliente_GUI();

    }

    public Cliente_GUI() {
        this.go();
    }

    public void go() {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                start(new Stage());
            }
        });
    }

    //Manejar mediante un try las conexiones entre consultorios. no todos van a estar abiertos siempre
    private void iniciarClientes() throws Exception{
        try {
            this.cliente1 = new Cliente("192.168.1.2"); // se crea el cliente
            this.cliente2 = new Cliente("192.168.1.2"); // se crea el cliente
            this.cliente3 = new Cliente("192.168.1.2"); // se crea el cliente
            this.cliente4 = new Cliente("192.168.1.2"); // se crea el cliente
            this.cliente5 = new Cliente("192.168.1.2"); // se crea el cliente
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void entrarPrimeraInterfaz() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        button5.setVisible(true);
        label0.setVisible(true);
        label2.setVisible(true);

        button6.setVisible(false);
        button7.setVisible(false);
        label1.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
    }

    private void entrarSegundaInterfaz() {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        button5.setVisible(false);
        label6.setVisible(false);
        label0.setVisible(false);
        label2.setVisible(false);

        button6.setVisible(true);
        button7.setVisible(true);
        label1.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        label5.setVisible(true);
        label7.setVisible(true);
        textField1.setVisible(true);
        textField2.setVisible(true);
        textField3.setVisible(true);
    }

}
