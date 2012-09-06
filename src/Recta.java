/******************************************************************************
 Clase: Recta.java
 *****************************************************************************/



import java.util.*;

/** Representa una Recta definida por 2 puntos */
public class Recta {
    /** Punto origen del rayo */
    protected Punto a;
    /** Otro punto del rayo */
    protected Punto b;
    /** Pendiente de la recta */
    protected double m;
    /** Valor c de la recta */
    protected double c;

    /** Construye una Recta pasándole el valor de su pendiente y de su constante */
    public Recta(double mm, double cc){
        m=mm;
        c=cc;
    }

    /** Construye una Recta que pasa por los puntos a y b */
    public Recta(Punto aa, Punto bb){
        a=aa;
        b=bb;
        m=a.pendiente(b);
        c=a.leey()-m*a.leex();
    }

    /** Construye una Recta copia de la recta r */
    public Recta(Recta r){
        a=r.a;
        b=r.b;
        m=r.m;
        c=r.c;
    }

    /** Devuelve el valor de a */
    public Punto leea(){
        return a;
    }

    /** Devuelve el valor de b */
    public Punto leeb(){
        return b;
    }

    /** Devuelve el valor de m */
    public double leem(){
        return m;
    }

    /** Devuelve el valor de m */
    public double leec(){
        return c;
    }

    /** Indica si la Recta intersecta con la recta r, e indica el punto de intersección */
    public boolean intersecta(Recta r, Punto pt){
        if(m==r.m)  // son paralelas
            return false;
        else{
            double x, y;
            x=(r.c-c)/(m-r.m);
            y=m*x+c;  // y=r.m*x+r.c;
            pt.asigna(x, y);
            return true;
        }
    }

    /** Indica si la Recta intersecta con el segmento s, e indica el punto de intersección */
    public boolean intersecta(Segmento s, Punto pt){
        return intersecta(new Recta(s.leea(), s.leeb()), pt) && s.contiene(pt);
    }

    /** Indica si la Recta intersecta con el poligono p devolviendo la lista de puntos donde intersecte */
    public LinkedList<Punto> intersecta(Poligono p){
        Punto pt=new Punto();
        LinkedList<Punto> l=new LinkedList();

        for(int i=0;i<p.numeroVertices();i++){
            if(intersecta(new Segmento(p.lee(i), p.lee((i+1)%p.numeroVertices())), pt))
                l.add(new Punto(pt));
        }
        return l;
    }
}