package Implementations;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    // Instancia de Stopify para cargar las canciones desde el archivo CSV
    Stopify stopify = new Stopify();
    // Cargar canciones desde el archivo CSV
    stopify.loadSongsFromCSV("songs.csv");
    // Obtener la lista de canciones
    List<Song> songs = stopify.listSongs;

    // Método de ordenamiento MergeSort
    List<Song> dataMergeSort = new ArrayList<>(songs);
    long start, finish;
    start = System.nanoTime();
    dataMergeSort = SortingMethods.mergeSort(dataMergeSort, false); // Ordenar por nombre
    finish = System.nanoTime();
    System.out.println("MergeSort time: " + (finish - start) + " ns.");

    // Método de ordenamiento QuickSort
    List<Song> dataQuickSort = new ArrayList<>(songs);
    start = System.nanoTime();
    dataQuickSort = SortingMethods.quickSort(dataQuickSort, false); // Ordenar por nombre
    finish = System.nanoTime();
    System.out.println("QuickSort time: " + (finish - start) + " ns.");

    // Método de ordenamiento InsertionSort
    List<Song> dataInsertionSort = new ArrayList<>(songs);
    start = System.nanoTime();
    dataInsertionSort = SortingMethods.insertionSort(dataInsertionSort, false); // Ordenar por nombre
    finish = System.nanoTime();
    System.out.println("InsertionSort time: " + (finish - start) + " ns.");

    // Método de ordenamiento BubbleSort
    List<Song> dataBubbleSort = new ArrayList<>(songs);
    start = System.nanoTime();
    dataBubbleSort = SortingMethods.bubbleSort(dataBubbleSort, false); // Ordenar por nombre
    finish = System.nanoTime();
    System.out.println("BubbleSort time: " + (finish - start) + " ns.");
  }
}
