package pfd.components;

import pfd.Utilities;
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
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 0, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ , 0, 0);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ , 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(Utilities.getDefaultImage(applet));
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 0, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
