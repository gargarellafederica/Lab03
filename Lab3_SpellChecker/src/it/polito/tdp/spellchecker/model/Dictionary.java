package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Dictionary {
	private List<String> dizionario;
	private String lingua;

	public boolean loadDictionary(String language) {
		if (dizionario!=null && lingua.equals(language)) {
			return true;
		}
			dizionario= new ArrayList<String>();
			lingua=language;
			try {
				FileReader fr=new FileReader("rsc/"+ lingua +".txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while ((word=br.readLine())!=null) {
					dizionario.add(word);
				}
				Collections.sort(dizionario);
				br.close();
				return true;
				
			} catch(IOException e) {
				System.out.println("Errore nella lettura del file");
				return false;
			}
	
	}


	public List<RichWord> spellCheckText (List<String> inputTextList){
		List<RichWord> frase =new ArrayList<>();
		for (String s: inputTextList) {
				RichWord e =new RichWord(s);
				if(dizionario.contains(s))
					e.setCorretto(true);
				else
					e.setCorretto(false);
				frase.add(e);
		}
		return frase;
		}
}
