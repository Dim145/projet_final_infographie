package pfd.components;

import pfd.Utilities;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Mur extends Boite
{
    private final List<Boite> fenetres;

    public Mur(PApplet applet, float origX, float origY, float origZ)
    {
        super(applet, origX, origY, origZ);

        this.fenetres = new ArrayList<>();

        this.tint(Utilities.BEIGE_BIZZARE);
    }

    public Mur addTrou(float startX, float startY, float startZ, float largeur, float hauteur, float longueur, boolean addFenetre)
    {
        if(startX <= this.origX) startX = this.origX;
        if(startY <= this.origY) startY = this.origY;
        if(startZ <= this.origZ) startZ = this.origZ;

        this.fenetres.add(new Boite(applet, startX, startY, startZ).setNoStroke(addFenetre).finilize(largeur, hauteur, longueur));

        return this;
    }

    @Override
    public Boite finilize(float largeur, float hauteur, float longeur)
    {
        if(this.fenetres.size() == 0)
            return super.finilize(largeur, hauteur, longeur);

        Boite fenetre = this.fenetres.get(0);

        this.addChild(new Boite(applet, this.origX, this.origY, this.origZ).finilize(fenetre.getOrigX(), hauteur, longeur));

        return this;
    }
}
