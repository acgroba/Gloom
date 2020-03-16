
public class Jugador {

	private String nombre;
	private Mano cartasMano;
	private Familia cartasMesa;

	public Jugador(String nombre, Familia cartasMesa) {
		this.nombre = nombre;
		this.cartasMano = new Mano();
		this.cartasMesa = cartasMesa;
	}

	public void ponerCartaEnPersonaje(CartaPersonaje personaje, CartaModificadora mod) {
			personaje.añadirModificadora(mod);
			//la puntuación -1 significa 0 y la puntución 0 significa puntuación vacía
		if (mod.getPuntosBajo() == -1) {
			personaje.setPuntuacionBaja(0);
		} else {
			personaje.setPuntuacionBaja(mod.getPuntosBajo());
		}
		if (mod.getPuntosMedio() == -1) {
			personaje.setPuntuacionMedia(0);
		} else {
			personaje.setPuntuacionMedia(mod.getPuntosMedio());
		}
		if (mod.getPuntosAlto() == -1) {
			personaje.setPuntuacionAlta(0);
		} else {
			personaje.setPuntuacionAlta(mod.getPuntosAlto());
		}
		if (mod.isEsMuerte()){
			personaje.setEstaMuerta(true);
		}
		
	}

	public Mano getCartasMano() {
		return cartasMano;
	}
	public Familia getCartasMesa() {
		return cartasMesa;
	}
	public String getNombre(){
		return nombre;
	}
	public void cogerCartaParaLaMano(CartaModificadora carta) {
		
		cartasMano.añadirCarta(carta);
	}

}
