/******************************************************************************
 Clase: Poligono.java
******************************************************************************/



/** Representa un Poligono con nVertices Vertices. */
public class Poligono {

    /** Numero de Vertices. */
    protected int nVertices;
    /** vector de Vertices que pertenecen al Poligono. */
    protected java.util.Vector<Vertice> Vertices;
    
    /** Contruye un Poligono por defecto (sin ningun Vertice). */
    public Poligono () {
        Vertices = new java.util.Vector ();
        nVertices = 0;
    }
    
    /** Construye un Poligono con un numero de Vertices nV. */
    public Poligono (int nV) {
        Vertices = new java.util.Vector (nV);
        nVertices = nV;
    }
    
    /** Construye un Poligono como p1. Para ello se utiliza el metodo clone,
     sin necesidad de reservar memoria, ya que para usar este metodo no es
     necesario. */
    public Poligono(Poligono pl) {
        Vertices = (java.util.Vector) pl.Vertices.clone ();
        nVertices = pl.nVertices;
    }
    
    /** Construye un Poligono con el numero de Vertice nV, los cuales estaran
     en el vector vert. */
    public Poligono (java.util.Vector vert, int nV) {
        Vertices = (java.util.Vector) vert.clone();
        nVertices = nV;
    }
    
    /** Devuelve una copia del Poligono actual. */
    public Poligono copia () {
        Poligono nuevoPoligono = new Poligono (nVertices);
        nuevoPoligono.Vertices = (java.util.Vector) Vertices.clone ();
        nuevoPoligono.nVertices = nVertices;
        return nuevoPoligono;
    }

    public void eliminaV(){
        Vertices.removeAllElements();
        nVertices=0;
    }
    
    /** Obtiene una copia del Poligono pl. */
    public void copia (Poligono pl) {
        Vertices.clear();                           //Se limpia el vector.
        Vertices = (java.util.Vector) pl.Vertices.clone();    //Se copia el vector.
        nVertices = pl.nVertices;
    }

    /** Obtiene una copia independiente del Poligono */
    public Poligono copia2(){
        Poligono pol=new Poligono();

        for(int i=0;i<nVertices;i++)
            pol.anade(new Vertice(lee(i)));

        return pol;
    }

    /** Establece el Vertice v en la posicion pos del Poligono actual. Teniendo
     en cuenta que el vector esta indexado desde 0. */
    public void modifica (Vertice v,int pos) {
        if (pos >= 0 && pos < nVertices) {
            Vertice antiguo = new Vertice ((Vertice) Vertices.get (pos));
            antiguo.modificaPoligono (null);
            antiguo.modificaPosicion (-1);
            Vertices.set(pos, (Vertice)v);
            v.modificaPoligono (this);
            v.modificaPosicion (pos);
        }
    }
    
    /** Establece el vï¿½rtice v en la ï¿½ltima posiciï¿½n del polï¿½gono actual. */
    public void anade (Vertice v) {
        Vertices.add ((Vertice)v);
        v.modificaPoligono (this);
        v.modificaPosicion (nVertices);
        nVertices ++;
    }
    
    /** Devuelve el vï¿½rtice v que ocupa la posiciï¿½n pos. */
    public Vertice lee (int pos) {
        if (pos >= 0 && pos < nVertices)
            return (Vertice) Vertices.get (pos);
        else
            return null;
    }
    
    
    /** Devuelve una copia del vï¿½rtice v que ocupa la posiciï¿½n pos. */
    public Vertice leeAsigna (int pos) {
        if (pos >= 0 && pos < nVertices)
            return new Vertice ((Vertice) Vertices.get(pos));
        else
            return null;
    }
    
    /** Devuelve el nï¿½mero de vï¿½rtices que tiene el polï¿½gono. */
    public int numeroVertices () {
        return nVertices;
    }
    
    
    /** Muestra por pantalla la informaciï¿½n del polï¿½gono. */
    public void out () {
        Vertice v = new Vertice ();
        for (int i = 0;i < nVertices;i++) {
            v = (Vertice)Vertices.get(i);
            v.out ();
        }
    }

    /** Devuelve un el kernel del Poligono */
    public Poligono kernel(){
        java.util.Vector<Vertice> copiaPol=(java.util.Vector) Vertices.clone();
        int tama = numeroVertices(),pos=0;
        Rayo ry;
        Segmento s;
        Punto p=new Punto();

        for(int i=0;i<tama;i++){
            ry=new Rayo(lee(i),lee((i+1)%tama)); //forma el rayo de i hacia i+1
            for(int j=0;j<copiaPol.size();j++){ // para comparar con todos los segmentos del kernel que llevamos
                s=new Segmento(copiaPol.get(j), copiaPol.get((j+1)%copiaPol.size())); //forma el segmento
                if(ry.intersecta(s,p) && !s.intersectaImpropia(new Segmento(lee(i), lee((i+1)%tama)))){ // si la interseccion es impropia con el segmento que se forma con el propio rayo no entra(por ejemplo un cuadradado)
                    copiaPol=quitarPuntosDer(copiaPol,tama,i,p); // elimina los puntos a la derecha
                }
            }

            ry=new Rayo(lee((i+1)%tama),lee(i)); //forma el rayo de i+1 hacia i
            for(int j=0;j<copiaPol.size();j++){
                s=new Segmento(copiaPol.get(j), copiaPol.get((j+1)%copiaPol.size()));
                if(ry.intersecta(s,p) && !s.intersectaImpropia(new Segmento(lee(i), lee((i+1)%tama)))){
                    copiaPol=quitarPuntosIzq(copiaPol,tama,i,p);
                }
            }
        }
        
        Poligono kernel=new Poligono();
        for(int i=0;i<copiaPol.size();i++)
                kernel.anade((Vertice) copiaPol.get(i));
        if(kernel.esKernel(this))
            return kernel;
        else return new Poligono();
    }

    /** Elimina los puntos que quedan a la derecha de un rayo dentro de un poligono(ultilizado para calcular el kernel) */
    public java.util.Vector<Vertice> quitarPuntosDer(java.util.Vector<Vertice> copiaP, int tama, int i, Punto p){
        java.util.Vector<Vertice> copiaPaux = new java.util.Vector();
        java.util.Vector<Integer> pSacar=new java.util.Vector();
        boolean igual=false;

        for(int k=0;k<copiaP.size();k++){ // recorre el vector donde estan los puntos del kernel
            if(!copiaP.get(k).igual(lee(i)) && !copiaP.get(k).igual(lee((i+1)%tama))){ // que no sean iguales a los puntos del rayo
                if(copiaP.get(k).derechaSobre(lee(i), lee((i+1)%tama)) && !copiaP.get(k).entre(lee(i), lee((i+1)%tama))){
                    RectaPrm rprm=new RectaPrm(lee(i), lee((i+1)%tama));
                    RectaPrm rprmPer=rprm.perpendicularPunto(lee(i).Punto2Vector()); // recta perpendicular al rayo por el punto de origen del rayo
                    Recta r=new Recta(rprmPer.leeB().Vector2Punto(),rprmPer.leeB().suma(rprmPer.leeM()).Vector2Punto());
                    Rayo ry=new Rayo(lee(i),lee((i+1)%tama));
                    if(ry.leea().leex()>ry.leeb().leex()){ // Comprueba si el rayo está lanzado a la derecha o a la izquierda
                        if(r.leeb().izquierda(lee(i), lee((i+1)%tama))){ // Si el punto b de la recta está "por debajo" del origen del rayo(el punto a) el punto a sacar debe de estar a la derecha
                            if(copiaP.get(k).derecha(r.leea(), r.leeb())){
                                pSacar.add(k);
                            }
                        }else{
                            if(copiaP.get(k).izquierda(r.leea(), r.leeb())) // El contrario de lo anterior
                                pSacar.add(k);
                        }
                    }else{ // El contrario, si el rayo al sentido contrario
                        if(r.leeb().izquierda(lee(i), lee((i+1)%tama))){
                            if(copiaP.get(k).derecha(r.leea(), r.leeb())){
                                pSacar.add(k);
                            }
                        }else{
                            if(copiaP.get(k).izquierda(r.leea(), r.leeb()))
                                pSacar.add(k);
                        }
                    }
                }
            }
        }
        for(int k=0;k<copiaP.size();k++){
            igual=false;
            for(int z=0;z<pSacar.size();z++){
                if(pSacar.get(z)==k) // para ver si hay que sacar esa posicion k
                    igual=true;
            }
            if(!igual)
                copiaPaux.add(copiaP.get(k)); //se usa vector auxiliar
        }
        copiaP=(java.util.Vector<Vertice>) copiaPaux.clone();
        if(pSacar.size()>0)
            copiaP.add(pSacar.get(0), new Vertice(p));  // la primera posicion que se ha sacado metemos el punto de interseccion

        return copiaP;
    }

    /** Elimina los puntos que quedan a la izquierda de un rayo dentro de un poligono(ultilizado para calcular el kernel) */
    public java.util.Vector<Vertice> quitarPuntosIzq(java.util.Vector<Vertice> copiaP, int tama, int i, Punto p){
        java.util.Vector<Vertice> copiaPaux = new java.util.Vector();
        java.util.Vector<Integer> pSacar=new java.util.Vector();
        boolean igual=false;

        for(int k=0;k<copiaP.size();k++){
            if(!copiaP.get(k).igual(lee(i)) && !copiaP.get(k).igual(lee((i+1)%tama))){
                if(copiaP.get(k).izquierdaSobre(lee((i+1)%tama), lee(i)) && !copiaP.get(k).entre(lee(i), lee((i+1)%tama))){
                    RectaPrm rprm=new RectaPrm(lee((i+1)%tama),lee(i));
                    RectaPrm rprmPer=rprm.perpendicularPunto(lee((i+1)%tama).Punto2Vector());
                    Recta r=new Recta(rprmPer.leeB().Vector2Punto(),rprmPer.leeB().suma(rprmPer.leeM()).Vector2Punto());
                    Rayo ry=new Rayo(lee((i+1)%tama),lee(i));
                    if(ry.leea().leex()>ry.leeb().leex()){
                        if(r.leeb().izquierda(lee((i+1)%tama), lee(i))){
                            if(copiaP.get(k).derecha(r.leea(), r.leeb())){
                                pSacar.add(k);
                            }
                        }else{
                            if(copiaP.get(k).izquierda(r.leea(), r.leeb()))
                                pSacar.add(k);
                        }
                    }else{
                        if(r.leeb().izquierda(lee((i+1)%tama), lee(i))){
                            if(copiaP.get(k).derecha(r.leea(), r.leeb())){
                                pSacar.add(k);
                            }
                        }else{
                            if(copiaP.get(k).izquierda(r.leea(), r.leeb()))
                                pSacar.add(k);
                        }
                    }
                }
            }
        }
        for(int k=0;k<copiaP.size();k++){
            igual=false;
            for(int z=0;z<pSacar.size();z++){
                if(pSacar.get(z)==k)
                    igual=true;
            }
            if(!igual)
                copiaPaux.add(copiaP.get(k));
        }
        copiaP=(java.util.Vector<Vertice>) copiaPaux.clone();
        if(pSacar.size()>0)
            copiaP.add(pSacar.get(0), new Vertice(p));  // la primera posicion que se ha sacado metemos el punto de interseccion

        return copiaP;
    }

    /** Comprueba si el poligono this es kernel del poligono pasado como parametro */
    private boolean esKernel(Poligono pol){
        Segmento s;

        for(int i=0;i<this.numeroVertices();i++){
            for(int j=0;j<pol.numeroVertices();j++){
                s=new Segmento(lee(i), pol.lee(j));
                for(int k=0;k<pol.numeroVertices();k++){
                    if(s.intersecta(new Segmento(pol.lee(k), pol.lee((k+1)%pol.numeroVertices()))))
                        return false;
                }
            }
        }
        return true;
    }

    /** Comprueba si es polgono(sus lados no se cortan) */
    public boolean esPoligono(){
        Segmento s1,s2;
        int tama = numeroVertices();

        for(int i=0;i<tama;i++){
            s1=new Segmento(lee(i), lee((i+1)%tama));
            for(int j=0;j<tama;j++){
                s2=new Segmento(lee(j), lee((j+1)%tama));
                if(s1.intersecta(s2)){
                    return false;
                }
            }
        }

        return true;
    }
}