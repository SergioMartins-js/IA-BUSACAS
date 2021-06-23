import espacoDeEstados.*;
import estrategiasDeBusca.cega.*;
import estrategiasDeBusca.heuristica.*;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		/*Scanner scan = new Scanner(System.in);

		System.out.println("Escolha a sequencia: ");
		System.out.println("1-(' ','2','3','1','4','6','7','5','8')");
		System.out.println("2-('2','4','3','7','1','6','5',' ','8')");
		System.out.println("3-('2','3',' ','7','4','1','5','8','6')");
		System.out.println("4-('7','2','3','4',' ','1','5','8','6')");

		int opcao = scan.nextInt();

		switch(opcao){
			case 1 :{
				char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
				break;
			}
			case 2 :{
				char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
				break;
			}
			case 3 :{
				char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
				break;
			}
			case 4 :{
				char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'};
				break;
			}
		}*/

		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
//		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
//		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
//		char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );

		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);

		Scanner scan = new Scanner(System.in);

		System.out.println("Escolha a sequencia:");
		System.out.println("1-(Busca em largura)");
        System.out.println("2-(Busca em profundidade)");
        System.out.println("3-(Busca em profundidade limitada)");
        System.out.println("4-(Busca em Best First)");
		System.out.println("5-(Busca em AStar)");
		System.out.println("6-(Busca em HillClimb)");
		System.out.println("Digite uma opcao: ");

		int opcao = scan.nextInt();

		switch(opcao){
			case 1 :{
				System.out.println("Busca em largura escolhido!!)");
				BuscaCega busca = new BuscaEmLargura();
				break;
			}case 2 :{
				System.out.println("Busca em profundidade escolhido!!)");
				BuscaCega busca = new BuscaEmProfundidade();
				break;
			}case 3 :{
				System.out.println("Busca em profundidade limitada escolhido!!");
				BuscaCega busca = new BuscaEmProfundidadeLimitada(null, null, 16);
				break;
			}case 4 :{
				System.out.println("Busca em BestFist escolhido!!");
				BuscaInformada busca = new BestFirst();
				break;
			}case 5 :{
				System.out.println("Busca em AStar escolhida!!!");
				BuscaInformada busca = new AStar();
				break;
			}case 6 :{
				System.out.println("Busca em HillClimbing escolhida!!");
				BuscaInformada busca = new HillClimbing();
				break;
			}
		}








//		BuscaCega busca = new BuscaEmLargura();
//		BuscaCega busca = new BuscaEmProfundidade();
//		BuscaCega busca = new BuscaEmProfundidadeLimitada(null, null, 16);
//		BuscaInformada busca = new BestFirst();
//		BuscaInformada busca = new AStar();
//		BuscaInformada busca = new HillClimbing();

		busca.setInicio(puzzleInicial);
		busca.setObjetivo(puzzleFinal);
		busca.buscar();
		for(Estado e : busca.getCaminhoSolucao()) {
			System.out.println(e);
		}

		System.exit(0);
	}

}
