package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PShape;

import java.util.Arrays;

public class Mur extends Composand3D
{
    private final PShape finalShape;
    private boolean isFinilise;

    /**
     * 0: droite (dir: -z) <br/>
     * 1: gauche (dir: z) <br/>
     * 2: dessou (dir: -y) <br/>
     * 3: dessu  (dir: y)<br/>
     * 4: derriere (dir: -x) <br/>
     * 5: devant (dir: (x)
     */
    private final PImage[] images;
    private final float[] shininesss;

    public Mur(PApplet applet, float baseX, float baseY, float baseZ)
    {
        super(applet, baseX, baseY, baseZ);

        this.images = new PImage[6];
        this.shininesss = new float[images.length];

        Arrays.fill(this.images, Utilities.getDefaultImage(applet));
        Arrays.fill(this.shininesss, Utilities.IMAGE_SHININESS);

        this.finalShape = applet.createShape(GROUP);
        this.addChild(this.finalShape);

        this.isFinilise = false;
    }

    @Override
    public void setShininess(float shine)
    {
        super.setShininess(shine);

        Arrays.fill(this.shininesss, shine);
    }

    @Override
    public void setShininess(int index, float shine)
    {
        super.setShininess(index, shine);

        this.shininesss[index] = shine;
    }

    @Override
    public void shininess(float shine)
    {
        super.shininess(shine);

        Arrays.fill(this.shininesss, shine);
    }

    @Override
    public void texture(PImage tex)
    {
        Arrays.fill(this.images, tex);
    }

    @Override
    public void setTexture(PImage tex)
    {
        texture(tex);
    }

    @Override
    public void noTexture()
    {
        Arrays.fill(this.images, Utilities.getDefaultImage(this.applet));
    }

    public void setTexture(int index, PImage image)
    {
        this.images[index] = image;
    }

    public void texture(int index, PImage image)
    {
        setTexture(index, image);
    }

    public Mur finilize(float largeur, float hauteur, float longeur)
    {
        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[0]);
        shape.shininess(this.shininesss[0]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, -1);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ, 0, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ, 1, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ, 1, 0);
        shape.endShape();

        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[1]);
        shape.shininess(this.shininesss[1]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX, this.origY, this.origZ + longeur, 0, 0);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ + longeur, 0, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ + longeur, 1, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ + longeur, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[2]);
        shape.shininess(this.shininesss[2]);
        shape.emissive(0, 0, 0);
        shape.normal(0, -1, 0);
        shape.vertex(this.origX, this.origY, this.origZ , 0, 0);
        shape.vertex(this.origX, this.origY, this.origZ + longeur , 0, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ + longeur, 1, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[3]);
        shape.shininess(this.shininesss[0]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ + longeur, 0, 0);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ, 1, 1);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ + longeur, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[4]);
        shape.shininess(this.shininesss[4]);
        shape.emissive(0, 0, 0);
        shape.normal(-1, 0, 0);
        shape.vertex(this.origX, this.origY, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ + longeur, 1, 1);
        shape.vertex(this.origX, this.origY, this.origZ + longeur, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[5]);
        shape.shininess(this.shininesss[5]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ + longeur, 0, 0);
        shape.vertex(this.origX + largeur, this.origY, this.origZ + longeur, 0, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ, 1, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        this.isFinilise = true;

        return this;
    }

    @Override
    public void draw(PGraphics g)
    {
        if(!isFinilise)
            this.finilize(10, 10, 10);

        super.draw(g);
    }
}
