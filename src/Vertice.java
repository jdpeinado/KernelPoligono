/******************************************************************************
 Clase: Vertice.java
 *****************************************************************************/



/* Representa un vï¿½rtice perteneciente a un polï¿½gono. */
public class Vertice extends Punto {
    /* Posiciï¿½n que ocupa dentro del polï¿½gono. */
    protected int posicion;
    /* Polï¿½gono al que pertenece. */
    protected Poligono polig;
    
    /** Construye un vï¿½rtice por defecto, es decir no asociado a ningï¿½n 
     polï¿½gono, con posiciï¿½n -1 (no pertenece a ningï¿½n polï¿½gono) y coordenadas 
     (0,0). */
    public Vertice() {
        x = 0; y=0;
        posicion = -1;
        polig = null;
    }
    
    
    /** Construye un vï¿½rtice asociado a un Punto, sin estar asociado a ningï¿½n 
     polï¿½gono. Aunque no es correcto, ya que un vï¿½rtice debe pertenecer a un
     polï¿½gono, es muy ï¿½til a la hora de inicializar vï¿½rtices, que luego formen
     un polï¿½gono determinado. */    
    public Vertice (Punto p) {
        x = p.x; y=p.y;
	posicion = -1;
        polig = null;
    }

    /** Construye un vï¿½rtice similar al anterior, con los valores xx e yy que se
     corresponden con las coordenadas X e Y del Punto p asociado al vï¿½rtice. */
    public Vertice (double xx,double yy, Poligono pol) {
        x = xx; y = yy;
	posicion = -1;
        polig = pol;
    }
    
    /** Lee el valor de la x */
    @Override
    public double leex () {
        return x;
    }
    
     /** Lee el valor de la y */
    @Override
    public double leey () {
        return y;
    }

        
    /** Lee la posiciï¿½n asociada al vï¿½rtice actual. */
    public int leePosicion () {
        return posicion;
    }
    
    /** Lee el polï¿½gono al que estï¿½ asociado el vï¿½rtice. */
    public Poligono leePoligono () {
        return polig;
    }
    
    /** Modifica las coordenadas del Punto asociadas al vï¿½rtice actual con los
     valores de las coordenadas del Punto p. */
    public void modificaPunto (Punto p) {
        x = p.x; y = p.y;
    }
    
    /** Modifica la posiciï¿½n del vï¿½rtice dentro del polï¿½gono. Esta operaciï¿½n
     se ha definido como protegida porque es peligroso que el usuario pueda
     modificar la posiciï¿½n del vï¿½rtice. */
    protected void modificaPosicion (int pos) {
        posicion = pos;
    }
    
    /** Modifica el polï¿½gono al que pertenece el vï¿½rtice v. De igual modo que el 
     mï¿½todo anterior, tambiï¿½n se ha declarado como un mï¿½todo protegido. */
    protected void modificaPoligono (Poligono pl) {
        polig = pl;
    }

    
    /** Muestra por pantalla la informaciï¿½n del vï¿½rtice actual. */
    @Override
    public void out () {
        System.out.print ("Coordenada x: ");
        System.out.println (x);
        System.out.print ("Coordenada y: ");
        System.out.println (y);

        System.out.print ("Posiciï¿½n: ");
        System.out.println (posicion);
    }

    /** Indica si el Vértice es convexo */
    public boolean convexo(){
        int imas1=(posicion+1)%polig.numeroVertices(), imenos1=(posicion-1+polig.numeroVertices())%polig.numeroVertices();

        return polig.lee(imas1).izquierda(polig.lee(imenos1), this);
    }
}