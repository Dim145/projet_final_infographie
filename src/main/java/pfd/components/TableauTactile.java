package pfd.components;

import gif.Gif;
import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class TableauTactile extends Composand3D
{
    public static final float LONGEUR = Table.LONGUEUR;
    public static final float LARGEUR = LONGEUR/10f;
    public static final float HAUTEUR_ECRAN = Table.HAUTEUR * 1.5f;

    private static PImage ecran = null;
    private final Gif ecranGif;

    public TableauTactile(PApplet applet, float x, float y, float z)
    {
        super(applet, x, y, z);

        if(ecran == null)
            ecran = applet.loadImage("images/tableau_tactile.png");

        this.ecranGif = new Gif(applet, "images/circle.gif", 15);
        ecranGif.play();

        this.addChild(creerEcran());
        this.addChild(creerPied());

        for (PShape p : this.listChild)
            p.rotateY(PApplet.radians(-45));
    }

    private PShape creerPied()
    {
        Boite b = new Boite(applet, this.origX - LARGEUR, this.origY + LARGEUR, this.origZ + LONGEUR/2 - LARGEUR);

        return b.finilize(LARGEUR, HAUTEUR_ECRAN * 1.25f, LARGEUR*2);
    }

    private PShape creerEcran()
    {
        Boite b = new Boite(applet, this.origX, this.origY + HAUTEUR_ECRAN, this.origZ);

        b.tint(Integer.valueOf(Utilities.BLACK)).shininess(Utilities.SUPER_MAT_SHININESS);
        b.tint(Face.DEVANT, null).texture(Face.DEVANT, ecranGif).setShininess(Face.DEVANT.ordinal(), Utilities.IMAGE_SHININESS);

        return b.finilize(LARGEUR, HAUTEUR_ECRAN, LONGEUR);
    }
}
