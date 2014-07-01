/*
 * SeqIterator
 */

package my.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Sandro
 * @param <T>
 */
public class SeqIterator<T> implements Iterator<T> {

  int idx;
  private final Seq<T> data;

  public SeqIterator(Seq<T> data) {
    this.data = data;
    idx = 0;
  }
  
  @Override
  public boolean hasNext() {
    return idx<data.length();
  }

  @Override
  public T next() {
    if (!hasNext()) throw new NoSuchElementException("Seq Iterator Error!");
    return data.getElement(idx++);
  }

}
