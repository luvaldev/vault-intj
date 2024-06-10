package Implementations;

import java.util.List;
import java.util.ArrayList;

public class SortingMethods {

  public static List<Song> mergeSort(List<Song> songs, boolean sortByDuration) {
    if (songs.size() <= 1) {
      return songs;
    }

    int middle = songs.size() / 2;
    List<Song> left = new ArrayList<>(songs.subList(0, middle));
    List<Song> right = new ArrayList<>(songs.subList(middle, songs.size()));

    return merge(mergeSort(left, sortByDuration), mergeSort(right, sortByDuration), sortByDuration);
  }

  private static List<Song> merge(List<Song> left, List<Song> right, boolean sortByDuration) {
    List<Song> merged = new ArrayList<>();
    int leftIndex = 0, rightIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      Song leftSong = left.get(leftIndex);
      Song rightSong = right.get(rightIndex);

      if (sortByDuration) {
        if (leftSong.getDuration() <= rightSong.getDuration()) {
          merged.add(leftSong);
          leftIndex++;
        } else {
          merged.add(rightSong);
          rightIndex++;
        }
      } else {
        if (leftSong.getName().compareTo(rightSong.getName()) <= 0) {
          merged.add(leftSong);
          leftIndex++;
        } else {
          merged.add(rightSong);
          rightIndex++;
        }
      }
    }

    while (leftIndex < left.size()) {
      merged.add(left.get(leftIndex));
      leftIndex++;
    }

    while (rightIndex < right.size()) {
      merged.add(right.get(rightIndex));
      rightIndex++;
    }

    return merged;
  }

  public static List<Song> quickSort(List<Song> songs, boolean sortByDuration) {
    if (songs.size() <= 1) {
      return songs;
    }

    Song pivot = songs.get(songs.size() / 2);
    List<Song> less = new ArrayList<>();
    List<Song> equal = new ArrayList<>();
    List<Song> greater = new ArrayList<>();

    for (Song song : songs) {
      int comparison;
      if (sortByDuration) {
        comparison = Integer.compare(song.getDuration(), pivot.getDuration());
      } else {
        comparison = song.getName().compareTo(pivot.getName());
      }
      if (comparison < 0) {
        less.add(song);
      } else if (comparison == 0) {
        equal.add(song);
      } else {
        greater.add(song);
      }
    }

    List<Song> sortedList = new ArrayList<>(quickSort(less, sortByDuration));
    sortedList.addAll(equal);
    sortedList.addAll(quickSort(greater, sortByDuration));

    return sortedList;
  }

  public static List<Song> insertionSort(List<Song> songs, boolean sortByDuration) {
    for (int i = 1; i < songs.size(); i++) {
      Song key = songs.get(i);
      int j = i - 1;
      while (j >= 0 && (sortByDuration ? songs.get(j).getDuration() > key.getDuration() :
              songs.get(j).getName().compareTo(key.getName()) > 0)) {
        songs.set(j + 1, songs.get(j));
        j--;
      }
      songs.set(j + 1, key);
    }
    return songs;
  }

  public static List<Song> bubbleSort(List<Song> songs, boolean sortByDuration) {
    boolean swapped;
    for (int i = 0; i < songs.size() - 1; i++) {
      swapped = false;
      for (int j = 0; j < songs.size() - 1 - i; j++) {
        if (sortByDuration ? songs.get(j).getDuration() > songs.get(j + 1).getDuration() :
                songs.get(j).getName().compareTo(songs.get(j + 1).getName()) > 0) {
          Song temp = songs.get(j);
          songs.set(j, songs.get(j + 1));
          songs.set(j + 1, temp);
          swapped = true;
        }
      }
      if (!swapped) break;
    }
    return songs;
  }
}
