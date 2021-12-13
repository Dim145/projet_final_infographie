package pfd.baseComponents;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PShape;

import java.util.ArrayList;
import java.util.List;

public abstract class Composand3D extends PShape
{
    protected final int origX;
    protected int origY;
    protected int origZ;

    protected final PApplet applet;

    protected final List<PShape> listChild;

    public Composand3D(PApplet applet, int originX, int originY, int originZ)
    {
        super(applet.getGraphics(), GROUP);

        this.origX = originX;
        this.origY = originY;
        this.origZ = originZ;

        this.applet = applet;

        this.listChild = new ArrayList<>();
    }

    @Override
    public void draw(PGraphics g)
    {
        for (PShape child : this.listChild)
        {
            child.draw(g);
        }

        super.draw(g);
    }

    @Override
    public void addChild(PShape who)
    {
        this.listChild.add(who);
    }

    @Override
    public void translate(float x, float y, float z)
    {
        super.translate(x, y, z);

        for (PShape child : this.listChild)
        {
            child.translate(x, y, z);
        }
    }
}
