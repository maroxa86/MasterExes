package hipodromo;

public class CHipodromo {

	public static void main(String[] args){
		String nombreCaballo;
		final int numeroParticipantes = 5;
		
		Tablon tablon = new Tablon(numeroParticipantes);
		Caballo[] caballos = new Caballo[numeroParticipantes];
		Marcador marcador = new Marcador(tablon);
		
		marcador.start();
		
		for(int i = 0; i < numeroParticipantes; i++){
			nombreCaballo = new String("Caballo " + i);
			caballos[i] = new Caballo(i, nombreCaballo, tablon);
			caballos[i].start();
		}
	}
}
