/******************************************************************************
 Clase: Rayo.java
 *****************************************************************************/



import java.util.*;

/** Representa un Rayo heredando de Recta */
public class Rayo extends Recta{
    /** Punto origen del rayo */
    protected Punto a;
    /** Otro punto del rayo */
    protected Punto b;

    /** Construye un Rayo con los puntos a y b */
    public Rayo(Punto aa, Punto bb){
        super(aa, bb);
        a=aa;
        b=bb;
    }

    /** Lee el punto origen del Rayo */
    @Override
    public Punto leea(){
        return a;
    }

    /** Lee el punto b del Rayo */
    @Override
    public Punto leeb(){
        return b;
    }

    /** Indica si el Rayo intersecta con la recta r, e indica el punto de intersección */
    @Override
    public boolean intersecta(Recta r, Punto pt){
        if(r.intersecta(this, pt)){
            if(a.leex()==b.leex()){  // el Rayo es vertical
                if(a.leey()<b.leey())
                    return pt.leey()>=a.leey();
                else
                    return pt.leey()<=a.leey();
            }else{  // el Rayo no es vertical
                if(a.leex()<b.leex())
                    return pt.leex()>=a.leex();
                else
                    return pt.leex()<=a.leex();
            }
        }else return false;
    }

    /** Indica si el Rayo intersecta con el rayo r, e indica el punto de intersección */
    public boolean intersecta(Rayo r, Punto pt){
        return (intersecta(new Recta(r.leea(), r.leeb()), pt) && r.intersecta(new Recta(a, b), pt));
    }

    /** Indica si el Rayo intersecta con el segmento s, e indica el punto de intersección */
    @Override
    public boolean intersecta(Segmento s, Punto pt){
        return intersecta(new Recta(s.leea(), s.leeb()), pt) && s.contiene(pt);
    }

    /** Indica si el Rayo intersecta con el poligono p devolviendo la lista de puntos donde intersecte */
    @Override
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