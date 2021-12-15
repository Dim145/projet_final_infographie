package pfd;

import pfd.baseComponents.BaseProcessing;
import pfd.components.Classe;
import processing.core.PApplet;
import processing.core.PVector;

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

        translateValue.x = -(classe.getLargeur())/2f;
        translateValue.z = -(classe.getLongueur())/2f;

        classe.translate(translateValue.x, translateValue.y, translateValue.z);
        axis = new Axis(0f, 0f, 0f, width*2, height*2, width*2, 2);
    }

    @Override
    public void dessiner()
    {
        axis.draw(this);

        shape(classe);
    }

    public static void main(String[] args)
    {
        PApplet.main(TestsCamera.class.getName());
    }
}
