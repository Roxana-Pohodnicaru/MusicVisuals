package example;

import processing.core.*;


public class Butterflies
{
    MyVisual mv;
    float cy = 0;

    public Butterflies(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }

    
    public void render()
    {
        mv.colorMode(PApplet.HSB);

        float[] waveform = mv.getAudioBuffer().toArray();

        int waveformSize = waveform.length;

        mv.strokeWeight(2);
        
        for (int i = 0; i < waveformSize; i++)
        {
            float angle = PApplet.map(i, 0, waveformSize, 0, PConstants.TWO_PI);

            float x = mv.width/2 + PApplet.cos(angle) * 500 * waveform[i];
            float y = mv.height/2 + PApplet.sin(angle) * 500 * waveform[i];

            mv.stroke(PApplet.map(i, 0, waveformSize, 0, 255), 255, 255);

            mv.line(mv.width/2, mv.height/2, x, y);

        }
    }

}