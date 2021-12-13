package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PShape;

public class Sol extends Composand3D
{
    public static final int EPAISSEUR = 5;

    public Sol(PApplet applet, int originX, int originY, int originZ, int finalX, int finalZ)
    {
        super(applet, originX, originY, originZ);

        this.addChild(creerSol(finalX, finalZ));
    }

    private PShape creerSol(int finalX, int finalZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.vertex(this.origX, this.origY, this.origZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ);
        shape.vertex(this.origX + finalX, this.origY, this.origZ);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(this.origX, this.origY, this.origZ );
        shape.vertex(this.origX, this.origY, this.origZ + finalZ );
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY, this.origZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(this.origX, this.origY, this.origZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ);
        shape.vertex(this.origX + finalX, this.origY, this.origZ);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
