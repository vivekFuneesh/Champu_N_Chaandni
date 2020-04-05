




/**********************
 *************************
        @author::Vivek Mangla
 **************************
 *****************************/

/*******************************************************************

GUI.java is part of Champu_N_Chaandni.

    Champu_N_Chaandni is free game: you can redistribute it    and/or modify
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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author vivek
 */

public class GUI implements ActionListener,ItemListener{
	static JMenuBar jmb;//-------------------------------------------INCLUDE INTRO,HELP,ABOUT.....-------------------------------------
	static JMenu Game,Stage,Snake,Noise,Player,Walls,High_Scores,Help;
	static JMenuItem Play,Quit,HighScores,About,Developer/*,Stage7*/;
	static JRadioButtonMenuItem Single_Player,Multi_Player;
	static JCheckBoxMenuItem Sounds,Music,UNWALLED,ThamJaa;
	static ButtonGroup Players_play,Stages_stage,Snake_type;
	static JRadioButtonMenuItem Stage1,Stage2,Stage3,Stage4,Stage5,Stage6;
	static JRadioButtonMenuItem Classic,Advance;
	static AboutFrame w;
	static DeveloperPanel dp;
	static MainFrame mf;
	Main main;

	GUI(Main main){
		this.main=main;
		jmb=new JMenuBar();


		Game=new JMenu("I");
		Stage=new JMenu("PLaCe");
		Snake=new JMenu("ChAmPu's_BaCk_PoS");
		Noise=new JMenu("Shor");
		Player=new JMenu("WHOWhOO");
		Walls=new JMenu("WALLS_Of_ScreeN");
		High_Scores=new JMenu("One_Sight");
		Help=new JMenu("I_NeeD_HeLp");
		//Game------------------------------------------------------------------------
		Game.add(Play=new JMenuItem("PlaY"));Play.addActionListener(this);
		Game.add(Quit=new JMenuItem("LeaVe_Play"));Quit.addActionListener(this);
		jmb.add(Game);
		//------------------------------------------------------------------------------------
		//Stage--------------------------------------------------------------------------------
		Stage.add(Stage1=new JRadioButtonMenuItem("BlaCk_NiGht",true));Stage1.addActionListener(this);
		Stage.add(Stage2=new JRadioButtonMenuItem("ConFuSDD_ColOnYY",new ImageIcon("aqua.gif")));Stage2.addActionListener(this);
		Stage.add(Stage3=new JRadioButtonMenuItem("STOONE"));Stage3.addActionListener(this);
		Stage.add(Stage4=new JRadioButtonMenuItem("MovING_STOONES"));Stage4.addActionListener(this);
		Stage.add(Stage5=new JRadioButtonMenuItem("NOMADIC_StooNeSS"));Stage5.addActionListener(this);
		Stage.add(Stage6=new JRadioButtonMenuItem("ChamPU_NOMAD_PERVERT"));Stage6.addActionListener(this);
		//Stage.add(Stage7=new JMenuItem("Under_Developement"));Stage7.addActionListener(this);
		Stages_stage=new ButtonGroup();
		Stages_stage.add(Stage1);
		Stages_stage.add(Stage2);
		Stages_stage.add(Stage3);
		Stages_stage.add(Stage4);
		Stages_stage.add(Stage5);
		Stages_stage.add(Stage6);
		//Stages_stage.add(Stage7);
		jmb.add(Stage);
		//--------------------------------------------------------------------------------------
		//-----------------WALLS---------------------------------------------
		Walls.add(UNWALLED=new JCheckBoxMenuItem("BreAK_PC_WALLsse"));UNWALLED.addActionListener(this);
		jmb.add(Walls);
		//-------------------------------------------------------------------
		//Snake---------------------------------------------------------------------------------
		Snake.add(Classic=new JRadioButtonMenuItem("SimPE-StrAiGht",true));Classic.addActionListener(this);
		Snake.add(Advance=new JRadioButtonMenuItem("TiLtY_WilTy"));Advance.addActionListener(this);
		//Snake.add(ThamJaa=new JCheckBoxMenuItem("Oye!ThamJaa"));ThamJaa.addActionListener(this);
		Snake_type=new ButtonGroup();
		Snake_type.add(Classic);
		Snake_type.add(Advance);
		jmb.add(Snake);
		//---------------------------------------------------------------------------------------
		//Noise----------------------------------------------------------------------------------
		Noise.add(Sounds=new JCheckBoxMenuItem("Dhichkyuon"));Sounds.addItemListener(this);
		Noise.add(Music=new JCheckBoxMenuItem("Aaha_Trana"));Music.addItemListener(this);
		jmb.add(Noise);
		//----------------------------------------------------------------------------------------
		//Player----------------------------------------------------------------------------------
		Player.add(Single_Player=new JRadioButtonMenuItem("ChAmPu_ALONE",true));Single_Player.addActionListener(this);
		Player.add(Multi_Player=new JRadioButtonMenuItem("WiTh_WiFe"));Multi_Player.addActionListener(this);
		Players_play=new ButtonGroup();
		Players_play.add(Single_Player);
		Players_play.add(Multi_Player);
		jmb.add(Player);
		//---------------------------------------------------------------------
		//High_Scores---------------------------------------------------------
		High_Scores.add(HighScores=new JMenuItem("GaMe_PrEiSts"));HighScores.addActionListener(this);
		jmb.add(High_Scores);
		//--------------------------------------------------------------------
		//------Help-----------------------------------------------------
		Help.add(About=new JMenuItem("HeLpFuLL_InFo"));About.addActionListener(this);
		Help.add(Developer=new JMenuItem("CrEdItSss"));Developer.addActionListener(this);
		jmb.add(Help);
		//--------------------------------------------------------------------


	}

	@Override
	public void actionPerformed(ActionEvent ue){
		if(ue.getSource()==Play){

			//remove(panel1);
			main.setIgnoreRepaint(true);

			if(Classic.isSelected()){
				main.Basic_Game();//System.out.println("Inside Basic");

			}
			else   {main.Start_Game();//System.out.println("Inside Advance Basic");
			}


		}
		else if(ue.getSource()==Quit){System.exit(0);}
		else if(ue.getSource()==HighScores){Scores.retrieve(6);}
		else if(ue.getSource()==Single_Player){Main.SINGLE_PLAYER=1;}
		else if(ue.getSource()==Multi_Player){Main.MULTI_PLAYER=1;}

		else if(ue.getSource()==Stage1){Main.stagestage="BlaCk_NiGht";}
		else if(ue.getSource()==Stage2){Main.stagestage="ConFuSDD_ColOnYY";}
		else if(ue.getSource()==Stage3){Main.stagestage="STOONE";}
		else if(ue.getSource()==Stage4){Main.stagestage="MovING_STOONES";}
		else if(ue.getSource()==Stage5){Main.stagestage="NOMADIC_StooNeSS";}
		else if(ue.getSource()==Stage6){Main.stagestage="ChamPU_NOMAD_PERVERT";}
		else if(ue.getSource()==UNWALLED){
			try {Main.Unwalled=1;} catch (Exception ex) {}
		}
		else if(ue.getSource()==About){
			//System.out.println("about pressed\nshowing help");
			w=new AboutFrame();
			//System.out.println("help_showed");
		}
		else if(ue.getSource()==Developer){
			dp=new DeveloperPanel();  
		}

	}

	@Override
	public void itemStateChanged(ItemEvent i){}



}
