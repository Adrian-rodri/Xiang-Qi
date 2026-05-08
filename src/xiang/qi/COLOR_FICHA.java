package xiang.qi;

import java.awt.Color;

/**
 *
 * @author adria
 */
public enum COLOR_FICHA {
    Rojo(1),Negro(2);
    private Color color;
    COLOR_FICHA(int i){
        switch(i){
            case 1:
                color=Color.red;
                break;
            case 2:
                color=Color.white;
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
