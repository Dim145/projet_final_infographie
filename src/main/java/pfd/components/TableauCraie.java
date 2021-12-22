package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class TableauCraie extends Composand3D
{
    public static final float EPAISSEUR = 5;
    public static final float HAUTEUR = Classe.HAUTEUR/2f;

    private final float longueur;

    public TableauCraie(PApplet applet, float origX, float origY, float origZ, float longueur)
    {
        super(applet, origX, origY, origZ);

        this.longueur = longueur;

        this.addChild(creerTab());
        this.addChild(creerRebord());
    }

    private Boite creerTab()
    {
        Boite b = new Boite(this.applet, this.origX, this.origY, this.origZ);

        b.tint(Utilities.VERT_FONCER);

        return b.finilize(EPAISSEUR, HAUTEUR, this.longueur);
    }

    private Boite creerRebord()
    {
        Boite b = new Boite(this.applet, this.origX, this.origY - 0.5f, this.origZ+0.5f);

        b.tint(Utilities.LIGHT_GRAY);

        return b.finilize(EPAISSEUR*2, EPAISSEUR/2f, this.longueur - 1f);
    }
}
