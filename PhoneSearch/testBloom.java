//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import trabalho.BloomFilter;

public class testBloom {
	public static void main(String[] args) {
		BloomFilter bf = new BloomFilter(100, 5, "128Gb");
		
		System.out.println("Test BloomFilter\n");
		
		String [] s = {"OnePlus", "Samsung", "Nokia"};
		
		for(int i=0; i<s.length;i++){
			bf.add(s[i]);
			System.out.println("String " + s[i] + " adicionada" );
		}
		
		System.out.println("\nOnePlus - " + bf.verify("OnePlus"));
		System.out.println("HTC - " + bf.verify("HTC"));
		System.out.println("Nokia - " + bf.verify("Nokia"));
		System.out.println("Apple - " + bf.verify("Apple"));
		
	}

}
