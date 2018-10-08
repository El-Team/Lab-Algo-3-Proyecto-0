/**Clase principal del juego de la bicicleta tandem. El juego es de dos jugadores.
 */
public class Main{

	/**Almacena la cantidad de jugadores*/
	static int numJugadores;

	/**Almacena la longitud de la pista*/
	static int longPista;

	/**Pista a recorrer*/
	static String pista;

	/**Chequea que los parametros de entrada sean los requeridos
	* Inicializa las variables {@link numJugadores} y {@link longPista}.
	*
	* @param args argumentos pasados en consola
	*/
	static boolean checkParams(String[] args) {
		try {
			numJugadores = Integer.parseInt(args[0]);
			longPista = Integer.parseInt(args[1]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(Utils.InitParamsErr + Utils.InitParamsWrongData);
			return false;

		} catch (NumberFormatException e) {
			System.out.println(Utils.InitParamsErr + Utils.InitParamsWrongFormat);
			return false;
		}
		return true;
	}

	/**Fija la cadencia que est&aacute; intentando lograr el ciclista delantero
	 * de la bicicleta t&aacute;ndem <code>t</code> en <code>p</code> rpm.
	 * 
	 * @param t Bicicleta t&aacute;ndem donde est&aacute; el ciclista
	 * @param p cadencia de pedal que intenta lograr el ciclista en rpm
	 */
	static void pedalearDelante(Tandem t, int p){
		int actual = t.getCadence();
		t.changeCadence(p, actual);
	}
	
	/**Fija la cadencia que est&aacute; intentando lograr el ciclista
	 * de atr&aacute;s de la bicicleta t&aacute;ndem <code>t</code>
	 * en <code>p</code> rpm.
	 * 
	 * @param t Bicicleta t&aacute;ndem donde est&aacute; el ciclista
	 * @param p cadencia de pedal que intenta lograr el ciclista en rpm
	 */
	static void pedalearDetras(Tandem t, int p){
		int actual = t.getCadence();
		t.changeCadence(actual, p);
	}

	/**Cambia la velocidad actual de la t&aacute;ndem donde est&aacute;n
	* los ciclistas.
	*
	* @param t Bicicleta t&aacute;ndem donde est&aacute; el ciclista
	* @param v nueva velocidad de la Bicicleta
	*/
	static void cambiarVelocidad(Tandem t, int v) {
		try {
			t.changeGear(v);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	
	/**Contiene el juego como tal.*/
	public static void main(String[] args) throws java.io.IOException {
		Tandem vehicle = new Tandem();
		int ganaDelante = 0;
		int ganaDetras  = 0;
		int vehicleID;
		
		// Chequea si se pasaron los parametros de consola necesarios
		if (!checkParams(args)) return;
		
		// Pide al usuario que escoja su vehiculo
		while (true) {
			System.out.println(Utils.welcome);
			try {
				char c = (char) System.in.read();
				if (c == 'q') return;
				vehicleID = Integer.parseInt(c + "");
				assert vehicleID == Utils.BICYCLE || vehicleID == Utils.TANDEM;
				break;
			} catch (NumberFormatException e) {
				System.out.println(Utils.tryAgain);
			} catch (AssertionError e) {
				System.out.println(Utils.tryAgain);
			}
		}

		System.out.println(vehicle.manual() + 
				"Presione un numero entre 1 y 3 (seguido de \"Enter\") para cambiar la velocidad\n"+
				"Presione 'n' (seguido de \"Enter\") para salir");
		
		pista = Utils.buildTrack(longPista);
		System.out.println("\n" + "Pista:   " + pista);
		while(true){
			char c = (char)System.in.read();
			if(c=='a'){
				pedalearDelante(vehicle, vehicle.getCadence()+2);
				vehicle.printStates();
				if(vehicle.esfuerzoDelante < vehicle.esfuerzoDetras){
					ganaDetras++;
				}else{
					ganaDelante++;
				}
			}
			if(c=='l'){
				pedalearDetras(vehicle, vehicle.getCadence()+2);
				vehicle.printStates();
				if(vehicle.esfuerzoDelante < vehicle.esfuerzoDetras){
					ganaDetras++;
				}else{
					ganaDelante++;
				}
			}
			if(c=='n'){
				if(ganaDelante < ganaDetras){
					System.out.println("El ciclista de atras hizo "+
							"la mayor parte del esfuerzo en "+
							ganaDetras+" de "+(ganaDelante+ganaDetras)+
							" pedaleadas. Felicidades, ciclista de atras!");
				}else{
					System.out.println("El ciclista delantero hizo "+
							"la mayor parte del esfuerzo en "+
							ganaDelante+" de "+(ganaDelante+ganaDetras)+
							" pedaleadas. Felicidades, ciclista delantero!");
				}
				return;
			}
			else {
				try {
					int v = Integer.parseInt(Character.toString(c));
					if (v != vehicle.getGear()) {
						cambiarVelocidad(vehicle, v);	
						System.out.println("Se cambio la velocidad a " + v);
					}
				} catch (NumberFormatException e) {
					// la tecla no era un entero, no se hace nada
				}
			}
		}
	}
}
