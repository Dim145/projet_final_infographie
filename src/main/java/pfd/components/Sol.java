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
        Boite b = new Boite(this.applet, this.origX, this.origY, this.origZ);

        b.texture(sol);

        b.finilize(finalX, EPAISSEUR, finalZ);

        return b;
    }
}
