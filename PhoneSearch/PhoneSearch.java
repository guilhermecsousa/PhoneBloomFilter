//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneSearch {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		minHash minhash = new minHash();
		List<Telemovel> simTel;
	//Leitura data.txt
		Path p = Paths.get("data.txt");					
		List<String> l = new ArrayList<String>();			//Cria arraylist das linhas
		try {
			l = Files.readAllLines(p,Charset.defaultCharset());
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	//Criacao dos BloomFilters
		String [] aux = l.get(0).split(";");
		String [] aux2;
		int size=0;
		for(int i=0; i<aux.length;i++){
			size += aux[i].split(":")[1].split(",").length;
		}
		size+=4;
		BloomFilter [] bf = new BloomFilter[size]; 
		int x=0;
		for(int j=0; j<aux.length;j++){
			aux2 = aux[j].split(":")[1].split(",");
			for(int k=0;k<aux2.length;k++){
				bf[x] = new BloomFilter(1000, 7, aux2[k]);
				x++;
			}
		}
			
		bf[size-4]=new BloomFilter(1000, 7, "0-150");
		bf[size-3]=new BloomFilter(1000, 7, "150-300");
		bf[size-2]=new BloomFilter(1000, 7, "300-500");
		bf[size-1]=new BloomFilter(1000, 7, "500+");
		
	
	//ArrayList com todos os telemoveis diponiveis	
		String [] telemovel;
		String [] atributos;
		List<Telemovel> t = new ArrayList<Telemovel>();
		
		for(int i=1; i<l.size(); i++){
			 telemovel = l.get(i).split(";");
			 atributos =  telemovel[2].split(",");
			 String [] preco = telemovel[3].split("€");
			 t.add(new Telemovel(telemovel[0], telemovel[1], atributos, Integer.parseInt(preco[0]),i-1));
		}
	
	//Adição ao BloomFilter
		for(int i=0; i<t.size(); i++){
			 for(int j=0; j <t.get(i).getCarac().length; j++){
				 for(int k=0; k<bf.length; k++){
				    //add caracteristicas
					 if(t.get(i).getCarac()[j].equals(bf[k].getName())){
						 bf[k].add(t.get(i).getNome()); 
					 }
				   //add marca
					 if(t.get(i).getMarca().equals(bf[k].getName())){
						 bf[k].add(t.get(i).getNome()); 
					 }
				 }
			 }
			//add preço
			 if(price(t.get(i).getPreco())==0) bf[size-4].add(t.get(i).getNome());
			 if(price(t.get(i).getPreco())==1) bf[size-3].add(t.get(i).getNome());
			 if(price(t.get(i).getPreco())==2) bf[size-2].add(t.get(i).getNome());
			 if(price(t.get(i).getPreco())==3) bf[size-1].add(t.get(i).getNome());
			 
		}
		int [] utilOpcoes = new int[l.get(0).split(";").length + 1];
		menu m = new menu();
		
			 int opcao=1;
			 int s;
			 int j=0; 
			 String [] precomenus = {"0€ até 150€","150€ até 300€","300€ até 500€","500€+"};
			 ArrayList<Telemovel> t2 = ArrayCopy(t); //Array de telemóveis filtrados
			 while(opcao!=0){
				 menu.mainMenu();	
				 opcao=sc.nextInt();
				 int op;
				 switch(opcao){
				 case 1:
					 do{
						m.caracteristicas(l.get(0), utilOpcoes, precomenus); 
						s=sc.nextInt();
						if(s==-3){
							for(int i=0; i<utilOpcoes.length;i++){
								if(i!=0){
									if(utilOpcoes[i]!=0){
										for(int k=0; k<bf.length;k++){
											if(l.get(0).split(";")[i-1].split(":")[1].split(",")[utilOpcoes[i]-1].equals(bf[k].getName())){
												j=0;
												do{
													//
													if(!bf[k].verify(t2.get(j).getNome())){
														t2.remove(j);
														j--;
													}
													j++;
												}while(j<t2.size());
											}
										}
									}
								}else{
									if(utilOpcoes[i]!=0){
										j=0;
										do{
											if(!bf[size-5+utilOpcoes[0]].verify(t2.get(j).getNome())){
												t2.remove(j);
												j--;
											}
											j++;
										}while(j<t2.size());
									}
								}
							}
							//
							for(int i=0; i<t2.size();i++){
								System.out.println(t2.get(i).toString()); 
							}
							for(;;){
								System.out.print("\nSaiba mais acerca de um modelo introduzindo o seu indice \nIntroduza -1 para sair \nOpção:");
								op = sc.nextInt();
								if(op==-1){
									break;
								}else{
									System.out.println(t.get(op).toStringAll());
								}
								simTel = minhash.verificar(t.get(op), t);
								System.out.println("");
								System.out.println("SIMILARES:");
								  for(int i=1; i<simTel.size();i++){
									  System.out.print(simTel.get(i).toStringSimilar());
								  }
								  System.out.println("");
								  System.out.println("");
							}
							//break;						
						
						}else if(s==-1 || s==-2){
							utilOpcoes = new int[l.get(0).split(";").length + 1];
							t2 = ArrayCopy(t);
						
						}else if(s>-4 && s<l.get(0).split(";").length+1){
							utilOpcoes=m.menus(l.get(0), utilOpcoes, s);
						}
					 }while(s!=-2);
					break;
					
				  case 2: 
					  for(int i=0; i<t.size();i++){
						  System.out.println(t.get(i).toString());
					  }
					  for(;;){
						  System.out.print("\nSaiba mais acerca de um modelo introduzindo o seu indice:");
						  op = sc.nextInt();
						  System.out.println("");
						  if(op==-1)break;
							  
					System.out.println(t.get(op).toStringAll());
					  
						  simTel = minhash.verificar(t.get(op), t);
						  System.out.println("");
						  System.out.println("SIMILARES:");
					  
						  for(int i=1; i<simTel.size();i++){
							  System.out.print(simTel.get(i).toStringSimilar());
					  }
					  System.out.println("");
					  System.out.println("");
					  } 
					 //break; 
				 }
			 }
	}
		
	//Funcao auxiliar para o preço	
	private static int price(int p){
		
		if(p>=0 && p<150) return 0;
		if(p>=150 && p<300) return 1;
		if(p>=300 && p<500) return 2;
		return 3;	
	}
	
	private static ArrayList<Telemovel> ArrayCopy(List<Telemovel> t){
		ArrayList<Telemovel> ac = new ArrayList<>();
		for(int i=0; i<t.size();i++){
			ac.add(t.get(i));
		}
		return ac;
	}
}
