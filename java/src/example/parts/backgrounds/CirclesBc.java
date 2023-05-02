package example.parts.backgrounds;

import example.MyVisual;
import processing.core.PConstants;

public class CirclesBc {

    MyVisual mv;
    float t = 0;

    public CirclesBc(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        mv.background(0);
        float[] waveform = mv.getAudioBuffer().toArray();
        int waveformSize = waveform.length;
        float amplitude = 0;

        mv.stroke(255, 255, 255, 100);
        mv.strokeWeight(10);

        int numLines = 50;
        float lineWidth = mv.width / numLines;

        for (int i = 0; i < waveformSize; i++) {
            float x = i * lineWidth + lineWidth / 2;
            float y = mv.height *  waveform[i];
            float offset = mv.map(mv.noise(t + i), 0, 1, -50, 50);
            mv.line(x + offset, y + 100, x + offset, y - 100);
        }

        t += 0.1;
    }

}
