package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Table extends Composand3D
{
    public static final int LARGUEUR = 50;
    public static final int LONGUEUR = (int) (LARGUEUR * 2.5);
    public static final int HAUTEUR  = LARGUEUR;

    public static final int EPAISSEUR_PLATEUR = HAUTEUR/10;

    private static PImage haut;

    public Table(PApplet applet)
    {
        this(applet, 0, 0, 0);
    }

    public Table(PApplet applet, float originX, float originY, float originZ)
    {
        super(applet, originX, originY, originZ);

        if(haut == null)
            haut = applet.loadImage("images/table.png");

        this.addChild(creerPlateau());
        this.addChild(creerPied(this.origX, this.origZ));
        this.addChild(creerPied(this.origX + LARGUEUR - EPAISSEUR_PLATEUR, this.origZ + LONGUEUR - EPAISSEUR_PLATEUR));
        this.addChild(creerPied(this.origX, this.origZ + LONGUEUR - EPAISSEUR_PLATEUR));
        this.addChild(creerPied(this.origX + LARGUEUR - EPAISSEUR_PLATEUR, this.origZ));
    }

    private PShape creerPied(float baseX, float baseZ)
    {
        Boite b = new Boite(applet, baseX, this.origY, baseZ);

        b.shininess(Utilities.METAL_SHININESS);
        b.tint(Utilities.BLACK);

        return b.finalize(EPAISSEUR_PLATEUR, HAUTEUR, EPAISSEUR_PLATEUR);
    }

    private PShape creerPlateau()
    {
        Boite b = new Boite(this.applet, this.origX, this.origY + HAUTEUR, this.origZ);

        b.tint(Integer.valueOf(Utilities.DARK_GRAY));
        b.tint(Face.DESSU, Utilities.CYAN).texture(Face.DESSU, haut);
        b.tint(Face.DESSOU, null);

        return b.finalize(LARGUEUR, EPAISSEUR_PLATEUR, LONGUEUR);
    }
}
