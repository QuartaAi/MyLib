/*
 * ISeq - Interfaccia generica per una collezione sequenziale di oggetti.
 */

package my.adt;

/**
 *
 * @author Sandro
 * @param <T>
 */
public interface ISeq<T> {

  void append(T elem);
  void insert(T elem, int idx);
  T getElement(int idx);
  void remove(int idx);
  int length();
  
}
