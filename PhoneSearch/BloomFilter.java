//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

public class BloomFilter {
	private int size;         //Tamanho do Bloom Filter
	private int n;            //Numero de funcoes de hash
	private int [] bfilter;	
	private String name;
	
	public BloomFilter(int size, int n, String name){
		
		this.size = size;
		this.n = n;
		this.name = name;
		bfilter = new int[size];		
	}
	
	public void add(String a){
		
		int hash = Math.abs(a.hashCode()%size);
		bfilter[hash] = 1;
		
		for(int i=1; i<n; i++){
			a=a+i;                     //Acrescenta um numero i a string de entrada
			hash = Math.abs(a.hashCode()%size);
			bfilter[hash] = 1;
		}
	}
	
	public boolean verify(String a){
		
		int hash = Math.abs(a.hashCode()%size);
		if(bfilter[hash]!=1) return false;
		
		for(int i=1; i<n; i++){
			a=a+i;                   
			hash = Math.abs(a.hashCode()%size);
			if(bfilter[hash]!=1) return false;
		}
		return true;
	}

	public String getName(){
		return name;
	}
}