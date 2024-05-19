public class Main {
  public static void main(String[] args) {
    // Crear canciones
    Song song1 = new Song("Song 1", "Artist 1", "Album 1", 210);
    Song song2 = new Song("Song 2", "Artist 2", "Album 2", 180);
    Song song3 = new Song("Song 3", "Artist 3", "Album 3", 240);

    // Crear playlist y agregar canciones
    Playlist playlist = new Playlist("Mi Playlist");
    playlist.agregarCancionPlaylist(song1);
    playlist.agregarCancionPlaylist(song2);
    playlist.agregarCancionPlaylist(song3);

    // Crear player y agregar canciones y playlist a la cola
    Player player = new Player();
    player.agregarSong(new Song("Song 4", "Artist 4", "Album 4", 200));
    player.agregarSong(song1);
    player.agregarSong(song2);
    player.agregarSong(song3);

    // Eliminar una canción específica de la cola
    System.out.println("Removing Song 2:");
    player.quitarSong(song2);

    // Reproducir aleatoriamente la playlist
    System.out.println("Playing playlist randomly:");
    Player.reproducirPlaylistAleatorio(playlist);
  }
}