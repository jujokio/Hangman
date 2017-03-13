
public class Sana {
	private String sana;
	private String salattu;
	private String aukaistu;

	public Sana(String given_sana) {
		this.sana = given_sana;
		this.salattu = salattuSana();
		this.aukaistu = salattu;
	}

	public String salattuSana(){
	String tulos = "";
	char [] temp = sana.toCharArray();
	for(int i=0;i<temp.length;i++){
		temp[i]='_';
		tulos=tulos+temp[i];
	}
	return tulos;
	}



	public String getSana(){
		return sana;
	}
	public String getSalattu(){
		return salattu;
	}
	public String getPurettu(){
		return aukaistu;
	}


	public int getLen(){
		return sana.length();
	}



	public boolean sisaltaa(String mjono){
		char [] jono = mjono.toCharArray();
		for (int i=0;i<mjono.length();i++){
			if(jono[i]!='_'){
				int index = sana.indexOf(jono[i]);
				if (index == -1){return false;}
			}
		}

		return true;
	}


	public void aukaiseSalaus(String mjono){
		char [] temp = sana.toCharArray();
		char [] sala = salattu.toCharArray();
		char [] jono = mjono.toCharArray();


		String purettu="";


		for (int i=0;i<sana.length();i++){
			for (int j=0;j<mjono.length();j++){
				if (jono[j]==temp[i]){
					sala[i] = jono[j];
					break;
				}else{sala[i] ='_';}
			}
			purettu = purettu+sala[i];


		}
		purettu = this.vertaa(purettu);
		this.aukaistu = purettu;

	}

	public String vertaa(String purettu){

		char [] auki = aukaistu.toCharArray();
		char [] purku = purettu.toCharArray();
		String temp="";
		for (int i=0;i<purku.length;i++){
			if(auki[i]!='_' & purku[i] == '_'){
				purku[i]=auki[i];
			}
			temp = temp+purku[i];
		}
	return temp;
	}

	public String toString(){
		String tuloste ="";
		char [] temp = sana.toCharArray();
		for (int k=0;k<temp.length;k++){
			tuloste=tuloste+" "+temp[k];
		}
		return tuloste;
	}













}
