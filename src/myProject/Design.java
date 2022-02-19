package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class Design  extends JPanel {

    private int step;
    private ImageIcon imagenFrame,imagenPanel;


    public Design(int option){
        step= option;

    }

    public void paintComponent(Graphics g){

        switch (step){
            case 1:
                imagenFrame= new ImageIcon(getClass().getResource("/myProject/recursos/inicio.jpg"));
                imagenFrame= new ImageIcon(imagenFrame.getImage().getScaledInstance(900,600, Image.SCALE_SMOOTH));
                g.drawImage(imagenFrame.getImage(),0,0,getWidth(),getHeight(),null);
                setOpaque(false);
                super.paintComponent(g);

                break;
            case 2:
                imagenPanel= new ImageIcon(getClass().getResource("/myProject/recursos/fondo2.jpg"));
                imagenPanel= new ImageIcon(imagenPanel.getImage().getScaledInstance(700,375, Image.SCALE_SMOOTH));
                g.drawImage(imagenPanel.getImage(),0,0,getWidth(),getHeight(),null);
                setOpaque(false);
                super.paintComponent(g);
                break;
        }

    }
}
