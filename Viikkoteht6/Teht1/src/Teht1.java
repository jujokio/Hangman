import  java.util.*;

public class Teht1 {

	public static Sanalista teeLista(){
		Sanalista list = new Sanalista("K:\\My Documents\\sanalista.txt");
		list.keraaSanat();

		String mjono = lueString("Anna merkkijono, joka sisältyy sanaan. Space jos kaikki kay!");
		mjono=mjono.toUpperCase();
		int pituus = lueInt("kuinka pitka sana? Jos 0, kaikki kay!");

		if(pituus !=0){
			list = list.sanatJoidenPituusOn(pituus);
		}
		if (list.koko()==0){
			System.out.println("Ei loytynyt sopivaa sanaa!");
			System.exit(0);
		}
		if (mjono.length() >=1 | mjono.equals(" ")){
			list = list.sanaJoissaMerkit(mjono);
		}
		if (list.koko()==0){
			System.out.println("Ei loytynyt sopivaa sanaa!");
			System.exit(0);
		}
	return list;
	}

	public static void GameOn(Sanalista lista){
		boolean ok = false;
		int maara =0;
		while (maara<=0){
			System.out.println("Arvauksien maara taytyy olla suurempi kuin 0!");
			maara = lueInt("Anna arvausten maara. Oikea vastaus ei vahenna arvauksien maaraa!");
		}
		Hirsipuu peli = new Hirsipuu(lista, maara);
		while(!ok){

			peli.tulostaPelitilanne();

			char arvaus = lueChar("Anna arvauksesi: ");

			if(peli.arvattuJo(arvaus)){
				peli.arvaa(arvaus);
			}else{System.out.println("Arvattu jo!");}

			if(peli.onLoppu()){
				ok=true;
			}

		}
	}

    public static void main(String[] args) {
		Sanalista list = teeLista();
		GameOn(list);
	}











    public static char lueChar(String kysymys){
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		char line='0';
		do {
			try {
				System.out.println(kysymys);
				line = sc.nextLine().charAt(0);
				ok = true;
			}catch( InputMismatchException ime ){
				sc.nextLine();
				System.out.print("Virhe, yrita uudelleen > ");
			}
		}while(!ok);
		line = Character.toUpperCase(line);
		return line;
	}

	public static int lueInt(String kysymys){
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		int luku = -1;
		do {
			try {
				System.out.println(kysymys);
				luku = sc.nextInt();
				sc.nextLine();
				if(luku>-1){ok = true;}
			}
			catch( InputMismatchException ime ){
				sc.nextLine();
				System.out.print("Virhe, yrita uudelleen > ");
			}
		}while(!ok);
		return luku;
	}


	public static String lueString(String kysymys){
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		String line=null;
		do {

			try {
				System.out.println(kysymys);
				line = sc.nextLine();
				if (line.length()>=1){ok = true;}

			}catch( InputMismatchException ime ){
				sc.nextLine();
				System.out.print("Virhe, yrita uudelleen > ");
			}
		}while(!ok);
		return line;
	}


}
