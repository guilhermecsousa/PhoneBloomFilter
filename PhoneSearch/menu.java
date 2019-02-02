//METODOS PROBABILISTICOS DE ENGENHARIA INFORMATICA - 2017

package trabalho;

import java.util.Scanner;

public class menu {
	static Scanner sc = new Scanner(System.in);
	public menu(){
		
	}
	public static void mainMenu(){
		System.out.println("1 - Pesquisar");
		System.out.println("2 - Listar todos os telemóveis\n");
		System.out.println("0 - Sair");
		System.out.print("Opção:");
	}
	
	public  void caracteristicas(String s, int[] op, String [] preco){
		String [] aux = s.split(";");
		if(op[0]==0){
			System.out.println("\n0 - PREÇO (Todos) ");
		}else{
			System.out.println("\n0 - PREÇO (" + preco[op[0]-1] + ")");
		}
		for(int i=1; i<aux.length+1; i++){
			if(op[i]==0){
				System.out.println(i+" - "+aux[i-1].split(":")[0] + " (Todos)");

			}else{
				System.out.println(i+" - "+aux[i-1].split(":")[0] + " (" +aux[i-1].split(":")[1].split(",")[op[i]-1] + ")");
			}
		}
		System.out.println("-----------------");
		System.out.println("-1 - Clear");
		System.out.println("-2 - Voltar atrás");
		System.out.println("-3 - Pesquisar");
		System.out.println("-----------------");
		System.out.print("Opção:");
				
	}
	public int [] menus(String s, int[] arr, int opcao){
		System.out.println("\n0 - Todos");
		String [] aux = s.split(";");
		if(opcao != 0){
			for(int k=0; k<aux[opcao-1].split(":")[1].split(",").length;k++){
					System.out.println(k+1 + " - " + aux[opcao-1].split(":")[1].split(",")[k]);
			}
						
			do{
				System.out.print("Opção:");
				arr[opcao] = sc.nextInt();
				if(arr[opcao]<0 || arr[opcao]>aux[opcao-1].split(":")[1].split(",").length+1){
					System.out.println("Invalido!");
				}
			}while(arr[opcao]<0 || arr[opcao]>aux[opcao-1].split(":")[1].split(",").length+1);
		}else{
			System.out.println("1 - 0€ até 150€");
			System.out.println("2 - 150€ até 300€");
			System.out.println("3 - 300€ até 500€");
			System.out.println("4 - 500€+");
			do{
				System.out.print("Opção:");
				arr[0] = sc.nextInt();
				if(arr[0]<0 || arr[0]>4){
					System.out.println("Inválido!");
				}
			}while(arr[0]<0 || arr[0]>4);
		}
	
		return arr;
	}
}