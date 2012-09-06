/******************************************************************************
 Clase: vector.java
 *****************************************************************************/



/** Representa un vector. */
public class vector {

    /** Coordenada X del vector. */
    protected double x;
    /** Coordenada Y del vector. */
    protected double y;

    /** Crea un vector con valores por defecto (componentes a 0). */
    public vector() {
        x = y = 0;
    }

    /** Crea un vector dadas sus componentes iguales a xX y yY,
     respectivamente. */
    public vector (double xx,double yy) {
        x = xx;
        y = yy;
    }

    /** Crea un vector dados los Puntos inicial y final, restando las
     coordenadas de dichos Puntos. */
    public vector (Punto p1,Punto p2) {
        x = p2.leex() - p1.leex ();
        y = p2.leey() - p1.leey ();
    }

    /** Crea un vector cuyas componentes se obtienen de los extremos de un
     Segmento. */
    public vector (Segmento sg) {
        x = sg.leebx() - sg.leeax();
        y = sg.leeby() - sg.leeay();
    }

    /** Crea un vector copia de v. */
    public vector (vector v) {
        x = v.x;
        y = v.y;
    }

    /** Crea un vector a partir de un Punto p */
    public vector(Punto p){
        x=p.leex();
        y=p.leey();
    }

    /** Obtiene la longitud del vector actual. */
    public double longitud () {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    /** Obtiene la longitud al cuadrado del vector actual. */
    public double longitud2 () {
        return Math.pow(x,2) + Math.pow(y,2);
    }

    /** Obtiene un vector que consiste en una copia normalizada del vector
     actual. */
    public vector normaliza () {
        double lng = longitud();
        return new vector (x/lng,y/lng);
    }

    /** Normaliza el vector actual. */
    public void normalizaAsigna () {
        double lng = longitud();
        x /= lng;
        y /= lng;
    }

    /** Obtiene un vector que es perpendicular al vector actual. */
    public vector perpendicular () {
        return new vector (-y,x);
    }

    /** Obtiene en el vector actual su perpendicular. */
    public void perpendicularAsigna () {
        double temp = x;
        x = -y;
        y = temp;
    }

    /** Suma al vector actual el vector v, devolviendo un nuevo vector con
     el resultado de la suma. */
    public vector suma (vector v) {
        return new vector (x + v.x,y + v.y);
    }

    /** Suma al vector actual el vector v, asignando el resultado al vector
     actual. */
    public void sumaAsigna (vector v) {
        x += v.x;
        y += v.y;
    }

    /** Resta al vector actual el vector v, devolviendo un nuevo vector con
     el resultado de la resta. */
    public vector resta (vector v) {
        return new vector (x - v.x,y - v.y);
    }

    /** Resta al vector actual el vector v, asignando el resultado al vector
     actual. */
    public void restaAsigna (vector v) {
        x -= v.x;
        y -= v.y;
    }

    /** Resta al vector actual el vector v, asignando el resultado al vector
     actual. */
    public void divideAsigna (int n) {
        x /= n;
        y /= n;
    }

    /** Obtiene un nuevo vector resultado de multiplicar el actual por un
     escalar t. */
    public vector prodEscalar (double t) {
        return new vector (x * t,y * t);
    }

    /** Se asigna al vector actual el resultado de multiplicar dicho vector
     por un escalar t. */
    public void prodEscalarAsigna (double t) {
        x *= t;
        y *= t;
    }

    /** Obtiene un nuevo vector resultado de dividir el actual por un escalar
     t. */
    public vector divEscalar (double t) {
        return new vector (x / t,y / t);
    }

    /** Se asigna al vector actual el resultado de dividir dicho vector por un
     escalar t. */
    public void divEscalarAsigna (double t) {
        x /= t;
        y /= t;
    }

    /** Obtiene el producto escalar del vector actual con el vector v. */
    public double dot (vector v) {
        return x * v.x + y * v.y;
    }

    /** Obtiene el ángulo del vector. */
    public double angulo () {
        double radianes = Math.atan2 (y,x);
        if (x < 0)
            return radianes += Math.PI;     //Segundo o tercer cuadrante.
        if (radianes < 0)
            return radianes += 2 * Math.PI; //Cuarto cuadrante.
        return radianes;
    }

    /** Obtiene un nuevo vector que es el producto Vectorial del vector actual
     con el vector v. */
    public vector prodVectorial (vector v) {
        return new vector (x * v.y,y * v.x);
    }

    /** Obtiene en el vector actual el producto Vectorial de dicho vector con el
     vector v. */
    public void prodVectorialAsigna (vector v) {
        x *= v.y;
        y *= v.x;
    }

    /** Obtiene el producto cruzado del vector actual con el vector v. */
    public double kross (vector v) {
        return x * v.y - y * v.x;
    }

    /** Compara el vector actual con el vector v y devuelve true si son iguales
     (si coinciden sus componentes X e Y) y false en caso contrario. */
    public boolean igual (vector v) {
        return x == v.x && y == v.y;
    }

    /** Compara el vector actual con el vector v y devuelve true si son distintos
     (si no coinciden sus componentes X o Y) y false en caso contrario. */
    public boolean distinto (vector v) {
        return x != v.x || y != v.y;
    }

    /** Obtiene en el vector actual una copia del vector v. */
    public void copia (vector v) {
        x = v.x;
        y = v.y;
    }

    /** Obtiene un vector que es una copia del vector actual. */
    public vector copia () {
        return new vector (x,y);
    }

    /** Obtiene la componente X del vector actual. */
    public double leex () {
        return x;
    }

    /** Obtiene la componente Y del vector actual. */
    public double leey () {
        return y;
    }

    /** Establece las componentes X e Y del vector actual con los valores xx y
     yy, respectivamente. */
    public void asigna (double xx,double yy) {
        x = xx;
        y = yy;
    }

    /** Establece la componente X del vector actual. */
    public void asignax (double xx) {
        x = xx;
    }

    /** Establece la componente Y del vector actual. */
    public void asignay (double yy) {
        y = yy;
    }

    /** Devuelve un Punto equivalente al vector actual. */
    public Punto Vector2Punto () {
        return new Punto (x,y);
    }

    /** Muestra por pantalla la información del vector actual. */
    public void out () {
        System.out.print ("Desplazamiento en x: ");
        System.out.println (x);
        System.out.print ("Desplazamiento en y: ");
        System.out.println (y);
    }

    /** Dados dos puntos Q0 y Q1, encontrar la recta situada entre ambos puntos y equidistante a
    ambos */
    RectaPrm equidistante2puntos (vector q){
        vector B;
        vector M;

        B=suma((q.resta(this)).divEscalar(2));
        M=(q.resta(this)).perpendicular();

        return new RectaPrm(B, M);
    }

}