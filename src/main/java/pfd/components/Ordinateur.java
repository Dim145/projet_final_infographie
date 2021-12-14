package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

import java.awt.*;

public class Ordinateur extends Composand3D
{
    public static final int LARGUEUR = 20;
    public static final int LONGUEUR = LARGUEUR * 2;
    public static final int EPAISSEUR = LONGUEUR / 20;
    public static final int HAUTEUR_ECRAN = 10;

    public static final int LARGEUR_TOUR = EPAISSEUR * 10;
    public static final int LARGEUR_CLAVIER = (int) (LARGEUR_TOUR / 2.25);


    private static PImage ecran = null;
    private static PImage clavier = null;
    private static PImage tour_avant = null;

    private final boolean tourGauche;

    public Ordinateur(PApplet applet, float baseX, float baseY, float baseZ, boolean tourGauche)
    {
        super(applet, baseX, baseY, baseZ);

        this.tourGauche = tourGauche;

        if(ecran == null)
            ecran = applet.loadImage("images/ordi.png");

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
        PShape finalShape = this.applet.createShape(GROUP);

        float baseZ = this.origZ + (this.tourGauche ? HAUTEUR_ECRAN : 0);

        PShape shape = applet.createShape();

        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.DARK_GRAY);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(ecran);
        shape.shininess(Utilities.IMAGE_SHININESS*4);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 1);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 1, 1);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ, 0, 0);
        shape.vertex(this.origX + EPAISSEUR + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + EPAISSEUR, this.origY + LARGUEUR + HAUTEUR_ECRAN, baseZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPied(float baseX, float baseZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        if (tourGauche) baseZ += HAUTEUR_ECRAN;

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlat(float baseZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        if (tourGauche) baseZ += HAUTEUR_ECRAN;

        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ + HAUTEUR_ECRAN + EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(origX + EPAISSEUR * 2, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerTour(boolean gauche)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        float baseZ = gauche ? this.origZ : this.origZ + LONGUEUR;
        float baseX = this.origX;

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        
        shape.textureMode(NORMAL);
        shape.texture(tour_avant);
        shape.shininess(Utilities.SUPER_MAT_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(1, 0, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ + HAUTEUR_ECRAN, 1, 0);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ + HAUTEUR_ECRAN, 1, 1);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY, baseZ, 0, 1);
        shape.vertex(baseX + LARGEUR_TOUR, this.origY + HAUTEUR_ECRAN * 2, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerClavier()
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        float baseZ = this.origZ + (tourGauche ? HAUTEUR_ECRAN : 0) + HAUTEUR_ECRAN;
        float baseX = this.origX + EPAISSEUR * 11;

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(PImage.NORMAL);
        shape.texture(clavier);
        shape.shininess(Utilities.SUPER_MAT_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 1, 1);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 1);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.BLACK);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ + HAUTEUR_ECRAN * 2 + EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.vertex(baseX + LARGEUR_CLAVIER, this.origY + EPAISSEUR / 2f, baseZ - EPAISSEUR / 2f, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
