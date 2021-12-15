package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Chaise extends Composand3D
{
    public static final int COTE = 30;
    public static final int HAUTEUR = COTE * 2;
    public static final int EPAISSEUR_PLATEAU = COTE/10;
    public static final float RATIO_DOSSIER_DEPASSEMENT = 8;

    private static PImage dossier_avant = null;
    private static PImage dossier_arriere = null;
    private static PImage plat = null;

    public Chaise(PApplet applet)
    {
        this(applet, 0, 0, 0);
    }

    public Chaise(PApplet applet, float origX, float origY, float origZ)
    {
        this(applet, origX, origY, origZ, false);
    }

    public Chaise(PApplet applet, float origX, float origY, float origZ, boolean sensInverser)
    {
        super(applet, origX, origY, origZ);

        if(plat == null)
            plat = applet.loadImage("images/plat.png");

        if(dossier_arriere == null)
            dossier_arriere = applet.loadImage("images/dossier_arriere.png");

        if(dossier_avant == null)
            dossier_avant = applet.loadImage("images/dossier.png");

        this.addChild(creerPlateau());
        this.addChild(creerDossier(sensInverser));
        this.addChild(creerPied(origX + 0.2f, origZ + 0.2f, sensInverser));
        this.addChild(creerPied(origX + 0.2f, origZ + 0.2f + COTE - EPAISSEUR_PLATEAU, sensInverser));
        this.addChild(creerPied(origX + 0.2f + COTE - EPAISSEUR_PLATEAU, origZ - 0.2f, !sensInverser));
        this.addChild(creerPied(origX + 0.2f + COTE - EPAISSEUR_PLATEAU, origZ + 0.2f + COTE - EPAISSEUR_PLATEAU, !sensInverser));
    }

    private PShape creerPied(float baseX, float baseZ, boolean arriere)
    {
        Boite b = new Boite(applet, baseX, this.origY, baseZ);

        b.tint(Utilities.RED);

        return b.finilize(EPAISSEUR_PLATEAU, (arriere ? HAUTEUR : COTE), EPAISSEUR_PLATEAU);
    }

    private PShape creerPlateau()
    {
        Boite b = new Boite(applet, origX, origY + COTE, origZ);

        b.texture(plat);

        return b.finilize(COTE, EPAISSEUR_PLATEAU, COTE);
    }

    private PShape creerDossier(boolean sensInverser)
    {
        Boite b = new Boite(applet, this.origX + (sensInverser ? EPAISSEUR_PLATEAU : COTE - EPAISSEUR_PLATEAU *2), this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);

        b.texture(plat);

        b.texture(Face.DERRIERE, dossier_avant).texture(Face.DERRIERE, dossier_arriere);

        return b.finilize(EPAISSEUR_PLATEAU, HAUTEUR*0.25f, COTE + (COTE/RATIO_DOSSIER_DEPASSEMENT)*2);
    }
}
