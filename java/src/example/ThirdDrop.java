package example;

import processing.core.*;

public class ThirdDrop {
    
    MyVisual mv;
    float t = 0; // time variable for animation

    //  first mountain blue, the second mountain pink, the third mountain green, the fourth mountain yellow, and the last mountain orange,
    int[] mountainColors = {0xff0099ff, 0xffff66cc, 0xff00cc66, 0xffffff00, 0xffff9900};

    
    public ThirdDrop(MyVisual mv) {
        this.mv = mv;
    }

    public void draw() {
    
        // Draw mountains
        int numMountains = mountainColors.length; // number of mountains
        for (int r = 0; r < numMountains; r++) {
            // Set the fill color of the mountain range
            mv.fill(mountainColors[r]);
            
            mv.noStroke();
            mv.beginShape();
            mv.vertex(-10, mv.height);
            for (int i = 0; i < mv.width; i += 50) {
                float y = PApplet.map(mv.noise(t + i + r * 100), 0, 1, mv.height / 8, mv.height);
                // Calculate the amount to adjust the y coordinate based on the music amplitude
                float adjustYcoordinate = mv.getAmplitude() * 200;
                // Add the amplitude offset to the y coordinate of the vertex
                mv.vertex(i, y + adjustYcoordinate);
            }
            mv.vertex(mv.width + 10, mv.height);
            mv.endShape();
        }
    
        // Update time for animation
        t += 0.01;
    }
    
}
