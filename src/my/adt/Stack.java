/*
 * Stack
 */

package my.adt;

/**
 *
 * @author Sandro
 * @param <T>
 */
public class Stack<T> implements IStack<T> {
  
  private final T[] data;
  private int len;
  private final int maxlen;
  private final int MAXLEN = 100;
  
  public Stack() {
    this.maxlen = MAXLEN;
    data = (T[]) new Object[maxlen];
    len = 0;
  }

  public Stack(int maxlen) {
    this.maxlen = maxlen;
    data = (T[]) new Object[maxlen];
    len = 0;
  }
  
  @Override
  public boolean isEmpty() {
    return len==0;
  }

  @Override
  public void push(T val) {
    if (len==maxlen) throw new RuntimeException("Stack overflow!");
    data[len] = val;
    len++;
  }
  
  @Override
  public T pop() {
    if (len==0) throw new RuntimeException("Stack underflow!");
    len--;
    T result = data[len];
    data[len] = null;
    return result;
  }

}
