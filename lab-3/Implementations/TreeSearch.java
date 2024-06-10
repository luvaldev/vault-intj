package Implementations;

public class TreeSearch {
  public static Song searchByName(Tree root, String name) {
    if (root == null) {
      return null;
    }
    if (root.song.getName().equals(name)) {
      return root.song;
    }
    Song leftResult = searchByName(root.left, name);
    if (leftResult != null) {
      return leftResult;
    }
    return searchByName(root.right, name);
  }
}
