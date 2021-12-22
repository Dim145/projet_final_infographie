package pfd;

import pfd.components.Boite;
import pfd.components.Classe;
import pfd.components.Table;
import processing.core.PApplet;
import processing.core.PVector;
import processing.opengl.PShader;

public class TestShaders extends TestsCamera
{
    private PShader shader = null;

    PVector[] lightPos = {
            new PVector(300, -300, 300),
            new PVector(-300, 300, 300),
            new PVector(-300, 300, -300),
            new PVector(0, -300, 0), // 4 premiere = lumière piece
            // 4 dernière = lumière extérieur
            new PVector(300, Classe.HAUTEUR/2, 300),
            new PVector(-300, Classe.HAUTEUR/2, 300),
            new PVector(-300, Classe.HAUTEUR/2, -300),
            new PVector(0, -Classe.HAUTEUR*2, 0)
    };

    PVector[] lightColor = {
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255)
    };

    Boite[] lights = null;

    @Override
    public void setup()
    {
        super.setup();

        lightPos[0].x = Table.LARGUEUR + translateValue.x;
        lightPos[0].y = Classe.HAUTEUR + translateValue.y;
        lightPos[0].z = Table.LONGUEUR/2f + translateValue.z;

        lightPos[1].x = Table.LARGUEUR + translateValue.x;
        lightPos[1].y = Classe.HAUTEUR + translateValue.y;
        lightPos[1].z = classe.getLongueur() - Table.LONGUEUR/2f + translateValue.z;

        lightPos[2].x = classe.getLargeur() - Table.LARGUEUR + translateValue.x;
        lightPos[2].y = Classe.HAUTEUR + translateValue.y;
        lightPos[2].z = Table.LONGUEUR/2f + translateValue.z;

        lightPos[3].x = classe.getLargeur() - Table.LARGUEUR + translateValue.x;
        lightPos[3].y = Classe.HAUTEUR + translateValue.y;
        lightPos[3].z = classe.getLongueur() - Table.LONGUEUR/2f + translateValue.z;

        lightPos[4].x = -classe.getLargeur() + translateValue.x;
        lightPos[4].y = Classe.HAUTEUR/2;
        lightPos[4].z = -classe.getLongueur()/2 + translateValue.z;

        lightPos[5].x = classe.getLargeur()*2 + translateValue.x;
        lightPos[5].y = Classe.HAUTEUR/2;
        lightPos[5].z = classe.getLongueur()*2 + translateValue.z;

        lightPos[6].x = classe.getLargeur()*2 + translateValue.x;
        lightPos[6].y = Classe.HAUTEUR/2;
        lightPos[6].z = -classe.getLongueur()/2 + translateValue.z;

        this.shader = loadShader("shaders/fragment.glsl", "shaders/vert.glsl");

        lights = new Boite[lightPos.length];

        for (int i = 0; i < lights.length; i++)
            lights[i] = new Boite(this, lightPos[i].x, lightPos[i].y-10, lightPos[i].z).addStroke().finilize(10, 10, 10);
    }

    @Override
    public void dessiner()
    {
        shader(this.shader);

        for(int i = 0; i < lightPos.length; i++)
        {
            lightSpecular(lightColor[i].x, lightColor[i].y, lightColor[i].z);
            pointLight(lightColor[i].x, lightColor[i].y, lightColor[i].z,
                    lightPos[i].x, lightPos[i].y, lightPos[i].z);
        }

        emissive(0, 0, 0);

        for (Boite light : lights)
            shape(light);

        super.dessiner();
    }

    //maven compile exec:java -Dfile.encoding=utf-8 -Dexec.mainClass=pfd.TestShaders
    public static void main(String[] args)
    {
        PApplet.main(TestShaders.class.getName());
    }
}
