package kernel;

public class CalculadoraPrecios {
	//Este metodo ademas de el numero de dias debera recibir el precio por noche
	public static double ValorReserva (long dias, double valorNoche) {
		double precio = dias*valorNoche;
		return precio;
	}
	public static double ValorServicio1 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = 12;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	public static double ValorServicio2 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = 15;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	public static double ValorServicio3 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = 17;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
}
