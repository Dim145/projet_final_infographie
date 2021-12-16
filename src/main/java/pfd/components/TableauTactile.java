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
        this.addChild(creerH());

        for (PShape p : this.listChild)
            p.rotateY(PApplet.radians(-45));
    }

    private Boite creerH()
    {
        Boite barGauche = new Boite(applet, this.origX - LARGEUR*2, this.origY, this.origZ + LARGEUR*1.5f);

        barGauche.tint(Integer.valueOf(Utilities.LIGHT_BLACK)).shininess(Utilities.MAT_SHININESS);

        barGauche.finilize(LARGEUR*3, LARGEUR/2f, LARGEUR);

        Boite barTransversale = new Boite(applet, barGauche.getOrigX() + LARGEUR, this.origY, barGauche.getOrigZ() + LARGEUR);

        barTransversale.tint(Integer.valueOf(Utilities.LIGHT_BLACK)).shininess(Utilities.MAT_SHININESS);

        barGauche.addChild(barTransversale.finilize(LARGEUR, barGauche.getHauteur(), LONGEUR - LARGEUR*2.5f*2));

        Boite barDroite = new Boite(applet, barGauche.getOrigX(), this.origY, this.origZ + LONGEUR - LARGEUR*2.5f);

        barDroite.tint(Integer.valueOf(Utilities.LIGHT_BLACK)).shininess(Utilities.MAT_SHININESS);

        barGauche.addChild(barDroite.finilize(barGauche.getLargeur(), barGauche.getHauteur(), barGauche.getLongeur()));

        return barGauche;
    }

    private Boite creerPied()
    {
        Boite b = new Boite(applet, this.origX - LARGEUR/2f, this.origY + LARGEUR, this.origZ + LONGEUR/2 - LARGEUR);

        b.tint(Integer.valueOf(Utilities.LIGHT_BLACK)).shininess(Utilities.MAT_SHININESS);

        return b.finilize(LARGEUR, HAUTEUR_ECRAN * 1.25f, LARGEUR*2);
    }

    private Boite creerEcran()
    {
        Boite b = new Boite(applet, this.origX, this.origY + HAUTEUR_ECRAN, this.origZ);

        b.tint(Integer.valueOf(Utilities.LIGHT_BLACK)).shininess(Utilities.SUPER_MAT_SHININESS);
        b.tint(Face.DEVANT, null).texture(Face.DEVANT, ecranGif).setShininess(Face.DEVANT.ordinal(), Utilities.IMAGE_SHININESS);

        return b.finilize(LARGEUR, HAUTEUR_ECRAN, LONGEUR);
    }
}
