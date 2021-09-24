package Juego;
import java.util.Random;
import java.util.Scanner;

public class JuegoGato {

	public static void main (String[] args) {
		ValidacionesG vc = new ValidacionesG();
		Scanner sc = new Scanner(System.in);
		String jugador1 = "", jugador2 ="";
		String op = "";
		do {
		System.out.println("Ingrese nombre del jugador 1 (Mínimo 3 caractéres)");
		jugador1 = sc.nextLine();
		}while(!vc.esPalabra(jugador1));
		
		System.out.println("Elije tu contrincante");
		System.out.println("1 = "+jugador1+" Vs jugador 2");
		System.out.println("2 = "+jugador1+" Vs IA");
		do {
			op = sc.nextLine();
		switch(op){
		case "1": 
			do {
			System.out.println("Ingrese nombre del jugador 2 (Mínimo 3 caractéres)");
			jugador2 = sc.nextLine();
			}while(!vc.esPalabra(jugador2)|| jugador2.equals(jugador1));
		juegoGato(jugador1,jugador2);
		break;
		case "2": juegoGato(jugador1,"IA"); break;
		default: System.out.println("Por favor ingrese una opción correcta"); break;
		}
		}while(!op.equals("1") && !op.equals("2"));
		
		
	}
	
	public static void juegoGato(String j1 , String j2) {
		Random azar = new Random();
		String gato[][] = new String[3][3];
		String posicion = "";
		Scanner sc = new Scanner(System.in);
		ValidacionesG vc = new ValidacionesG();
		menteIA IA = new menteIA();
		 llenarInicio(gato);
		boolean terminado = false;
		mostrarGato(gato);
		do {
			do {
			do {
			System.out.println(j1+" ingrese posición de X (1 a 9)");
			posicion= sc.nextLine();
			}while(!vc.esPosicion(posicion));
			if(IA.estoyLleno(gato,Integer.parseInt(posicion))){
				System.out.println("Posición llena, por favor elija otra que esté disponible");
				mostrarGato(gato);
			}
			}while(IA.estoyLleno(gato,Integer.parseInt(posicion)));
			llenarPosicion(gato,Integer.parseInt(posicion),"X");
			mostrarGato(gato);
			terminado = esGanador(j1, gato,"X");
			if(!terminado) {
				if(j2.equals("IA")) {
					System.out.println("Turno de IA");
					do {
						if(!IA.jugadaIA(gato, "O").equals("0")) {
							posicion = IA.jugadaIA(gato,"O");
						} else {
							if(!IA.jugadaIA(gato, "X").equals("0")) {
								posicion = IA.jugadaIA(gato,"X");
							}
							else {
								do {
								posicion= String.valueOf(azar.nextInt(8)+1);
								}while(IA.estoyLleno(gato, Integer.parseInt(posicion)));
							}
						}
						}while(IA.estoyLleno(gato,Integer.parseInt(posicion)));
					System.out.println("IA ha ingresado su figura en la casilla "+posicion);
					llenarPosicion(gato,Integer.parseInt(posicion),"O");
					mostrarGato(gato);
					terminado = esGanador(j2, gato,"O");
						
				} else {
			do {
				do {
					System.out.println(j2+" ingrese posición de O (1 a 9)");
					posicion= sc.nextLine();
				}while(!vc.esPosicion(posicion));
				if(IA.estoyLleno(gato,Integer.parseInt(posicion))){
					System.out.println("Posición llena, por favor elija otra que esté disponible");
					mostrarGato(gato);
				}
			}while(IA.estoyLleno(gato,Integer.parseInt(posicion)));
			llenarPosicion(gato,Integer.parseInt(posicion),"O");
			mostrarGato(gato);
			terminado = esGanador(j2, gato,"O");
			}
			}	
		}while(!terminado);
	}
	public static void llenarInicio(String gato[][]) {
		int contador = 1;	
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
			gato[i][j] = String.valueOf(contador);
			contador++;
			}
		}
	}
	public static void mostrarGato(String gato[][]) {
		System.out.println ("***************************************************************");
		System.out.println("\n"+gato[0][0] + " | " + gato[0][1] + " | " + gato[0][2]+ "\n"
		          + "---------\n" 
		          + gato[1][0] + " | " + gato[1][1] + " | " + gato[1][2] + "\n"
		          +	"---------\n"  
		          + gato[2][0] + " | " + gato[2][1] + " | " + gato[2][2]+"\n");
	}
	public static void llenarPosicion(String matrizGato[][], int posicion, String figura) {
		switch(posicion){
		case 1: matrizGato[0][0]=figura; break;
		case 2: matrizGato[0][1]=figura; break;
		case 3: matrizGato[0][2]=figura; break;
		case 4: matrizGato[1][0]=figura; break;
		case 5: matrizGato[1][1]=figura; break;
		case 6: matrizGato[1][2]=figura; break;
		case 7: matrizGato[2][0]=figura; break;
		case 8: matrizGato[2][1]=figura; break;
		case 9: matrizGato[2][2]=figura; break;
		}
	}
	
	public static boolean esGanador(String jugador, String gato[][],String figura) {
		boolean gano = false;
		if (gato[0][0].equals(figura) && gato[0][1].equals(figura) && gato[0][2].equals(figura)) {
			gano = true;
		}
		if (gato[1][0].equals(figura) && gato[1][1].equals(figura) && gato[1][2].equals(figura)) {
			gano = true;
		}
		if (gato[2][0].equals(figura) && gato[2][1].equals(figura) && gato[2][2].equals(figura)) {
			gano = true;
		}
		if (gato[0][0].equals(figura) && gato[1][0].equals(figura) && gato[2][0].equals(figura)) {
			gano = true;
		}
		if (gato[0][1].equals(figura) && gato[1][1].equals(figura) && gato[2][1].equals(figura)) {
			gano = true;
		}
		if (gato[0][2].equals(figura) && gato[1][2].equals(figura) && gato[2][2].equals(figura)) {
			gano = true;
		}
		if (gato[0][0].equals(figura) && gato[1][1].equals(figura) && gato[2][2].equals(figura)) {
			gano = true;
		}
		if (gato[0][2].equals(figura) && gato[1][1].equals(figura) && gato[2][0].equals(figura)) {
			gano = true;
		}
		if (gano) {
			System.out.println(jugador + " Haz ganado!");
		} else{
			if(esEmpate(gato)) {
				gano = true;
			}
		}
	
		return gano;
	}
	
	public static boolean esEmpate(String matriz[][]) {
		int contador = 0;
		for(int i=0; i<3; i++) {
			for (int j =0 ; j<3; j++) {
				if(matriz[i][j].equals("X") || matriz[i][j].equals("O"))  {
					contador++;
				}
			}
		}
		if(contador==9) {
			System.out.println("Hay un empate");
			return true;
		}else {
			return false;
		}
	}
}
