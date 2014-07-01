/*
 * IStack Interface
 */

package my.adt;

/**
 *
 * @author Sandro
 * @param <T>
 */
public interface IStack<T> {

  /**
   * testa se lo stack è vuoto
   * @return true se lo stack è vuoto, altrimenti false
  */
  boolean isEmpty();

  /**
   * inserisce un dato in cima allo stack
   * @param val  
  */
  void push(T val);

  /**
   * estrae il dato che sta in cima dello stack
   * @return il dato estratto o null se lo stack è vuoto
   */
  T pop();
  
}
