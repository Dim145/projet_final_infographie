package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Sol extends Composand3D
{
    public static final int EPAISSEUR = 5;

    private static PImage sol = null;

    public Sol(PApplet applet, float originX, float originY, float originZ, float finalX, float finalZ)
    {
        super(applet, originX, originY, originZ);

        if(sol == null)
            sol = applet.loadImage("images/sol.png");

        this.addChild(creerSol(finalX, finalZ));
    }

    private PShape creerSol(float finalX, float finalZ)
    {
        PShape finalShape = this.applet.createShape(GROUP);

        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 0, 1);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 1, 1);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 1, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 1);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 1, 1);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ , 0, 0);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ , 0, 1);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 1, 1);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 1, 1);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + EPAISSEUR, this.origZ + finalZ, 1, 1);
        shape.vertex(this.origX, this.origY, this.origZ + finalZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(sol);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ + finalZ, 0, 0);
        shape.vertex(this.origX + finalX, this.origY, this.origZ + finalZ, 0, 1);
        shape.vertex(this.origX + finalX, this.origY, this.origZ, 1, 1);
        shape.vertex(this.origX + finalX, this.origY + EPAISSEUR, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        return finalShape;
    }
}
