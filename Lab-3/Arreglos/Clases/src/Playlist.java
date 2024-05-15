public class Playlist {
  private String nombre;
  private Song[] canciones; //Declaro un arreglo indefinido
  private int posicion;
  private final int numCancionesMax = 10;

  // Constructor
  public Playlist(String nombre) {
    this.nombre = nombre;
    this.canciones = new Song[numCancionesMax]; //Declaro el tamaño de la playlist
    this.posicion = 0;
  }

  // Agregar canción a la playlist
  public void agregarCancionPlaylist(Song x) {
    if (posicion == canciones.length) {
      int nuevoTamano = canciones.length + 10;
      Song[] nuevoArreglo = new Song[nuevoTamano];
      System.arraycopy(canciones, 0, nuevoArreglo, 0, canciones.length);
      canciones = nuevoArreglo;
    }
    canciones[posicion] = x;
    posicion++;
    System.out.println("Canción agregada a la playlist");
  }

  // Quitar canción de la playlist
  public void quitarCancionPlaylist(Song x) {
    for (int i = 0; i < posicion; i++) {
      if (canciones[i].equals(x)) {
        canciones[i] = null;
        System.out.println("Canción eliminada de la playlist");
        break;
      } else {
        System.out.println("La canción no existe en la playlist");
      }
    }
  }

  // Editar canción de la playlist
  public void editarPlaylist(int x, int y) {
    if (canciones[x] != null && canciones[y] != null) {
      Song temp = canciones[x];
      canciones[x] = canciones[y];
      canciones[y] = temp;
      System.out.println("Canciones intercambiadas");
    } else {
      System.out.println("No se puede intercambiar canciones");
    }
  }
}
