/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	List<String> frase;
    	//TOGLIERE SEGNI DI PUNTEGGIATURA
    	String testo = txtArea.getText().toLowerCase();
    	frase.add(testo.split(" "));
    	//vedere bene 
    	public List<RichWord> spellCheckText (frase);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}