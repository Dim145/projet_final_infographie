package pfd;

import pfd.baseComponents.BaseProcessing;
import pfd.components.Boite;
import pfd.components.Classe;

import pfd.components.Curseur;
import pfd.components.Mur;
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
    private Axis axis;

    protected Classe classe = null;
    protected final PVector translateValue = new PVector(0, 0, 0);

    private final HashMap<Character, KeyEvent> keysEvents = new HashMap<>();
    private PMatrix3D baseMat;
    private Curseur curseur;
    private boolean drawAxis = true;

    @Override
    public void setup()
    {
        super.setup();

        classe = new Classe(this, 4, 3);

        translateValue.x = -(classe.getLargeur())  / 2f;
        translateValue.z = -(classe.getLongueur()) / 2f;

        classe.translate(translateValue.x, translateValue.y, translateValue.z);
        axis = new Axis(0f, 0f, 0f, width*2, height*2, width*2, 2);

        baseMat = getMatrix(baseMat);
    }

    @Override
    public void dessiner()
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
            }

            if(event.getKey() == 'z' || keyCode == VK_S)
            {
                int mult = (event.getKey() == 'z' ? -1 : 1);

                centerX += Utilities.PAS_DEPLACEMENT * mult;
            }
        }

        popMatrix();

        this.setMatrix(baseMat);

        text("z q s d pour déplacement\nespace pour monter\nshift pour descendre", 10, height-30);
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
        PApplet.main(TestsCamera.class.getName());
    }
}
