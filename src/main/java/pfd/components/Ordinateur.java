package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PShape;

public class Ordinateur extends Composand3D
{
    public static final int LARGUEUR = 20;
    public static final int LONGUEUR = LARGUEUR * 2;
    public static final int EPAISSEUR = LONGUEUR /20;
    public static final int HAUTEUR_ECRAN = 10;

    public static final int LARGEUR_TOUR = EPAISSEUR * 10;
    public static final int LARGEUR_CLAVIER = (int) (LARGEUR_TOUR/2.25);

    private final boolean tourGauche;

    public Ordinateur(PApplet applet, int baseX, int baseY, int baseZ, boolean tourGauche)
    {
        super(applet, baseX, baseY, baseZ);

        this.tourGauche = tourGauche;

        if(!tourGauche)
            this.origZ -= HAUTEUR_ECRAN;

        this.addChild(creerEcran());
        this.addChild(creerPlat(this.origZ + (LONGUEUR - HAUTEUR_ECRAN)/2f));
        this.addChild(creerTour(tourGauche));
        this.addChild(creerClavier());
        this.origY += 1;
        this.addChild(creerPied(baseX + 0.5f, this.origZ + (LONGUEUR - HAUTEUR_ECRAN)/2f));
    }

    public Ordinateur(PApplet applet)
    {
        this(applet, 0, 0, 0, false);
    }

    private PShape creerEcran()
    {
        PShape shape = this.applet.createShape();

        int baseZ = this.origZ + (this.tourGauche ? HAUTEUR_ECRAN : 0);

        shape.beginShape(QUADS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);

        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);

        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);

        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);

        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR);

        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR);

        shape.endShape();

        return shape;
    }

    private PShape creerPied(float baseX, float baseZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        if(tourGauche)
            baseZ += HAUTEUR_ECRAN;

        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ );
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN );
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlat(float baseZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        if(tourGauche)
            baseZ += HAUTEUR_ECRAN;

        shape.beginShape(QUADS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ - EPAISSEUR/2f);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX  + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR/2f );
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f );
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ - EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(origX + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(origX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(origX + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(origX + EPAISSEUR*2, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerTour(boolean gauche)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        int baseZ = gauche ? this.origZ : this.origZ + LONGUEUR;
        int baseX = this.origX;

        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ );
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN );
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN*2, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerClavier()
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        int baseZ = this.origZ + (tourGauche ? HAUTEUR_ECRAN : 0) + HAUTEUR_ECRAN;
        int baseX = this.origX + EPAISSEUR*11;

        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR/2f);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR/2f );
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f );
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN*2 + EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR/2f);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR/2f, baseZ - EPAISSEUR/2f);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
