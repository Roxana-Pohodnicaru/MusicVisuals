package example;

import processing.core.*;

public class LeftBackgroundWaves {

    MyVisual mv;

    float cx = 0;

    public LeftBackgroundWaves(MyVisual mv)
    {
        this.mv = mv;

        // for location of waveform
        cx = this.mv.width / 6; 
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);

        float[] waveform = mv.getAudioBuffer().toArray();

        int waveformSize = waveform.length;


        // creates the waveform
        for (int i = 0; i < waveformSize; i++)
        {
            mv.stroke(PApplet.map(i, 0, waveformSize, 0, 255), 255, 255);
            

            // these coordinates place the waveform on the left hand side of the screen vertically
            float x1 = cx;

            // height of waveform
            float y1 = PApplet.map(i, 0, waveformSize, 0, mv.height);

            // width of waveform
            float x2 = cx + waveform[i] * 200;

            float y2 = y1;

            mv.line(x1, y1, x2, y2);
            
        }
    }
}
