

public class RectaPrm {
    protected vector B;
    protected vector M;

    /** Construye una RectaPrm a partir de 2 Vectores */
    public RectaPrm(vector v1, vector v2){
        B=v1;
        M=v2;
    }

    /** Construye una RectaPrm a partir de 2 Puntos */
    public RectaPrm(Punto p1, Punto p2){
        B=p1.Punto2Vector();
        M=p2.Punto2Vector().resta(B);
    }

    /** Devuelve el vector B de la RectaPrm */
    public vector leeB(){
        return B;
    }

    /** Devuelve el vector M de la RectaPrm */
    public vector leeM(){
        return M;
    }

    /** Devuelve una nueva recta perpendicular a la RectaPrm en un punto determinado por el punto q (o vector) */
    RectaPrm perpendicularPunto(vector q){
        return new RectaPrm(q, M.perpendicular());
    }

    /** Devuelve una nueva recta paralela a la RectaPrm actual a una distancia X */
    RectaPrm paralelaDistancia(float x){
        return new RectaPrm(B.suma((M.perpendicular().prodEscalar(x)).divEscalar(M.longitud())), M);
    }

    /** Devuelve una nueva recta paralela a la RectaPrm a una distancia vertical v */
    RectaPrm paralelaDistanciaV(float v){
        return new RectaPrm(B.suma(new vector(0, v)), M);
    }

    /** Devuelve una nueva recta paralela a la RectaPrm a una distancia horizontal h */
    RectaPrm paralelaDistanciaH(float h){
        return new RectaPrm(B.suma(new vector(h, 0)), M);
    }

    /** Calcula la distancia de un punto (vector) a la RectaPrm */
    float distPuntoRecta(vector v){
        double t=M.dot(v.resta(B))/M.dot(M);

        return (float) v.resta(B.suma(M.prodEscalar(t))).longitud();
    }

    /** Calcula la distancia entre dos rectas */
    float distRectaRecta(RectaPrm r){
        if(M.dot(r.leeM())!=0)
            return 0;
        else
            return (float) (Math.abs(M.perpendicular().dot(r.leeB().resta(B)))/M.longitud());
    }

    /** Muestra por pantalla la información de la RectaPrm actual */
    public void out () {
        new Punto(B).out();
        M.out();
    }

}