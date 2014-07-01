/*
 * MyRaccolta - Classe implementazione del Contenitore
 */

package my.adt;

import java.util.ArrayList;

/**
 *
 * @author Sandro
 * @param <T>
 */
public class MyRaccolta<T> implements IRaccolta<T> {

  ArrayList<T> dati;

  public MyRaccolta() {
    dati = new ArrayList<>();
  }
  
  @Override
  public void append(T elem) {
    dati.add(elem);
  }

  @Override
  public void insert(T elem, int idx) {
    dati.add(idx, elem);
  }

  @Override
  public T getElem(int idx) {
    return dati.get(idx);
  }

  @Override
  public void remove(int idx) {
    dati.remove(idx);
  }
  
}
