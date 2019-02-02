//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import java.util.ArrayList;
import java.util.List;

public class similarityList {
	
	private List<Integer> similarity;
	private List<Telemovel> telemoveis;
	
	public similarityList(){
		telemoveis = new ArrayList<>();  //ArrayList dos telemoveis
		similarity = new ArrayList<>();	 //ArrayList dos indices de similaridade
	}
	
	public void add2(Telemovel tele, int sim){
		telemoveis.add(tele);
		similarity.add(sim);
	}
	
	
	//Ordenação do mais semelhante para o menos semelhante
	public void sort(){				
		List<Integer> similarityaux = new ArrayList<>();
		List<Telemovel> taux = new ArrayList<>();
		int sim = -1;
		int k = 0;
		while(telemoveis.size()>0){
			sim=-1;
			for(int i=0; i<telemoveis.size();i++){
				if(similarity.get(i)>sim){
					k=i;
					sim=similarity.get(i);
				}
			}
			taux.add(telemoveis.get(k));
			similarityaux.add(sim);
			telemoveis.remove(k);
			similarity.remove(k);
		}
		similarity=new ArrayList<>();
		similarity=similarityaux;
		telemoveis=new ArrayList<>();
		telemoveis=taux;
	}
	
	public List<Telemovel> getMaisSimilares(int k){
		sort();
		List<Telemovel> maisSimilares = new ArrayList<>();
		for(int i=0;i<k;i++){
			maisSimilares.add(telemoveis.get(i));
		}
		return maisSimilares;
	}
}