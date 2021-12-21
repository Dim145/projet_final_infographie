package pfd;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;

import java.awt.*;

public final class Utilities
{
    public static final int METAL_SHININESS = 10;
    public static final int MAT_SHININESS = METAL_SHININESS * 2;
    public static final int SUPER_MAT_SHININESS = MAT_SHININESS * 2;
    public static final int IMAGE_SHININESS = SUPER_MAT_SHININESS * 100;

    public static int BLACK = Color.BLACK.getRGB();
    public static int DARK_GRAY = Color.DARK_GRAY.getRGB();
    public static int LIGHT_BLACK = new Color(24, 24, 24).getRGB();
    public static int CYAN = new Color(0, 240, 228).getRGB();
    public static int DARK_WHITE = DARK_GRAY*2;
    public static int RED = Color.RED.getRGB();
    public static int VERT_FONCER = new Color(9, 73, 9).getRGB();
    public static int BEIGE_BIZZARE = new Color(236, 227, 196).getRGB();
    public static int LIGHT_GRAY = Color.LIGHT_GRAY.getRGB();

    public static float DEFAULT_PHI = 404.55f;
    public static float DEFAULT_THETA = -360.9f;

    private static PImage defaultImage = null;

    public static PImage getDefaultImage(PApplet applet)
    {
        if(defaultImage == null)
            defaultImage = applet.loadImage("images/default.png");

        return defaultImage;
    }

    public static PShape createShape(PApplet applet, float origX, float largueur, float origY, float hauteur, float origZ, float longueur, int tint)
    {
        if(defaultImage == null)
            defaultImage = applet.loadImage("images/default.png");

        return createShape(applet, origX, largueur, origY, hauteur, origZ, longueur, tint, defaultImage);
    }

    public static PShape createShape(PApplet applet, float origX, float largueur, float origY, float hauteur, float origZ, float longueur, int tint, PImage texture)
    {
        PShape shape = applet.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.textureMode(PConstants.NORMAL);
        shape.texture(texture);
        shape.shininess(Utilities.IMAGE_SHININESS);
        shape.emissive(0, 0, 0);
        shape.normal(0, 0, 1);
        shape.tint(tint);
        shape.vertex(origX + largueur, origY + hauteur, origZ + longueur, 0, 1);
        shape.vertex(origX + largueur, origY + hauteur, origZ, 1, 1);
        shape.vertex(origX, origY + hauteur, origZ, 1, 0);
        shape.vertex(origX, origY + hauteur, origZ + longueur, 0, 0);
        shape.endShape();

        return shape;
    }

    private Utilities(){}
}
