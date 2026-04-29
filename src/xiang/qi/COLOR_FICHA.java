package xiang.qi;

import java.awt.Color;

/**
 *
 * @author adria
 */
public enum COLOR_FICHA {
    rojo(1),negro(2),verde(3);
    Color color;
    COLOR_FICHA(int i){
        switch(i){
            case 1:
                color=Color.red;
                break;
            case 2:
                color=Color.black;
                break;
            case 3:
                color=Color.green;
                break;
            
        }
    }
}
