
public class CartaPersonaje {

	private String nombre;
	
    private boolean estaMuerta;
	private int puntuacionAlta;
	private int puntuacionMedia;
	private int puntuacionBaja;
	private int numCartas;
        
        
        public CartaPersonaje (String nombre){
            this.nombre = nombre;
            estaMuerta = false;
            puntuacionAlta = 0;
            puntuacionMedia = 0;
            puntuacionBaja = 0;
            numCartas = 0;
        }
        
	private CartaModificadora[] cartaAustoestima;

	
	public String getNombre() {
		return nombre;
	}

	public void añadirCarta(){
		//
	}
	// Creamos estos gets para el toString();

	public int getPuntuacionAlta() {
		return puntuacionAlta;
	}

	public void setPuntuacionAlta(int puntuacionAlta) {
		this.puntuacionAlta = puntuacionAlta;
	}

	public int getPuntuacionMedia() {
		return puntuacionMedia;
	}

	public void setPuntuacionMedia(int puntuacionMedia) {
		this.puntuacionMedia = puntuacionMedia;
	}

	public int getPuntuacionBaja() {
		return puntuacionBaja;
	}

	public void setPuntuacionBaja(int puntuacionBaja) {
		this.puntuacionBaja = puntuacionBaja;
	}

	public int getPuntuacionTotal() {
		return this.getPuntuacionAlta() + this.getPuntuacionMedia() + this.getPuntuacionBaja();
	}
	public void añadirModificadora(CartaModificadora carta){
		this.cartaAustoestima[getNumCartas()]=carta;
	}
	public int getNumCartas(){
		return numCartas;
	}
	
	
	// Creamos este toString() en clase
	
	public void setEstaMuerta(boolean estaMuerta) {
		this.estaMuerta = estaMuerta;
	}
	public boolean getEstaMuerta(){
		return estaMuerta;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[Carta:");
		sb.append(this.getNombre());
	        sb.append(" P.A:");
	        sb.append(this.getPuntuacionAlta());
	        sb.append(" P.M:");
	        sb.append(this.getPuntuacionMedia());
	        sb.append(" P.B:");
	        sb.append(this.getPuntuacionBaja());
	        sb.append("] ");
	        if (getEstaMuerta()){ //añadimos esta cláusula a quellas cartas sobre las que se ha usado una carta de muerte
	        	sb.append("MUERTA");
	        }
	        
	        return sb.toString();
	}
}
