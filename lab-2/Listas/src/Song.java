public class Song{
  private String nombre;
  private String artista;
  private String album;
  private int duracion;

  public Song(String nombre, String artista, String album, int duracion){
    this.nombre = nombre;
    this.artista = artista;
    this.album = album;
    this.duracion = duracion;
  }

  public String getNombre(){
    return nombre;
  }

  public String getArtista(){
    return artista;
  }

  public String getAlbum(){
    return album;
  }

  public int getDuracion(){
    return duracion;
  }
}