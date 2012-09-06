/******************************************************************************
 Clase: Punto.java
 ******************************************************************************/



/** Representa un Punto 2D. */
public class Punto {
       
    /** Coordenada X del Punto. */
    protected double x;
    /** Coordenada Y del Punto. */
    protected double y;
    
    /** Crea un nuevo Punto con coordenadas por defecto (iguales a 0) */
    public Punto () {
        x = 0;
        y = 0;
    }
    
    /** Crea un nuevo Punto con coordenadas X e Y igual a xx e yy, 
     respectivamente. */ 
    public Punto (double xx, double yy) {
        x = xx;
        y = yy;
    }
    
    /** Crea un nuevo Punto copiando el Punto p. */
    public Punto (Punto p) {
        x = p.x;
        y = p.y;
    }

        /** Crea un Punto a partir de un vector v */
    public Punto(vector v){
        x=v.leex();
        y=v.leey();
    }
    
    /** Obtiene la distancia del Punto actual al Punto p, calculada como: 
     distancia = raiz ((p.x - x)2 + (p.y - y)2). */
    public double distancia (Punto p) {
        double dX,dY;
        dX = Math.abs (p.x - x);
        dY = Math.abs (p.y - y);
        return Math.sqrt (Math.pow (dX,2) + Math.pow (dY,2));
    }
    
    /** Obtiene el doble del ï¿½rea que forman el triï¿½ngulo definido por el Punto 
     actual y los Puntos a y b, en el orden (*this, a, b). */
    public double areaTriangulo2 (Punto a, Punto b) {
        return x * a.y - y * a.x + a.x * b.y - a.y * b.x + b.x * y - b.y * x;
    }
    
    /** Compara el Punto actual con el Punto p, devolviendo true si son iguales 
     (si coinciden coordenada a coordenada), y false en caso contrario. */
    public boolean igual (Punto p) {
        return x == p.x && y == p.y;
    }
    
    /** Compara el Punto actual con el Punto p, devolviendo true si son 
     distintos (si alguna de las coordenadas no coinciden), y false en caso contrario. */
    public boolean distinto (Punto p) {
        return x != p.x || y != p.y;
    }
    
    /** Obtiene un Punto copia del actual. */
    public Punto copia () {
        return new Punto (x,y);
    }
    
    /** El Punto actual pasa a ser una copia del Punto p. */
    public void copia (Punto p) {
        x = p.x;
        y = p.y;
    }
    
    /** Devuelve el Punto para ser leido. */
    public Punto lee () {
        return this;
    }
    
    /** Devuelve la coordenada X del Punto. */
    public double leex () {
        return x;
    }
    
    /** Devuelve la coordenada Y del Punto. */
    public double leey () {
        return y;
    }
    
    /** Establece las coordenadas X e Y del Punto con los valores de xx e yy, 
     respectivamente. */
    public void asigna (double xx, double yy) {
        x = xx;
        y = yy;
    }
    
    /** Establece la coordenada X del Punto. */
    public void asignax (double xx) {
        x = xx;
    }
    
    /** Establece la coordenada Y del Punto. */
    public void asignay (double yy) {
        y = yy;
    }
    
    /** Realiza la suma de dos Puntos, devolviendo la suma en otro Punto. */
    public Punto suma (Punto p) {
        return new Punto (x + p.x,y + p.y);
    }
    
    /** Realiza la suma de dos Puntos, almacenando dicha suma en el Punto 
     actual. */
    public void sumaAsigna (Punto p) {
        x += p.x;
        y += p.y;
    }
    
    /** Realiza la resta de dos Puntos, devolviendo la suma en otro Punto. */
    public Punto resta (Punto p) {
        return new Punto (x - p.x,y - p.y);
    }
    
    /** Realiza la resta de dos Puntos, almacenando dicha resta en el Punto 
     actual. */
    public void restaAsigna (Punto p) {
        x -= p.x;
        y -= p.y;
    }
    
    /** Realiza el producto del Punto actual por un escalar, devolviendo el 
     producto en otro Punto. */
    public Punto producto (double d) {
        return new Punto (x * d,y * d);
    }
    
    /** Realiza el producto del Punto actual por un escalar, almacenando dicho 
     producto en el Punto actual. */
    public void productoAsigna (double d) {
        x *= d;
        y *= d;
    }
    
    /** Realiza la divisiï¿½n del Punto actual por un escalar, devolviendo la 
     divisiï¿½n en otro Punto. */
    public Punto division (double d) {
        return new Punto (x / d,y / d);
    }
    
    /** Realiza la divisiï¿½n del Punto actual por un escalar, almacenando dicha 
     divisiï¿½n en el Punto actual. */
    public void divisionAsigna (double d) {
        x /= d;
        y /= d;
    }
    
    /** Indica si el Punto estï¿½ a la izquierda del segmento definido por los 
     Puntos ab. */
    public boolean izquierda (Punto a, Punto b) {
        return areaTriangulo2 (a,b) > Geometria.CERO;
    }
    
    /** Indica si el Punto estï¿½ a la derecha del segmento definido por los 
     Puntos ab. */
    public boolean derecha (Punto a, Punto b) {
        return areaTriangulo2 (a,b) < Geometria.CERO;
    }
    
    /** Indica si los tres Puntos son colineales. */
    public boolean colineal (Punto a, Punto b) {
        return Math.abs(areaTriangulo2 (a,b)) < Geometria.CERO;
    }
    
    /** Indica si el Punto estï¿½ a la izquierda o es colineal al segmento 
     definido por los Puntos ab. */
    public boolean izquierdaSobre (Punto a, Punto b) {
        return areaTriangulo2 (a,b) >= Geometria.CERO;
    }
    
    /** Indica si el Punto estï¿½ a la derecha o es colineal al segmento definido 
     por los Puntos ab. */
    public boolean derechaSobre (Punto a, Punto b) {
        return areaTriangulo2 (a,b) <= Geometria.CERO;
    }
    
    /** Indica la pendiente que forma con el Punto p. */
    public double pendiente (Punto p) {
        if (Math.abs(x-p.x)<Geometria.CERO) return Geometria.INFINITO;

	return (p.y - y)/(p.x - x);
    }
    
    /** Muestra en pantalla los valores de las coordenadas del Punto. */
    public void out () {
        System.out.print ("Coordenada x: ");
        System.out.println (x);
        System.out.print ("Coordenada y: ");
        System.out.println (y);
    }

    /** Calcula el Ã§angulo (en grados) que forma con el Punto pt */
    public double angulo(Punto pt){
        double m, anguloRadianes, anguloGrados;

        m=pendiente(pt);
        anguloRadianes=Math.atan(m);
        anguloGrados=anguloRadianes*180/Math.PI;

        if(anguloGrados<0)
            anguloGrados+=180;

        return anguloGrados;
    }


    /** Nos dice si el Punto está entre los puntos a y b */
    public boolean entre(Punto a, Punto b){
        if(!colineal(a, b))
            return false;
        else{
            if(a.x!=b.x)
                return ((a.x<=x && x<=b.x)||(a.x>=x && x>=b.x));
            else
                return ((a.y<=y && y<=b.y)||(a.y>=y && y>=b.y));
        }
    }

    /** Rota el Punto 90° positivos */
    public void rotar90(){
        double r, anguloRotado;
        Punto p=new Punto();

        r=distancia(p);
        anguloRotado=angulo(p)+Math.toRadians(90);  // le sumamos 90° positivos
        setPolares((float)r, (float)anguloRotado);
    }

    /** Rota el Punto 90° negativos (270°) */
    public void rotar270(){
        double r, anguloRotado;
        Punto p=new Punto();

        r=distancia(p);
        anguloRotado=angulo(p)+Math.toRadians(270);  // le sumamos 90° negativos
        setPolares((float)r, (float)anguloRotado);
    }

    /** Determina el cuadrante donde se encuentra el Punto (1,2,3,4) */
    public int cuadrante(){
        Punto p=new Punto();

        if(angulo(p)<=Math.toRadians(90)) return 1;
        if(angulo(p)<=Math.toRadians(180)) return 2;
        if(angulo(p)<=Math.toRadians(270)) return 3;
        return 4;
    }

    /** Compara las abscisas del Punto y el punto p */
    int compX(Punto p){
        return (int)(x-p.x);
    }

    /** Compara las ordenadas del Punto y el punto p */
    int compY(Punto p){
        return (int)(y-p.y);
    }

    /** Determina el punto resultante tras interpolar el Punto y el punto pt en una posición relativa al
    parámetro f, de modo que cuanto más cercano sea f a 1.0, más cercano es el nuevo
    punto cercano al parámetro this */
    public Punto interpolar(Punto pt, float f){
        double m, c, xpt, ypt, dX, dY;

        m=pendiente(pt);
        c=y-m*x;
        
        if(compX(pt)==0){  // ambos puntos tienen igual abscisa
            dY=Math.abs(y-pt.y);
            if(compY(pt)<0)  // el Punto está por debajo del punto pt
                ypt=pt.y-dY*f;
            else  // el Punto está por encima del punto pt
                ypt=pt.y+dY*f;
            xpt=x;
        }else{  // ambos puntos tienen distinta abscisa
            dX=Math.abs(x-pt.x);
            if(compX(pt)<0)  // el Punto está a la izquierda del punto pt
                xpt=pt.x-dX*f;
            else  // el Punto está a la derecha del punto pt
                xpt=pt.x+dX*f;
            ypt=m*xpt+c;
        }
         return (new Punto(xpt, ypt));
    }

    /** Escala el segmento con origen en (0,0) y el Punto a una longitud dada por el
    valor de n. Por ejemplo si el punto actual es (0,5) y se normaliza a 1, el punto que se
    devuelve es (0,1) */
    public void normalizar(float n){
        double r, factorNorm;

        r=distancia(new Punto(0, 0));
        factorNorm=n/r;

        copia(interpolar(new Punto(0, 0), (float)factorNorm));
    }

    /** Establece las coordenadas del punto a las coordenadas polares dadas como
    parámetro */
    public void setPolares(float r, float angulo){
        asigna(r*Math.cos(angulo), r*Math.sin(angulo));
    }

        /** Devuelve un vector equivalente al Punto actual. */
    public vector Punto2Vector() {
        return new vector (x,y);
    }

}