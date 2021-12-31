package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;
import processing.core.PImage;

public class Porte extends Composand3D
{
    public static final float HAUTEUR = Classe.HAUTEUR/1.5f;
    public static final float EPAISSEUR = Sol.EPAISSEUR;
    public static final float LONGUEUR = Classe.HAUTEUR/4f;

    private static PImage texture = null;

    private boolean isOpen;
    private final boolean onZAxe;

    public Porte(PApplet applet, float origX, float origY, float origZ, boolean onZAxe)
    {
        this(applet, origX, origY, origZ, onZAxe, false);
    }

    public Porte(PApplet applet, float origX, float origY, float origZ, boolean onZAxe, boolean isDefaultOpen)
    {
        super(applet, origX, origY, origZ);

        if(texture == null)
            texture = applet.loadImage("images/table.png");

        this.onZAxe = onZAxe;

        this.addChild(creerPorte());

        this.isOpen = isDefaultOpen;
    }

    public Boite creerPorte()
    {
        Boite b = new Boite(applet, this.origX, this.origY, this.origZ);

        b.tint(Integer.valueOf(Utilities.CYAN)).texture(texture);

        return b.finilize(onZAxe ? EPAISSEUR : LONGUEUR, HAUTEUR, onZAxe ? LONGUEUR : EPAISSEUR);
    }

    public void openClose()
    {
        new Thread(() ->
        {
            // Ne fonctionne que dans le cas où le centre de l'écran se trouve au centre de la classe
            boolean ouvrir = isOpen;

            float lastX = -(this.getOrigX() + Porte.EPAISSEUR*2) - Porte.LONGUEUR;
            float lastZ = this.getOrigZ() + Porte.EPAISSEUR*3;

            float rotate = PApplet.radians(90) * (ouvrir ? -1 : 1);
            this.rotateY(rotate);

            this.translate(ouvrir ? lastX : -lastZ, 0, ouvrir ? lastZ : lastX);

        }).start();

        this.isOpen = !this.isOpen;
    }
}
