package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Ordinateur extends Composand3D
{
    public static final int LARGUEUR = 20;
    public static final int LONGUEUR = LARGUEUR * 2;
    public static final int EPAISSEUR = LONGUEUR / 20;
    public static final int HAUTEUR_ECRAN = 10;

    public static final int LARGEUR_TOUR = EPAISSEUR * 10;
    public static final int LARGEUR_CLAVIER = (int) (LARGEUR_TOUR / 2.25);

    private static PImage clavier = null;
    private static PImage tour_avant = null;

    private static PImage[] images = null;

    private final PImage ecran;
    private int selectedIndex;

    private final boolean tourGauche;

    public Ordinateur(PApplet applet, float baseX, float baseY, float baseZ, boolean tourGauche)
    {
        super(applet, baseX, baseY, baseZ);

        this.tourGauche = tourGauche;

        if(images == null)
        {
            images = new PImage[4];

            images[0] = applet.loadImage("images/ordi.png");
            images[1] = applet.loadImage("images/minecraft.png");
            images[2] = applet.loadImage("images/processing.png");
            images[3] = applet.loadImage("images/youtube.png");
        }

        selectedIndex = ((int) (Math.random() * images.length));

        this.ecran = images[selectedIndex];

        if(clavier == null)
            clavier = applet.loadImage("images/clavier.png");

        if(tour_avant == null)
            tour_avant = applet.loadImage("images/tour_avant.png");

        if (!tourGauche) this.origZ -= HAUTEUR_ECRAN;

        this.addChild(creerEcran());
        this.addChild(creerPlat(this.origZ + (LONGUEUR - HAUTEUR_ECRAN) / 2f));
        this.addChild(creerTour(tourGauche));
        this.addChild(creerClavier());
        this.origY += 1;
        this.addChild(creerPied(baseX + 0.5f, this.origZ + (LONGUEUR - HAUTEUR_ECRAN) / 2f));
    }

    public Ordinateur(PApplet applet)
    {
        this(applet, 0, 0, 0, false);
    }

    private PShape creerEcran()
    {
        float baseZ = this.origZ + (this.tourGauche ? HAUTEUR_ECRAN : 0);

        Boite b = new Boite(this.applet, this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);

        b.tint(Utilities.BLACK);
        b.shininess(Utilities.MAT_SHININESS);

        b.tint(Face.DERRIERE, Utilities.DARK_GRAY);

        // images 1 et 2 trop blanches. Pour evité cela, mise en place d'un filtre gris
        b.tint(Face.DEVANT, selectedIndex == 1 || selectedIndex == 2 ? Utilities.DARK_WHITE : null).texture(Face.DEVANT, ecran).setShininess(Face.DEVANT.ordinal(), Utilities.IMAGE_SHININESS*2);

        return b.finalize(EPAISSEUR, LARGUEUR, LONGUEUR);
    }

    private PShape creerPied(float baseX, float baseZ)
    {
        if (tourGauche) baseZ += HAUTEUR_ECRAN;

        Boite b = new Boite(applet, baseX, this.origY, baseZ);

        b.tint(Integer.valueOf(Utilities.BLACK)).shininess(Utilities.MAT_SHININESS);

        return b.finalize(EPAISSEUR, HAUTEUR_ECRAN * 2, HAUTEUR_ECRAN);
    }

    private PShape creerPlat(float baseZ)
    {
        if (tourGauche) baseZ += HAUTEUR_ECRAN;

        Boite b = new Boite(applet, this.origX, this.origY, baseZ - EPAISSEUR / 2f);

        b.tint(Integer.valueOf(Utilities.BLACK)).shininess(Utilities.MAT_SHININESS);

        return b.finalize(EPAISSEUR * 2, EPAISSEUR/2f, HAUTEUR_ECRAN + EPAISSEUR);
    }

    private PShape creerTour(boolean gauche)
    {
        Boite b = new Boite(applet, this.origX, this.origY, gauche ? this.origZ : this.origZ + LONGUEUR);

        b.tint(Integer.valueOf(Utilities.BLACK)).shininess(Utilities.MAT_SHININESS);

        b.tint(Face.DEVANT, null).texture(Face.DEVANT, tour_avant).setShininess(Face.DEVANT.ordinal(), Utilities.SUPER_MAT_SHININESS);

        return b.finalize(LARGEUR_TOUR, HAUTEUR_ECRAN*2, HAUTEUR_ECRAN);
    }

    private PShape creerClavier()
    {
        float baseZ = this.origZ + (tourGauche ? HAUTEUR_ECRAN : 0) + HAUTEUR_ECRAN;

        Boite b = new Boite(applet, this.origX + EPAISSEUR * 11, this.origY, baseZ - EPAISSEUR / 2f);

        b.tint(Integer.valueOf(Utilities.BLACK)).shininess(Utilities.MAT_SHININESS);

        b.tint(Face.DESSU, null).texture(Face.DESSU, clavier).setShininess(Face.DESSU.ordinal(), Utilities.SUPER_MAT_SHININESS);

        return b.finalize(LARGEUR_CLAVIER, EPAISSEUR / 2f, HAUTEUR_ECRAN * 2);
    }
}
