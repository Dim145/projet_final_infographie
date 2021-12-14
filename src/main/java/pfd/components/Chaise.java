package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
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

    public Chaise(PApplet applet, int origX, int origY, int origZ)
    {
        super(applet, origX, origY, origZ);

        if(plat == null)
            plat = applet.loadImage("images/plat.png");

        if(dossier_arriere == null)
            dossier_arriere = applet.loadImage("images/dossier_arriere.png");

        if(dossier_avant == null)
            dossier_avant = applet.loadImage("images/dossier.png");

        this.addChild(creerPlateau());
        this.addChild(creerDossier());
        this.addChild(creerPied(origX + 0.2f, origZ + 0.2f, false));
        this.addChild(creerPied(origX + 0.2f, origZ + 0.2f + COTE - EPAISSEUR_PLATEAU, false));
        this.addChild(creerPied(origX + 0.2f + COTE - EPAISSEUR_PLATEAU, origZ - 0.2f, true));
        this.addChild(creerPied(origX + 0.2f + COTE - EPAISSEUR_PLATEAU, origZ + 0.2f + COTE - EPAISSEUR_PLATEAU, true));
    }

    private PShape creerPied(float baseX, float baseZ, boolean arriere)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 1, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ, 1, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, -1);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU, 0, 0);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 1, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(baseX, this.origY, baseZ , 0, 0);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU, 1, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 0, 1);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 1, 1);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 0, 1);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 1, 1);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.tint(Utilities.RED);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU, 0, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ, 1, 1);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlateau()
    {
        PShape finalShape = applet.createShape(GROUP);

        PShape shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX, this.origY + COTE, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 1, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 0, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE, 0, 0);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 0, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 1, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX, this.origY + COTE, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE, 1, 0);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE, 1, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 0, 0);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 1, 1);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX, this.origY + COTE, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 1, 1);
        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE, 0, 0);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE, 1, 0);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ, 1, 1);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerDossier()
    {
        PShape finalShape = applet.createShape(GROUP);

        PShape shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(dossier_avant);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(dossier_arriere);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(plat);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 0);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT, 0, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 1);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
