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

        Boite b = new Boite(applet, startX, startY, startZ).setNoStroke(addFenetre);

        b.tint(Utilities.VERT_FONCER, 127f);

        this.fenetres.add(b.finilize(largeur, hauteur, longueur));

        return this;
    }

    @Override
    public Boite finilize(float largeur, float hauteur, float longeur)
    {
        if(this.fenetres.size() == 0)
            return super.finilize(largeur, hauteur, longeur);

        if(longeur > largeur)
            this.addFenetreAxeZ(largeur, hauteur, longeur);
        else
            this.addFenetreAxeX(largeur, hauteur, longeur);

        this.isFinilise = true;

        return this;
    }

    private void addFenetreAxeZ(float largeur, float hauteur, float longeur)
    {
        Boite fenetre = this.fenetres.get(0);

        this.addChild(fenetre);

        this.addChild(new Boite(applet, this.origX, this.origY, this.origZ)
                .finilize(largeur, fenetre.getOrigY(), longeur));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY(), fenetre.getOrigZ() + fenetre.getLongeur())
                .finilize(largeur, hauteur - fenetre.getOrigY(), longeur - (fenetre.getOrigZ()+fenetre.getLongeur())));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY() + fenetre.getHauteur(), this.origZ)
                .finilize(largeur, hauteur - (fenetre.getOrigY() + fenetre.getHauteur()), fenetre.getOrigZ() + fenetre.getLongeur()));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY(), this.origZ)
                .finilize(largeur, fenetre.getHauteur(), fenetre.getOrigZ()));
    }

    private void addFenetreAxeX(float largeur, float hauteur, float longeur)
    {
        Boite fenetre = this.fenetres.get(0);

        this.addChild(fenetre);

        this.addChild(new Boite(applet, this.origX, this.origY, this.origZ)
                .finilize(largeur, fenetre.getOrigY(), longeur));

        this.addChild(new Boite(applet, fenetre.getOrigX() + fenetre.getLargeur(), fenetre.getOrigY(), this.origZ)
                .finilize(largeur - (fenetre.getOrigX() + fenetre.getLargeur()), hauteur - fenetre.getOrigY(), longeur));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY() + fenetre.getHauteur(), this.origZ)
                .finilize(fenetre.getOrigX() + fenetre.getLargeur(), hauteur - (fenetre.getOrigY() + fenetre.getHauteur()), longeur));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY(), this.origZ)
                .finilize(fenetre.getOrigX(), fenetre.getHauteur(), longeur));
    }
}
