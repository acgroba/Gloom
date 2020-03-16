
import java.util.Scanner;

public class Principal {
//creamos jugador y llenamos su mano
	public static void crearJugador(String nombre, int familia, Mazo mazo, Jugador[] jugadores, int numJug) {

		jugadores[numJug] = new Jugador(nombre, FamiliasDelJuego.getFamilia(familia));
		for (int i = 0; i < 5; i++) {
			jugadores[numJug].cogerCartaParaLaMano(mazo.retirarCarta());
		}
	}
//mostramos las cartas de la familia de cada jugador
	public static void mostrarMesa(int numJugadores, Jugador[] jugadores) {
		System.out.println("================MESA================");
		for (int j = 0; j < numJugadores; j++) {
			System.out.println("Familia del Jugador" + " " + (j + 1));
			System.out.println(jugadores[j].getCartasMesa().toString());
			System.out.println("====================================");
		}

	}
//mostramos las cartas de la mano del jugador jug
	public static void mostrarCartas(int jug, Jugador[] jugadores) {
		System.out.println("===========CARTAS DE" + " " + jugadores[jug - 1].getNombre() + "===========");

		System.out.println(jugadores[jug - 1].getCartasMano().toString());
		System.out.println("====================================");
	}
//actualiza la puntuación de la carta Objetivo según los puntos de la cartaMano y nos dice si tras usarla toda la familia está muerta
	public static boolean usarCarta(CartaModificadora cartaMano, CartaPersonaje cartaObjetivo, Jugador[] jugadores,
			int jugadorObjetivo) {
		boolean toret = false;
		if (cartaMano.getPuntosAlto() != -1 && cartaMano.getPuntosAlto() != 0) {
			cartaObjetivo.setPuntuacionAlta(cartaMano.getPuntosAlto());
		} else if (cartaMano.getPuntosAlto() == -1) {
			cartaObjetivo.setPuntuacionAlta(0);
		}
		if (cartaMano.getPuntosMedio() != -1 && cartaMano.getPuntosMedio() != 0) {
			cartaObjetivo.setPuntuacionMedia(cartaMano.getPuntosMedio());
		} else if (cartaMano.getPuntosMedio() == -1) {
			cartaObjetivo.setPuntuacionMedia(0);
		}
		if (cartaMano.getPuntosBajo() != -1 && cartaMano.getPuntosBajo() != 0) {
			cartaObjetivo.setPuntuacionBaja(cartaMano.getPuntosBajo());
		} else if (cartaMano.getPuntosBajo() == -1) {
			cartaObjetivo.setPuntuacionBaja(0);
		}

		if (cartaMano.isEsMuerte()) {
			cartaObjetivo.setEstaMuerta(true);
			if (jugadores[jugadorObjetivo - 1].getCartasMesa().familiaEstaMuerta()) {
				toret = true;
			}
		}
		return toret;
	}

	// *********************************************************

	

	public static void main(String[] args) {

		Mazo mazo = new Mazo();
		Scanner sc = new Scanner(System.in);
		int numJugadores;
//pedimos número de jugadores
		do {
			System.out.println("Introduzca número de jugadores: ");
			numJugadores = Integer.parseInt(sc.nextLine());

			if (numJugadores < 2 || numJugadores > 4) {
				System.out.println("El número de jugadores ha de estar comprendido entre 2 y 4");
			}
		} while (numJugadores < 2 || numJugadores > 4);

		// Creamos el array de jugadores
		Jugador[] jugadores = new Jugador[numJugadores];
		// Array de Booleans para saber que familias estan escogidas
		boolean[] familiasEscogidas = new boolean[4];
		//creamos los jugadores con los datos de entrada
		for (int i = 0; i < numJugadores; i++) {

			System.out.println("Introduzca el nombre del jugador " + (i + 1));
			String nombreJugador = sc.nextLine();
			int numFamilia;

			do {
				System.out.println("Escoja una familia:");
				System.out.println("Dark’s Den of Deformity (1), Hemlock Hall (2)");
				System.out.println("Blackwater Watch (3), Castle Slogar (4)");

				numFamilia = Integer.parseInt(sc.nextLine());
				if (numFamilia < 1 || numFamilia > 4) {
					System.out.println("Familia incorrecta");
					// Ej: Familia 1 esta escogida [0]==true. Si eliges 1-> 1-1
					// --> [0] Familia Escogida
				} else if (familiasEscogidas[numFamilia - 1]) {
					System.out.print("Familia ya escogida. ");
				}
			} while (numFamilia < 1 || numFamilia > 4 || familiasEscogidas[numFamilia - 1]);

			crearJugador(nombreJugador, numFamilia, mazo, jugadores, i);
			familiasEscogidas[numFamilia - 1] = true;

		}

		// comienza el juego
		boolean familiaMuerta = false; // nos indica si alguien tiene toda su
										// familia muerta
		int jug = 1; //empieza el jugador 1

		do {

			String resp = "";
			int cartaMano = 0;
			int jugObjetivo = 0;
			int cartaObjetivo = 0;
			mostrarMesa(numJugadores, jugadores);
			mostrarCartas(jug, jugadores);

			System.out.println("Primera jugada del jugador" + jug + ": ");
			do {
				System.out.println(jugadores[jug - 1].getNombre() + ", ¿quieres pasar?(S/N)");
				resp = sc.next();

				if (!resp.equals("S") && !resp.equals("N") && !resp.equals("s") && !resp.equals("n")) {
					System.out.println("Respuesta errónea");
				}
			} while (!resp.equals("S") && !resp.equals("N") && !resp.equals("s") && !resp.equals("n"));

			if (resp.equals("N") || resp.equals("n")) {
				do {
					System.out.println("¿Qué carta de tu mano quieres usar?"); //escoge carta de su mano
					cartaMano = sc.nextInt();
					if (cartaMano < 1 || cartaMano > jugadores[jug - 1].getCartasMano().getCartasMano().length) {
						System.out.println("Carta incorrecta, escoja de nuevo");
					}
				} while (cartaMano < 1 || cartaMano > jugadores[jug - 1].getCartasMano().getCartasMano().length);

				do {
					System.out.println("¿Sobre las cartas de qué jugador quieres usar esa carta?"); //escoge jugador sobre el que usar la carta
					jugObjetivo = sc.nextInt();
					if (jugObjetivo < 1 || jugObjetivo > numJugadores) {
						System.out.println("Ese jugador no existe, introduzca de nuevo");
					}
				} while (jugObjetivo < 1 || jugObjetivo > numJugadores);

				do {
					System.out.println("¿Sobre qué carta de ese jugador la quieres usar?");//escoge carta sobre la que se va a usar
					cartaObjetivo = sc.nextInt();
					if (cartaObjetivo < 1 || cartaObjetivo > 5
							|| jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1]
									.getEstaMuerta()) {
						System.out.println("Carta errónea, introduzca de nuevo");
					}
				} while (cartaObjetivo < 1 || cartaObjetivo > 5
						|| jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1]
								.getEstaMuerta());

				familiaMuerta = usarCarta(jugadores[jug - 1].getCartasMano().quitarCarta(cartaMano),
						jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1], jugadores,
						jugObjetivo); //finalmente usa la carta

				mostrarMesa(numJugadores, jugadores);

				if (!familiaMuerta) { //si no ha muerto ninguna familia completa en la primera jugada pasamos a la segunda mostrando de nuevo la mano de jug
					mostrarCartas(jug, jugadores);

					System.out.println("Segunda jugada del jugador" + jug + ": ");

					do {

						System.out.println(jugadores[jug - 1].getNombre() + ", ¿quieres pasar?(S/N)");
						resp = sc.next();

						if (!resp.equals("S") && !resp.equals("N") && !resp.equals("s") && !resp.equals("n")) {
							System.out.println("Respuesta errónea");

						}
					} while (!resp.equals("S") && !resp.equals("N") && !resp.equals("s") && !resp.equals("n"));

					if (resp.equals("N") || resp.equals("n")) {

						do {
							//introducimos la opción 0 para pasar en caso de que el jugador solo tenga cartas de muerte
							System.out.println("¿Qué carta de tu mano quieres usar? (Introduce 0 para pasar)");
							cartaMano = sc.nextInt();
							if(cartaMano==0){
								System.out.println("Turno pasado");
							}
							else if (cartaMano < 1
									|| cartaMano > jugadores[jug - 1].getCartasMano().getNumCartas()) {
								System.out.println("Carta incorrecta, escoja de nuevo");
							} else if (jugadores[jug - 1].getCartasMano().getCartasMano()[cartaMano - 1].isEsMuerte()) {
								System.out.println("No se pueden usar cartas de muerte en la segunda jugada.");
							}

						} while (cartaMano < 0 || cartaMano > jugadores[jug - 1].getCartasMano().getNumCartas()
								||(cartaMano>=1 && jugadores[jug - 1].getCartasMano().getCartasMano()[cartaMano - 1].isEsMuerte()));
						if(cartaMano!=0){
						do {
							System.out.println("¿Sobre las cartas de qué jugador quieres usar esa carta?");
							jugObjetivo = sc.nextInt();
							if (jugObjetivo < 1 || jugObjetivo > numJugadores) {
								System.out.println("Ese jugador no existe, introduzca de nuevo");
							}
						} while (jugObjetivo < 1 || jugObjetivo > numJugadores);

						do {
							System.out.println("¿Sobre qué carta de ese jugador la quieres usar?");
							cartaObjetivo = sc.nextInt();
							if (cartaObjetivo < 1 || cartaObjetivo > 5
									|| jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1]
											.getEstaMuerta()) {
								System.out.println("Carta errónea, introduzca de nuevo");
							}
						} while (cartaObjetivo < 1 || cartaObjetivo > 5
								|| jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1]
										.getEstaMuerta());

						usarCarta(jugadores[jug - 1].getCartasMano().quitarCarta(cartaMano),
								jugadores[jugObjetivo - 1].getCartasMesa().getCartasFamilia()[cartaObjetivo - 1],
								jugadores, jugObjetivo);
						}
					}

				}

				while (jugadores[jug - 1].getCartasMano().getNumCartas() < 5) { //al terminar una jugada o ambas se rellena la mano
					jugadores[jug - 1].getCartasMano().añadirCarta(mazo.retirarCarta());
				}

			}
			System.out.println("Fin de la jugada del jugador" + jug);
			jug++;
			if (jug > numJugadores) {
				jug = 1;
			}

		} while (!familiaMuerta && Mazo.getNumCartas()!=0); //el juego termina cuando toda una familia está muerta o no quedan cartas en el mazo
		
		if(Mazo.getNumCartas()==0){
			System.out.println("Mazo sin cartas");
		}//mostramos puntuaciones y ganador
		System.out.println("FIN DEL JUEGO");
		int menor = Integer.MAX_VALUE;
		int ganador = -1;
		for (int i = 0; i < numJugadores; i++) {
			System.out.println(
					"Autoestima jugador " + (i + 1) + ": " + jugadores[i].getCartasMesa().getPuntuacionFamilia());
			if (jugadores[i].getCartasMesa().getPuntuacionFamilia() < menor) {
				menor = jugadores[i].getCartasMesa().getPuntuacionFamilia();
				ganador = i;
			}
		}
		System.out.println("GANADOR: " + jugadores[ganador].getNombre()); //en caso de empate el ganador es el jugador que comenzó primero
		System.out.println("¡Felicidades!");
	}
}
