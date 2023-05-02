package example.parts;

import example.MyVisual;

public class Piano {
  MyVisual mv;
  float keyWidth;
  float keyHeight;
  float blackKeyWidth = keyWidth / 2;
  int numKeys;
  int[] keyColors;
  int offcet = 30;

  public Piano(MyVisual mv) {
    this.mv = mv;
    this.numKeys = 12;
    keyColors = new int[] {mv.color(255), mv.color(0)};
  }

  public void render() {
    mv.strokeWeight(5);

    float[] waveform = mv.getAudioBuffer().toArray();
    int waveformSize = waveform.length;
    float amplitude = 0;

    for (int i = 0; i < waveformSize; i++) {   
        if (waveform[i] > amplitude) {
            amplitude = waveform[i];
        }
    }

    amplitude = mv.map(amplitude, 0, 1, 0, numKeys - 1);
    keyWidth = mv.width / numKeys;
    keyHeight = mv.height/3 + 100;

    paintWhite(amplitude);
    paintBlack(amplitude);
    drawBall(amplitude);
  }
  

  void paintWhite(float amplitude) {
    mv.fill(keyColors[0]);
    mv.stroke(0);

    for (int i = 0; i < numKeys; i++) {
        float keyX = i * keyWidth;
        float keyY = 0;
        float keyYDown = keyHeight;
        if(i == (int)amplitude){
            keyYDown = keyHeight + offcet;
            mv.fill(mv.map(i, 0, numKeys-1, 0, 255), 255, 255);
        } else {
            mv.fill(keyColors[0]);
        }
        mv.rect(keyX, keyY, keyWidth, keyYDown);
    }
  }

  void paintBlack(float amplitude){
    float blackKeyWidth = keyWidth / 2;
    float blackKeyHeight = keyHeight / 2;
    float keyYDown = blackKeyHeight;
        for (int i = 0; i < numKeys; i++) {
        if(i == (int)amplitude){
            mv.fill(255, 255, mv.map(i, 0, numKeys-1, 0, 255));
        } else {
            mv.fill(keyColors[1]);
        }
      if (i % 7 != 2 && i % 7 != 6) {
        mv.rect(i * keyWidth + keyWidth - blackKeyWidth / 2, 0, blackKeyWidth, keyYDown);
      }
    }
  }

  void drawBall(float amplitude) {

    float ballY = keyHeight + 2 * offcet;
    float ballSpeedX = 10;
    float ballSpeedY = 40;
    float ballX = mv.map(amplitude, 0, numKeys - 1, 0, 800);
    int ballSize = 60;
  
    // update ball position
    ballX += ballSpeedX;
    ballY += ballSpeedY;
  
    // check for collision with walls
    if (ballX > mv.width - ballSize / 2 || ballX < ballSize / 2) {
      ballSpeedX *= -1;
    }
    if (ballY < ballSize / 2) {
      ballSpeedY *= -1;
    }
  
    // check for collision with piano
    if (ballY + ballSize / 2 > mv.height - keyHeight) {
      float keyWidthWithBlack = keyWidth + (keyWidth / 2);
      int blackKeyOffset = (int) ((keyWidthWithBlack / 2) + ((ballX % keyWidthWithBlack) / 2));
      int whiteKeyOffset = (int) (ballX % keyWidthWithBlack);
      if (blackKeyOffset < blackKeyWidth / 2) {
        mv.stroke(255);
        mv.strokeWeight(3);
        mv.ellipse(ballX, ballY - ballSize / 2, ballSize, ballSize);
      } else if (blackKeyOffset > keyWidthWithBlack - blackKeyWidth / 2) {
        mv.stroke(255);
        mv.strokeWeight(3);
        mv.ellipse(ballX, ballY - ballSize / 2, ballSize, ballSize);
      } else if (whiteKeyOffset < keyWidth / 2) {
        mv.stroke(255);
        mv.strokeWeight(3);
        mv.ellipse(ballX, ballY - ballSize / 2, ballSize, ballSize);
      } else {
        mv.stroke(255);
        mv.strokeWeight(3);
        mv.ellipse(ballX, ballY - ballSize / 2, ballSize, ballSize);
      }
    } else {
      mv.stroke(255);
      mv.strokeWeight(3);
      mv.ellipse(ballX, ballY, ballSize, ballSize);
    }
  }
}

//mv.map(amplitude, 0, numKeys - 1, mv.height - 100, mv.height - keyHeight + offcet)