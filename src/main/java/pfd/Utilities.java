package pfd;

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;

public final class Utilities
{
    public static final int METAL_SHININESS = 10;
    public static final int MAT_SHININESS = METAL_SHININESS * 2;
    public static final int SUPER_MAT_SHININESS = MAT_SHININESS * 2;
    public static final int IMAGE_SHININESS = SUPER_MAT_SHININESS * 100;

    public static final int BLACK = Color.BLACK.getRGB();
    public static final int DARK_GRAY = Color.DARK_GRAY.getRGB();
    public static final int LIGHT_BLACK = new Color(24, 24, 24).getRGB();
    public static final int CYAN = new Color(0, 240, 228).getRGB();
    public static final int DARK_WHITE = DARK_GRAY*2;
    public static final int RED = Color.RED.getRGB();
    public static final int VERT_FONCER = new Color(9, 73, 9).getRGB();
    public static final int BEIGE_BIZZARE = new Color(236, 227, 196).getRGB();
    public static final int LIGHT_GRAY = Color.LIGHT_GRAY.getRGB();

    public static final float DEFAULT_PHI = 404.55f;
    public static final float DEFAULT_THETA = -360.9f;

    public static final float PAS_DEPLACEMENT = 10f;

    public static int INITIAL_X_CAM_VALUE = 1;
    public static int INITIAL_Y_CAM_VALUE = -98;

    private static PImage defaultImage = null;

    public static PImage getDefaultImage(PApplet applet)
    {
        if(defaultImage == null)
            defaultImage = applet.loadImage("images/default.png");

        return defaultImage;
    }

    private Utilities(){}
}
