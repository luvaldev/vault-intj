import java.util.Random;

public class Player {
  //Part 1
  private CustomQueue<Song> colaSongs;
  private CustomLinkedList<Song> listSongs;

  public Player(){
    colaSongs = new CustomQueue<>();
    listSongs = new CustomLinkedList<>();
  }

  public void agregarCancionCola(Song cancion){
    colaSongs.agregar(cancion);
  }

  public void quitarCancionCola(Song cancion){
    listSongs.quitar(cancion);
  }

  //Part 2
  public void reproducirColaEnOrden(Playlist playlist){
    CustomQueue<Song> colaTemp = new CustomQueue<>();
    colaTemp.agregar(colaSongs.obtenerPrimero());
    colaSongs.quitar();

    while (!colaTemp.estaVacia()) {
      Song cancion = colaTemp.obtenerPrimero();
      System.out.println("Reproduciendo: " + cancion.getNombre() + " de " + cancion.getArtista());
      colaTemp.quitar();
    }
  }

  public void reproducirPlaylistEnOrden(Playlist playlist){
    CustomLinkedList<Song> listaTemp = playlist.getCanciones();
    listaTemp.mostrar();
  }

  //Part 3
  public void reproducirPlaylistEnOrden(CustomQueue<Song> cola) {
    CustomQueue<Song> colaTemp = new CustomQueue<>();
    while (!cola.estaVacia()) {
      Song cancion = cola.obtenerPrimero();
      System.out.println("Reproduciendo: " + cancion.getNombre() + " de " + cancion.getArtista());
      colaTemp.agregar(cancion);
      cola.quitar();
    }
    while (!colaTemp.estaVacia()) {
      cola.agregar(colaTemp.obtenerPrimero());
      colaTemp.quitar();
    }
  }

  public void reproducirAleatoriamente(Playlist playlist){
    CustomLinkedList<Song> listaTemp = playlist.getCanciones();
    Random random = new Random();

    while (!listaTemp.estaVacia()) {
      int index = random.nextInt(listaTemp.tamano());
      Song cancion = listaTemp.obtener(index);
      listaTemp.remover(index);
      System.out.println("Reproduciendo: " + cancion.getNombre() + " de " + cancion.getArtista());
    }
  }
  // ----- Part 4
  public void reproducirIntercaladoAleatorio(Playlist playlist1, Playlist playlist2){
    Random random = new Random();

    while (!playlist1.getCanciones().estaVacia() || !playlist2.getCanciones().estaVacia()) {
      // Escogemos aleatoriamente una de las dos playlists
      Playlist playlistAleatoria = random.nextBoolean() ? playlist1 : playlist2;
      CustomLinkedList<Song> listaCanciones = playlistAleatoria.getCanciones();
      CustomQueue<Song> colaPlaylistAleatoria = new CustomQueue<>();

      while (!listaCanciones.estaVacia()) {
        colaPlaylistAleatoria.agregar(listaCanciones.poll());
      }

      if (!colaPlaylistAleatoria.estaVacia()) {
        int pos = random.nextInt(colaPlaylistAleatoria.tamano());
        Song cancion = null;
        // Recorremos la cola hasta llegar a la posición aleatoria
        for (int i = 0; i < pos; i++) {
          cancion = colaPlaylistAleatoria.poll();
          colaPlaylistAleatoria.agregar(cancion);
        }
        colaPlaylistAleatoria.quitar();
        System.out.println("Reproduciendo: " + cancion.getNombre() + " de " + cancion.getArtista());
      }
    }
  }
}
