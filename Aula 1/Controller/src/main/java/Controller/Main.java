/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;
import java.awt.*;
import static java.lang.Thread.sleep;
import javax.swing.*; 

/**
 *
 * @author ia941
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    NewJFrame gui;
    Creature c;
    
    
    //public Main(NewJFrame in) { gui = in; }
    public Main(Creature c){
        this.c = c;
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        WS3DProxy proxy = new WS3DProxy();
        try {   
            World w = World.getInstance();
            w.reset();
            World.createFood(0, 350, 75);
            World.createFood(0, 100, 220);
            World.createFood(0, 250, 210);
            Main m = new Main(proxy.createCreature(250,450,0));
            //m.c.start();
            NewJFrame f = new NewJFrame(m);
            f.setVisible(true);
        } catch (CommandExecException e) {
            System.out.println("Erro capturado");
        }  
    }
    
}
