
package petshop.custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRounded extends JPanel {

    private int roundTopLeft = 30;
    int roundTopRight = 30;
    int roundBottomLeft = 30;
    int roundBottomRight = 30;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
    }
    
    
    
    public PanelRounded() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D g2 = (Graphics2D) graphic.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        
        
        Area area = new Area(createRoundTopLeft());
        
        if(roundTopRight>0){
            area.intersect(new Area(createRoundTopRight()));
        }
        
        if(roundBottomLeft>0){
            area.intersect(new Area(createRoundBottomLeft()));
        }
        
        if(roundBottomRight>0){
            area.intersect(new Area(createRoundBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        super.paintComponent(graphic);
    }

    private Shape createRoundTopLeft(){
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundTopLeft);
        int roundY=Math.min(height, roundTopLeft);
                
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundTopRight(){
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundTopRight);
        int roundY=Math.min(height, roundTopRight);
                
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundBottomLeft(){
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundBottomLeft);
        int roundY=Math.min(height, roundBottomLeft);
                
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundBottomRight(){
        int width = getWidth();
        int height = getHeight();
        int roundX=Math.min(width, roundBottomRight);
        int roundY=Math.min(height, roundBottomRight);
                
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
    
    
}
