import java.util.Random;

public class Utils {

	// Variables globales
	public static final int BICYCLE = 1;
	public static final int TANDEM = 2;

	// Metodos
	private static final int plainTerrain = 0;
	private static final int ascendTerrain = 1;
	private static final int descendTerrain = 2;
	private static final int rugorTerrain = 3;
	/** Construye una pista randomizada
	*
	* @param longitud longitud de la pista a construir
	* @return la pista construida;
	*/
	public static String buildTrack(int longitud) {
		Random rand = new Random();
		String track = "";
		while ((longitud--) != 1) {
			int tipo = rand.nextInt(4);
			switch (tipo) {
				case plainTerrain:
					track += "-";
					break;
				case ascendTerrain:
					track += "/";
					break;
				case descendTerrain:
					track += "\\";
					break;
				case rugorTerrain:
					track += "#";
					break;
				default:
					break;
			}
		}
		return track + "!";
	}

	// Mensajes
	public static String welcome = "Bienvenido a BikeGame! \n" +
		"por favor, escoja con el numero indicado el vehiculo " +
		"de su preferencia: \n" +
		"1. Bicicleta\n" +
		"2. Tandem\n" + 
		"Escriba \"q\" para salir.";

	public static String tryAgain = "Por favor, intente de nuevo";


	// Mensajes de errores

	public static String InitParamsErr = "Error al obtener los datos de entrada: ";
	public static String InitParamsWrongData = "Datos insuficientes, se " +
			"requiere un numero de jugadores y la longitud de la pista.";
	public static String InitParamsWrongFormat = "Los datos no son enteros";
}