package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Dictionary {
	List<String> dizionarioE, dizionarioI;

	public void loadDictionary(String language) {
		if (language.equals("English")) {
			dizionarioE= new ArrayList<String>();
			try {
				FileReader fr=new FileReader("rsc/English.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while ((word=br.readLine())!=null) {
					dizionarioE.add(word);
				}
				br.close();
			} catch(IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
		else {
			dizionarioI= new ArrayList<String>();
			try {
				FileReader fr=new FileReader("rsc/Italian.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while ((word=br.readLine())!=null) {
					dizionarioI.add(word);
				}
				br.close();
			} catch(IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
	
	}


	public List<RichWord> spellCheckText (List<String> inputTextList){
		List<RichWord> frase =new ArrayList<>();
		for (String s: inputTextList) {
			for(String r: dizionarioI) {
				if(s.equals(r))
				{
					RichWord e =new RichWord(s, true);
					frase.add(e);
				}
				else {
					RichWord e =new RichWord(s, false);
					frase.add(e);
				}
			}
		}
		return frase;
		}

	
	
}
