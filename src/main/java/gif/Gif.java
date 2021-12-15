package gif;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Gif extends PImage implements PConstants, Runnable
{
    private final PApplet parent;
    private final PImage[] frames;
    private final int[] delays;

    private boolean play;
    private boolean loop;
    private boolean ignoreRepeatSetting = false;
    private int repeatSetting = 1;
    private int repeatCount = 0;
    private int currentFrame;
    private int lastJumpTime;

    private Thread runner;

    private long waitTime;

    public Gif(PApplet parent, String filename, int framerate)
    {
        this(parent, filename);

        this.waitTime = 1000L / Math.max(Math.abs(framerate), 5);
    }

    public Gif(PApplet parent, String filename)
    {
        super(1, 1, ARGB);

        this.parent = parent;


        GifDecoder gifDecoder = createDecoder(parent, filename);


        frames = extractFrames(gifDecoder);
        delays = extractDelays(gifDecoder);
        waitTime = 30;

        repeatSetting = gifDecoder.getLoopCount();

        super.init(frames[0].width, frames[0].height, ARGB);
        jump(0);
        parent.registerMethod("dispose", this);

        runner = new Thread(this);
        runner.start();
    }

    public void dispose()
    {
        stop();
        runner = null;
    }

    public void run()
    {
        while (Thread.currentThread() == runner)
        {
            try
            {
                Thread.sleep(this.waitTime);
            }
            catch (InterruptedException ignored)
            {}

            if (play)
            {


                if (parent.millis() - lastJumpTime >= delays[currentFrame])
                {


                    if (currentFrame == frames.length - 1)
                    {

                        if (loop)
                        {
                            jump(0);
                        }
                        else if (!ignoreRepeatSetting)
                        {


                            repeatCount++;
                            if (repeatSetting == 0)
                            {

                                jump(0);
                            }
                            else if (repeatCount == repeatSetting)
                            {


                                stop();
                            }
                        }
                        else
                        {


                            stop();
                        }
                    }
                    else
                    {

                        jump(currentFrame + 1);
                    }
                }
            }
        }
    }

    private static InputStream createInputStream(PApplet parent, String filename)
    {
        InputStream inputStream = parent.createInput(filename);
        return inputStream;
    }

    public static PImage[] getPImages(PApplet parent, String filename)
    {
        GifDecoder gifDecoder = createDecoder(parent, filename);
        return extractFrames(gifDecoder);
    }

    public PImage[] getPImages()
    {
        return frames;
    }

    private static GifDecoder createDecoder(PApplet parent, String filename)
    {
        GifDecoder gifDecoder = new GifDecoder();
        gifDecoder.read(createInputStream(parent, filename));
        return gifDecoder;
    }

    private static PImage[] extractFrames(GifDecoder gifDecoder)
    {
        int n = gifDecoder.getFrameCount();

        PImage[] frames = new PImage[n];

        for (int i = 0; i < n; i++)
        {
            BufferedImage frame = gifDecoder.getFrame(i);
            frames[i] = new PImage(frame.getWidth(), frame.getHeight(), ARGB);
            System.arraycopy(frame.getRGB(0, 0, frame.getWidth(), frame.getHeight(), null, 0, frame.getWidth()), 0,
                    frames[i].pixels, 0, frame.getWidth() * frame.getHeight());
        }
        return frames;
    }

    private static int[] extractDelays(GifDecoder gifDecoder)
    {
        int n = gifDecoder.getFrameCount();
        int[] delays = new int[n];
        for (int i = 0; i < n; i++)
        {
            delays[i] = gifDecoder.getDelay(i);

        }
        return delays;
    }

    public void ignoreRepeat()
    {
        ignoreRepeatSetting = true;
    }

    public int getRepeat()
    {
        return repeatSetting;
    }

    public boolean isPlaying()
    {
        return play;
    }

    public int currentFrame()
    {
        return currentFrame;
    }

    public boolean isLooping()
    {
        return loop;
    }

    public boolean isIgnoringRepeat()
    {
        return ignoreRepeatSetting;
    }

    public void play()
    {
        play = true;
        if (!ignoreRepeatSetting)
        {
            repeatCount = 0;
        }
    }

    public void loop()
    {
        play = true;
        loop = true;
    }


    public void noLoop()
    {
        loop = false;
    }


    public void pause()
    {

        play = false;
    }


    public void stop()
    {

        play = false;
        currentFrame = 0;
        repeatCount = 0;
    }


    public void jump(int where)
    {
        if (frames.length > where)
        {
            currentFrame = where;

            loadPixels();
            System.arraycopy(frames[currentFrame].pixels, 0, pixels, 0, width * height);
            updatePixels();

            lastJumpTime = parent.millis();
        }
    }

}
