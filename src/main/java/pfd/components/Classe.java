package pfd.components;

import pfd.Utilities;
import pfd.baseComponents.Composand3D;
import pfd.baseComponents.Face;
import processing.core.PApplet;

public class Classe extends Composand3D
{
    public static float HAUTEUR = Table.LONGUEUR * 1.5f;

    private float largeur;
    private float longeur;

    public Classe(PApplet applet, int nbRanger, int nbTableParRanger)
    {
        super(applet, 0, 0, 0);

        float departBureauxLongeur  = this.origZ + Table.LONGUEUR * 0.75f;
        float departBureauxLargueur = this.origX + Table.LARGUEUR * 3;

        this.largeur = Table.LARGUEUR + Table.LARGUEUR * 2 * (nbRanger + 1);
        this.longeur = Table.LONGUEUR * nbTableParRanger;

        for (int i = 0; i < nbRanger; i++)
            for (int j = 0; j < nbTableParRanger; j++)
                this.addChild(new Bureau(applet, departBureauxLargueur + (Table.LARGUEUR * 2)*i, this.origY + Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*j));

        this.addChild(new Sol(applet, this.origX, this.origY, this.origZ, this.getLargeur() + Table.LARGUEUR, departBureauxLongeur + this.getLongueur()));

        this.addChild(new Table(applet, this.origX + this.getLargeur(), this.origY + Sol.EPAISSEUR, this.origZ + this.getLongueur() - Table.LONGUEUR/2f));
        this.addChild(new Table(applet, this.origX + this.getLargeur(), this.origY + Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR * (1/4f)));

        // bureau prof
        this.addChild(new Table(applet, departBureauxLargueur - Table.LARGUEUR, this.origY + Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*(3/4f)));

        Chaise chaiseProf = new Chaise(applet, departBureauxLargueur - Table.LARGUEUR * 1.5f, this.origY + Sol.EPAISSEUR, departBureauxLongeur + Table.LONGUEUR*1.25f - Chaise.COTE/2f, true);

        this.addChild(chaiseProf);

        this.largeur += Table.LARGUEUR;
        this.longeur += departBureauxLongeur;

        this.addChild(new TableauTactile(applet, this.origX + Table.LARGUEUR*2, this.origY + Sol.EPAISSEUR, this.origZ - Table.LARGUEUR*1.75f));

        Mur[] murs = new Mur[4];

        murs[0] = new Mur(applet, this.origX - Sol.EPAISSEUR, this.origY, this.origZ - Sol.EPAISSEUR);
        murs[1] = new Mur(applet, this.origX + this.getLargeur(), this.origY, this.origZ + this.getLongueur());
        murs[2] = new Mur(applet, this.origX + this.getLargeur(), this.origY, this.origZ);
        murs[3] = new Mur(applet, this.origX, this.origY, this.origZ + this.getLongueur());

        murs[0].addTrou(Sol.EPAISSEUR, Sol.EPAISSEUR, 0,
                this.getLargeur(), HAUTEUR-Sol.EPAISSEUR*2, Sol.EPAISSEUR, true, Utilities.DARK_WHITE, 100f);

        murs[3].normal(Face.DERRIERE, 1, 0, 0);
        murs[3].normal(Face.DEVANT, -1, 0, 0);

        murs[0].finilize(this.getLargeur() + Sol.EPAISSEUR*2, HAUTEUR, Sol.EPAISSEUR);
        murs[1].finilize(-this.getLargeur() - Sol.EPAISSEUR, HAUTEUR, Sol.EPAISSEUR);
        murs[2].finilize(Sol.EPAISSEUR, HAUTEUR, this.getLongueur() + Sol.EPAISSEUR);
        murs[3].finilize(-Sol.EPAISSEUR, HAUTEUR, -this.getLongueur());

        for (Boite m : murs)
            this.addChild(m);

        this.addChild(new TableauCraie(applet, this.origX, this.origY + HAUTEUR/3, this.origZ + longeur/4, longeur/2));
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
