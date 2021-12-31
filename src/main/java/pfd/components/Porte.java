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

    public static final float HAUTEUR_POIGNEE = 10;
    public static final float LONGUEUR_POIGNEE = HAUTEUR_POIGNEE/2;
    public static final float DISTANCE_POIGNEE = 5;

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
        this.addChild(creerPoignee(true));
        this.addChild(creerPoignee(false));

        this.isOpen = isDefaultOpen;
    }

    public Boite creerPorte()
    {
        Boite b = new Boite(applet, this.origX, this.origY, this.origZ);

        b.tint(Integer.valueOf(Utilities.CYAN)).texture(texture);

        return b.finilize(onZAxe ? EPAISSEUR : LONGUEUR, HAUTEUR, onZAxe ? LONGUEUR : EPAISSEUR);
    }

    private Boite creerPoignee(boolean avant)
    {
        float relativePosX = this.origX + (onZAxe ? avant ? Porte.EPAISSEUR : -2 : Porte.LONGUEUR - HAUTEUR_POIGNEE);
        float relativePosZ = this.origZ + (onZAxe ? Porte.LONGUEUR - HAUTEUR_POIGNEE : avant ? Porte.EPAISSEUR : -2);

        Boite b = new Boite(applet, relativePosX, this.origY + Porte.HAUTEUR/2 - HAUTEUR_POIGNEE/2, relativePosZ);

        b.tint(Utilities.DARK_GRAY);
        b.shininess(Utilities.METAL_SHININESS);

        Boite p1 = new Boite(applet,relativePosX + (onZAxe ? 0 : HAUTEUR_POIGNEE/2 - LONGUEUR_POIGNEE/4), this.origY + Porte.HAUTEUR/2 - HAUTEUR_POIGNEE/2 + HAUTEUR_POIGNEE/4 + LONGUEUR_POIGNEE/4,relativePosZ + (onZAxe ? HAUTEUR_POIGNEE/2 - LONGUEUR_POIGNEE/4 : 0));

        p1.tint(Utilities.DARK_GRAY);
        p1.shininess(Utilities.METAL_SHININESS);

        b.addChild(p1.finilize(onZAxe ? avant ? DISTANCE_POIGNEE : -DISTANCE_POIGNEE : LONGUEUR_POIGNEE/2, LONGUEUR_POIGNEE/2, onZAxe ? LONGUEUR_POIGNEE/2 : avant ? DISTANCE_POIGNEE : -DISTANCE_POIGNEE));

        Boite p2 = new Boite(applet, p1.getOrigX() + p1.getLargeur(), p1.getOrigY(), p1.getOrigZ() + p1.getLongeur());

        p2.tint(Utilities.DARK_GRAY);
        p2.shininess(Utilities.METAL_SHININESS);

        b.addChild(p2.finilize(onZAxe ? LONGUEUR_POIGNEE/2 : LONGUEUR_POIGNEE*-2, p1.getHauteur(), onZAxe ? LONGUEUR_POIGNEE*-2 : LONGUEUR_POIGNEE/2));

        return b.finilize(onZAxe ? 2 : HAUTEUR_POIGNEE, HAUTEUR_POIGNEE, onZAxe ? HAUTEUR_POIGNEE : 2);
    }

    public void openClose()
    {
        new Thread(() ->
        {
            // Ne fonctionne que dans le cas où le centre de l'écran se trouve au centre de la classe
            boolean ouvrir = isOpen;

            float lastX = -(this.getOrigX() + Porte.EPAISSEUR*2) - Porte.LONGUEUR;
            float lastZ = this.getOrigZ() + Porte.EPAISSEUR*3 + Porte.LONGUEUR;

            float rotate = PApplet.radians(90) * (ouvrir ? 1 : -1);
            this.rotateY(rotate);

            this.translate(ouvrir ? -lastZ : lastX, 0, ouvrir ? lastX : lastZ);

        }).start();

        this.isOpen = !this.isOpen;
    }
}
