package Implementations;

public class Tree {
  Song song;
  Tree left;
  Tree right;

  public Tree(Song song) {
    this.song = song;
    this.left = null;
    this.right = null;
  }
}