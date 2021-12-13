package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PShape;

public class Chaise extends Composand3D
{
    public static final int COTE = 30;
    public static final int HAUTEUR = COTE * 2;
    public static final int EPAISSEUR_PLATEAU = COTE/10;
    public static final float RATIO_DOSSIER_DEPASSEMENT = 8;

    public Chaise(PApplet applet)
    {
        this(applet, 0, 0, 0);
    }

    public Chaise(PApplet applet, int origX, int origY, int origZ)
    {
        super(applet, origX, origY, origZ);

        this.addChild(creerPlateau());
        this.addChild(creerDossier());
        this.addChild(creerPied(origX, origZ, false));
        this.addChild(creerPied(origX, origZ + COTE - EPAISSEUR_PLATEAU, false));
        this.addChild(creerPied(origX + COTE - EPAISSEUR_PLATEAU, origZ, true));
        this.addChild(creerPied(origX + COTE - EPAISSEUR_PLATEAU, origZ + COTE - EPAISSEUR_PLATEAU, true));
    }

    private PShape creerPied(int baseX, int baseZ, boolean arriere)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ );
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, this.origY, baseZ);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.vertex(baseX, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ + EPAISSEUR_PLATEAU);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY, baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEAU, this.origY + (arriere ? HAUTEUR : COTE), baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlateau()
    {
        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.vertex(this.origX, this.origY + COTE, this.origZ);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ);

        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE);

        shape.vertex(this.origX, this.origY + COTE, this.origZ);
        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ);

        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);

        shape.vertex(this.origX, this.origY + COTE, this.origZ);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);
        shape.vertex(this.origX, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);
        shape.vertex(this.origX, this.origY + COTE, this.origZ + COTE);

        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ + COTE);
        shape.vertex(this.origX + COTE, this.origY + COTE, this.origZ);
        shape.vertex(this.origX + COTE, this.origY + COTE + EPAISSEUR_PLATEAU, this.origZ);

        shape.endShape();

        return shape;
    }

    private PShape creerDossier()
    {
        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + COTE + COTE/2f, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ - COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2 + EPAISSEUR_PLATEAU, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);
        shape.vertex(this.origX + COTE - EPAISSEUR_PLATEAU *2, this.origY + HAUTEUR, this.origZ + COTE + COTE/RATIO_DOSSIER_DEPASSEMENT);

        shape.endShape();

        return shape;
    }
}
