package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PShape;

import java.util.Arrays;

public class Boite extends Composand3D
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

    /**
     * 0: droite (dir: -z) <br/>
     * 1: gauche (dir: z) <br/>
     * 2: dessou (dir: -y) <br/>
     * 3: dessu  (dir: y)<br/>
     * 4: derriere (dir: -x) <br/>
     * 5: devant (dir: (x)
     */
    private final float[] shininesss;

    /**
     * 0: droite (dir: -z) <br/>
     * 1: gauche (dir: z) <br/>
     * 2: dessou (dir: -y) <br/>
     * 3: dessu  (dir: y)<br/>
     * 4: derriere (dir: -x) <br/>
     * 5: devant (dir: (x)
     */
    private final Integer[] tints;

    public Boite(PApplet applet, float baseX, float baseY, float baseZ)
    {
        super(applet, baseX, baseY, baseZ);

        this.images = new PImage[6];
        this.shininesss = new float[images.length];
        this.tints = new Integer[shininesss.length];

        Arrays.fill(this.images, Utilities.getDefaultImage(applet));
        Arrays.fill(this.shininesss, Utilities.IMAGE_SHININESS);
        Arrays.fill(this.tints, -1);

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

    public Boite setTexture(Face index, PImage image)
    {
        this.images[index.ordinal()] = image;

        return this;
    }

    public Boite texture(Face index, PImage image)
    {
        return setTexture(index, image);
    }

    @Override
    public void tint(int rgb)
    {
        tint(Integer.valueOf(rgb));
    }

    public Boite tint(Integer rgb)
    {
        Arrays.fill(this.tints, rgb);

        return this;
    }

    public Boite tint(Face index, Integer rgb)
    {
        this.tints[index.ordinal()] = rgb;

        return this;
    }



    /**
     *
     * creer les différentes faces en ajoutant les pramètres aux coordonnées d'origine <br/>
     * <br/>
     * Si cette méthode n'est pas appeler, une boite de 10/10/10 est creer
     *
     * @param largeur largeur sur axeX
     * @param hauteur hauteur sur axeY
     * @param longeur longeur sur axeZ
     * @return this
     */
    public Boite finilize(float largeur, float hauteur, float longeur)
    {
        PShape shape = this.applet.createShape();

        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[Face.DROITE.ordinal()]);
        if(this.tints[Face.DROITE.ordinal()] != null)
            shape.tint(this.tints[Face.DROITE.ordinal()]);
        shape.shininess(this.shininesss[Face.DROITE.ordinal()]);
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
        shape.texture(this.images[Face.GAUCHE.ordinal()]);
        if(this.tints[Face.GAUCHE.ordinal()] != null)
            shape.tint(this.tints[Face.GAUCHE.ordinal()]);
        shape.shininess(this.shininesss[Face.GAUCHE.ordinal()]);
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
        shape.texture(this.images[Face.DESSOU.ordinal()]);
        if(this.tints[Face.DESSOU.ordinal()] != null)
            shape.tint(this.tints[Face.DESSOU.ordinal()]);
        shape.shininess(this.shininesss[Face.DESSOU.ordinal()]);
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
        shape.texture(this.images[Face.DESSU.ordinal()]);
        if(this.tints[Face.DESSU.ordinal()] != null)
            shape.tint(this.tints[Face.DESSU.ordinal()]);
        shape.shininess(this.shininesss[Face.DESSU.ordinal()]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 1, 0);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ + longeur, 1, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ, 0, 1);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ, 0, 0);
        shape.vertex(this.origX, this.origY + hauteur, this.origZ + longeur, 1, 0);
        shape.endShape();
        finalShape.addChild(shape);

        shape = this.applet.createShape();
        shape.beginShape(QUADS);
        shape.textureMode(NORMAL);
        shape.texture(this.images[Face.DERRIERE.ordinal()]);
        if(this.tints[Face.DERRIERE.ordinal()] != null)
            shape.tint(this.tints[Face.DERRIERE.ordinal()]);
        shape.shininess(this.shininesss[Face.DERRIERE.ordinal()]);
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
        shape.texture(this.images[Face.DEVANT.ordinal()]);
        if(this.tints[Face.DEVANT.ordinal()] != null)
            shape.tint(this.tints[Face.DEVANT.ordinal()]);
        shape.shininess(this.shininesss[Face.DEVANT.ordinal()]);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ + longeur, 1, 0);
        shape.vertex(this.origX + largeur, this.origY, this.origZ + longeur, 1, 1);
        shape.vertex(this.origX + largeur, this.origY, this.origZ, 0, 1);
        shape.vertex(this.origX + largeur, this.origY + hauteur, this.origZ, 0, 0);
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
