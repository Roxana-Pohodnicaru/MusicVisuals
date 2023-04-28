package example;
import example.parts.BounceBall;
import example.parts.backgrounds.CloudsBackground;
import example.parts.backgrounds.MolecularsBC;
import example.parts.backgrounds.SpeakersBC;
import example.parts.backgrounds.Planet;
import processing.core.*;
import ie.tudublin.*;



public class MyVisual extends Visual
{
    WaveForm wf;
    
    AudioBandsVisual abv;

    //pt1
    CloudsBackground cb;
    

    //pt2
    BounceBall baunceBall;
    SpeakersBC speackersBc;

    //pt3
    //PoliceText pt;

    //pt4
    BassBall bb;
    LeftBackgroundWaves Lbgw;
    RightBackgroundWaves Rbgw;

    //p5
    MolecularsBC molecularsBC;
    Lyrics Lyrics;

    //p6
    ThirdDrop td;

    //part 7
    Fairies fairies;
    Planet planet;



    int mode = 1;
    int numbersOfPurts = 6;



    boolean lastPressed = false;
    boolean showLyrics = false;

    

    public void settings(){

        size(1024, 1024);
        
        // Use this to make fullscreen

        fullScreen();

        ///Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }


    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Hensonn_Flare.mp3");  
         
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);

        //pt1
        cb = new CloudsBackground(this);
        
        //pt2
        baunceBall = new BounceBall(this);
        speackersBc = new SpeakersBC(this);

        //pt3
        //pt =  new PoliceText(this);

        //pt4
        bb = new BassBall(this);
        Lbgw = new LeftBackgroundWaves(this);
        Rbgw = new RightBackgroundWaves(this);

        //pt5
        molecularsBC = new MolecularsBC(this);

        //pt 6
        td = new ThirdDrop(this);
        Lyrics = new Lyrics(this);

        // part 7
        planet = new Planet(this);
        fairies = new Fairies(this);
        
    }


    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        else if(key == 'p') 
        {
            showLyrics = true;
        }
        else if(key == 'o') 
        {
            showLyrics = false;
        }
    }



    @Override
    public void draw(){
        background(0);

		switch(mode) {
            case 1: 
                partOne();
                break;
            case 2: 
                partTwo(); 
                break;
            case 3:
                partThree();
                break;   
            case 4:
                partFour();
                break;   
            case 5: 
                partFive();
                break;
            case 0:
                partSix();
                break;
            default:
                break;
        }   

        keyPressingLogic();

}


    void keyPressingLogic(){
        if(keyPressed){
            switch(key){
                case '1':
                    mode = 1;
                    break;
                case '2':
                    mode = 2;
                    break;
                case '3':
                    mode = 3;
                    break;
                case '4':
                    mode = 4;
                    break;
                case '5':
                    mode = 0;
                    break;
                default:
                    break;
            }
            lastPressed = true;
        } else{
            lastPressed = false;
        }
    }



    void partOne(){          
        calculateAverageAmplitude(); 
        cb.render();

        int numStars = PApplet.round(map(getAmplitude(), 0, 1, 0, 50));
        for (int i = 0; i < numStars ; i++)
        {
            Stars s = new Stars(this);
            s.draw();
        }
    }


    void partTwo(){
        try {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
            // Call this is you want to use frequency bands
            calculateFrequencyBands(); 

            // Call this is you want to get the average amplitude
            calculateAverageAmplitude(); 

        molecularsBC.render();
        baunceBall.render();
        if (showLyrics) {
            Lyrics.update();
            Lyrics.render();
        }
    }

    
    void partThree(){

        bb.render();
        Lbgw.render();
        Rbgw.render();
    }


    void partFour(){
        calculateAverageAmplitude(); 
        speackersBc.render();
        td.draw();
    }
    
    void partFive(){
        
        // steph piano tiles
    }

    void partSix(){
        
        fairies.render();
        planet.render();

    }
}