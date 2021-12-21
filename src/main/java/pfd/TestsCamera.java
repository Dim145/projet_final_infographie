package pfd;

import pfd.baseComponents.BaseProcessing;
import pfd.components.Classe;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.Event;
import processing.event.KeyEvent;

public class TestsCamera extends BaseProcessing
{
    private Axis axis;

    protected Classe classe = null;
    protected final PVector translateValue = new PVector(0, 0, 0);

    @Override
    public void setup()
    {
        super.setup();

        classe = new Classe(this, 4, 3);

        translateValue.x = -(classe.getLargeur())  / 2f;
        translateValue.z = -(classe.getLongueur()) / 2f;

        classe.translate(translateValue.x, translateValue.y, translateValue.z);
        axis = new Axis(0f, 0f, 0f, width*2, height*2, width*2, 2);
    }

    @Override
    public void dessiner()
    {
        axis.draw(this);

        shape(classe);
    }

    @Override
    public void keyTyped(KeyEvent event)
    {
        int keyCode = event.getKeyCode();

        System.out.println(keyCode);

        if(keyCode == java.awt.event.KeyEvent.VK_DOWN || keyCode == java.awt.event.KeyEvent.VK_UP)
        {
            int mult = (keyCode == java.awt.event.KeyEvent.VK_DOWN ? -1 : 1);

            centerY += 10 * mult;
        }

        if(keyCode == java.awt.event.KeyEvent.VK_LEFT || keyCode == java.awt.event.KeyEvent.VK_RIGHT)
        {
            int mult = (keyCode == java.awt.event.KeyEvent.VK_LEFT ? -1 : 1);

            centerZ += 10 * mult;
        }

        if(event.isControlDown() && keyCode == java.awt.event.KeyEvent.VK_R)
        {
            centerY = 0;
            centerZ = 0;

            phi = Utilities.DEFAULT_PHI;
            theta = Utilities.DEFAULT_THETA;
        }

        if(key == 'z' || keyCode == java.awt.event.KeyEvent.VK_S)
        {
            int mult = (key == 'z' ? -1 : 1);

            centerX += 10 * mult;
            camX += 10 *mult;
        }
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        keyTyped(event);
    }

    public static void main(String[] args)
    {
        PApplet.main(TestsCamera.class.getName());
    }
}
