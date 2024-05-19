import java.util.Random;

public class Player {
  private Song[] songPlayer;
  private int posicion;

  public Player() {
    songPlayer = new Song[0];
    posicion = 0;
  }
  public void agregarSong(Song song) {
    //Aumentar el tamaño del arreglo para agregar Song
    Song nuevoArreglo[] = new Song[posicion + 1];
    System.arraycopy(songPlayer, 0, nuevoArreglo, 0, posicion);
    nuevoArreglo[posicion] = song;
    songPlayer = nuevoArreglo;
    posicion++;
  }
  public void quitarSong(Song song) {
    int pos = -1;
    //Buscar la posición de la canción
    for(int i = 0; i < posicion; i++) {
      if (songPlayer[i].equals(song)) {
        pos = i;
        break;
      }
    }
    //En caso de encontrarla
    if(pos != -1) {
      Song nuevoArreglo[] = new Song[posicion - 1];
      //Con esto copio una parte de la songPlayer a nuevoArreglo
      System.arraycopy(songPlayer, 0, nuevoArreglo, 0, pos);
      //Luego copio el resto de canciones pero sin el pos
      System.arraycopy(songPlayer, pos + 1, nuevoArreglo, pos, posicion - pos - 1);
      songPlayer = nuevoArreglo;
      posicion--;
    }
  }
  public static void reproducirPlaylistAleatorio(Playlist playlist) {
    Song songs[] = playlist.getCanciones();
    Random random = new Random();

    for(int i = 0; i < songs.length; i++) {
      int pos = random.nextInt(i + 1);
      //Intercambio de canciones
      Song aux = songs[i];
      songs[i] = songs[pos];
      songs[pos] = aux;
    }

    for(Song song: songs) {
      if(song != null) {
        System.out.println("Reproduciendo: " + song.getNombre());
      }
    }
  }
}