
public class Mano {

	private CartaModificadora[] cartasMano;
	private int numCartas;

	public Mano() {
		numCartas = 0;
		cartasMano = new CartaModificadora[5];
	}
	// Quitar Carta es poner una carta en la mesa

	public CartaModificadora quitarCarta(int i) {
		CartaModificadora toret = cartasMano[i - 1];
		cartasMano[i - 1]=cartasMano[numCartas-1];
		
		cartasMano[numCartas - 1] = null;
		numCartas--;
		return toret;

	}

	// Añadir carta es robar una carta del mazo y ponerla en la mano
	public void añadirCarta(CartaModificadora cartaRetirada) {
		cartasMano[numCartas] = cartaRetirada;
		numCartas++;

	}

	public CartaModificadora[] getCartasMano() {
		return cartasMano;
	}

	public void setCartasMano(CartaModificadora[] cartasMano) {
		this.cartasMano = cartasMano;
	}
	public int getNumCartas(){
		return numCartas;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numCartas; i++) {
			sb.append(i+1+")");
			sb.append(cartasMano[i].toString());
			if (i != numCartas - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}



}