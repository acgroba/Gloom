

public class Familia {
	
	private CartaPersonaje [] cartasFamilia;
        
        public Familia ( CartaPersonaje [] cartasFamilia ){
            this.cartasFamilia=cartasFamilia;
        }
        
        public CartaPersonaje [] getCartasFamilia() {
        	return cartasFamilia;
        }
        public String toString() {
    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i < 5; i++) {
    			sb.append(i+1+")");
    			sb.append(cartasFamilia[i].toString());
    			if (i != 5 - 1) {
    				sb.append(", ");
    			}
    		}
    		return sb.toString();
    	}
	
        public boolean familiaEstaMuerta(){ //devuelve verdadero cuando todas las cartas de la familia están muertas
        	
        	int i=0;
        	while (i<5 && cartasFamilia[i].getEstaMuerta()){
        		i++;
        	}
        	return i==5;
        }
        
        public int getPuntuacionFamilia(){ //devuelve la suma total de autoestima de aquellas cartas de la familia que están muertas
        	int toret=0;
        	for (int i=0;i<5;i++){
        		if (cartasFamilia[i].getEstaMuerta()){
        		toret+=cartasFamilia[i].getPuntuacionTotal();}
        	}
        	return toret;
        }
	

}
