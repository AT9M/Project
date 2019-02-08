package application;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.LpcWhisperiserEffect;
import marytts.signalproc.effects.RobotiserEffect;
import marytts.signalproc.effects.StadiumEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.signalproc.effects.VolumeEffect;
import org.hsqldb.Database;
import org.hsqldb.server.Server;

import javax.print.URIException;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.lang.Object;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    static final int PORT = 8080;

	/**
	 * The main method from which our application is starting
	 * 
	 * @param args
	 */
    private Socket connect;
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
		//Create TextToSpeech
		TextToSpeech tts = new TextToSpeech();

		//=========================================================================
		//======================= Print available AUDIO EFFECTS ====================
		//=========================================================================
		
		//Print all the available audio effects
		//tts.getAudioEffects().stream().forEach(audioEffect -> {
		//	System.out.println("-----Name-----");
		//	System.out.println(audioEffect.getName());
		//	System.out.println("-----Examples-----");
		//	System.out.println(audioEffect.getExampleParameters());
		//	System.out.println("-----Help Text------");
		//	System.out.println(audioEffect.getHelpText() + "\n\n");
			
		//});
		//=========================================================================
		//========================= Print available voices =========================
		//=========================================================================
		
		//Print all the available voices
		//tts.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
		
		// Setting the Current Voice

		
		//=========================================================================
		//========================= Let's try different effects=====================
		//=========================================================================
		
		//----- Hey you !-> check the help that is being printed on the console
		//----- You will understand how to use the effects better :)
		
		//VocalTractLinearScalerEffect
		//VocalTractLinearScalerEffect vocalTractLSE = new VocalTractLinearScalerEffect(); //russian drunk effect
		//vocalTractLSE.setParams("amount:70");
		
		//JetPilotEffect
		JetPilotEffect jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:100");
		
		//RobotiserEffect
		//RobotiserEffect robotiserEffect = new RobotiserEffect();
		//robotiserEffect.setParams("amount:50");
		
		//StadiumEffect
		StadiumEffect stadiumEffect = new StadiumEffect();
		stadiumEffect.setParams("amount:150");
		
		//LpcWhisperiserEffect
		LpcWhisperiserEffect lpcWhisperiserEffect = new LpcWhisperiserEffect(); //creepy
		lpcWhisperiserEffect.setParams("amount:70");
		
		//VolumeEffect
		VolumeEffect volumeEffect = new VolumeEffect(); //be careful with this i almost got heart attack
		volumeEffect.setParams("amount:0");
		
		//Apply the effects
		//----You can add multiple effects by using the method `getFullEffectAsString()` and + symbol to connect with the other effect that you want
		//----check the example below
		//tts.getMarytts().setAudioEffects(jetPilotEffect.getFullEffectAsString());// + "+" + stadiumEffect.getFullEffectAsString());
        System.out.printf("What's your name ?\n");
        Scanner nm = new Scanner(System.in);
        String NN = nm.next();
		int flag=0,flag2=0;
		System.out.printf("Do you want me to be a girl or a boy ?\n");
        Scanner sexe = new Scanner(System.in);
        String Sexe = sexe.next();
        switch (Sexe) {
            case "girl":
                tts.setVoice("dfki-poppy-hsmm");
                flag=1; flag2=0;
                break;

            case "boy":
                tts.setVoice("cmu-rms-hsmm");
                flag=1;
                flag2=1;
                break;
                default:
            System.out.printf("Pas d'autre option\n");break;
        }
if(flag==1) {

    String commande;

    System.out.printf("I'm ready to follow your instruction\n");
    tts.speak("I'm ready to follow your instruction", 1.0f, false, false);
    do {
        Scanner command = new Scanner(System.in);
        commande = command.next();
        switch (commande) {
            case "who":
                if(flag2==0) {
                    tts.speak("It's Alicia, i am an Virtual assistant !", 1.0f, false, false);
                }
                 if (flag2==1)
                {
                    tts.speak("It's Eduardo, i was made by liam !", 1.0f, false, false);
                }
                break;

            case "today":
                tts.speak("Today is " + LocalDate.now() + " ", 1.0f, false, false);
                System.out.printf("Aujourd'hui :" + LocalDate.now() + "\n");
                break;

            case "file":
                try {
                    File file = new File("C:\\Users\\melia\\Desktop\\Divers\\Assistant file\\file.txt");
                    /*If file gets created then the createNewFile()
                     * method would return true or if the file is
                     * already present it would return false
                     */
                    boolean fvar = file.createNewFile();
                    if (fvar) {
                        System.out.println("File has been created successfully");
                    } else {
                        System.out.println("File already present at the specified location");
                    }
                } catch (IOException e) {
                    System.out.println("Exception Occurred:");
                    e.printStackTrace();
                }
                tts.speak("it's done !", 1.0f, false, false);
                System.out.printf("Voila vous trouverez votre fichier ici C:\\Users\\melia\\Desktop\\Divers\\Assistant file\\\n");
                break;
            case "web":
                tts.speak("What site do you want, first type in the name, then type in the address" , 1.0f, false, false);
                Scanner Nan = new Scanner(System.in);
                String Name1 = Nan.next();
                Scanner Nan2 = new Scanner(System.in);
                String Name2 = Nan2.next();
                try {

                    Desktop.getDesktop().browse(new URI("http://www."+Name1+"."+Name2+""));
                } catch (URISyntaxException e) {
                    //e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "bye":
                tts.speak("Good bye "+NN+" !", 1.0f, false, false);
                System.out.printf("Au revoir\n");
                commande = "arret";
                break;
            case "sexe":

                if(flag2==0){
                    tts.setVoice("cmu-rms-hsmm");
                    flag2=1;

                }
              else{
                    tts.setVoice("dfki-poppy-hsmm");flag2=0;
                }
                tts.speak("Transformation complete", 1.0f, false, false);
                break;
            case "flag":
                System.out.printf(+flag2+"\n");
                break;
            case "say":
               // tts.speak("What do you want me to say ?", 1.0f, false, false);
                System.out.printf("Type in\n");
                Scanner commandV = new Scanner(System.in);
                String commandeV = commandV.next();
                System.out.printf("Understood\n");
                tts.speak(commandeV, 1.0f, false, false);
                break;


            default:
                tts.speak("i haven't understand, could you please try again", 1.0f, false, false);
                break;
            case"play":

                try {

                    Desktop.getDesktop().browse(new URI( "https://www.youtube.com"));
                } catch (URISyntaxException e) {
                    //e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "murphy":

                Random rr= new Random();

              Murphy M = new Murphy();


                tts.speak(  M.Murphy(rr.nextInt(19)), 1.0f, false, false);

                break;

            case "list":
                    

                tts.speak("I will display the command on the console", 1.0f, false, false);
                System.out.printf("who\n" +
                        "game\n" +
                        "today\n" +
                        "play\n" +
                        "murphy\n" +
                        "say\n" +
                        "sexe (change voice sex)\n" +
                        "web\n" +
                        "file\n");
                break;
            case "game":
                tts.speak( "I have two games what do you perfer one Missile commando , two space invader ", 1.0f, false, false);


                Scanner gamme = new Scanner(System.in);
                String gammee = gamme.next();
                switch (gammee){
                    case "1":
                        tts.speak( "I will launch  the game Missile commando", 1.0f, false, false);
                        JFrame frame = new JFrame("FrameDemo");


                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JLabel emptyLabel = new JLabel();

                        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);


                        frame.pack();

                        MissileCommando k = new MissileCommando();
                        frame.setVisible(true);
                        frame.add(k);

                        k.init();
                        k.newGame();break;
                    case "2":
                        tts.speak( "I will launch  the game Space Invader", 1.0f, false, false);
                        SpaceInvaders ghj = new  SpaceInvaders();

                         break;

                    default:
                        tts.speak( "It's not a game, please try again", 1.0f, false, false);
                        break;
                }
            break;


        }

    }
    while (commande != "arret");
}
}
	public void differentspeech() {
		TextToSpeech tts = new TextToSpeech();
		

		
		//Print all the available voices
		tts.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
		
		// Setting the Current Voice

		
		// Setting the Voice
		tts.setVoice("dfki-poppy-hsmm");
		
		// TTS say something that we actually are typing into the first variable
		tts.speak("", 2.0f, false, true);
		
		// Setting the Voice
		tts.setVoice("cmu-rms-hsmm");
		
		// TTS say something that we actually are typing into the first variable
		tts.speak("", 2.0f, false, true);
		
	}


    private static class AudioStream {
    }
}
