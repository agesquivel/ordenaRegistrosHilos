package application;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class hiloOrdena extends Thread {
	
	private TextArea atxMensaje;
	private ProgressBar barraProgreso;
	private ProgressIndicator indicadorProgreso;
	
	public hiloOrdena(TextArea textoMsj, ProgressBar barraProgreso, 
			ProgressIndicator indicadorProgreso) {
		super();
		this.atxMensaje = textoMsj;
		this.barraProgreso = barraProgreso;
		this.indicadorProgreso = indicadorProgreso;
	}

	@Override
	public void run() {
		for (int cont = 1; cont <= 10000; cont++) {
			atxMensaje.appendText("Registros ordenados " + cont + '\n');
			barraProgreso.setProgress(cont/10000);
			indicadorProgreso.setProgress(cont/10000);
		}
	}
}








