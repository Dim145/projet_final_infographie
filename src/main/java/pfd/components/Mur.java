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

    /**
     * Ajoute un "trou" au mur. Couleur et transparence modifiable. <br/>
     * </br>
     * Toutes les coordonnées sont relative au mur. Si startX = 50, la valeur X de la fenetre seras de "origX du mur + 50"
     * @param startX coordonnée X par rapport au mur
     * @param startY coordonnée Y par rapport au mur
     * @param startZ coordonnée Z par rapport au mur
     * @param largeur largeur du trou.
     * @param hauteur hauteur du trou.
     * @param longueur hauteur du trou.
     * @param noStroke Mettre les bordures sur la fenêtre.
     * @return this
     */
    public Mur addTrou(float startX, float startY, float startZ, float largeur, float hauteur, float longueur, boolean noStroke)
    {
        return addTrou(startX, startY, startZ, largeur, hauteur, longueur, noStroke, Utilities.VERT_FONCER, 127f);
    }

    /**
     * Ajoute un "trou" au mur. Couleur et transparence modifiable. <br/>
     * </br>
     * Toutes les coordonnées sont relative au mur. Si startX = 50, la valeur X de la fenetre seras de "origX du mur + 50"
     * @param startX coordonnée X par rapport au mur
     * @param startY coordonnée Y par rapport au mur
     * @param startZ coordonnée Z par rapport au mur
     * @param largeur largeur du trou.
     * @param hauteur hauteur du trou.
     * @param longueur hauteur du trou.
     * @param noStroke Mettre les bordures sur la fenêtre.
     * @param color couleur de la fenêtre.
     * @param alpha transparence de la fenêtre.
     * @return this
     */
    public Mur addTrou(float startX, float startY, float startZ, float largeur, float hauteur, float longueur, boolean noStroke, int color, float alpha)
    {
        Boite b = new Boite(applet, this.origX + startX, this.origY + startY, this.origZ + startZ).setNoStroke(noStroke);

        b.tint(color, alpha);

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
                .finilize(largeur, fenetre.getOrigY() - this.origY, longeur));

        this.addChild(new Boite(applet,fenetre.getOrigX() + fenetre.getLargeur(), fenetre.getOrigY(), this.origZ)
                .finilize((this.origX + largeur) - (fenetre.getOrigX() + fenetre.getLargeur()), hauteur - (fenetre.getOrigY() - this.origY), longeur));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY() + fenetre.getHauteur(), this.origZ)
                .finilize((fenetre.getOrigX() - this.getOrigX()) + fenetre.getLargeur(), hauteur - ((fenetre.getOrigY() - this.origY) + fenetre.getHauteur()), longeur));

        this.addChild(new Boite(applet, this.origX, fenetre.getOrigY(), this.origZ)
                .finilize(fenetre.getOrigX() - this.getOrigX(), fenetre.getHauteur(), longeur));
    }
}
