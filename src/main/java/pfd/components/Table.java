package pfd.components;

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
        shape.vertex(baseX, 0, baseZ);
        shape.vertex(baseX, HAUTEUR, baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, 0, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ + EPAISSEUR_PLATEUR);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, 0, baseZ );
        shape.vertex(baseX, 0, baseZ + EPAISSEUR_PLATEUR );
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ);
        shape.vertex(baseX, HAUTEUR, baseZ);
        shape.vertex(baseX, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX, 0, baseZ);
        shape.vertex(baseX, HAUTEUR, baseZ);
        shape.vertex(baseX, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX, 0, baseZ + EPAISSEUR_PLATEUR);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ + EPAISSEUR_PLATEUR);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, 0, baseZ);
        shape.vertex(baseX + EPAISSEUR_PLATEUR, HAUTEUR, baseZ);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }

    private PShape creerPlateau()
    {
        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.vertex(this.origX, HAUTEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ);

        shape.vertex(this.origX, HAUTEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ + LONGUEUR);

        shape.vertex(this.origX, HAUTEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ);

        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);

        shape.vertex(this.origX, HAUTEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);
        shape.vertex(this.origX, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX, HAUTEUR, this.origZ + LONGUEUR);

        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ + LONGUEUR);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR, this.origZ);
        shape.vertex(this.origX + LARGUEUR, HAUTEUR + EPAISSEUR_PLATEUR, this.origZ);

        shape.endShape();

        return shape;
    }
}
