package pfd;

import pfd.baseComponents.BaseProcessing;
import pfd.components.Classe;
import pfd.components.Table;
import processing.core.PApplet;

public class TestsCamera extends BaseProcessing
{
    private Axis axis;

    private Classe classe = null;

    @Override
    public void setup()
    {
        super.setup();

        classe = new Classe(this, 4, 3);
        
        classe.translate(-(Table.LONGUEUR*4)/2f, 0, -(Table.LONGUEUR*3)/2f);
        axis = new Axis(0f, 0f, 0f, width, height, width, 2);
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
