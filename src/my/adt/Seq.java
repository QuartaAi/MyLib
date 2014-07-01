/*
 * Seq - Implementazione di ISeq
 */

package my.adt;

import java.util.Iterator;

/**
 *
 * @author Sandro
 * @param <T>
 */
public class Seq<T> implements ISeq<T>, Iterable<T> {

  private int len;
  private final T[] data;
  private final int maxlen;
  private final int MAXLEN = 100;

  public Seq() {
    this(0);
  }

  public Seq(int maxlen) {
    this.maxlen = ( maxlen>0 ? maxlen : MAXLEN );
    data = (T[]) new Object[this.maxlen];
    len = 0;
  }
  
  @Override
  public void append(T elem) {
    if (len>=maxlen-1) throw new RuntimeException("Seq overflow!");
    data[len] = elem;
    len++;
  }

  @Override
  public void insert(T elem, int idx) {
    if (len>=maxlen) throw new RuntimeException("Seq overflow!");
    if (idx<0 || idx>len) throw new RuntimeException("Seq idx error!");
    for (int i=len; i>idx; i--) data[i] = data[i-1];
    data[idx] = elem;
    len++;
  }

  @Override
  public T getElement(int idx) {
    if (idx<0 || idx>=len) throw new RuntimeException("Seq idx not exists!");
    return data[idx];
  }

  @Override
  public void remove(int idx) {
    if (idx<0 || idx>=len) throw new RuntimeException("Seq idx not exists!");
    for (int i=idx; i<len; i++) data[i] = data[i+1];
    len--;
    data[len] = null;
  }

  @Override
  public int length() {
    return len;
  }

  @Override
  public Iterator<T> iterator() {
    return new SeqIterator(this);
  }

}
