package application;
	
import java.util.Observable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.TipoPelicula;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Creo el layout que contendra los elementos
			VBox root = new VBox(2);
			
			//Creo un elemento label
			Label tituloPantalla = new Label("Ingreso de Pelicula");
			//Agrego el elemento al layout
			root.getChildren().add(tituloPantalla);
			
			
			//Elementos del Formulario (van dentro de la grilla)
			Label titulo = new Label("Titulo");
			TextField txtTitulo = new TextField();
			//Necesito que el choiceBox tenga cargados elementos.
			//El choice box espera una lista observable
			ObservableList<TipoPelicula> listaTiposPeliculaObservable = FXCollections.observableArrayList(TipoPelicula.values());
			ChoiceBox<TipoPelicula> chbTipoPelicula = new ChoiceBox<>(listaTiposPeliculaObservable);
			//Creo un textArea
			TextArea txtSinopsis = new TextArea();
			txtSinopsis.setPrefWidth(100);
			/*... espacio para uds creen otros elementos
			 * 
			 */
			
			//Me creo el Spinner
			Spinner<Integer> spnDuracionMinutos = new Spinner<>(30, 430, 120);
			
			//Creo la grilla :)
			GridPane grillaDeDatos = new GridPane();
			grillaDeDatos.add(titulo, 0, 0);
			grillaDeDatos.add(txtTitulo, 1, 0);
			grillaDeDatos.add(new Label("Tipo Pelicula"), 0, 1);
			grillaDeDatos.add(chbTipoPelicula, 1, 1);
			grillaDeDatos.add(new Label("Sinopsis"), 0, 2);
			grillaDeDatos.add(txtSinopsis, 1, 2);
			grillaDeDatos.add(spnDuracionMinutos, 1, 4);
			grillaDeDatos.setGridLinesVisible(true);
			
			//Agregada la grilla al VBox
			root.getChildren().add(grillaDeDatos);
			
			HBox cajitaBotones = new HBox(30);
			Button btnGuardar = new Button("Guardar");
			Button btnLimpiar = new Button("Limpiar");
			Button btnCancelar = new Button("Cancelar");
			cajitaBotones.getChildren().add(btnLimpiar);
			cajitaBotones.getChildren().add(btnGuardar);
			cajitaBotones.getChildren().add(btnCancelar);
			root.getChildren().add(cajitaBotones);
			
			btnGuardar.setOnAction(e -> System.out.println(txtTitulo.getText()));
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
