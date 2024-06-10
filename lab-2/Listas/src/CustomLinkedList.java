import java.util.LinkedList;

public class CustomLinkedList<T> {
  private LinkedList<T> list;

  public CustomLinkedList() {
    list = new LinkedList<>();
  }

  public void agregar(T elemento) {list.add(elemento);}

  public void quitar(T elemento) {list.remove(elemento);}

  public void mostrar() {
    for (T elemento : list) {
      System.out.print(elemento + " ");
    }
    System.out.println();
  }

  public T obtenerPrimero() {return list.getFirst();}

  public T obtenerUltimo() {return list.getLast();}

  public int tamano() {return list.size();}

  public boolean estaVacia() {return list.isEmpty();}

  public T poll() {return list.poll();}

  public T obtener(int index) {return list.get(index);}

  public void remover(int index) {
    list.remove(index);
  }

  public void insertar(int index, T elemento) {
    list.add(index, elemento);
  }

  public boolean contiene(T elemento) {
    return list.contains(elemento);
  }

  public void vaciar() {
    list.clear();
  }
}
