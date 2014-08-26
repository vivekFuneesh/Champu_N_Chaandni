
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

MainFrame.java is part of Champu_N_Chaandni.

    Champu_N_Chaandni is free Game: you can redistribute it    and/or modify
    it under the terms of the GNU General Public License as published     by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champu_N_Chaandni is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champu_N_Chaandni.  If not, see <http://www.gnu.org/licenses/>.

*******************************************************************
*/

import java.applet.AudioClip;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author vivek
 */

public class MainFrame extends JFrame implements Runnable{
    
    static AudioClip p1,p2;
    static int pWidth,pHeight;
    static File sound,music;
    static Main main;
    static MainFrame mf;
    static Thread musicThread;
    
    static{
        try{
        sound=new File("Noise/death_box.wav");
        music=new File("Noise/music.wav");
        }catch(Exception er){JOptionPane.showMessageDialog(null,"Oye!! RaagNI Ki PHIILEN To Mill Hi nahin Rahin ");}
          }
    
    public MainFrame(){
    super("ChAmPu_N_CHaaNdnI");
   try{ setUndecorated(true);
    pack();
    setResizable(false);
    calculateSizes();
    setResizable(true);
    Container c=getContentPane();
    main=new Main(pWidth,pHeight);
    c.add(main,"Center");
    new GUI(main);
    setJMenuBar(GUI.jmb);
    //setSize(pWidth,pHeight);
    pack();
    //System.out.println(pWidth+"  "+pHeight);
   // GUI.setMainFrame(this);
    setResizable(false);
    setVisible(true);
    }catch(Exception er){}
                      }
    
    private void calculateSizes(){
    
        GraphicsConfiguration gc=getGraphicsConfiguration();
        Rectangle screenRect=gc.getBounds();
       // Toolkit tk=Toolkit.getDefaultToolkit();
       // Insets desktopInsets=tk.getScreenInsets(gc);
       // Insets frameInsets=getInsets();System.out.println(frameInsets);
        pWidth=screenRect.width;//-(desktopInsets.left+desktopInsets.right)-(frameInsets.left+frameInsets.right);
        pHeight=screenRect.height;//-(desktopInsets.bottom+desktopInsets.top)-(frameInsets.bottom+frameInsets.top);
        
                                 }
    
    public static void main(String[] arg){
    
    try{
     SwingUtilities.invokeLater(new Runnable() {
            public void run() {
    mf=new MainFrame();    mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
         
            }
        });
    }catch(Exception er){JOptionPane.showMessageDialog(null,"Kuch Errrr Aaaa rrrrra hhh..::DekH Le BhAI::"+er);}
                                        }
    
    static void playSound(){
    
        try{
    p1=java.applet.Applet.newAudioClip(sound.toURI().toURL());
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
