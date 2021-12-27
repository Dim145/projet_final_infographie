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
        this.addChild(new TableauCraie(applet, this.origX, this.origY + HAUTEUR/3, this.origZ + longeur/4, longeur/2));

        Mur[] murs = new Mur[4];

        murs[1] = new Mur(applet, this.origX - Sol.EPAISSEUR, this.origY, this.origZ + this.getLongueur());
        murs[2] = new Mur(applet, this.origX + this.getLargeur(), this.origY, this.origZ);
        murs[0] = new Mur(applet, this.origX, this.origY, this.origZ + this.getLongueur());

        murs[0].normal(Face.DERRIERE, 1, 0, 0);
        murs[0].normal(Face.DEVANT, -1, 0, 0);

        for (Boite m : murs)
            if(m!= null)
                m.tint(Utilities.BEIGE_BIZZARE);

        murs[1].fillTrou(false).addTrou(Sol.EPAISSEUR*2, Sol.EPAISSEUR, 0,
                HAUTEUR/4, HAUTEUR/1.5f, Sol.EPAISSEUR, true, Utilities.LIGHT_GRAY, 0);

        murs[1].finilize(this.getLargeur(), HAUTEUR, Sol.EPAISSEUR);
        murs[2].finilize(Sol.EPAISSEUR, HAUTEUR, this.getLongueur() + Sol.EPAISSEUR);
        murs[0].finilize(-Sol.EPAISSEUR, HAUTEUR, -this.getLongueur());

        Mur basMurF = new Mur(applet, this.origX - Sol.EPAISSEUR, this.origY, this.origZ - Sol.EPAISSEUR);

        basMurF.tint(Utilities.BEIGE_BIZZARE);

        Mur f1 = createFenetre(basMurF.getOrigX(), basMurF.getOrigY() + HAUTEUR/3, basMurF.getOrigZ(),
                HAUTEUR/4, HAUTEUR/2, Sol.EPAISSEUR);
        basMurF.addChild(f1);

        boolean isCarre = true;
        while(f1.getOrigX() + f1.getLargeur() <= this.getLargeur())
        {
            f1 = createFenetre(f1.getOrigX() + f1.getLargeur(), f1.getOrigY(), f1.getOrigZ(),
                    (HAUTEUR/4)*(isCarre ? 2 : 1), f1.getHauteur(), f1.getLongeur());

            isCarre = !isCarre;

            basMurF.addChild(f1);
        }

        Mur f2 = createFenetre(basMurF.getOrigX(), f1.getOrigY() + f1.getHauteur(), basMurF.getOrigZ(),
                f1.getLargeur()*2, (this.origY + HAUTEUR)-(f1.getOrigY()+f1.getHauteur()), Sol.EPAISSEUR);
        basMurF.addChild(f2);

        isCarre = true;
        while(f2.getOrigX() + f2.getLargeur() <= this.getLargeur())
        {
            f2 = createFenetre(f2.getOrigX() + f2.getLargeur(), f2.getOrigY(), f2.getOrigZ(),
                    (f1.getLargeur()*2)/(isCarre ? 2 : 1), f2.getHauteur(), f2.getLongeur());

            if(f2.getOrigX() + f2.getLargeur()*2 <= this.getLargeur())
                isCarre = !isCarre;

            basMurF.addChild(f2);
        }

        murs[3] = (Mur) basMurF.finilize(this.getLargeur() + Sol.EPAISSEUR*2, HAUTEUR/3, Sol.EPAISSEUR);

        for (Boite m : murs)
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

    private Mur createFenetre(float startX, float startY, float startZ, float largeur, float hauteur, float longeur)
    {
        Mur f1 = new Mur(applet, startX, startY, startZ);

        f1.tint(Utilities.DARK_GRAY);

        f1.addTrou(Sol.EPAISSEUR, Sol.EPAISSEUR, 0,
                largeur - Sol.EPAISSEUR*2, hauteur - Sol.EPAISSEUR*2, longeur,
                true, Utilities.DARK_WHITE, 100f);

        return (Mur) f1.finilize(largeur, hauteur, longeur);
    }
}
