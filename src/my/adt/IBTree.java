/*
 * IBTree - interfaccia albero binario
 */

package my.adt;

/**
 *
 * @author sandro
 * @param <T>
 */
public interface IBTree<T> {
  IBTree<T> left();
  IBTree<T> right();
  T getInfo();
  boolean isEmpty();
}
