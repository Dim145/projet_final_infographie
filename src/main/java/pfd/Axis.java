package pfd;

// Andrew Craigie
// Axis class

// Draws x, y and z axis in sketch

import processing.core.PApplet;

import java.awt.*;

import static processing.core.PConstants.*;

public class Axis
{

    private Color colX = Color.RED;
    private Color colY = Color.GREEN;
    private Color colZ = Color.BLUE;

    private final int strokeW;

    private final float originX;
    private final float originY;
    private final float originZ;

    private final float xLength;
    private final float yLength;
    private final float zLength;

    public Axis(float oX, float oY, float oZ, float xL, float yL, float zL, int sWeight)
    {
        originX = oX;
        originY = oY;
        originZ = oZ;

        xLength = xL;
        yLength = yL;
        zLength = zL;

        strokeW = sWeight;
    }

    public void draw(PApplet applet)
    {
        applet.colorMode(RGB, 255, 255, 255, 255);

        float x1 = originX - (xLength / 2);
        float x2 = originX + (xLength / 2);
        float y1 = originY - (yLength / 2);
        float y2 = originY + (yLength / 2);
        float z1 = originZ - (zLength / 2);
        float z2 = originZ + (zLength / 2);

        // Draw X axis
        applet.pushStyle();
        applet.strokeWeight(strokeW);
        applet.stroke(colX.getRGB());
        applet.line(x1, originY, originZ, x2, originY, originZ);
        applet.line(x2, originY, originZ, x2 - 20, originY - 10, originZ);
        applet.popStyle();

        // Draw Y axis
        applet.pushStyle();
        applet.strokeWeight(strokeW);
        applet.stroke(colY.getRGB());
        applet.line(originX, y1, originZ, originX, y2, originZ);
        applet.line(originX, y2, originZ, originX + 10, y2 - 20, originZ);
        applet.popStyle();

        // Draw Z axis
        applet.pushStyle();
        applet.strokeWeight(strokeW);
        applet.stroke(colZ.getRGB());
        applet.line(originX, originY, z1, originX, originY, z2);
        applet.line(originX, originY, z2, originX + 10, originY, z2 - 20);
        applet.popStyle();
    }

    public void draw(PApplet applet, Color xCol, Color yCol, Color zCol)
    {
        if(xCol != null)
            this.colX = xCol;

        if(yCol != null)
            this.colY = yCol;

        if(zCol != null)
            this.colZ = zCol;

        draw(applet);
    }
}
