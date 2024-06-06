import java.util.*;
import java.io.*;

public class lab3 {
public static void main(String[] args) {
Random rnd = new Random();
StringBuilder sb = new StringBuilder();
// Constants
int songQty = 10000000; // 1 million
int queryQty = songQty / 10; // 10% of songQty
int songNameLenght = 20;
char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
List<Character> input = new ArrayList<>();
for(char c : alphabet) input.add(c);
ArrayList<String> songs = new ArrayList<>();
for(int i = 0; i < songQty; i++){
// Name
Collections.shuffle(input);
for (Character c : input) sb.append(c);
String songName = sb.toString().substring(0, songNameLenght); // Length
= 20 chars
// Duration in seconds (between 100 and 10000)
int duration = 100 + rnd.nextInt(10000);
// Output: id,name,duration
songs.add(i + "," + songName + "," + String.valueOf(duration));
// Reset StringBuilder to re-use
sb.delete(0, sb.length());
}
// Queries Per Name
ArrayList<String> aux = new ArrayList<>(songs);
Collections.shuffle(aux);
ArrayList<String> queriesPerName = new ArrayList<>(aux.subList(0,
queryQty));
// Queries Per Duration
ArrayList<String> queriesPerDuration = new ArrayList<>();
for(int i = 0; i < queryQty; i++) {
int duration = 100 + rnd.nextInt(10000);
queriesPerDuration.add(String.valueOf(duration));
}
// Dump to CSV from ArrayList
arrayListToCSV(songs, "songs");
arrayListToCSV(queriesPerName, "queriesPerName");
arrayListToCSV(queriesPerDuration, "queriesPerDuration");
}
public static void arrayListToCSV(ArrayList<String> list, String fileName) {
try (FileWriter writer = new FileWriter(fileName + ".csv")) {
for (String line : list) {
writer.write(line + "\n");
}
System.out.println("CSV file " + fileName + " created.");
} catch (IOException e) {
e.printStackTrace();
}
}
}



//----------------------------------------------------------
// Uso de un árbol binario de búsqueda para organizar y buscar canciones por ID

// 1. Clase Song:
//    - Define una clase para representar las canciones, con campos que contienen la información relevante de cada canción, como ID, nombre y duración.

// class Song {
//     int id;
//     String name;
//     int duration;

//     public Song(int id, String name, int duration) {
//         this.id = id;
//         this.name = name;
//         this.duration = duration;
//     }
// }

// 2. Clase TreeNode:
//    - Crea una clase para representar un nodo del árbol. Cada nodo contendrá un objeto de canción y referencias a sus nodos hijo izquierdo y derecho.

// class TreeNode {
//     Song song;
//     TreeNode left;
//     TreeNode right;

//     public TreeNode(Song song) {
//         this.song = song;
//         this.left = null;
//         this.right = null;
//     }
// }

// 3. Clase SongBinarySearchTree:
//    - Define una clase para el árbol binario de búsqueda, que contiene operaciones para insertar, buscar y eliminar canciones.

// class SongBinarySearchTree {
//     TreeNode root;

//     public SongBinarySearchTree() {
//         root = null;
//     }

//     public void insert(Song song) {
//         root = insertRec(root, song);
//     }

//     private TreeNode insertRec(TreeNode root, Song song) {
//         if (root == null) {
//             return new TreeNode(song);
//         }

//         if (song.id < root.song.id) {
//             root.left = insertRec(root.left, song);
//         } else if (song.id > root.song.id) {
//             root.right = insertRec(root.right, song);
//         }

//         return root;
//     }

//     public Song search(int id) {
//         return searchRec(root, id);
//     }

//     private Song searchRec(TreeNode root, int id) {
//         if (root == null || root.song.id == id) {
//             return (root != null) ? root.song : null;
//         }

//         if (id < root.song.id) {
//             return searchRec(root.left, id);
//         } else {
//             return searchRec(root.right, id);
//         }
//     }
// }

// 4. Main:
//    - Utiliza la clase SongBinarySearchTree para insertar canciones desde un archivo CSV y buscar canciones por su ID.

// public class Main {
//     public static void main(String[] args) {
//         SongBinarySearchTree tree = new SongBinarySearchTree();

//         // Leer el archivo CSV y agregar canciones al árbol
//         // Cada línea del CSV se convierte en un objeto Song y se inserta en el árbol

//         // Ejemplo de inserción de canciones
//         Song song1 = new Song(1, "Song 1", 200);
//         Song song2 = new Song(2, "Song 2", 180);
//         Song song3 = new Song(3, "Song 3", 220);

//         tree.insert(song1);
//         tree.insert(song2);
//         tree.insert(song3);

//         // Buscar una canción por su ID
//         int searchId = 2;
//         Song foundSong = tree.search(searchId);

//         if (foundSong != null) {
//             System.out.println("Song found: " + foundSong.name);
//         } else {
//             System.out.println("Song with ID " + searchId + " not found.");
//         }
//     }
// }


/**
Claro, este código se encarga de medir el tiempo que tarda el algoritmo de ordenamiento MergeSort en ordenar un conjunto de datos. Aquí tienes una explicación línea por línea:

1. `long start, finish;`: Declara dos variables de tipo `long` llamadas `start` y `finish`. Estas variables se utilizarán para almacenar el tiempo de inicio y finalización de la ejecución del algoritmo.

2. `start = System.nanoTime();`: Captura el tiempo actual en nanosegundos antes de iniciar la ejecución del algoritmo de ordenamiento. `System.nanoTime()` proporciona una precisión muy alta para medir el tiempo.

3. `dataMergeSort = SortingMethods.MergeSort(dataMergeSort);`: Ejecuta el algoritmo de ordenamiento MergeSort sobre un conjunto de datos, representado por la variable `dataMergeSort`. El resultado ordenado se guarda nuevamente en la misma variable `dataMergeSort`.

4. `finish = System.nanoTime();`: Captura el tiempo actual en nanosegundos después de que el algoritmo de ordenamiento ha finalizado su ejecución.

5. `System.out.println("MergeSort time: " + (finish - start) + " ns.");`: Imprime en la consola el tiempo que tomó el algoritmo MergeSort en ordenar los datos. La diferencia entre el tiempo de finalización (`finish`) y el tiempo de inicio (`start`) nos da la cantidad de tiempo (en nanosegundos) que tardó el algoritmo en ejecutarse.

En resumen, estas líneas de código te permiten medir el tiempo de ejecución del algoritmo de ordenamiento MergeSort para evaluar su eficiencia en términos de rendimiento.
*/

//--------------------------------------------------

//Primero crear clase song y generar el codigo para crear un csv con songs aleatorias
//Luego crear 5 arreglos para mantener uno desordenado y los demás para utilizarlos en MergeSort, QuickSort, InsertionSort y BubbleSort
//Crear el ordenamiento mediante el tiempo de ejecucion con el codigo de los nanoTime
//Luego escoger 1 de los 5 arreglos para crear un arbol de busqueda binaria
//Implementar una clase para realizar todo esto y adicional 

