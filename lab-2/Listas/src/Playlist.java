public class Playlist {
  private String nombre;
  private CustomLinkedList<Song> canciones;

  // Constructor
  public Playlist(String nombre) {
    this.nombre = nombre;
    canciones = new CustomLinkedList<>();
  }

  // Getters
  public String getNombre() {
    return nombre;
  }

  public CustomLinkedList<Song> getCanciones() {
    return canciones;
  }

  public void agregarCancionPlaylist(Song cancion) {
    canciones.agregar(cancion);
  }

  public void quitarCancionPlaylist(Song cancion) {
    canciones.quitar(cancion);
  }

  public void editarPlaylist(int x, int y) {
    if (x < canciones.tamano() && y < canciones.tamano()) {
      Song cancionX = canciones.obtener(x);
      Song cancionY = canciones.obtener(y);
      canciones.remover(x);
      canciones.insertar(x, cancionY);
      canciones.remover(y);
      canciones.insertar(y, cancionX);
    } else {
      System.out.println("No se puede realizar la operacion");
    }
  }
}
