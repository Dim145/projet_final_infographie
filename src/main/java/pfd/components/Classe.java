package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class Classe extends Composand3D
{
    public Classe(PApplet applet, int nbRanger, int nbTableParRanger)
    {
        super(applet, 0, 0, 0);

        for (int i = 0; i < nbRanger; i++)
            for (int j = 0; j < nbTableParRanger; j++)
                this.addChild(new Bureau(applet, (Table.LARGUEUR + Table.LARGUEUR)*i, 0, Table.LONGUEUR*j));

//        this.addChild(new Bureau(applet));
    }
}
