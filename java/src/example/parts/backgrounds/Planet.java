package example.parts.backgrounds;

import processing.core.*;

import example.MyVisual;


public class Planet {

    MyVisual mv;

    float cy = 0;
    
    float cx = 0;

    
    public Planet(MyVisual mv)
    {
        this.mv = mv;

        cy = this.mv.height / 2;

        cx = this.mv.width / 2;

    }


    public void render() 
    {

        mv.colorMode(PApplet.RGB);

        mv.strokeWeight(2);

        mv.stroke(200);

        mv.noFill();


        // top left planet ring
        mv.pushMatrix();

        mv.translate(cx/3, cy/3);

        mv.rotate(mv.frameCount * 0.01f);

        mv.ellipse(0, 0, cy * 0.7f, cy * 0.2f);

        mv.popMatrix();


        // top left planet
        mv.noStroke();

        mv.fill(73, 175, 253);

        mv.ellipse(cx/3, cy/3, cy * 0.3f, cy * 0.3f);

        // draws infite circles decreasing in size
        // inside left planet
        // colour ranges in the blue
        for (float circle = cy * 0.3f; circle >= 0; circle -= (30))
        {
            mv.fill(mv.random(70,120), mv.random(100,150), mv.random(200,256));

            mv.ellipse(cx/3, cy/3, circle, circle);
            
        }

        
        mv.strokeWeight(2);

        mv.stroke(200);

        mv.noFill();

        // bottom right planet ring
        mv.pushMatrix();

        mv.translate(cx + cx/2, cy + cy/2);

        mv.rotate(mv.frameCount * -0.01f);

        mv.ellipse(0, 0, cy * 1.5f, cy * 0.5f);

        mv.popMatrix();


        // bottom right planet
        mv.noStroke();

        mv.fill(100, 255, 100);

        mv.ellipse(cx + cx/2, cy + cy/2, cy * 0.8f, cy * 0.8f);

        // draws infite circles decreasing in size
        // inside right planet
        // colour ranges in the green
        for (float circle = cy * 0.8f; circle >= 0; circle -= (30))
        {
            mv.fill(mv.random(100,150), mv.random(200,256), mv.random(100,150));

            mv.ellipse(cx + cx/2, cy + cy/2, circle, circle);
            
        }
    }
}