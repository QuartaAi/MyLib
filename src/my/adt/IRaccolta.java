/*
 * IRaccolta - Interfaccia generica per collezioni di oggetti.
 */

package my.adt;

/**
 *
 * @author Sandro
 * @param <T>
 */
public interface IRaccolta<T> {

  void append(T elem);
  void insert(T elem, int idx);
  T getElem(int idx);
  void remove(int idx);
  
}
