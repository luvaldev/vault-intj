package Implementations;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

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

    System.out.println("");

    // Medir el tiempo de construcción del árbol balanceado
    long startBalancedTree = System.nanoTime();
    Tree balancedTree = TreeBuilder.buildBalancedTree(songs);
    long finishBalancedTree = System.nanoTime();
    System.out.println("Time to build balanced tree: " + (finishBalancedTree - startBalancedTree) + " ns.");

    // Medir el tiempo de construcción del árbol no balanceado
    long startUnbalancedTree = System.nanoTime();
    Tree unbalancedTree = TreeBuilder.buildUnbalancedTree(songs);
    long finishUnbalancedTree = System.nanoTime();
    System.out.println("Time to build unbalanced tree: " + (finishUnbalancedTree - startUnbalancedTree) + " ns.");

    System.out.println(" ");

    // Realizar consultas sobre el árbol balanceado
    System.out.println("Searching in balanced tree:");
    long startBalancedQueries = System.nanoTime();
    searchQueries(balancedTree, songs, 100);
    long finishBalancedQueries = System.nanoTime();
    System.out.println("Time to search in balanced tree: " + (finishBalancedQueries - startBalancedQueries) + " ns.");

    // Realizar consultas sobre el árbol no balanceado
    System.out.println("Searching in unbalanced tree:");
    long startUnbalancedQueries = System.nanoTime();
    searchQueries(unbalancedTree, songs, 100);
    long finishUnbalancedQueries = System.nanoTime();
    System.out.println("Time to search in unbalanced tree: " + (finishUnbalancedQueries - startUnbalancedQueries) + " ns.");
  }

  public static void searchQueries(Tree root, List<Song> songs, int numQueries) {
    // Ejemplo de consulta: buscar canciones por nombre
    for (int i = 0; i < numQueries && i < songs.size(); i++) {
      Song song = songs.get(i);
      TreeSearch.searchByName(root, song.getName());
    }
  }
}