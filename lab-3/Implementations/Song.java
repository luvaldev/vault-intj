package Implementations;

public class Song {
  public int id;
  public String name;
  public int duration; // in seconds

  public Song(String name, int duration) {
    this.name = name;
    this.duration = duration;
  }

  public int getId() {return id;}
  public String getName() {return name;}
  public int getDuration() {return duration;}
}
