

import java.applet.AudioClip;
import java.io.File;

import javax.swing.JOptionPane;

public class Vibrations implements Runnable {

	static Thread musicThread;
	static File sound,music;
	static AudioClip p1,p2;

	
	static{
		try{
			sound=new File("Noise/death_box.wav");
			music=new File("Noise/music.wav");
		}catch(Exception er){JOptionPane.showMessageDialog(null,"Oye!! RaagNI Ki PHIILEN To Mill Hi nahin Rahin ");}
	}

	static void playSound(){

		try{
			p1=java.applet.Applet.newAudioClip(sound.toURI().toURL());
		//	System.out.println(sound.toURI()+"\n"+sound.toURL());
			if(p1!=null){p1.play();}
		}catch(Exception er){//System.out.println("SOUND_FILE_ERROR::"+er);
		}

	}

	void playMusic(){

		musicThread=null;
		musicThread=new Thread(this);
		musicThread.start();

	}

	public void run() {
		try{
			p2=java.applet.Applet.newAudioClip(music.toURI().toURL());
			if(p2!=null){p2.loop();}
		}catch(Exception er){//System.out.println("MUSIC_FILE_ERROR::"+er);
		}
	}

	static void stopMusic(){
		if(p2!=null)p2.stop();

	}
}
