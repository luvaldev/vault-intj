public class Main {
  public static void main(String[] args) {
    // Crear algunas canciones
    Song cancion1 = new Song("Canción 1", "Artista 1", "Álbum 1", 180);
    Song cancion2 = new Song("Canción 2", "Artista 2", "Álbum 2", 210);
    Song cancion3 = new Song("Canción 3", "Artista 3", "Álbum 3", 195);

    // Crear una lista de reproducción
    Playlist playlist1 = new Playlist("Mis Favoritas");
    playlist1.agregarCancionPlaylist(cancion1);
    playlist1.agregarCancionPlaylist(cancion2);
    playlist1.agregarCancionPlaylist(cancion3);

    // Crear un reproductor
    Player reproductor = new Player();

    // Agregar canciones al reproductor
    reproductor.agregarCancionCola(cancion1);
    reproductor.agregarCancionCola(cancion2);
    reproductor.agregarCancionCola(cancion3);

    // Reproducir la cola en orden
    System.out.println("Reproduciendo la cola en orden:");
    reproductor.reproducirColaEnOrden(playlist1);

    // Reproducir la playlist en orden
    System.out.println("\nReproduciendo la playlist en orden:");
    reproductor.reproducirPlaylistEnOrden(playlist1);

    // Reproducir aleatoriamente la playlist
    System.out.println("\nReproduciendo la playlist aleatoriamente:");
    reproductor.reproducirAleatoriamente(playlist1);

    // Reproducir canciones de dos playlists de manera intercalada aleatoria
    Playlist playlist2 = new Playlist("Otra Playlist");
    playlist2.agregarCancionPlaylist(new Song("Canción A", "Artista A", "Álbum A", 240));
    playlist2.agregarCancionPlaylist(new Song("Canción B", "Artista B", "Álbum B", 180));
    System.out.println("\nReproduciendo intercaladamente canciones de dos playlists aleatoriamente:");
    reproductor.reproducirIntercaladoAleatorio(playlist1, playlist2);
  }
}