package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			TextArea txtRegistros = new TextArea("Ordenando...");
			root.setTop(txtRegistros);
			
			HBox hbxAvance = new HBox();
			
			ProgressBar progressBar = new ProgressBar(0);
		    ProgressIndicator progressIndicator = new ProgressIndicator(0);
		    hbxAvance.getChildren().addAll(progressBar, progressIndicator);
		    
		    root.setCenter(hbxAvance);
			
		    Button btnIniciar = new Button("Iniciar");
		    
		    //TODO: ¿Cómo se pone el tipo de evento
		    btnIniciar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {	
					
					//try {
						/*Error de acceso a los componentes de la GUI desde otro hilo
						 * hiloOrdena hiloExterno = new hiloOrdena(txtRegistros, 
								progressBar, progressIndicator);
						hiloExterno.start();
						*/
						
						/* Sí permite que otro hilo actualice componentes GUI pero no en tiempo real
						Platform.runLater(new hiloOrdena(txtRegistros, 
								progressBar, progressIndicator));
						*/		
								
						tareaActualizaAvance tareaConcurrente = new tareaActualizaAvance(txtRegistros, 
								progressBar, progressIndicator);
						Thread hiloExterno = new Thread(tareaConcurrente);
						hiloExterno.setDaemon(true);
						hiloExterno.start();
						
						//Thread.sleep(1000);
					//} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					//}
				} 	
		    });
		    
		    root.setBottom(btnIniciar);
		    
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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