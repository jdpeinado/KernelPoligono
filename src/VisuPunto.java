/*
 * VisuPunto.java
 *
 * Created on 11 de octubre de 2006, 20:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */



import java.awt.*;


public class VisuPunto extends Vista {
    
    Punto vp;
    

    public VisuPunto (Punto p) {
        vp = p;
        
    }
    
    public Punto getPunto (){
        return vp;
    }
    
    public void pinta (Graphics g){
        int xp = convCoordX(vp.leex());
        int yp = convCoordY(vp.leey());
        int tama = 6;
        g.setColor(Color.BLACK);
        g.fillOval((int)xp-(int)(tama/2),(int)yp-(int)(tama/2),tama,tama);

    }
    
}