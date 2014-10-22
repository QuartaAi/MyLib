/*
 * TextLines: un lettore standard di file di testo.
 */

package my.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sandro
 */
public class TextLines implements Iterable {

  String filename;
  ArrayList<String> records;

  public TextLines(String filename) {
    this.filename = filename;
    records = new ArrayList<>();
    File f = new File(filename);
    String s;
    try {
      Scanner lettore = new Scanner(f);
      while (lettore.hasNext()) {
        s = lettore.nextLine();
        records.add(s);
      }
      lettore.close();
    } catch (FileNotFoundException ex) {
      System.out.println("ERRORE: file " + filename + " non trovato.");
    }
  }

  public String getRecord(int idx) {
    if (idx<0 || idx>=records.size()) return null;
    return records.get(idx);
  }

  public int getSize() {
    return records.size();
  }

  @Override
  public Iterator iterator() {
    return records.iterator();
  }
  
}
