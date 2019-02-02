//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import java.util.ArrayList;
import java.util.List;
import trabalho.minHash;

public class testMinHash {
	public static void main(String[] args) {
		
		minHash teste = new minHash();
		
		List<Telemovel> list = new ArrayList<Telemovel>();
		
		String [] carac = {"Octa-Core","2Gb","64Gb","16mpx","FHD","Fingerprint","Mono-SIM"};       //Telemovel em teste
		Telemovel telemovel = new Telemovel("Teste", "Alcatel",carac , 0, 0);
		list.add(telemovel);
		
		String [] carac1 = {"Dual-Core","4Gb","32Gb","20mpx","HD","Fingerprint","Mono-SIM"};
		Telemovel telemovel1 = new Telemovel("Teste", "     Teste     ",carac1 , 0, 1);
		list.add(telemovel1);
		String [] carac2 = {"Dual-Core","4Gb","32Gb","20mpx","HD","No-Fingerprint","Dual-SIM"};    //Telemovel mais diferente
		Telemovel telemovel2 = new Telemovel("Teste", "Mais diferente ",carac2 , 0, 2);
		list.add(telemovel2);         
		String [] carac3 = {"Dual-Core","4Gb","32Gb","20mpx","FHD","Fingerprint","Mono-SIM"};
		Telemovel telemovel3 = new Telemovel("Teste", "     Teste     ",carac3 , 0, 3);
		list.add(telemovel3);
		String [] carac4 = {"Dual-Core","2Gb","64Gb","16mpx","FHD","Fingerprint","Mono-SIM"};	   //Telemovel mais semelhante
		Telemovel telemovel4 = new Telemovel("Teste", "Mais semelhante",carac4 , 0, 4);
		list.add(telemovel4);
		String [] carac5 = {"Dual-Core","4Gb","64Gb","16mpx","FHD","Fingerprint","Mono-SIM"};
		Telemovel telemovel5 = new Telemovel("Teste", "     Teste     ",carac5 , 0, 5);
		list.add(telemovel5);
		String [] carac6 = {"Dual-Core","4Gb","32Gb","16mpx","FHD","Fingerprint","Mono-SIM"};
		Telemovel telemovel6 = new Telemovel("Teste", "     Teste     ",carac6 , 0, 6);
		list.add(telemovel6);
		
		for(int i=1; i<list.size(); i++){
			System.out.print(teste.verificarTeste(telemovel, list).get(i).toString());
		}
	}
}
