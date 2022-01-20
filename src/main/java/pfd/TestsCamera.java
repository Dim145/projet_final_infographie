package pfd;

import gif.Gif;
import pfd.baseComponents.BaseProcessing;
import pfd.baseComponents.Face;
import pfd.components.*;

import processing.core.*;
import processing.event.Event;
import processing.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class TestsCamera extends BaseProcessing
{
    private static boolean isThisClassStratPoint = false;

    private Axis axis;

    protected Classe classe = null;
    protected final PVector translateValue = new PVector(0, 0, 0);

    private final HashMap<Character, KeyEvent> keysEvents = new HashMap<>();
    private PMatrix3D baseMat;
    private Curseur curseur;
    protected boolean drawAxis = true;

    private int dirX = 1;
    private int dirY = 1;

    private Gif gif = null;

    @Override
    public void setup()
    {
        super.setup();

        if(isThisClassStratPoint)
        {
            new Thread(() ->
            {
                classe = new Classe(this, 4, 3);

                translateValue.x = -(classe.getLargeur())  / 2f;
                translateValue.z = -(classe.getLongueur()) / 2f;

                classe.translate(translateValue.x, translateValue.y, translateValue.z);
            }).start();
        }

        axis = new Axis(0f, 0f, 0f, width*2, height*2, width*2, 2);

        baseMat = getMatrix(baseMat);

        this.gif = new Gif(this, "images/circle.gif", 15);
        gif.play();
    }

    @Override
    public void dessiner()
    {
        if(classe != null)
        {
            pushMatrix();

            if(drawAxis)
                axis.draw(this);

            shape(classe);

            if(curseur == null || centerX != curseur.getOrigX() || centerZ != curseur.getOrigZ() || centerY != curseur.getOrigY())
                curseur = new Curseur(this, centerX, centerY, centerZ);

            shape(curseur);

            for (KeyEvent event : this.keysEvents.values())
            {
                int keyCode = event.getKeyCode();

                if(keyCode == VK_SPACE || keyCode == VK_SHIFT)
                {
                    int mult = (keyCode == VK_SHIFT ? -1 : 1);

                    centerY += Utilities.PAS_DEPLACEMENT * mult;
                }

                if(event.getKey() == 'q' || keyCode == VK_D)
                {
                    int mult = (event.getKey() == 'q' ? -1 : 1);

                    centerZ += Utilities.PAS_DEPLACEMENT * mult;
                }

                if(event.isControlDown() && keyCode == VK_R)
                {
                    centerY = 0;
                    centerZ = 0;
                    centerX = 0;

                    phi = Utilities.DEFAULT_PHI;
                    theta = Utilities.DEFAULT_THETA;

                    tmpMouseX = Utilities.INITIAL_X_CAM_VALUE;
                    tmpMouseY = Utilities.INITIAL_Y_CAM_VALUE;
                }

                if(event.getKey() == 'z' || keyCode == VK_S)
                {
                    int mult = (event.getKey() == 'z' ? -1 : 1);

                    centerX += Utilities.PAS_DEPLACEMENT * mult * dirX;
                }
            }

            popMatrix();
        }

        this.setMatrix(baseMat);

        text("z q s d pour déplacement\nespace pour sauter\nclic bords pour tourner", 10, height-50);

        if(classe == null)
        {
            int widthTmp = sketchFullScreen() ? displayWidth : width;
            int heigthTmp = sketchFullScreen() ? displayHeight : height;

            image(this.gif, widthTmp/2f - this.gif.width/2f, heigthTmp /2f - this.gif.height/2f);

            float ts = g.textSize;
            textSize(50);
            text("CHARGEMENT", widthTmp/2f-150, heigthTmp/2f+10);
            textSize(ts);
        }
    }

    @Override
    public void mouseDragged()
    {
        if(classe == null) return;

        super.mouseDragged();

        dirX = theta < -100 && theta > -250 ? 1 : -1;
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        this.keysEvents.put(event.getKey(), event);
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        this.keysEvents.remove(event.getKey());

        if(event.getKey() == 'p')
            classe.rotatePorte();

        if(event.isControlDown() && event.getKeyCode() == VK_Q)
            this.drawAxis = !this.drawAxis;
    }

    public static void main(String[] args)
    {
        isThisClassStratPoint = true;
        PApplet.main(TestsCamera.class.getName());
    }
}
