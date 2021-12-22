package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class TableauCraie extends Composand3D
{
    public static final float EPAISSEUR = 5;
    public static final float HAUTEUR = Classe.HAUTEUR/2f;

    private static PImage tableau = null;

    private final float longueur;

    public TableauCraie(PApplet applet, float origX, float origY, float origZ, float longueur)
    {
        super(applet, origX, origY, origZ);

        if(tableau == null)
            tableau = applet.loadImage("images/tab.jpg");

        this.longueur = longueur;

        this.addChild(creerTab());
        this.addChild(creerRebord());
    }

    private Boite creerTab()
    {
        Boite b = new Boite(this.applet, this.origX, this.origY, this.origZ);

        b.tint(Utilities.VERT_FONCER);

        b.tint(Face.DEVANT, Color.GREEN.getRGB()).texture(Face.DEVANT, tableau);

        return b.finilize(EPAISSEUR, HAUTEUR, this.longueur);
    }

    private Boite creerRebord()
    {
        Boite b = new Boite(this.applet, this.origX, this.origY - 0.5f, this.origZ+0.5f);

        b.tint(Utilities.LIGHT_GRAY);

        return b.finilize(EPAISSEUR*2, EPAISSEUR/2f, this.longueur - 1f);
    }
}
