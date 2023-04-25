package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
        getTileImage();
    }
    public void getTileImage(){
        try{
            tile[0]= new Tile();
            tile[0].image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enviroment/grass01.png")));

            tile[1]=new Tile();
            tile[1].image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enviroment/wall.png")));

            tile[2]=new Tile();
            tile[2].image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enviroment/water01.png")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){
        int col=0;
        int row=0;
        int x=0;
        int y=0;
        while(col<gp.screenCol && row<gp.screenRow){
            g2.drawImage(tile[0].image,0,0,gp.size,gp.size,null);
            col++;
            x+=gp.size;

            if(col==gp.screenCol){
                col=0;
                x=0;
                row++;
                y+=gp.size;
            }
        }
    }
}
