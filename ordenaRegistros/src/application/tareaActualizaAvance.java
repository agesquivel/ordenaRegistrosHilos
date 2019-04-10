package application;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class tareaActualizaAvance extends Task<String>{

	private TextArea atxMensaje;
	private ProgressBar barraProgreso;
	private ProgressIndicator indicadorProgreso;
	
	public tareaActualizaAvance(TextArea atxMensaje, 
			ProgressBar barraProgreso, ProgressIndicator indicadorProgreso) {
		super();
		this.atxMensaje = atxMensaje;
		this.barraProgreso = barraProgreso;
		this.indicadorProgreso = indicadorProgreso;
		
		this.atxMensaje.textProperty().bind(this.messageProperty());
		this.barraProgreso.progressProperty().bind(this.progressProperty());
		this.indicadorProgreso.progressProperty().bind(this.progressProperty());
	}

	@Override
	protected String call() throws Exception {
		// TODO Auto-generated method stub
		for (int cont = 1; cont <= 10000; cont++) {
			//atxMensaje.appendText("Registros ordenados " + cont + '\n');
			this.updateMessage("Registros ordenados " + cont + '\n');
			
			//barraProgreso.setProgress(cont/10000);
			this.updateProgress(cont, 10000);
			
			//indicadorProgreso.setProgress(cont/10000);
			
			if (this.isCancelled())
				break;
			
			Thread.sleep(1);
		}
		
		return "Tarea terminada";
	}
}
