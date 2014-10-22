/*
 * Logger
 */

package my.wrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sandro
 */
public class Logger implements Iterable<String> {

  File f;
  PrintWriter output;

  public Logger(File f) throws IOException {
    this.f = f;
    output = new PrintWriter( new FileWriter(f, true) );
  }

  public void append( String msg ) {
    output.println( new Date() + ": " + msg );
    output.flush();
  }
  
  @Override
  public Iterator<String> iterator() {
    return new Iteratore();
  }

  private class Iteratore implements Iterator<String> {
    Scanner r;

    public Iteratore() {
      try {
        r = new Scanner(f);
      } catch (FileNotFoundException ex) {
        
      }
    }
    
    @Override
    public boolean hasNext() {
      return r.hasNext();
    }

    @Override
    public String next() {
      return r.nextLine();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }
  
}
