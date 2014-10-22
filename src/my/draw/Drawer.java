/*
 * Drawer: Una classe che disegna su un contesto grafico.
 */

package my.draw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author 4Ai A.S. 2014/2015
 */
public class Drawer {
    
    GraphicsContext cxt;
    double w, h;
    
    public Drawer (GraphicsContext c) {
        this.cxt = c;
        this.w = cxt.getCanvas().getWidth();
        this.h = cxt.getCanvas().getHeight();
        cxt.setLineWidth(1);
        cxt.setStroke(Color.RED);
        cxt.setFill(Color.LIGHTYELLOW);
    }
    
    public void drawAxes () {
        Paint old_p = cxt.getStroke();
        cxt.setStroke(Color.BLUE);
        cxt.strokeLine(w/2, h, w/2, 0); // ordinata
        cxt.strokeLine(0, h/2, w, h/2); // ascissa
        cxt.strokeLine(w/2., 0, w/2 + (w*2)/100, (h*5)/100);
        cxt.strokeLine(w/2., 0, w/2 - (w*2)/100, (h*5)/100);
        cxt.strokeLine(w, h/2, w - (w*5)/100, h/2 + (h*2)/100);
        cxt.strokeLine(w, h/2, w - (w*5)/100 , h/2 - (h*2)/100);
        cxt.setStroke(old_p);
    }

    public int convertToY(int n) {
        // converte un numero da -100 a 100 in un'ordinata da h a 0
        int o = (int)(h/2);
        if (n<=-100 || n>=100 || n==0) return o;
        // metodo matematico
        o = (int)(-h/200) * n + (int)(h/2);
        return o;
    }
    
    public void drawBar( int x, int y, int w, int h ) {
        cxt.strokeRect(x, y, w, h);
        cxt.fillRect(x, y, w, h);
    }

    public void drawBars(int[] v) {
        int bars = v.length;
        if ( w/4 < bars ) {
            System.out.println("Troppi dati da visualizzare! - w=" + w + "; bars=" + bars);
            return;
        }
        int bw = (int) (w - bars) / bars;
        for (int i = 0; i < bars; i++) {
            int uly, bh;
            if ( v[i]>=0 ) {
                uly = (100-v[i]) * (int)((h/2)/100);
                bh = (int)(h/2) - uly;
            } else {
                uly = (int)h/2;
                bh = (-v[i]) * (int)((h/2)/100);
            }
            drawBar( i*(bw+1), uly, bw, bh );
        }
    }
    
}
