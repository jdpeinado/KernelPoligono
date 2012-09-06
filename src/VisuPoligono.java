

import java.awt.*;


public class VisuPoligono extends Vista {
    
    Poligono vp;
    boolean relleno;
    /** Creates a new instance of VisuPunto */
    public VisuPoligono (Poligono p, boolean arelleno) {
        vp = p;
        relleno = arelleno;
    }
    
    public void pinta (Graphics g){
        Polygon p=new Polygon();

        // convertir las distintas coordenadas a posiciones de pantalla
        int tama = vp.numeroVertices();
        for (int i = 0; i<tama; i++){
           int sy = convCoordY(vp.lee(i).leey());
           int sx = convCoordX(vp.lee(i).leex());
           g.setColor(Color.GREEN);
           p.addPoint(sx, sy);
        }
        g.drawPolygon(p);
        if(relleno)
            g.fillPolygon(p);
    }
    
}