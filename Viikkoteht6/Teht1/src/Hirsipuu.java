import  java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
import java.util.concurrent.ThreadLocalRandom;


class Hirsipuu {
	private Sanalista sanat;
	private static int  arvausten_maara;
	private static Sana oikea_vastaus;
	private static List<Character> arvaukset = new Vector<Character>(3,1);


	public Hirsipuu(Sanalista lista,int maara){
		this.sanat = lista;
		this.arvausten_maara = maara;
		this.oikea_vastaus = arvoSana(sanat);
		}

	public Sana arvoSana(Sanalista sanat){

		Sana oikea_sana = null;
		int min =0;
		int max = sanat.koko();
		int index = ThreadLocalRandom.current().nextInt(min,max);
		oikea_sana = sanat.yksinainenSana(index);
		return oikea_sana;
	}

	public boolean arvaa(char arvaus){
		arvaukset.add(arvaus);
		if (oikea_vastaus.sisaltaa(String.valueOf(arvaus))){
			return true;
		}
		else{
			arvausten_maara--;
			return false;
		}
	}
	public void tulostaPelitilanne(){
		System.out.println("Arvauksia jaljella: "+arvausten_maara);
		System.out.println("Arvattava sana: "+this.aukaise());
		System.out.println("Tahan mennessa arvatut sanat: "+arvaukset);


	}

	public List<Character> arvaukset(){
		return arvaukset;
	}
	public int arvauksiaOnJaljella(){
		return arvausten_maara;
	}
	public String sana(){
		return oikea_vastaus.getSana();
	}
	public boolean onLoppu(){
		if (arvausten_maara ==0 | this.voitto()){
			return true;
		}
		else{
			return false;
		}
	}
	public String aukaise(){
		for (int i=0;i<arvaukset.size();i++){
			String jono = String.valueOf(arvaukset.get(i));
			oikea_vastaus.aukaiseSalaus(jono);
		}
		String tuloste ="";
		String vastaus = oikea_vastaus.getPurettu();
		char [] temp = vastaus.toCharArray();
		for (int k=0;k<temp.length;k++){
			tuloste=tuloste+" "+temp[k];
		}
		return tuloste;
	}


	public boolean arvattuJo(char arvaus){
		for (int i =0;i<arvaukset.size();i++){
			if (arvaus == arvaukset.get(i)){return false;}
		}
		return true;
	}

	public boolean voitto(){
		String arvaus = this.aukaise();
		String maali = oikea_vastaus.toString();
		if (arvaus.equals(maali)){
			this.tulostaVoitto();
			return true;
		}
		else if (arvausten_maara ==0){
			this.tulostaHavio();
			return false;
		}
		else{return false;}
	}



	public void tulostaVoitto(){
		this.tulostaPelitilanne();
		System.out.println();
		System.out.println("-------------------------- Voitit pelin! --------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Oikea sana oli: "+oikea_vastaus.getSana());
		System.out.println();
	}

	public void tulostaHavio(){
		this.tulostaPelitilanne();
		System.out.println();
		System.out.println("-------------------------- Havisit pelin! --------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Oikea sana oli: "+oikea_vastaus.getSana());
		System.out.println();
	}





}
