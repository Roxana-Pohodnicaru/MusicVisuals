package example;

import ie.tudublin.Visual;

import processing.core.*;


public class BassBall
{
    MyVisual mv;
    
    Visual v;

    float cy = 0;

    float cx = 0;
    

    public BassBall(MyVisual mv)
    {
        this.mv = mv;

        cy = this.mv.height / 2;

        cx = this.mv.width / 2;

    }


    public void render()
    {
        mv.colorMode(PApplet.HSB);

        float[] waveform = mv.getAudioBuffer().toArray();

        int waveformSize = waveform.length;

        float amplitude = 0;
        

        // calculates x,y coordinates based on amplitude
        for (int i = 0; i < waveformSize; i++)
        {   
            // map index val of current i to angle between 0 - 2pi
            float angle = PApplet.map(i, 0, waveformSize, 0, PConstants.TWO_PI);

            // calculate x,y coordinates using angle calculated
            float x = mv.width/2 + PApplet.cos(angle) * 200 * waveform[i];
            float y = mv.height/2 + PApplet.sin(angle) * 200 * waveform[i];

            // rainbow colour
            mv.stroke(PApplet.map(i, 0, waveformSize, 0, 255), 255, 255);

            mv.line(mv.width/2, mv.height/2, x, y);

            amplitude += Math.abs(waveform[i]);

        }
        

        // creating randomly generating circles for background
        for(int i = 0; i < 10; i++)
        {
            mv.noFill();

            mv.stroke(255,100);

            mv.ellipse(mv.random(mv.height), mv.random(mv.width), 1, 1);

            mv.ellipse(mv.random(mv.width), mv.random(mv.height), 1, 1);

        }
        
        
        amplitude /= waveformSize;

        // make the circle change in size based on amplitude
        float circleSize = 150 + amplitude * 100;

        // circle code
        mv.fill(0);

        mv.stroke(255, 200);

        mv.strokeWeight(4);

        mv.ellipse(cx, cy, circleSize, circleSize);

    }
}