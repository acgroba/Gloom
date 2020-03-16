
public class FamiliasDelJuego {
	
	 static CartaPersonaje [][] familias = {
			  {new CartaPersonaje("Pulgarcita"), new CartaPersonaje("Señor Risas"), new CartaPersonaje("Elissandre"),new CartaPersonaje("Darius"),new CartaPersonaje("Samson")}, 
			  {new CartaPersonaje("Los gemelos"), new CartaPersonaje("Goody Zarr"), new CartaPersonaje("Butterfield"), new CartaPersonaje("Lola"), new CartaPersonaje("Lord")},
			  {new CartaPersonaje("Angel"), new CartaPersonaje("Balthazar"), new CartaPersonaje("Willen"), new CartaPersonaje("Primo"), new CartaPersonaje("Dam")}, 
			  {new CartaPersonaje("Grogar"), new CartaPersonaje("Melisa"), new CartaPersonaje("Helena"), new CartaPersonaje("Slogar"), new CartaPersonaje("Elias")}
			  };
	
	public static Familia getFamilia(int i)
	{
		return new Familia(familias[i-1]);
	}
	
	

}
