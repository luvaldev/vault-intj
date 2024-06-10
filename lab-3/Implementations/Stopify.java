package Implementations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stopify {
  LinkedList<Song> listSongs;

  public Stopify() {
    listSongs = new LinkedList<Song>();
  }

  // Add a song to the list of songs
  public void addSong(Song song) {
    listSongs.add(song);
  }

  // Create and return a new tree from the list of songs
  public Tree newTree(List<Song> songs) {
    if (songs == null || songs.isEmpty()) {
      return null;
    }
    return TreeBuilder.buildBalancedTree(songs);
  }

  // Ordenar canciones por nombre usando diferentes métodos
  public List<Song> sortByName(String method) {
    List<Song> sortedList = new LinkedList<>(listSongs);
    switch (method) {
      case "merge":
        return SortingMethods.mergeSort(sortedList, false);
      case "quick":
        return SortingMethods.quickSort(sortedList, false);
      case "insertion":
        return SortingMethods.insertionSort(sortedList, false);
      case "bubble":
        return SortingMethods.bubbleSort(sortedList, false);
      default:
        throw new IllegalArgumentException("Método de ordenamiento no soportado");
    }
  }

  // Ordenar canciones por duración usando diferentes métodos
  public List<Song> sortByDuration(String method) {
    List<Song> sortedList = new LinkedList<>(listSongs);
    switch (method) {
      case "merge":
        return SortingMethods.mergeSort(sortedList, true);
      case "quick":
        return SortingMethods.quickSort(sortedList, true);
      case "insertion":
        return SortingMethods.insertionSort(sortedList, true);
      case "bubble":
        return SortingMethods.bubbleSort(sortedList, true);
      default:
        throw new IllegalArgumentException("Método de ordenamiento no soportado");
    }
  }

  // Load songs from a CSV file
  public void loadSongsFromCSV(String fileName) {
    String filePath = "C:\\Users\\luisv\\Documentos\\Archivos_GitHub\\vault-intj\\lab-3\\Implementations\\" + fileName;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        Song song = new Song(values[1], Integer.parseInt(values[2]));
        song.id = Integer.parseInt(values[0]);
        addSong(song);
      }
      System.out.println("Loaded songs from " + filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
