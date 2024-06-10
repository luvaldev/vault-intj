import java.util.LinkedList;

public class CustomQueue<T> {
  private LinkedList<T> queue;

  public CustomQueue() {
    queue = new LinkedList<>();
  }

  public void agregar(T elemento) {
    queue.add(elemento);
  }

  public void quitar() {
    queue.poll();
  }

  public void mostrar() {
    for (T elemento : queue) {
      System.out.print(elemento + " ");
    }
    System.out.println();
  }

  public T obtenerPrimero() {
    return queue.peek();
  }

  public int tamano() {
    return queue.size();
  }

  public boolean estaVacia() {
    return queue.isEmpty();
  }

  public T poll() {
    return queue.poll();
  }

  public T obtener(int index) {
    return queue.get(index);
  }
}
