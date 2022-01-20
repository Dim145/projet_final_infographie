package pfd;

import pfd.components.Classe;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestNewCamera extends TestShaders
{
    //constants
    /**
     * Bigger number = slower
     */
    protected static final float sensitivity = 30;
    protected static final int stillBox = 300;
    protected static final int cameraDistance = 2000;
    protected static final float magnitude_max = 1.5f;

    //Camera Variables
    protected float x, y, z;
    protected float tx, ty, tz;
    protected float rotX, rotY;
    protected float xComp, zComp;
    protected float angle;

    //Movement Variables
    protected int moveX;
    protected int moveZ;
    protected float vY;
    protected boolean canJump;
    protected boolean moveUP, moveDOWN, moveLEFT, moveRIGHT;

    /**
     * Bigger number = slower
     */
    protected int movementSpeed = 50;

    private boolean isCorrectCameraFirstTime = false;

    public static void main(String[] args)
    {
        PApplet.main(TestNewCamera.class);
    }

    @Override
    public void setup()
    {
        super.setup();

        //Camera Initialization
        x = 0;
        y = Classe.HAUTEUR/2;
        z = 1 / tan(PI*60.0f / 360.0f);
        tx = -width/2f;
        ty = 0;
        tz = 0;
        rotX = 0;
        rotY = 0;
        xComp = tx - x;
        zComp = tz - z;
        angle = 0;

        //Movement Initialization
        moveX = 0;
        moveUP = false;
        moveDOWN = false;
        moveLEFT = false;
        moveRIGHT = false;
        canJump = true;
        vY = 0;
    }

    @Override
    public void dessiner()
    {
        if(classe != null)
        {
            movementSpeed = zComp == 0 ? 150 : 300;

            locationUpdate();
            if(this.mousePressed)
                cameraUpdate();
            jumpManager(10);

            //Camera Mode 1 - Original
            camera(x,y,z,tx,ty,tz,0,-1,0);
        }
        else
        {
            if(!isCorrectCameraFirstTime)
            {
                int tmp = mouseX;
                mouseX = width*2+300;
                cameraUpdate(false);
                mouseX = tmp;
                cameraUpdate(false);

                isCorrectCameraFirstTime = true;
            }

            camera(width/2f,Classe.HAUTEUR/2,(height/2.0f) / tan(PI*60.0f / 360.0f),
                    width/2f,height/2f,0,0,-1,0);
        }

        super.dessiner();
    }

    public float correctAngle(float xc, float zc)
    {
        float newAngle = -degrees(atan(xc / zc));

        if (xComp > 0 && zComp > 0) newAngle = (90 + newAngle) + 90;
        else if (xComp < 0 && zComp > 0) newAngle = newAngle + 180;
        else if (xComp < 0 && zComp < 0) newAngle = (90 + newAngle) + 270;

        return newAngle;
    }

    @Override
    public void mousePressed()
    {
        this.mousePressed = true;
    }

    @Override
    public void mouseReleased()
    {
        this.mousePressed = false;
    }

    public void jumpManager(int magnitude)
    {
        if(classe == null) return;

        if (keyPressed && key == ' ' && canJump)
        {
            vY += magnitude;
            if (vY > magnitude_max) canJump = false;
        }
        else if (y > Classe.HAUTEUR/2)
        {
            vY--;
        }
        else if (y <= Classe.HAUTEUR/2)
        {
            vY = 0;
            y = Classe.HAUTEUR/2;
        }

        if ((!canJump) && (!keyPressed))
        {
            canJump = true;
        }

        y += vY;
    }

    public void keyPressed(KeyEvent event)
    {
        if (keyCode == UP || key == 'z')
        {
            moveZ = -10;
            moveUP = true;
        }

        else if (keyCode == DOWN || key == 's')
        {
            moveZ = 10;
            moveDOWN = true;
        }

        else if (keyCode == RIGHT || key == 'd')
        {
            moveX = -10;
            moveLEFT = true;
        }

        else if (keyCode == LEFT || key == 'q')
        {
            moveX = 10;
            moveRIGHT = true;
        }
    }

    public void keyReleased(KeyEvent event)
    {
        if (keyCode == UP || key == 'z')
        {
            moveUP = false;
            moveZ = 0;
        }
        else if (keyCode == DOWN || key == 's')
        {
            moveDOWN = false;
            moveZ = 0;
        }

        else if (keyCode == RIGHT || key == 'd')
        {
            moveLEFT = false;
            moveX = 0;
        }

        else if (keyCode == LEFT || key == 'q')
        {
            moveRIGHT = false;
            moveX = 0;
        }

        if(event.getKey() == 'p')
            classe.rotatePorte();
    }

    public void locationUpdate()
    {
        float tmpZ = z, tmpTZ = tz, tmpX = x, tmpTX = tx;

        //Apply Movement
        if (moveUP)
        {
            z += zComp / movementSpeed;
            tz += zComp / movementSpeed;
            x += xComp / movementSpeed;
            tx += xComp / movementSpeed;
        }
        else if (moveDOWN)
        {
            z -= zComp / movementSpeed;
            tz -= zComp / movementSpeed;
            x -= xComp / movementSpeed;
            tx -= xComp / movementSpeed;
        }
        if (moveRIGHT)
        {
            z += xComp / movementSpeed;
            tz += xComp / movementSpeed;
            x -= zComp / movementSpeed;
            tx -= zComp / movementSpeed;
        }
        if (moveLEFT)
        {
            z -= xComp / movementSpeed;
            tz -= xComp / movementSpeed;
            x += zComp / movementSpeed;
            tx += zComp / movementSpeed;
        }

        AtomicBoolean collision = new AtomicBoolean(false);
        Utilities.MURS.forEach(m ->
        {
            if(tz > (m.getOrigZ() + m.getLongeur()) && tz < m.getOrigZ() &&
               tx > (m.getOrigX() + m.getLargeur()) && tx < m.getOrigX())
            {
                collision.set(true);
            }
        });

        if(collision.get())
        {
            z = tmpZ;
            tz = tmpTZ;
            x = tmpX;
            tx = tmpTX;
        }
    }

    private void cameraUpdate()
    {
        cameraUpdate(true);
    }

    private void cameraUpdate(boolean updateY)
    {
        int diffX = mouseX - width / 2;
        int diffY = mouseY - height / 2;

        if (abs(diffX) > stillBox)
        {
            xComp = tx - x;
            zComp = tz - z;
            angle = correctAngle(xComp, zComp);

            angle -= diffX / (sensitivity * 10);

            if (angle < 0) angle += 360;
            else if (angle >= 360) angle -= 360;

            float newXComp = cameraDistance * sin(radians(angle));
            float newZComp = cameraDistance * cos(radians(angle));

            tx = newXComp + x;
            tz = -newZComp + z;
        }

        if (updateY && abs(diffY) > stillBox) ty -= diffY / (sensitivity / 5);
    }

    @Override
    public void updateCamera()
    {

    }
}
