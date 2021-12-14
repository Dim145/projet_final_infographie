package pfd.components;

import pfd.baseComponents.Composand3D;
import processing.core.PApplet;

public class Bureau extends Composand3D
{
    public Bureau(PApplet applet)
    {
        this(applet, 0, 0, 0);
    }

    public Bureau(PApplet applet, float baseX, float baseY, float baseZ)
    {
        super(applet, baseX, baseY, baseZ);

        this.addChild(new Table(applet, baseX, baseY, baseZ));
        this.addChild(new Chaise(applet, baseX + Table.LARGUEUR - Table.EPAISSEUR_PLATEUR, baseY, baseZ + Table.EPAISSEUR_PLATEUR*2));
        this.addChild(new Chaise(applet, baseX + Table.LARGUEUR - Table.EPAISSEUR_PLATEUR, baseY, baseZ + Table.LONGUEUR - Chaise.COTE - Table.EPAISSEUR_PLATEUR*2));


        this.addChild(new Ordinateur(applet, baseX, baseY + Table.HAUTEUR + Table.EPAISSEUR_PLATEUR, baseZ + Ordinateur.EPAISSEUR, true));
        this.addChild(new Ordinateur(applet, baseX, baseY + Table.HAUTEUR + Table.EPAISSEUR_PLATEUR, baseZ + Table.LONGUEUR - Ordinateur.LONGUEUR - Ordinateur.EPAISSEUR, false));
    }
}
