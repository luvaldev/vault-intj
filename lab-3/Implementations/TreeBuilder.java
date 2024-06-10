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
}
