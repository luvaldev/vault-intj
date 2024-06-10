package Implementations;

import java.util.List;

public class TreeBuilder {
  public static Tree buildBalancedTree(List<Song> songs) {
    if (songs.isEmpty()) {
      return null;
    }
    int mid = songs.size() / 2;
    Tree root = new Tree(songs.get(mid));
    root.left = buildBalancedTree(songs.subList(0, mid));
    root.right = buildBalancedTree(songs.subList(mid + 1, songs.size()));
    return root;
  }
  public static Tree buildUnbalancedTree(List<Song> songs) {
    if (songs.isEmpty()) {
      return null;
    }
    // Construir el árbol de forma lineal
    Tree root = new Tree(songs.get(0));
    Tree current = root;
    for (int i = 1; i < songs.size(); i++) {
      current.right = new Tree(songs.get(i));
      current = current.right;
    }
    return root;
  }
}
