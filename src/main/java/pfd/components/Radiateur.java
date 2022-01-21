package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PImage;

public class Radiateur extends Composand3D
{
    public static final float HAUTEUR = Classe.HAUTEUR/3/2;
    public static final float LONGUEUR = HAUTEUR*3;
    public static final float EPAISSEUR = 3;

    private static PImage image = null;

    public Radiateur(PApplet applet, float origX, float origY, float origZ)
    {
        super(applet, origX, origY, origZ);

        if(image == null)
            image = applet.loadImage("images/radiateur.png");

        this.addChild(creerRadiateur());
    }

    private Boite creerRadiateur()
    {
        Boite b = new Boite(applet, this.origX, this.origY, this.origZ);

        b.texture(image);

        return b.finalize(LONGUEUR, HAUTEUR, EPAISSEUR);
    }
}
