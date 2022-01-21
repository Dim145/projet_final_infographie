package pfd.components;

import pfd.Utilities;
import processing.core.PApplet;

public class Curseur extends Boite
{
    public static final int TAILLE = 10;

    public Curseur(PApplet applet, float origX, float origY, float origZ)
    {
        super(applet, origX - TAILLE/2f, origY - TAILLE/2f, origZ - TAILLE/2f);

        this.tint(Utilities.RED);

        this.finalize(TAILLE, TAILLE, TAILLE);
    }
}
