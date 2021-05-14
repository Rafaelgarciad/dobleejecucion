

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.lang.reflect.Method;

public class DibujoCartesianas {

    //Método a modificar. x e y están entre 0 y 1.
    //El origen (0,0) está en la esquina inferior izquierda

    public static Color crear3franjas(double x, double y) {
        if (x < 0.33) {

        }
        if (x < 0.66 && x > 0.33) {
            return new Color(0, 0, 0);
        }

        if (x < 1 && x > 0.66) {
            return new Color(241, 255, 29);
        }


        return new Color(0, 0, 0);
    }

    public static Color crear3columnas(double x, double y) {
        if (y < 0.33) {

        }
        if (y < 0.66 && y > 0.33) {
            return new Color(0, 0, 0);
        }

        if (y < 1 && y > 0.66) {
            return new Color(241, 255, 29);
        }


        return new Color(0, 0, 0);
    }


    private static Color devuelveColor(double x, double y) {

        if (y < 0.60 && y > 0.30) {
            return new Color(60, 208, 35);
        }
        if (y < 0.44 && y > 0.33) {

        }
        if (y < 0.66 && y > 0.55) {

        }
        if (y < 0.88 && y > 0.77) {

        }
        return new Color(255, 255, 255);
    }


    //NO MODIFICAR A PARTIR DE AQUÍ

    public static int ANCHO = 400;
    public static int ALTO = 400;
    public static int diagonal = (int) Math.sqrt(ANCHO * ANCHO + ALTO * ALTO);

    public static void repinta(Canvas cnvs) {
        Graphics g = cnvs.getGraphics();
        Dimension dimension = cnvs.getSize();
        ANCHO = dimension.width;
        ALTO = dimension.height;
        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Color color = devuelveColor(x / (double) ANCHO, y / (double) ALTO);
                g.setColor(color);
                g.drawOval(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(ANCHO, ALTO + 50);

        final Canvas cnvs = new Canvas();
        cnvs.setSize(ANCHO, ALTO);

        frmMain.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                repinta(cnvs);
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {
            }
        });
        frmMain.add(cnvs);
        frmMain.setVisible(true);
        repinta(cnvs);
    }
}
