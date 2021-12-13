package pfd;

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
            new PVector(0, -300, 0)
    };

    PVector[] lightColor = {
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255),
            new PVector(255, 255, 255)
    };

    @Override
    public void setup()
    {
        super.setup();

        this.shader = loadShader("shaders/fragment.glsl", "shaders/vert.glsl");
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

        for(int i=0; i<lightPos.length; i++)
        {
            pushMatrix();
            noStroke();
            fill(1, 1, 1);
            emissive(lightColor[i].x, lightColor[i].y, lightColor[i].z);
            translate(lightPos[i].x, lightPos[i].y, lightPos[i].z);
            box(10, 10, 10);
            popMatrix();
        }

        emissive(0, 0, 0);

        super.dessiner();
    }

    public static void main(String[] args)
    {
        PApplet.main(TestShaders.class.getName());
    }
}
