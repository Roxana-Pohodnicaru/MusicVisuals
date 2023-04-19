package example.parts.backgrounds;

import processing.core.*;

import example.MyVisual;


public class Planet
{
    MyVisual mv;

    float cy = 0;

    float cx = 0;


    public Planet(MyVisual mv)
    {
        this.mv = mv;

        cy = this.mv.height/2;

        cx = this.mv.width/2;
    }


    public void render()
    {
        mv.colorMode(PApplet.RGB);

        mv.ellipse(cx, cx, cy, cx);
        

        
    }
}