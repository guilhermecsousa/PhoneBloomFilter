//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

public class Telemovel {
	private String nome, marca, cpu, ram, rom, cam, scr, fpr, sim;
	private int preco, index;
	private String[] carac;
	
	public Telemovel(String nome, String marca, String[] carac, int preco, int index) {
		
		this.nome = nome;
		this.marca = marca;
		this.cpu = carac[0];
		this.ram = carac[1];
		this.rom = carac[2];
		this.cam = carac[3];
		this.scr = carac[4];
		this.fpr = carac[5];
		this.sim = carac[6];
		this.preco = preco;
		this.carac=carac;
		this.index=index;
	}
	
	public String [] getCarac(){
		String [] caracaux = new String [carac.length+3];
		for(int i=0;i<caracaux.length-3;i++){
			caracaux[i]=carac[i];
		}
		caracaux[carac.length]=nome;
		caracaux[carac.length+1]=marca;
		caracaux[carac.length+2]="" + preco;
		return caracaux;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getCpu() {
		return cpu;
	}

	public String getRam() {
		return ram;
	}

	public String getRom() {
		return rom;
	}

	public String getCam() {
		return cam;
	}

	public String getScr() {
		return scr;
	}

	public String getFpr() {
		return fpr;
	}

	public String getSim() {
		return sim;
	}

	public int getPreco() {
		return preco;
	}

	public int getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		System.out.println();
		return index +" | Marca - " + marca + " | Modelo - " + nome + " || PVP - " + preco + "€";
	}
	/*
	public String toString() {
	    return String.format("%5s | Marca - %13s | Modelo - %20s || PVP - %3d €", index, marca, nome, preco);
	}*/
	
	public String toStringAll() {
		System.out.println();
		return index +" | Marca - " + marca + " | Modelo - " + nome + " | Processador - " + cpu + " | RAM - " + ram + " | ROM - " + rom
				+ " | Câmara - " + cam + " | Ecrã - " + scr + " | M.Desbloqueio - " + fpr + " | SIM - " + sim + " || PVP - " + preco + "€\n";
	}
		
	public String toStringSimilar() {
		return  index +" | Marca - " + marca + " | Modelo - " + nome + " || PVP - " + preco + "€\n";
	}
	
}