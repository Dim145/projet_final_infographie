package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class Classe extends Composand3D
{
    public static float HAUTEUR = Table.LONGUEUR * 1.5f;

    private float largeur;
    private float longeur;

    public Classe(PApplet applet, int nbRanger, int nbTableParRanger)
    {
        super(applet, 0, 0, 0);

        float departBureauxLongeur  = Table.LONGUEUR * 0.75f;
        float departBureauxLargueur = Table.LARGUEUR * 2;

        this.largeur = Table.LARGUEUR * 2 * (nbRanger + 1);
        this.longeur = Table.LONGUEUR * nbTableParRanger;

        for (int i = 0; i < nbRanger; i++)
            for (int j = 0; j < nbTableParRanger; j++)
                this.addChild(new Bureau(applet, departBureauxLargueur + (Table.LARGUEUR * 2)*i, Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*j));

        this.addChild(new Sol(applet, 0, 0, 0, departBureauxLargueur + this.getLargeur() - Table.LARGUEUR, departBureauxLongeur + this.getLongueur()));

        this.addChild(new Table(applet, this.getLargeur(), Sol.EPAISSEUR, this.getLongueur() - Table.LONGUEUR/2f));
        this.addChild(new Table(applet, this.getLargeur(), Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR * (1/4f)));

        this.addChild(new Table(applet, departBureauxLargueur - Table.LARGUEUR, Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*(3/4f)));

        this.largeur += Table.LARGUEUR;
        this.longeur += departBureauxLongeur;

        Mur[] murs = new Mur[4];

        murs[0] = new Mur(applet, this.origX, this.origY, this.origZ);
        murs[1] = new Mur(applet, this.getLargeur(), this.origY, this.getLongueur());
        murs[2] = new Mur(applet, this.getLargeur(), this.origY, this.origZ);
        murs[3] = new Mur(applet, this.origX, this.origY, this.getLongueur());

        murs[0].finilize(this.getLargeur(), HAUTEUR, Sol.EPAISSEUR);
        murs[1].finilize(-this.getLargeur() - Sol.EPAISSEUR, HAUTEUR, Sol.EPAISSEUR);
        murs[2].finilize(Sol.EPAISSEUR, HAUTEUR, this.getLongueur() + Sol.EPAISSEUR);
        murs[3].finilize(-Sol.EPAISSEUR, HAUTEUR, -this.getLongueur());

        for (Mur m : murs)
            this.addChild(m);
    }

    public float getLongueur()
    {
        return this.longeur;
    }

    public float getLargeur()
    {
        return this.largeur;
    }
}
