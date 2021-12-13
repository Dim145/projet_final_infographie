package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class Classe extends Composand3D
{
    private final int largeur;
    private final int longeur;

    public Classe(PApplet applet, int nbRanger, int nbTableParRanger)
    {
        super(applet, 0, 0, 0);

        this.largeur = Table.LARGUEUR * 2 * nbRanger;
        this.longeur = Table.LONGUEUR * nbTableParRanger;

        for (int i = 0; i < nbRanger; i++)
            for (int j = 0; j < nbTableParRanger; j++)
                this.addChild(new Bureau(applet, (Table.LARGUEUR * 2)*i, Sol.EPAISSEUR, Table.LONGUEUR*j));

        this.addChild(new Sol(applet, 0, 0, 0, this.getLargeur(), this.getLongueur()));

//        this.addChild(new Bureau(applet));
    }

    public int getLongueur()
    {
        return this.longeur;
    }

    public int getLargeur()
    {
        return this.largeur;
    }
}
