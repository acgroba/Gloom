public class CartaModificadora {

   
    private int puntosAlto;
    private int puntosMedio;
    private int puntosBajo;
    private boolean esMuerte;

    public CartaModificadora(boolean esMuerte, int puntosAlto, int puntosMedio, int puntosBajo) {
        this.esMuerte = esMuerte;
        this.puntosAlto = puntosAlto;
        this.puntosMedio = puntosMedio;
        this.puntosBajo = puntosBajo;
    }


    public int getPuntosAlto() {
        return puntosAlto;
    }

    public void setPuntosAlto(int puntosAlto) {
        this.puntosAlto = puntosAlto;
    }

    public int getPuntosMedio() {
        return puntosMedio;
    }

    public void setPuntosMedio(int puntosMedio) {
        this.puntosMedio = puntosMedio;
    }

    public int getPuntosBajo() {
        return puntosBajo;
    }

    public void setPuntosBajo(int puntosBajo) {
        this.puntosBajo = puntosBajo;
    }

    public boolean isEsMuerte() {
        return esMuerte;
    }

    public void setEsMuerte(boolean esMuerte) {
        this.esMuerte = esMuerte;
    }

	
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (isEsMuerte()){
        	sb.append("MUERTE ");
        }
        sb.append("[P.A: ");
        sb.append(this.getPuntosAlto());
        sb.append(" P.M: ");
        sb.append(this.getPuntosMedio());
        sb.append(" P.B: ");
        sb.append(this.getPuntosBajo());
        sb.append("] ");
        return sb.toString();

    }

}
