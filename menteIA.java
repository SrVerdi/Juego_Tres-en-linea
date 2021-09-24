package Juego;


	public class menteIA {
		public String jugadaIA(String gato[][], String figura) {
			String posicion = "0";
			//Fila 1
			if ( !estoyLleno(gato,1) && gato[0][1].equals(figura) && gato[0][2].equals(figura)) {
				posicion = "1";
			}
			if (gato[0][0].equals(figura) && !estoyLleno(gato,2) && gato[0][2].equals(figura)) {
				posicion = "2";
			}
			if (gato[0][0].equals(figura) && gato[0][1].equals(figura) && !estoyLleno(gato,3)) {
				posicion = "3";
			}
			
			//Fila 2
			
			if (!estoyLleno(gato,4) && gato[1][1].equals(figura) && gato[1][2].equals(figura)) {
				posicion = "4";
			}
			if (gato[1][0].equals(figura) && !estoyLleno(gato,5) && gato[1][2].equals(figura)) {
				posicion = "5";
			}
			if (gato[1][0].equals(figura) && gato[1][1].equals(figura) && !estoyLleno(gato,6)) {
				posicion = "6";
			}
			
			
			//Fila 3
			if (!estoyLleno(gato,7) && gato[2][1].equals(figura) && gato[2][2].equals(figura)) {
				posicion = "7";
			}
			if (gato[2][0].equals(figura) && !estoyLleno(gato,8) && gato[2][2].equals(figura)) {
				posicion = "8";
			}
			if (gato[2][0].equals(figura) && gato[2][1].equals(figura) && !estoyLleno(gato,9)) {
				posicion = "9";
			}
			//Columna 1
			
			if (!estoyLleno(gato,1) && gato[1][0].equals(figura) && gato[2][0].equals(figura)) {
				posicion = "1";
			}
			if (gato[0][0].equals(figura) && !estoyLleno(gato,4) && gato[2][0].equals(figura)) {
				posicion = "4";
			}
			if (gato[0][0].equals(figura) && gato[1][0].equals(figura) && !estoyLleno(gato,7)) {
				posicion = "7";
			}
			
			//COLUMNA 2
			if (!estoyLleno(gato,2)  && gato[1][1].equals(figura) && gato[2][1].equals(figura)) {
				posicion = "2";
			}
			if (gato[0][1].equals(figura) && !estoyLleno(gato,5) && gato[2][1].equals(figura)) {
				posicion = "5";
			}
			if (gato[0][1].equals(figura) && gato[1][1].equals(figura) && !estoyLleno(gato,8)) {
				posicion = "8";
			}
			
			//COLUMNA 3
			if (!estoyLleno(gato,3) && gato[1][2].equals(figura) && gato[2][2].equals(figura)) {
				posicion = "3";
			}
			if (gato[0][2].equals(figura) &&!estoyLleno(gato,6) && gato[2][2].equals(figura)) {
				posicion = "6";
			}
			if (gato[0][2].equals(figura) && gato[1][2].equals(figura) && !estoyLleno(gato,9)) {
				posicion = "9";
			}
			// Diagonal 1
			if (!estoyLleno(gato,1) && gato[1][1].equals(figura) && gato[2][2].equals(figura)) {
				posicion = "1";
			}
			if (gato[0][0].equals(figura) && !estoyLleno(gato,5) && gato[2][2].equals(figura)) {
				posicion = "5";
			}
			if (gato[0][0].equals(figura) && gato[1][1].equals(figura) &&!estoyLleno(gato,9)) {
				posicion = "9";
			}
			// Diagonal 2
			if (!estoyLleno(gato,3) && gato[1][1].equals(figura) && gato[2][0].equals(figura)) {
				posicion = "3";
			}
			if (gato[0][2].equals(figura) && !estoyLleno(gato,5) && gato[2][0].equals(figura)) {
				posicion = "5";
			}
			if (gato[0][2].equals(figura) && gato[1][1].equals(figura) && !estoyLleno(gato,7)) {
				posicion = "7";
			}
			return posicion;
		}
		
		public boolean estoyLleno(String matrizGato[][], int posicion) {

			boolean toyLleno = false;
			switch(posicion){
			case 1:
				if(matrizGato[0][0].equals("X") || matrizGato[0][0].equals("O")){
					toyLleno = true;
				} break;
			case 2: 
				if(matrizGato[0][1].equals("X") || matrizGato[0][1].equals("O")){
					toyLleno = true;
				} break;
			case 3:
				if(matrizGato[0][2].equals("X") || matrizGato[0][2].equals("O")){
					toyLleno = true;
				} break;
			case 4: 
				if(matrizGato[1][0].equals("X") || matrizGato[1][0].equals("O")){
				toyLleno = true;
			} break;
			case 5: 
				if(matrizGato[1][1].equals("X") || matrizGato[1][1].equals("O")){
					toyLleno = true;
				} break;
			case 6: 
				if(matrizGato[1][2].equals("X") || matrizGato[1][2].equals("O")){
					toyLleno = true;
				} break;
			case 7: 
				if(matrizGato[2][0].equals("X") || matrizGato[2][0].equals("O")){
					toyLleno = true;
				} break;
			case 8: 
				if(matrizGato[2][1].equals("X") || matrizGato[2][1].equals("O")){
					toyLleno = true;
				} break;
			case 9:
				if(matrizGato[2][2].equals("X") || matrizGato[2][2].equals("O")){
					toyLleno = true;
				} break;
			}
			return toyLleno;
	}

}
