import  java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;


public class Sanalista {
private String tiedostonnimi;
private List<Sana> sanalista = new Vector<Sana>(3,1);

	public Sanalista (String Tiedostonnimi){
		this.tiedostonnimi=Tiedostonnimi;
	}
	public List<Sana> keraaSanat(){
		List<String> lol = this.annaSanat(tiedostonnimi);
		Iterator<String> iter = lol.iterator();
      	while(iter.hasNext()){
      		String sana = iter.next();
      		Sana olio = new Sana(sana);
      		sanalista.add(olio);
      	}
		return sanalista;
	}

	public String getName(){
		return tiedostonnimi;
	}

	public List<String> annaSanat(String tiedostonnimi){
		String line=null;
		boolean ok = false;
		List<String> result = new Vector<String>(3,1);
    	try(BufferedReader bufreader = new BufferedReader(new FileReader(
    		new File(tiedostonnimi)))){

    		while (!ok) {
    			line = bufreader.readLine();
				if(line == null){ok=true;}
				else{result.add(line.toUpperCase());}
    		}

   			bufreader.close();
		}catch(IOException ioe){
			System.out.println("ei bygee...");
			ioe.printStackTrace();
			System.exit(0);
		}
		return result;
	}

	public Sanalista sanatJoidenPituusOn(int pituus){
		Sanalista palauta = new Sanalista(tiedostonnimi);
		Iterator<Sana> iter = sanalista.iterator();
      	while(iter.hasNext()){
      		Sana word = iter.next();
      		if(word.getLen()==pituus){
      			palauta.lisaa(word);
      		}
      	}
		return palauta;
	}

	public Sanalista sanaJoissaMerkit( String mjono ){
		char [] jono = mjono.toCharArray();
		Sanalista palauta = new Sanalista(tiedostonnimi);
		Iterator<Sana> iter = sanalista.iterator();
      	while(iter.hasNext()){
      		Sana word = iter.next();

	      		if(word.sisaltaa(mjono) | mjono.equals(" ")){
	      			word.aukaiseSalaus(mjono);
	      			palauta.lisaa(word);
	      		}

      	}
		return palauta;
	}

	public void lisaa(Sana sana){
		sanalista.add(sana);
	}

	public void tulostaSalattu(){
		Iterator<Sana> iter = sanalista.iterator();
      	while(iter.hasNext()){
      		System.out.println(iter.next().getSana());
      	}
	}
	public void tulostaSana(){
		Iterator<Sana> iter = sanalista.iterator();
      	while(iter.hasNext()){
      		System.out.println(iter.next().getSalattu());
      	}
	}

	public int koko(){
      	return sanalista.size();
	}

	public Sana yksinainenSana(int index){
		return sanalista.get(index);
	}





}
