/******************************************************************************
 Clase: Segmento.java
******************************************************************************/



/** Representa un Segmento definido por dos Puntos. */
public class Segmento {
    
    /** Punto inferior del Segmento. */
    protected Punto a;
    /** Punto superior del Segmento. */
    protected Punto b;
    
    /** Contruye un Segmento con valores por defecto (Punto superior e inferior igual a (0,0). */
    public Segmento() {
        b = new Punto ();
        a = new Punto ();
    }
    
    /** Construye un Segmento con un Punto inferior igual a ii y un Punto superior igual a ss. */
    public Segmento (Punto ii,Punto ss) {
        a=ii; b=ss;
    }
    
    /** Construye un Segmento copia del Segmento sg. */
    public Segmento (Segmento sg) {
        //i = new Punto (sg.i);
        //b = new Punto (sg.b);
        a=sg.a; b=sg.b;
    }
    
    /** Construye un Segmento a partir de las coordenadas del Punto inferior y 
     del Punto superior. */
    public Segmento (double ax, double ay, double bx, double by) {
        a = new Punto (ax,ay);
        b = new Punto (bx,by);
    }
    
    /** Obtiene el doble ï¿½rea formada por el triï¿½ngulo compuesto por el 
     Segmento actual y la uniï¿½n de los extremos de dicho Segmento con el Punto p. */
    public double areaTriangulo2 (Punto p) {
        return p.areaTriangulo2 (a,b);
    }
    
    
    /** Devuelve la longitud del Segmento, utilizando el mï¿½todo distancia de la
     clase Punto. */
    public double longitud () {
        return a.distancia (b);
    }
    
    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
     iguales, es decir coinciden sus Puntos inferior y superior, y false en
     caso contrario. */
    public boolean igual (Segmento sg) {
        return a.igual (sg.a) && b.igual (sg.b);
    }
    
    /** Compara el Segmento actual con el Segmento sg, devolviendo true si son
     distintos, es decir el Punto inferior o superior es distinto, y false en
     caso contrario. */
    public boolean distinto (Segmento sg) {
        return a.distinto (sg.a) || b.distinto (sg.b);
    }
    
    /** Obtiene una copia del Segmento actual. */
    public Segmento copia () {
        return new Segmento (a,b);
    }
    
    /** Obtiene una copia en el Segmento actual del Segmento sg. */
    public void copia (Segmento sg) {
        a.copia (sg.a);
        b.copia (sg.b);
    }
    
    /** Obtiene el Segmento actual. */
    public Segmento lee () {
        return this;
    }
    
    /** Obtiene el Punto inferior. */
    public Punto leea () {
        return a;
    }
    
    /** Obtiene la coordenada X del Punto inferior. */
    public double leeax () {
        return a.leex ();
    }
    
    /** Obtiene la coordenada Y del Punto inferior. */
    public double leeay () {
        return a.leey ();
    }

    /** Obtiene el Punto superior. */
    public Punto leeb () {
        return b;
    }
    
    /** Obtiene la coordenada X del Punto superior. */
    public double leebx () {
        return b.leex ();
    }
    
    /** Obtiene la coordenada Y del Punto superior. */
    public double leeby () {
        return b.leey ();
    }
    
    /** Establece el Punto inferior con las coordenadas del Punto p. */
    public void asignai (Punto p) {
        a.copia (p);
    }
    
    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
     X e Y, respectivamente. */
    public void asignaa (double xx,double yy) {
        a.asigna (xx,yy);
    }
    
    /** Establece la coordenada X del Punto inferior. */
    public void asignaax (double xx) {
        a.asignax (xx);
    }
    
    /** Establece la coordenada Y del Punto inferior. */
    public void asignaay (double yy) {
        a.asignay (yy);
    }
    
    /** Establece el Punto superior con las coordenadas del Punto p. */
    public void asignab (Punto p) {
        b.copia (p);
    }
    
    /** Establece el Punto inferior con los valores xx e yy para las coordenadas
     X e Y, respectivamente. */
    public void asignab (double xx,double yy) {
        b.asigna (xx,yy);
    }
    
    /** Establece la coordenada X del Punto superior. */
    public void asignabx (double xx) {
        b.asignax (xx);
    }
        
    /** Establece la coordenada Y del Punto superior. */
    public void asignaby (double yy) {
        b.asignay (yy);
    }
    
    /** Indica si el Segmento es horizontal, en cuyo caso se devuelve true, y en
     caso contrario se devuelve false. */
    public boolean esHorizontal () {
        return Math.abs (b.leey() - a.leey()) == 0.0;
    }
    
    /** Indica si el Segmento es vertical, en cuyo caso se devuelve true, y en
     caso contrario se devuelve false. */
    public boolean esVertical () {
        return Math.abs (b.leex() - a.leex()) == 0.0;
    }
    
    /** Indica si el Punto p estï¿½ a la izquierda del Segmento. Para ello, se
     utiliza el mï¿½todo "izquierda" definido en la clase Punto. */
    public boolean izquierda (Punto p) {
        return p.izquierda (a,b);
    }
    
    /** Muestra en pantalla la informaciï¿½n del Segmento. */
    public void out () {
        System.out.println ("Punto inferior: ");
        a.out ();
        System.out.println ("Punto superior: ");
        b.out ();
    }

    /** Indica si el Segmento intersecta con el segmento se, no dice el punto de intersección */
    public boolean intersecta(Segmento se){
        if(se.leea().colineal(a, b) || se.leeb().colineal(a, b) ||  // si algún punto es colineal
                a.colineal(se.leea(), se.leeb()) || b.colineal(se.leea(), se.leeb()))
            return false;
        else
            return (se.leea().izquierda(a, b) ^ se.leeb().izquierda(a, b)) &&
                    (a.izquierda(se.leea(), se.leeb()) ^ b.izquierda(se.leea(), se.leeb()));
    }

    /** Indica si el Segmento intersecta con el segmento se; pt es el punto de corte */
    public boolean intersecta(Segmento se, Punto pt){
        if(intersecta(se)){
            double xpt, ypt, m1, m2, c1, c2;
            m1=a.pendiente(b);
            c1=a.leey()-m1*a.leex();
            m2=se.leea().pendiente(se.leeb());
            c2=se.leeay()-m2*se.leeax();
            xpt=(c2-c1)/(m1-m2);
            ypt=m1*xpt+c1;  // ypt=m2*xpt+c2;
            pt.asigna(xpt, ypt);
            return true;
        }
        return false;
    }

    /** Indica si el Segmento intersecta de modo impropio con el segmento se, no dice el punto de intersección */
    public boolean intersectaImpropia(Segmento se){
        return se.leea().entre(a, b) || se.leeb().entre(a, b) ||
                a.entre(se.leea(), se.leeb()) || b.entre(se.leea(), se.leeb());
    }

    /** Indica si el Segmento intersecta de modo impropio con el segmento se; pt es el punto de corte */
    public boolean intersectaImpropia(Segmento se, Punto pt){
        if(intersectaImpropia(se)){
            if(se.leea().entre(a, b))
                pt.copia(se.leea());
            else
                if(se.leeb().entre(a, b))
                    pt.copia(se.leeb());
                else
                    if(a.entre(se.leea(), se.leeb()))
                        pt.copia(a);
                    else
                        pt.copia(b);
            return true;
        }
        return false;
    }

    /** Indica si el Segmento se solapa con el segmento se */
    public boolean solapa(Segmento se){
        return (se.leea().colineal(a, b) && se.leeb().colineal(a, b)) &&  // los 4 puntos son colineales
                (se.leea().entre(a, b) || se.leeb().entre(a, b));
    }

    /** Indica si el Segmento está contenido dentro del segmento se, es decir, al dibujar ambos
    segmentos, *this queda totalmente oculto */
    public boolean contiene(Segmento se){
        return (se.leea().colineal(a, b) && se.leeb().colineal(a, b)) &&  // los 4 puntos son colineales
                (a.entre(se.leea(), se.leeb()) && b.entre(se.leea(), se.leeb()));  
    }

    /** Indica si el Segmento contiene al punto p */
    public boolean contiene(Punto p){
        return p.entre(a, b);
    }

    /** Rota el Segmento 90° positivos */
    public void rotar90(){
        double r, m, anguloRotado;

        r=a.distancia(b);
        anguloRotado=a.angulo(b)+Math.toRadians(90);
        b.setPolares((float)r, (float)anguloRotado);
    }

    /** Rota el Segmento 90° negativos */
    public void rotar270(){
        double r, m, anguloRotado;

        r=a.distancia(b);
        anguloRotado=a.angulo(b)+Math.toRadians(270);
        b.setPolares((float)r, (float)anguloRotado);
    }

    /** Función que determina si *this está a la izquierda de se
     (<0) si está a la izquierda
     (==0) si son iguales
     (==1) si son distintos (ni izquierda ni derecha)
     (>1) si está a la derecha
     */
    public int izquierda(Segmento se){
        if(igual(se))
            return 0;  // son iguales
        else{
            if(se.izquierda(a) && se.izquierda(b))  // a y b están a la izquierda del segmento se
                return -1;  // está a la izquierda
            else{
                if(!se.izquierda(a) && !se.izquierda(b))  // a y b están a la drecha del segmento se
                    return 1;  // está a la derecha
                else  // a y b están en distintos lados del segmento se
                    return 1;  // son distintos
            }
        }

    }
       
}