package pfd.baseComponents;

import pfd.Utilities;
import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public abstract class BaseProcessing extends PApplet
{
    public static final int PAS_CAMERA = 20;

    // Distance de la camera au sujet.
    protected float rayon = 500;
    protected int taille = 50;

    protected float phi = Utilities.DEFAULT_PHI;

    // Angle de la camera avec le sujet sur le plan XZ.
    protected float theta = Utilities.DEFAULT_THETA;

    // Position cartésienne de la camera
    // calculée à partir du rayon et de l'angle.
    protected float camX = 0;
    protected float camZ = 0;
    protected float camY = 0;

    protected float centerX = 0;
    protected float centerY = 0;
    protected float centerZ = 0;

    protected int tmpMouseY = Utilities.INITIAL_Y_CAM_VALUE;
    protected int tmpMouseX = Utilities.INITIAL_X_CAM_VALUE;

    @Override
    public void settings()
    {
        super.settings();

        size(800, 800, P3D);
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    public final void draw()
    {
        noStroke();
        background(0);

        updateCamera();
        camera(camX, camY, camZ,            // observateur : position de la camera.
                centerX, centerY, centerZ,  // sujet : position du sujet visé.
                0, -1, 0);         // orientation : vecteur "haut".

        dessiner();
    }

    void updateCamera()
    {
        camX = rayon * cos(radians(phi)) * cos(radians(theta)) + X + centerX;
        camY = rayon * sin(radians(phi)) + Y + centerY;
        camZ = rayon * cos(radians(phi)) * sin(radians(theta)) + Z + centerZ;
    }

    @Override
    public void mouseDragged()
    {
        tmpMouseY += pmouseY - mouseY;
        tmpMouseX += mouseX - pmouseX;

        System.out.println("y:" + tmpMouseY);
        System.out.println("x:" + tmpMouseX);

        phi += map(-tmpMouseY, 0, height, 180, -180) - phi;
        theta += map(-tmpMouseX, 0, width, -180, 180) - theta;
    }

    @Override
    public void mouseReleased()
    {

    }

    @Override
    public void mouseWheel(MouseEvent event)
    {
        rayon += PAS_CAMERA * (event.getCount() > 0 ? 1 : -1);
    }

    public abstract void dessiner();

    @Override
    public void mousePressed()
    {
        mouseDragged();
    }

    public void creerTetrahede(int taille, int nb, PShape f)
    {
        recTriangle(nb, new PVector(-taille / 2f, -taille / 2f, taille / 2f),
                new PVector(taille / 2f, -taille / 2f, -taille / 2f),
                new PVector(-taille / 2f, taille / 2f, -taille / 2f), f);
        recTriangle(nb, new PVector(-taille / 2f, -taille / 2f, taille / 2f),
                new PVector(taille / 2f, -taille / 2f, -taille / 2f),
                new PVector(taille / 2f, taille / 2f, taille / 2f), f);
        recTriangle(nb, new PVector(taille / 2f, taille / 2f, taille / 2f),
                new PVector(taille / 2f, -taille / 2f, -taille / 2f),
                new PVector(-taille / 2f, taille / 2f, -taille / 2f), f);
        recTriangle(nb, new PVector(taille / 2f, taille / 2f, taille / 2f),
                new PVector(-taille / 2f, -taille / 2f, taille / 2f),
                new PVector(-taille / 2f, taille / 2f, -taille / 2f), f);
    }

    public void triangle(PVector x, PVector y, PVector z, PShape f)
    {
        PVector a = x.copy().normalize().mult(taille);
        PVector b = y.copy().normalize().mult(taille);
        PVector c = z.copy().normalize().mult(taille);

        f.fill(255, 255, 255);

        PVector a2 = a.copy().normalize();
        PVector b2 = b.copy().normalize();
        PVector c2 = c.copy().normalize();

        f.shininess(400);

        f.normal(a2.x, a2.y, a2.z);
        f.vertex(a.x, a.y, a.z);

        f.normal(b2.x, b2.y, b2.z);
        f.vertex(b.x, b.y, b.z);

        f.normal(c2.x, c2.y, c2.z);
        f.vertex(c.x, c.y, c.z);
    }

    public void recTriangle(int nb, PVector x, PVector y, PVector z, PShape f)
    {
        if (nb > 0)
        {
            PVector xy = new PVector((x.x + y.x) / 2, (x.y + y.y) / 2, (x.z + y.z) / 2);
            PVector yz = new PVector((y.x + z.x) / 2, (y.y + z.y) / 2, (y.z + z.z) / 2);
            PVector zx = new PVector((z.x + x.x) / 2, (z.y + x.y) / 2, (z.z + x.z) / 2);

            recTriangle(nb - 1, xy, yz, zx, f);
            recTriangle(nb - 1, x, xy, zx, f);
            recTriangle(nb - 1, xy, y, yz, f);
            recTriangle(nb - 1, zx, yz, z, f);
        }
        else
        {
            triangle(x, y, z, f);
        }
    }

    public PShape creerCube(int taille)
    {
        PShape shape = createShape();

        shape.beginShape(QUADS);
        shape.vertex(0, 0, 0);
        shape.vertex(0, taille, 0);
        shape.vertex(taille, taille, 0);
        shape.vertex(taille, 0, 0);

        shape.vertex(0, 0, taille);
        shape.vertex(0, taille, taille);
        shape.vertex(taille, taille, taille);
        shape.vertex(taille, 0, taille);

        shape.vertex(0, 0, 0);
        shape.vertex(0, 0, taille);
        shape.vertex(taille, 0, taille);
        shape.vertex(taille, 0, 0);

        shape.vertex(taille, taille, taille);
        shape.vertex(taille, taille, 0);
        shape.vertex(0, taille, 0);
        shape.vertex(0, taille, taille);

        shape.vertex(0, 0, 0);
        shape.vertex(0, taille, 0);
        shape.vertex(0, taille, taille);
        shape.vertex(0, 0, taille);

        shape.vertex(taille, taille, taille);
        shape.vertex(taille, 0, taille);
        shape.vertex(taille, 0, 0);
        shape.vertex(taille, taille, 0);
        shape.endShape();

        return shape;
    }
}
