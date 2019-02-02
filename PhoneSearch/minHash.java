//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import java.util.List;

public class minHash {
	similarityList sl;
	public minHash(){
		
	}
	public List<Telemovel> verificar(Telemovel t, List<Telemovel> todos){
		sl = new similarityList();
		for(int i=0; i<todos.size();i++){
			sl.add2(todos.get(i), getSimilarity(t,todos.get(i)));
		}
		return sl.getMaisSimilares(4);
	}
	
	public List<Telemovel> verificarTeste(Telemovel t, List<Telemovel> todos){
		sl = new similarityList();
		for(int i=0; i<todos.size();i++){
			sl.add2(todos.get(i), getSimilarity(t,todos.get(i)));
		}
		return sl.getMaisSimilares(todos.size());
	}
	
	private int[] getSignature(String [] t1){
		int [] signature = new int [t1.length];
		for(int i=0; i<t1.length;i++){
			signature[i]=t1[i].hashCode();
		}
		return signature;
	}
	
	private int getSimilarity(Telemovel t1, Telemovel t2){
		int[] t1S=getSignature(t1.getCarac());
		int[] t2S=getSignature(t2.getCarac());
		int similarity=0;
		for(int i=0; i<t1S.length;i++){
			if(t1S[i]==t2S[i]){
				similarity++;
			}
		}
		return similarity;
	}	
}