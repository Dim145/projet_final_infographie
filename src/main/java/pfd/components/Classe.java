package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class Classe extends Composand3D
{
    private final float largeur;
    private final float longeur;

    public Classe(PApplet applet, int nbRanger, int nbTableParRanger)
    {
        super(applet, 0, 0, 0);

        this.largeur = Table.LARGUEUR * 2 * (nbRanger + 1);
        this.longeur = Table.LONGUEUR * nbTableParRanger;

        float departBureauxLongeur  = Table.LONGUEUR * 0.75f;
        float departBureauxLargueur = Table.LARGUEUR * 2;

        for (int i = 0; i < nbRanger; i++)
            for (int j = 0; j < nbTableParRanger; j++)
                this.addChild(new Bureau(applet, departBureauxLargueur + (Table.LARGUEUR * 2)*i, Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*j));

        this.addChild(new Sol(applet, 0, 0, 0, departBureauxLargueur + this.getLargeur() - Table.LARGUEUR, departBureauxLongeur + this.getLongueur()));

        this.addChild(new Table(applet, this.getLargeur(), Sol.EPAISSEUR, this.getLongueur() - Table.LONGUEUR/2f));
        this.addChild(new Table(applet, this.getLargeur(), Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR * (1/4f)));

        this.addChild(new Table(applet, departBureauxLargueur - Table.LARGUEUR, Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*(3/4f)));

//        this.addChild(new Bureau(applet));
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
