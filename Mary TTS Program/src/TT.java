

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static sun.misc.Version.print;


public class TT {

    public static native int SystemParametersInfo(int uiAction, int uiParam, String pvParam, int fWinIni);

    static {
        System.loadLibrary("user32");
    }

    public int Change(String path) {
        return SystemParametersInfo(20, 0, path, 0);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("hello");
        application.TextToSpeech tts = new application.TextToSpeech();
        tts.setVoice("cmu-rms-hsmm");

        String comm = "a";
        while (comm!="stop") {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter command");

            comm = myObj.nextLine();  // Read user input

            String monthString;
            switch (comm) {
                case "help":
                    System.out.print("help\n" +
                            "say\n" +
                            "web\n" +
                            "today\n" +
                            "home\n" +
                            "back\n" +
                            "game\n");

                    break;
                case "say":
                    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter command");

                    String comm2 = myObj2.nextLine();  // Read user input
                    tts.speak(comm2, 2.0f, false, true);
                    break;
                case "web":
                    Desktop.getDesktop().browse(new URI("http://www.google.ie"));
                    break;

                case "today":
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    System.out.println(dateFormat.format(date));
                    break;

                case "home":
                    Desktop.getDesktop().browse(new URI("http://www.myhome.ie"));
                    break;

                case "back":
                    // JFileChooserDemo application = new JFileChooserDemo();
                    // application.setSize(400, 400);
                    //  application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //  application.setVisible(true);
                    String wallpaper_file = "path";
                    TT mychanger = new TT();
                    mychanger.Change(wallpaper_file);
                    break;

                case "game":
                     GravitySoccer g = new GravitySoccer();
                    g.main();

                    break;

            }

        }

    }
}

