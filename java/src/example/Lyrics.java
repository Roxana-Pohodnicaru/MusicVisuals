package example;

import processing.core.*;

public class Lyrics {
    private MyVisual mv;
    private String lyricLeft = "If you were a vegetable";
    private String lyricRight = "you'd be a cutecumber";
    private int lyricY = 500;
    private int sizeOfLyric = 48;
    private float positioning = 0.0f;
    private float speedOfText = 2.0f;

    public Lyrics(MyVisual mv) {
        this.mv = mv;
        mv.textFont(mv.createFont("Arial Bold", sizeOfLyric));
    }

    public void update() {
        if (positioning < mv.width / 4) {
            positioning += speedOfText;
        } else {
            speedOfText = 0;
        }
    }

    public void render() {
        mv.pushStyle();

        mv.fill(0);
        mv.textAlign(PConstants.RIGHT, PConstants.CENTER);
        mv.textSize(sizeOfLyric);
        mv.text(lyricLeft, mv.width / 2 + positioning, lyricY - 20);

        mv.fill(0);
        mv.textAlign(PConstants.LEFT, PConstants.CENTER);

        mv.textSize(sizeOfLyric);
        mv.text(lyricRight, mv.width / 2 - positioning, lyricY + 20);
        mv.popStyle();
    }
}
