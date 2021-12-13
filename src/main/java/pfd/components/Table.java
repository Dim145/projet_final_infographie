package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PShape;

public class Table extends Composand3D
{
    public static final int LARGUEUR = 50;
    public static final int LONGUEUR = (int) (LARGUEUR * 2.5);
    public static final int HAUTEUR  = LARGUEUR;

    public static final int EPAISSEUR_PLATEUR = HAUTEUR/10;

    public Table(PApplet applet)
    {
        this(applet, 0, 0, 0);
    }

    public Table(PApplet applet, int originX, int originY, int originZ)
    {
        super(applet, originX, originY, originZ);

        this.addChild(creerPlateau());
        this.addChild(creerPied(this.origX, this.origZ));
        this.addChild(creerPied(this.origX + LARGUEUR - EPAISSEUR_PLATEUR, this.origZ + LONGUEUR - EPAISSEUR_PLATEUR));
        this.addChild(creerPied(this.origX, this.origZ + LONGUEUR - EPAISSEUR_PLATEUR));
        this.addChild(creerPied(this.origX + LARGUEUR - EPAISSEUR_PLATEUR, this.origZ));
    }

    private PShape creerPied(int baseX, int baseZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX, this.origY, baseZ , 0, 0);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEUR , 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX, this.origY, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.vertex(baseX, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX, this.origY, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.BLACK);
        shape.shininess(Utilities.METAL_SHININESS);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ + EPAISSEUR_PLATEUR, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY, baseZ, 0, 0);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, this.origY + HAUTEUR, baseZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlateau()
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.fill(Utilities.DARK_GRAY);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape();
        shape.fill(Utilities.DARK_GRAY);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape();
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape();
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape();
        shape.fill(Utilities.DARK_GRAY);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape();
        shape.fill(Utilities.DARK_GRAY);
        shape.shininess(Utilities.MAT_SHININESS);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ + LONGUEUR, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR, this.origZ, 0, 0);
        shape.vertex(this.origX + LARGUEUR, this.origY + HAUTEUR + EPAISSEUR_PLATEUR, this.origZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
