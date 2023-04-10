package example;

import javax.swing.border.StrokeBorder;

import processing.core.*;

// This is an example of a visual that renders the waveform
public class BassBall
{
    MyVisual mv;
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
        mv.colorMode(PApplet.RGB);
        
        
        mv.noFill();
        mv.stroke(255, 255);
        mv.strokeWeight(4);
        mv.ellipse(cx, cy, 150, 150);

    }
}