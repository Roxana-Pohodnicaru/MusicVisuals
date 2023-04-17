package example;

import processing.core.*;

public class Fairies
{

    MyVisual mv;

    float cy = 0;

    float cx = 0;

    float[] x;

    float[] y;

    float[] size;

    int numPoints = 100;


    public Fairies(MyVisual mv)
    {
        this.mv = mv;

        cy = this.mv.height/2;

        cx = this.mv.width/2;

        x = new float[numPoints];

        y = new float[numPoints];

        size = new float[numPoints];

        // assigning random x, y, and size values for circle coordinates
        for (int i = 0; i < numPoints; i++)
        {
            x[i] = mv.random(mv.width);

            y[i] = mv.random(mv.height);

            size[i] = mv.random(5, 20);
        }

    }

    public void render()
    {
        mv.colorMode(PApplet.RGB);

        // update point sizes based on audio buffer values
        for (int i = 0; i < numPoints; i++)
        {
            size[i] = 5 + mv.getAudioBuffer().get(i * mv.getAudioBuffer().size() / numPoints) * 100;

        }

        mv.strokeWeight(2);

        mv.fill(255, 197, 40, 100);

        mv.stroke(255,192,82,50);

        // used to make circles follow the mouse briefly
        for (int i = 0; i < numPoints; i++)
        {
            float mx = mv.mouseX - x[i];

            float my = mv.mouseY - y[i];

            // dist between point and mouse using pythagoras
            float dist = PApplet.sqrt(mx * mx + my * my);

            // move the circles towards the mouse if true
            // move circle by amount proportional to dist && 100 - dist for gentle 'fairy' effect
            if (dist < 100)
            {
                x[i] += mx * (100 - dist) / 1000;

                y[i] += my * (100 - dist) / 1000;

            }

            // draw circle
            mv.ellipse(x[i], y[i], size[i], size[i]);

        }

        // move the points randomly
        for (int i = 0; i < numPoints; i++)
        {
            x[i] += mv.random(-2, 2);

            y[i] += mv.random(-2, 2);


            // check if circle goes outside screen size
            if (x[i] < 0)
            {
                x[i] = mv.width;

            }
             
            if (x[i] > mv.width)
            {
                x[i] = 0;

            }
             
            if (y[i] < 0)
            {
                y[i] = mv.height;

            }

            if (y[i] > mv.height)
            {
                y[i] = 0;

            } 

        }
    }
}