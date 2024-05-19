import java.util.*;

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

  // Getters
  public Song[] getCanciones() {
    return canciones;
  }

  // Agregar canción a la playlist
  public void agregarCancionPlaylist(Song song) {
    if (posicion == canciones.length) {
      int nuevoTamano = canciones.length + 10;
      Song[] nuevoArreglo = new Song[nuevoTamano];
      System.arraycopy(canciones, 0, nuevoArreglo, 0, canciones.length);
      canciones = nuevoArreglo;
    }
    canciones[posicion] = song;
    posicion++;
    System.out.println("Cancion agregada a la playlist");
  }

  // Quitar canción de la playlist
  public void quitarCancionPlaylist(Song song) {
    for (int i = 0; i < posicion; i++) {
      if (canciones[i].equals(song)) {
        canciones[i] = null;
        System.out.println("Cancion eliminada de la playlist");
        break;
      } else {
        System.out.println("La cancion no existe en la playlist");
      }
    }
  }

  // Editar canción de la playlist
  public void editarPlaylist(int posX, int posY) {
    if (canciones[posX] != null && canciones[posY] != null) {
      Song temp = canciones[posX];
      canciones[posX] = canciones[posY];
      canciones[posY] = temp;
      System.out.println("Canciones intercambiadas");
    } else {
      System.out.println("No se puede intercambiar canciones");
    }
  }
}
