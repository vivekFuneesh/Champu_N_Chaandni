
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

AboutFrame.java is part of Champu_N_Chaandni.

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


/**
 *
 * @author vivek
 */

class AboutFrame extends JFrame implements ActionListener{
    
    static JButton Close;
    static JPanel buttonPanel;
   
    
    AboutFrame(){
       
        super("ChAmPu_N_CHaaNdnI");
       
       
    setUndecorated(true);
    setLayout(new BorderLayout());
    Container c=getContentPane();
    
    c.add(new AboutPane(),BorderLayout.CENTER);
    Close=new JButton("Close");
    buttonPanel=new JPanel();buttonPanel.add(Close);
    c.add(buttonPanel,BorderLayout.EAST);Close.addActionListener(this);
    pack();setSize(Main.pWidth,Main.pHeight);
    setResizable(false);setVisible(true);
    addWindowListener(
       new WindowAdapter(){
       @Override public void windowClosing(WindowEvent s){setEnabled(false);dispose();setVisible(false);}});
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==Close){setEnabled(false);setVisible(false);this.dispose();}
    }
     
    
}

class AboutPane extends JTabbedPane{

    static AboutPanel Controls,AbP[];
    static String name;
    static String msg=""; 
    AboutPane(){
       
        AbP=new AboutPanel[6];
        
        for(int i=0;i<5;i++)
        {
            AbP[i]=new AboutPanel();
            AbP[i].setLayout(new GridLayout(1,2));
            AbP[i].add(new image(i));
            AbP[i].add(new JScrollPane(create(i)));
            addTab(getName(i),AbP[i]);
        }
        
         Controls=new AboutPanel();
         Controls.setLayout(new GridLayout(1,2));
         Controls.add(new image(5));
         Controls.add(new JScrollPane(create(5)));
         addTab("Controls",Controls);
        
        
        
    }
    
  //-SET FONT-STYLE,SIZE,BACKGROUNDCOLOR,FOREGROUNDCOLOR  
    
     JTextArea create(int i){
    
        JTextArea jt;
        Font font;
        font = new Font(Font.SERIF, Font.BOLD, 50);
        jt=new JTextArea(getInfo(i),5,5);
        jt.setFont(font);jt.setEditable(false);
        jt.setBackground(Color.black);jt.setLineWrap(true);jt.setWrapStyleWord(true);
        jt.setForeground(Color.GREEN);
        return jt;
        
    }
    
     String getName(int i){name="";
    if(i==0)return "ConFuSDD_ColOnYY";
    else if(i==1)return "STOONE";
    else if(i==2)return "MovING_STOONES";
    else if(i==3)return "NOMADIC_StooNeSS";
    else return "ChamPU_NOMAD_PERVERT";
        
    }
    
     String getInfo(int i){
         
         if(i==0){
             msg="Well, length of Colonies are UNKNOWN. "
                     + "Only, for first 1-2 seconds BoTh CaNnoT diE fRoM rOdS, reSt iS kNoWn tO ChaMPU"
                     + " Aur BallSS Will Remainn Att SiNglE PpOsItIonn"
                     + "";
             return msg;}
         
         else if(i==1){msg="Uuff! 200 ObsTaclEs and that tOo in UnOrdEreD ManneR butTT StiLll boTh caNnot die fOr FirSt 1-2 Seconds,by STOONES.";
             return msg;}
         
         else if(i==2){msg="Yippeeeeee!!!! Life in Which ObsTacleS arE AlSo MoVinG.?? "
                 + ", AlThouGh TheSe (MiyAn & BiWi) WilL nOt Die FoR FirSt 1-2 sEcondon , But-if-elsEE  "
                 + "ThEiRR Sizeee WilL InCreasEE Tilly 8 BOLLS.. "
                 + " So,,,,JusT ProTecT YouRSelfff,"
                 + " Par BADE BHAI(Vicky)  Ka Shukar Hai ki wo bhi sirf 8 gendon ke lie hi Hai.. ";return msg;}
         
         else if(i==3){msg="Now STOONES Hv CurSed Big Bro alSO..and Both Start mOVINGGG"
                 + " anDD  ThEiR FIGURE WiLl InCreAsE FoR 16 BaLlSSee."
                 + "  ";
         return msg;}
         
         else if(i==4){msg="OK!OK! Move LikE NomADS!! NoWW BoTh Will Have To Eat A Total Of 20 BALSEE in NomaDiC STOONES ChabEr";
         return msg;}
         
         else if(i==5){msg="Champu ::\nArrOWeDD ButOns\nChaandni ::\nW Run_Above\nA MovE_ur_Left\nS ComE_DOWN_BABy\nD Now Take UR RIGHT\n::::"
                 + "Both KeySets On Same KeyBoard.\n (Esc) Press!!if Got in MiddLEE TIRED! \"PLAY_PLAY\"."
                 + "If Still Wants To Play Better than Play in Windows in Safe Mode "
                 + "And Yes+!! if WaNt tO avOid SuspEnsed mOves in Next Stage duRing ChamPU_NOMAD_PERVERT LeVeL theN doNOT press aSSinged Keys when eAtInG Ball AfTer 'BAS' is There ONSCREEN  "
                 + " Esc Press To LeAvE CReDiTss ScReEn";
             return msg;}         
         
         
         return "Hey_"+i+"_YOU_ARE_SEEING_ME";
     }
    
}
