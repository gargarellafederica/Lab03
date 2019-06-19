/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {
	
	private Dictionary dizionario;
	private List<String> frase;
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="boxlingua"
    private MenuButton boxlingua; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtError"
    private Text txtError; // Value injected by FXMLLoader

    @FXML // fx:id="txtTempo"
    private Text txtTempo; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txtArea.clear();
    	txtResult.clear();
    	txtError.setText(" ");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	List<RichWord> listauscita;
    	frase= new LinkedList<>();
    	//TOGLIE I SEGNI DI PUNTEGGIATURA
    	String testo = txtArea.getText().toLowerCase();
    	if (testo.isEmpty())
    		txtResult.setText("Inserire frase da correggere\n");
    	testo.replaceAll("[.,\\/#!$%\\^&\\*);:{}=\\-_'~\\[\\]\"]","");
    	
    	StringTokenizer st = new StringTokenizer(testo, " ");

		while (st.hasMoreTokens()) {
			frase.add(st.nextToken());
		}
		
		long start = System.nanoTime();
		
		listauscita= dizionario.spellCheckText(frase);
		long end = System.nanoTime();
		
		int numerrori=0;
		
		for(RichWord r: listauscita)
			if(r.isCorretto()==false) {
				numerrori++;
				txtResult.appendText(r.getParola()+ "\n");
			}
		txtTempo.setText("Ricerca completata in: " + (end - start) / 1E9 + " secondi!");

		txtError.setText("Il testo contiene " + numerrori + " errori!");
    
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxlingua != null : "fx:id=\"boxlingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }

	public void setModel(Dictionary model) {
		this.dizionario=model;
	}
}