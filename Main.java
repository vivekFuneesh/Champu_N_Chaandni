
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

Main.java is part of Champu_N_Chaandni.

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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class Main extends JPanel implements Runnable
{ 
    //TEST FOR ARR[][][] & ARR1[][][]
    
 
    static int pWidth,pHeight,sleepTime,minimum_Food_Count_for_Stage6,showFoodCount,relaxTime;
    static int SCORES,player_1OUT,player_2OUT;
    static double food=1,count=1,var1=2,var2=4,turn_b=1,score;
    static double var3=Math.PI+5.5;   
    static double b[][],arr[][],arr1[][],b1[][],const_arr[][],const_arr1[][];
    static double turn=0;
    static int length=5;
    static double d,flag[],dist,snake_taste=0;
    Thread t;
    static int SHOW_SCORES=0,SINGLE_PLAYER=0,MULTI_PLAYER=0,MUSIC=0,SOUNDS=0,GAME_OUT=0;
    static int Unwalled=0;  
    static String msg="";
    static KeyAdapter key1,key2;
    static Image buffer;

    static Graphics current_g;
    static String stagestage="BlaCk_NiGht";
    String m="y";
    Graphics2D g2d,g2d1; static int name_count=0; 
   //------------------------PLAYER_2------------------------------------
    static player2 plr; static player_advnc_2 plr_advnc;
   //-----------------------------------------------------------------------------------
  //  JPanel panel1;
   //-------------------------SLEEPING--TIME--VARIABLES-------------------------------------
    static long beforetime,aftertime,timediff,sleeptime,oversleeptime,excess;
    static int skip=0;
    static long period=(long)Math.pow(10, 9)/30;
  //--------------------------------------------------------------------  
    
   void snake_nature(){
   snake_taste=0;
  try{m="y";
      m=JOptionPane.showInputDialog("Can Snake Bite itself::\n Enter Y for yes and n otherwise",m);
     }catch(Exception e){}
  if((m==null)||(m.length()==0))m="y";
  if(m.charAt(0)=='y'){snake_taste=1;}
   }
  
   void reset_all_variables(){
       beforetime=aftertime=timediff=sleeptime=oversleeptime=excess=0;
       skip=0;
       setIgnoreRepaint(true);
    food=1;count=1;var1=2;var2=4;turn_b=1;player_1OUT=0;player_2OUT=0;
    turn=0;score=0;length=5;d=0;dist=0;m="y";snake_taste=1;t=null;
    
    MainFrame.p1=null;
    SHOW_SCORES=0;
    GAME_OUT=1;
    minimum_Food_Count_for_Stage6=0;showFoodCount=0;relaxTime=0;
    //SHOW_SCORES=0;SINGLE_PLAYER=0;MULTI_PLAYER=0;MUSIC=0;SOUNDS=0;GAME_OUT=0;
    //BASIC1=0;BASIC2=0;ADVANCED1=0;ADVANCED2=0;FINAL_F=0; 
   
    pWidth=MainFrame.pWidth;pHeight=MainFrame.pHeight;
    //remove(panel1);
     matrix3.calculate_vsl();matrix3.generate_matrix();
     matrix4.reset();sleepTime=0;matrix5.reset();
     matrix4.calculate_VSL();matrix5.calculate_VSL();
     food_generate.count_Stage5_1=food_generate.count_Stage5_2=0;
     food_generate.count_Stage4_1=food_generate.count_Stage4_2=0;
     food_generate.foodCount=1;
    GUI.jmb.setVisible(false);GUI.jmb.setEnabled(false);g2d=g2d1=null;
        arr=null;const_arr=null;b=null;arr1=null;b1=null;const_arr1=null;
        if(key1!=null)removeKeyListener(key1);
        if(key2!=null){removeKeyListener(key2);}
        key1=key2=null;            t=null;
    name_count=0;Unwalled=0;       
    plr=null;plr_advnc=null;
    plr= new player2();  plr_advnc=new player_advnc_2();
                        plr.reset();plr_advnc.reset();
  
    
                          }
    
    @Override
   public void paintComponent(Graphics g){
 
                                        super.paintComponent(g);
                         
                 Graphics2D name2d=(Graphics2D)g;
                 name2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true));
          
             Font font = new Font(Font.SERIF, Font.BOLD, 50);
             FontMetrics fm=getFontMetrics(font);
             name2d.setFont(font);
             String str="ChAmPu_N_CHaaNdnI";
        name2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
         
                 name2d.drawString(str, (pWidth-fm.stringWidth(str))/2, pHeight/2);
                                        
                                        
                                          }
  
   Main(int pWidth,int pHeight) {
    //System.out.println(pWidth+"  "+pHeight);
     this.pWidth=pWidth;this.pHeight=pHeight;
    plr=new player2();plr_advnc=new player_advnc_2();
      setBackground(Color.BLACK);
    Dimension dim=new Dimension();
    dim.height=pHeight;dim.width=pWidth;
        
    setPreferredSize(dim);
        //-----------------form panels---------------------------------------------------
            //panel1=new JPanel();
            //-----------------------------------------------------------------------------------------
           
           
            
    }
    
  
////////////----------------//////////------------------//////////-------------------------//////////----------------/////////-----
  
 //---------------------ADVANCE SNAKE FORMATION AND CALCULATIONS---------------------------------------------------------------------
  
///////////----------------//////////-------------------///////////---------------------///////////-----------------/////////------
     
    void Start_Game() {
       
//----0-439879032-=12iuhfbjndcskjsmlp;[]f[][];j'h./hfl        
      if(!GUI.Stage6.isSelected()) matrixSelect.checkStage();
      else {matrixSelect.number=0;matrix6.create_stage_number();}
              
        reset_all_variables();
       
       
//eprfuj95t98030-=3209458950wre[ole;glgk;dwl]fg';mngnfebdlkdff       
      
        
       form1(); 
       if(GUI.Multi_Player.isSelected()){plr_advnc.form_player_2();}
       if(GUI.Stage6.isSelected()==false)snake_nature();
    //--------------------CHECKING--------------------
   // System.out.println(Math.cos(var3));
            
   // setBackground(Color.black);
  flag=new double[2];flag[0]=flag[1]=0;
   // setSize(400,400);
    if((GUI.Music.getState())){
                            MainFrame.mf.playMusic();
                          }
   
    
     // System.out.println("hioi");
        t=new Thread(this);
     //System.out.println("hioi1");
    
     //System.out.println("hioi3");
   
          setFocusable(true);requestFocus();
          processKeyMove();
           //---------------------------------------------------------------
          t.start();
    //-----------------------------------------------------
    }
    
    void processKeyMove(){
        
          if((count==1)&&(GUI.Advance.isSelected()))
     addKeyListener(key1=new KeyAdapter(){
           
  /*
   !!*****!! 
    Right now both of the player moves( Key Presses ) are being considered to be one process signal .To give more FAIRNESS
    in Player's move ,both key presses can be considered to be different signals,and so concurrency on 3 process can be applied
    !!*****!!
   
   */      

         @Override
    public void keyPressed(KeyEvent ke){
        
        if(GUI.Classic.isSelected()==false)
        {
        if(count==1){flag[1]=1;
        turn=0;}
        while(true){if((flag[0]!=1)||(turn!=0))break;else System.out.print("");}
           //Thread t=Thread.currentThread();
        if(key1!=null)removeKeyListener(key1);
        
        
           //showStatus("clicked::"+ke.getKeyChar());
        int y=ke.getKeyCode();
        
         if(count==1){
             
            
                       
                 
        switch(y)
    {
            
      case KeyEvent.VK_ESCAPE:{player_1OUT=1;player_2OUT=1;turn=1;count=0;break;}      
            
      case KeyEvent.VK_UP :{if((check_up()==1)||(check_up()==2)){
       if(player_1OUT!=1){
       arr[0][1]=b[0][1];arr[0][0]=b[0][0];
       if(check_up()==1)
       {b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));turn_b=0;}else {b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));turn_b=1;}
       b[0][1]-=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]-=var2; move_rest();}
         if(GUI.Multi_Player.isSelected()&&(player_2OUT!=1)){plr_advnc.move_to_same_path_2();plr_advnc.move_rest_2();}   
      }break;}
      
               
      case KeyEvent.VK_DOWN :{if((check_up() ==1)||(check_up() ==2)){
    if(player_1OUT!=1){
     arr[0][1]=b[0][1];arr[0][0]=b[0][0];
     if(check_up() ==1)
     {b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));turn_b=1;}else{b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));turn_b=0;}
     b[0][1]+=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]+=var2;move_rest();}
         if(GUI.Multi_Player.isSelected()&&(player_2OUT!=1)){plr_advnc.move_to_same_path_2();plr_advnc.move_rest_2();}
      }break;}      
      
      case KeyEvent.VK_LEFT :{if((check_left()==1)||(check_left()==2)){
     if(player_1OUT!=1){
      arr[0][0]=b[0][0];arr[0][1]=b[0][1];
      if(check_left()==1)
      {b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3));turn_b=1;}else {b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3));turn_b=0;}
      b[0][0]-=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]-=var2;move_rest();}
        if(GUI.Multi_Player.isSelected()&&(player_2OUT!=1)){plr_advnc.move_to_same_path_2();plr_advnc.move_rest_2();}  
         }break;}      
      
     case KeyEvent.VK_RIGHT :{
         if((check_left() ==1)||(check_left() ==2)){
             if(player_1OUT!=1){     
        arr[0][0]=b[0][0];arr[0][1]=b[0][1];
        if(check_left() ==1)
        {b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3));turn_b=0;}else {turn_b=1;b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3));}
        b[0][0]+=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]+=var2;move_rest();}
         if(GUI.Multi_Player.isSelected()&&(player_2OUT!=1)){plr_advnc.move_to_same_path_2();plr_advnc.move_rest_2();} 
       } break;}   
      
     
        case KeyEvent.VK_W :{if(GUI.Multi_Player.isSelected()){if((plr_advnc.check_up_2()==1)||(plr_advnc.check_up_2()==2)){
                  if(player_2OUT!=1){
       plr_advnc.arr[0][1]=plr_advnc.b[0][1];plr_advnc.arr[0][0]=plr_advnc.b[0][0];
       if(plr_advnc.check_up_2()==1)
       {plr_advnc.b[0][0]=plr_advnc.b[0][0]-(var1*Math.sin(plr_advnc.b[0][1]/var3));plr_advnc.turn_b_player_2=0;}else {plr_advnc.b[0][0]=plr_advnc.b[0][0]+(var1*Math.sin(plr_advnc.b[0][1]/var3));plr_advnc.turn_b_player_2=1;}
       plr_advnc.b[0][1]-=var2;plr_advnc.const_arr_player_2[0][2]=plr_advnc.const_arr_player_2[0][0];plr_advnc.const_arr_player_2[0][3]=plr_advnc.const_arr_player_2[0][1];plr_advnc.const_arr_player_2[0][1]-=var2;
         plr_advnc.move_rest_2();         }if(player_1OUT!=1){move_to_same_path(t);  move_rest();}
         }break;}
         else break;}
      
               
      case KeyEvent.VK_S :{if(GUI.Multi_Player.isSelected()){if((plr_advnc.check_up_2() ==1)||(plr_advnc.check_up_2() ==2)){
    if(player_2OUT!=1){
     plr_advnc.arr[0][1]=plr_advnc.b[0][1];plr_advnc.arr[0][0]=plr_advnc.b[0][0];
     if(plr_advnc.check_up_2() ==1)
     {plr_advnc.b[0][0]=plr_advnc.b[0][0]+(var1*Math.sin(plr_advnc.b[0][1]/var3));plr_advnc.turn_b_player_2=1;}else{plr_advnc.b[0][0]=plr_advnc.b[0][0]-(var1*Math.sin(plr_advnc.b[0][1]/var3));plr_advnc.turn_b_player_2=0;}
     plr_advnc.b[0][1]+=var2;plr_advnc.const_arr_player_2[0][2]=plr_advnc.const_arr_player_2[0][0];plr_advnc.const_arr_player_2[0][3]=plr_advnc.const_arr_player_2[0][1];plr_advnc.const_arr_player_2[0][1]+=var2;
    plr_advnc.move_rest_2();
    }if(player_1OUT!=1){move_to_same_path(t);  move_rest();}     }break;}else break;}      
      
      case KeyEvent.VK_A :{if(GUI.Multi_Player.isSelected()){if((plr_advnc.check_left_2()==1)||(plr_advnc.check_left_2()==2)){
     if(player_2OUT!=1){
      plr_advnc.arr[0][0]=plr_advnc.b[0][0];plr_advnc.arr[0][1]=plr_advnc.b[0][1];
      if(plr_advnc.check_left_2()==1)
      {plr_advnc.b[0][1]=plr_advnc.b[0][1]+(var1*Math.sin(plr_advnc.b[0][0]/var3));plr_advnc.turn_b_player_2=1;}else {plr_advnc.b[0][1]=plr_advnc.b[0][1]-(var1*Math.sin(plr_advnc.b[0][0]/var3));plr_advnc.turn_b_player_2=0;}
      plr_advnc.b[0][0]-=var2;plr_advnc.const_arr_player_2[0][2]=plr_advnc.const_arr_player_2[0][0];plr_advnc.const_arr_player_2[0][3]=plr_advnc.const_arr_player_2[0][1];plr_advnc.const_arr_player_2[0][0]-=var2;
     plr_advnc.move_rest_2();
     }if(player_1OUT!=1){move_to_same_path(t);  move_rest();}   
         }break;}      else break;}
      
     case KeyEvent.VK_D :{if(GUI.Multi_Player.isSelected()){
         if((plr_advnc.check_left_2() ==1)||(plr_advnc.check_left_2() ==2)){
     if(player_2OUT!=1){
        plr_advnc.arr[0][0]=plr_advnc.b[0][0];plr_advnc.arr[0][1]=plr_advnc.b[0][1];
        if(plr_advnc.check_left_2() ==1)
        {plr_advnc.b[0][1]=plr_advnc.b[0][1]-(var1*Math.sin(plr_advnc.b[0][0]/var3));plr_advnc.turn_b_player_2=0;}else {plr_advnc.turn_b_player_2=1;plr_advnc.b[0][1]=plr_advnc.b[0][1]+(var1*Math.sin(plr_advnc.b[0][0]/var3));}
        plr_advnc.b[0][0]+=var2;plr_advnc.const_arr_player_2[0][2]=plr_advnc.const_arr_player_2[0][0];plr_advnc.const_arr_player_2[0][3]=plr_advnc.const_arr_player_2[0][1];plr_advnc.const_arr_player_2[0][0]+=var2;
      plr_advnc.move_rest_2();
     }if(player_1OUT!=1){move_to_same_path(t); move_rest();} 
       } break;}   else break;   }
      
         
     default:{}
     }
         
        }
         if(count==1){
         if((y==KeyEvent.VK_UP)||(y==KeyEvent.VK_LEFT)||(y==KeyEvent.VK_RIGHT)||(y==KeyEvent.VK_DOWN)||(y==KeyEvent.VK_F2)||(y==KeyEvent.VK_1)||(y==KeyEvent.VK_2)||(y==KeyEvent.VK_3))
         {
               
         
         if(player_1OUT!=1)OtherCollisions.check_for_walls(b);
         if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1){OtherCollisions.check_for_walls_advnc();}}
        
          if((snake_taste==1)||(GUI.Stage6.isSelected())){
              if(player_1OUT!=1)selfBite.did_not_bite(const_arr);
          if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1)selfBite.did_not_bite_2(plr_advnc.const_arr_player_2,plr_advnc.length_player_2);}
                            }
          
          matrixSelect.matrix_collide(b,plr_advnc.b);
          
         if((player_1OUT!=1)||(player_2OUT!=1))
               food_generate.check_for_food_cord(b,d,plr_advnc.b,plr_advnc.length_player_2);
          if((food==0)&&(GUI.Stage6.isSelected()))
          {
              if(food_generate.foodCount==matrix6.getFoodLimit()){
                  if(matrixSelect.number==5)minimum_Food_Count_for_Stage6=1;
                  food_generate.foodCount=0;
                  matrix6.create_stage_number();
                  if(matrixSelect.number==6)matrixSelect.number=5;
                  else{matrix6.resetSnake();sleepTime=0;
                  if(GUI.Multi_Player.isSelected()){matrix6.resetSnake2();}
                  try{
                      Thread.sleep(1500);
                  }catch(Exception er){}    
                  }
                                                                 }
          }
          
         }
         
         if(GUI.Multi_Player.isSelected()){
                  if((player_1OUT==1)&&(player_2OUT==1)){turn=1;count=0;//System.out.println("out in key");
                  }
                                        }
          else if(player_1OUT==1){turn=1;count=0;}
         if(count==1)
        paint_applet();
        }
    flag[1]=0;if(y!=KeyEvent.VK_ESCAPE)processKeyMove();
     
    
   }
    
    }  });
    
  
    }

    static void MOVE_OTHER_SIDE(){
    
       if((b[0][0]>=pWidth-10)&&(check_up()==1)){
          
                 const_arr[0][0]=0;const_arr[0][2]=-1;
                 arr[0][1]=b[0][1];b[0][0]=0;arr[0][0]=-1; Main.move_rest();
                    
             }    
       else if((b[0][0]<=0)&&(check_up()==2)){
           
                 const_arr[0][0]=pWidth-5;const_arr[0][2]=pWidth-2;
                 arr[0][0]=pWidth-2;arr[0][1]=b[0][1];b[0][0]=pWidth-5; Main.move_rest();
           
             }    
       else if((b[0][1]>=pHeight-10)&&(check_left()==2)){
                 arr[0][0]=b[0][0];arr[0][1]=-1;b[0][1]=0;
                 const_arr[0][1]=0;const_arr[0][3]=-1; Main.move_rest();
            
             }    
       else if((b[0][1]<=0)&&(check_left()==1)){
             arr[0][0]=b[0][0];arr[0][1]=pHeight-2;b[0][1]=pHeight-5;
           const_arr[0][1]=pHeight-5;const_arr[0][3]=pHeight-2; Main.move_rest();
          
             }    
       
    }
   
    static void move_rest(){
     for(int i=1;i<length;i++)
     {
        
         arr[i][0]=b[i][0];
         arr[i][1]=b[i][1];
         b[i][0]=arr[i-1][0];
         b[i][1]=arr[i-1][1];
           const_arr[i][2]=const_arr[i][0];  const_arr[i][3]=const_arr[i][1];
         const_arr[i][0]=const_arr[i-1][2];  const_arr[i][1]=const_arr[i-1][3];
         
         
     }
     
 
 }
  
    void  move_to_same_path(Thread t){
   
          if(const_arr[0][0]>const_arr[0][2])      {arr[0][0]=b[0][0];arr[0][1]=b[0][1];
       if(turn_b==1)
       b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3));else b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3)); 
       b[0][0]+=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]+=var2;}
      
   else if(const_arr[0][0]<const_arr[0][2]) {arr[0][0]=b[0][0];arr[0][1]=b[0][1];
      if(turn_b==1)
      b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3)); else b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3));
      b[0][0]-=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]-=var2;}
      
   else if(const_arr[0][1]>const_arr[0][3]) {arr[0][1]=b[0][1];arr[0][0]=b[0][0];
   if(turn_b==0)
   b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));else b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));
   b[0][1]+=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]+=var2;}
    
   else if(const_arr[0][1]<const_arr[0][3]) {arr[0][1]=b[0][1];arr[0][0]=b[0][0];
   if(turn_b==0)
   b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));else b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));
   b[0][1]-=var2;const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]-=var2;}
   
          
        
      
      }
      
    void stop_movement(){
    flag[1]=1;turn=1;
    
    }
    
    @Override
    public void run(){if(GUI.Classic.isSelected()==false){
                run_advnc();
 try{Thread.currentThread().sleep(1000);}catch(Exception er){}
            msg=Double.toString(score);
    
    }else run_basic();
    }
     
    void run_advnc(){
        beforetime=System.nanoTime();//System.out.println(beforetime);
        
        while(count==1){
          
            run_advnc_calc();
            
          
          aftertime=System.nanoTime();
          timediff=aftertime-beforetime;
         // System.out.println("time_difference::::::::"+timediff);
          sleeptime=period -timediff-oversleeptime;//System.out.println(timediff);
          if(sleeptime>0){//System.out.println(">0"); 
          try{ Thread.sleep(sleeptime/1000000L);}catch(InterruptedException e){}
          oversleeptime=(System.nanoTime()-aftertime)-sleeptime;}
          else{//System.out.println("it is <0");
              excess-=sleeptime;
              oversleeptime=0;
              
          
          
          while((excess>period)&&(skip<5)&&(count==1)){//System.out.println("SKIPPING_PAINTING");
              excess-=period;
              run_advnc_calc();
              skip++;
          }
          }
          beforetime=System.nanoTime();
          
           if(count==1)
            flag[0]=0;
          
            }
    }
    
    void run_advnc_calc(){flag[0]=1;turn=1;
    while(true){if((flag[1]!=1)||(turn!=1))break;else System.out.print("");}
            
   // System.out.println(b[0][0]+" "+b[0][1]+" ");
    
         if(player_1OUT!=1){move_to_same_path(t);move_rest();}
               if(GUI.Multi_Player.isSelected()){
                      if(player_2OUT!=1){plr_advnc.move_to_same_path_2();plr_advnc.move_rest_2();}
                                            }
           if(player_1OUT!=1)OtherCollisions.check_for_walls(b);
         if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1){OtherCollisions.check_for_walls_advnc();}}
        
          if((snake_taste==1)||(GUI.Stage6.isSelected())){
              if(player_1OUT!=1)selfBite.did_not_bite(const_arr);
          if(GUI.Multi_Player.isSelected())
          {if(player_2OUT!=1)selfBite.did_not_bite_2(plr_advnc.const_arr_player_2,plr_advnc.length_player_2);}
                            }
          
         matrixSelect.matrix_collide(b,plr_advnc.b);
          
         if((player_1OUT!=1)||(player_2OUT!=1))
               food_generate.check_for_food_cord(b,d,plr_advnc.b,plr_advnc.length_player_2);
          if((food==0)&&(GUI.Stage6.isSelected()))
          {
              if(food_generate.foodCount==matrix6.getFoodLimit()){
                  if(matrixSelect.number==5)minimum_Food_Count_for_Stage6=1;
                  food_generate.foodCount=0;matrix6.create_stage_number();
                  if(matrixSelect.number==6)matrixSelect.number=5;
                  else{matrix6.resetSnake();sleepTime=0;
                  if(GUI.Multi_Player.isSelected()){matrix6.resetSnake2();}
                  try{Thread.sleep(1500);}catch(Exception er){}    
                  }
                  
                                            }
          }
          if(GUI.Multi_Player.isSelected()){
                  if((player_1OUT==1)&&(player_2OUT==1)){turn=1;count=0;//System.out.println("out in run");
                  }
                                        }
          else if(player_1OUT==1){turn=1;count=0;}
          paint_applet();
          if(sleepTime<3000)sleepTime+=50;
    }
    
    static void realloc_memory(){
        //arr is used for track b
    arr1=new double[length][2];b1=new double[length][2];const_arr1=new double[length][4];
    for(int i=0;i<length-2;i++){
        arr1[i]=arr[i];
        b1[i]=b[i];
    }
    arr=null;arr=arr1;
    b=null;b=b1;b1=arr1=null;
    b[length-2][0]=arr[length-3][0];b[length-1][0]=b[length-2][0];
    b[length-2][1]=arr[length-3][1];b[length-1][1]=b[length-2][1];
    for(int i=0;i<length-2;i++){
    const_arr1[i][0]=const_arr[i][0];const_arr1[i][1]=const_arr[i][1];
    const_arr1[i][2]=const_arr[i][2];const_arr1[i][3]=const_arr[i][3];
    }const_arr=null;const_arr=const_arr1;const_arr1=null;
    
    }
    
    void paint_applet(){
        
          current_g=this.getGraphics();
    
          g2d1=(Graphics2D)(current_g);
  
 
             
             

                       if(buffer==null)buffer=createImage(pWidth,pHeight);
   
                     
      
         if((count==1))
         {
             Snake1.paint_advance(g2d, b, this);
         }
       else 
         {
             msg=Double.toString(score);count=0;
             if(key1!=null)removeKeyListener(key1);
             if(key2!=null)removeKeyListener(key2);
             if(GUI.Music.getState())try{MainFrame.stopMusic();}catch(Exception eee){}
             if(GUI.Sounds.getState())if(MainFrame.p1!=null)try{MainFrame.p1.stop();}catch(Exception eee){}
           
             try{Thread.currentThread().sleep(1000);}catch(Exception er){}
          
             turn=1;addKeyListener(null); 
             paint_out();
          }
        
    
    }
    
    void paint_out(){
            count=0;setIgnoreRepaint(false);
    repaint();
    

 if(name_count==0){
 try{GUI.jmb.setVisible(false);
 if((!GUI.Stage6.isSelected())||((GUI.Stage6.isSelected())&&(minimum_Food_Count_for_Stage6==1)))
 {
     String name11="Priest_Number_ONE";
     name_count++;name11=JOptionPane.showInputDialog("SCORE::"+score+"\n Game_Preist_Write_ur_Name",name11);
    // System.out.println(stagestage+"thus usus in paint_out");
     if(name11=="null")name11="Pujaari_Number_Ek";
     Scores.write(name11, (int) score,stagestage);
     if(GUI.Multi_Player.isSelected()){name11="Miss!Cutie_Preist";
     double temp_score=0;
     temp_score=(GUI.Classic.isSelected())?player2.score_player_2:player_advnc_2.score_player_2;
     
     name11=JOptionPane.showInputDialog("SCORE::"+temp_score+"\n ENTER YOUR NAME::",name11);
     if(name11=="null")name11="Dusri_Pujaaran";
     Scores.write(name11, (int) temp_score,stagestage);
     }}else JOptionPane.showMessageDialog(null, "You FoOl_NaMaKoOl ... GoT LoSt iNnn ChamPU_NOMAD_PERVERT");
     
 GUI.jmb.setVisible(true);GUI.jmb.setEnabled(true);
     }
 catch(Exception er){JOptionPane.showMessageDialog(null, er);//System.out.println("inside paint_out exception");
 }
       
 
 }
      
    } 
    
    void show_score(){//System.out.println("YOUR SCORE IS****"+msg+"****");
    }
    
    static void form1(){
                  b=new double[5][2];arr=new double[5][2];const_arr=new double[5][4];
                  b[0][0]=0;b[0][1]=matrix6.getInitialHeight();
                  arr[0][0]=-10;arr[0][1]=b[0][1];
                   const_arr[0][0]=b[0][0];const_arr[0][1]=b[0][1];
                   const_arr[0][2]=const_arr[0][0]-4;const_arr[0][3]=const_arr[0][1];
                             length=5;                                
                   for(int i=1;i<length;i++)
                  {
                      b[i][0]=b[i-1][0]-4;
                      b[i][1]=b[i-1][1];
                      arr[i][0]=b[i][0]-4;
                      arr[i][1]=b[i][1];
                       const_arr[i][0]=const_arr[i-1][2];const_arr[i][1]=const_arr[i-1][3];
                       const_arr[i][2]=const_arr[i][0]-4;const_arr[i][0]=const_arr[i][3];
                  }
                  
          
                     
                     }
  
////////////----------------//////////------------------//////////-------------------------//////////----------------/////////-----
  
 //---------------------CLASSIC SNAKE FORMATION AND CALCULATIONS---------------------------------------------------------------------
  
///////////----------------//////////-------------------///////////---------------------///////////-----------------/////////------
 
    void Basic_Game(){
    if(!GUI.Stage6.isSelected()) matrixSelect.checkStage();
    else {matrixSelect.number=0;matrix6.create_stage_number(); }   
    start_game_basic();
  
                                 }
  
    void start_game_basic(){
        reset_all_variables();
        
        form1_basic();if(GUI.Multi_Player.isSelected()){plr.form_player_2();}
    //--------------------CHECKING--------------------
   
           if(GUI.Stage6.isSelected()==false) snake_nature();
    //setBackground(Color.green);
  flag=new double[2];flag[0]=flag[1]=0;
  //  setSize(400,400);
  if((GUI.Music.getState())){MainFrame.mf.playMusic();}
      
        
    
  t=new Thread(this);
     
    key2=null;
    setFocusable(true);requestFocus();
    processKeyMoveSimple();
    t.start();
    }
    
    void processKeyMoveSimple(){
        
     if((count==1)&&(GUI.Advance.isSelected()==false))
     addKeyListener(key2=new KeyAdapter(){
           
         
   /*
   !!*****!! 
    Right now both of the player moves( Key Presses ) are being considered to be one process signal .To give more FAIRNESS
    in Player's move ,both key presses can be considered to be different signals,and so concurrency on 3 process can be applied
    !!*****!!
   
   */      

         
         @Override
     public void keyPressed(KeyEvent ke){
        
        if(GUI.Classic.isSelected()){
        flag[1]=1;
        turn=0;
        while(true){if((flag[0]!=1)||(turn!=0))break;else System.out.print("");}
           
   
       if(key2!=null)removeKeyListener(key2);
       
        int y=ke.getKeyCode();
        
         if(count==1){
      
         
           
                 
        switch(y)
    {
        
      case KeyEvent.VK_ESCAPE:{player_1OUT=1;player_2OUT=1;turn=1;count=0;break;}      
            
      case KeyEvent.VK_UP :{if((check_up()==1)||(check_up()==2)){if(player_1OUT!=1){
       const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]-=var2;move_rest_basic();}
       if((GUI.Multi_Player.isSelected())&&(player_2OUT!=1)) {plr.move_to_same_path_2();plr.move_rest_2();}  
      }break;}
      
               
      case KeyEvent.VK_DOWN :{if((check_up() ==1)||(check_up() ==2)){if(player_1OUT!=1){
    const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]+=var2;move_rest_basic();}
       if((GUI.Multi_Player.isSelected())&&(player_2OUT!=1))  {  plr.move_to_same_path_2();plr.move_rest_2();} 
      }break;}      
      
      case KeyEvent.VK_LEFT :{if((check_left()==1)||(check_left()==2)){if(player_1OUT!=1){
     const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]-=var2;move_rest_basic();}
        if((GUI.Multi_Player.isSelected())&&(player_2OUT!=1)){  plr.move_to_same_path_2(); plr.move_rest_2();} 
         }break;}      
           
     case KeyEvent.VK_RIGHT :{if((check_left() ==1)||(check_left() ==2)){
         if(player_1OUT!=1){
        const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]+=var2; move_rest_basic();}
      if((GUI.Multi_Player.isSelected())&&(player_2OUT!=1)){   plr.move_to_same_path_2(); plr.move_rest_2();}
       }break;}    
         
     
     
         
         
 case KeyEvent.VK_W :{if(GUI.Multi_Player.isSelected()){if((plr.check_up_2()==1)||(plr.check_up_2()==2)){if(player_2OUT!=1){
        plr.const_arr_player_2[0][2]=plr.const_arr_player_2[0][0];plr.const_arr_player_2[0][3]=plr.const_arr_player_2[0][1];
                              plr.const_arr_player_2[0][1]-=var2;
                  plr.move_rest_2();}if(player_1OUT!=1){ move_to_same_path_basic();   move_rest_basic();}
      }break;}else break;}
     
          
     case KeyEvent.VK_S :{if(GUI.Multi_Player.isSelected()){if((plr.check_up_2()==1)||(plr.check_up_2()==2)){if(player_2OUT!=1){
    plr.const_arr_player_2[0][2]=plr.const_arr_player_2[0][0];plr.const_arr_player_2[0][3]=plr.const_arr_player_2[0][1];plr.const_arr_player_2[0][1]+=var2;
          plr.move_rest_2();}if(player_1OUT!=1){move_to_same_path_basic(); move_rest_basic();}
      }break;}else break;}
     
         
     case KeyEvent.VK_A :{if(GUI.Multi_Player.isSelected()){if((plr.check_left_2()==1)||(plr.check_left_2()==2)){if(player_2OUT!=1){
     plr.const_arr_player_2[0][2]=plr.const_arr_player_2[0][0];plr.const_arr_player_2[0][3]=plr.const_arr_player_2[0][1];plr.const_arr_player_2[0][0]-=var2;
       plr.move_rest_2();} if(player_1OUT!=1){ move_to_same_path_basic();  move_rest_basic();}
         }break;}break;}

     case KeyEvent.VK_D :{if(GUI.Multi_Player.isSelected()){if((plr.check_left_2()==1)||(plr.check_left_2()==2)){
     if(player_2OUT!=1){
        plr.const_arr_player_2[0][2]=plr.const_arr_player_2[0][0];plr.const_arr_player_2[0][3]=plr.const_arr_player_2[0][1];plr.const_arr_player_2[0][0]+=var2;
         plr.move_rest_2();}if(player_1OUT!=1){move_to_same_path_basic(); move_rest_basic();}
       }break;}break;}
         
     default:{}
     }
             
        }
         if(count==1){
          if((y==KeyEvent.VK_UP)||(y==KeyEvent.VK_LEFT)||(y==KeyEvent.VK_RIGHT)||(y==KeyEvent.VK_DOWN)||(y==KeyEvent.VK_F2)||(y==KeyEvent.VK_1)||(y==KeyEvent.VK_2)||(y==KeyEvent.VK_3))
         {
              
          
          if(player_1OUT!=1)
            OtherCollisions.check_for_walls_basic(const_arr);
          if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1)OtherCollisions.check_for_walls_2_basic();}
          
          if((snake_taste==1)||(GUI.Stage6.isSelected())){
              if(player_1OUT!=1)selfBite.did_not_bite(const_arr); 
              if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1)selfBite.did_not_bite_2(plr.const_arr_player_2,plr.length_player_2);}}
          
         matrixSelect.matrix_collide(const_arr,plr.const_arr_player_2);
          
          if((player_1OUT!=1)||(player_2OUT!=1))
               food_generate.check_for_food_cord_basic(const_arr,d,plr.const_arr_player_2,plr.length_player_2);
          if((food==0)&&(GUI.Stage6.isSelected()))
          {
              if(food_generate.foodCount==matrix6.getFoodLimit()){
                  if(matrixSelect.number==5)minimum_Food_Count_for_Stage6=1;
                  food_generate.foodCount=0;matrix6.create_stage_number();
                  if(matrixSelect.number==6)matrixSelect.number=5;
                  else{matrix6.resetSnake();sleepTime=0;
                  if(GUI.Multi_Player.isSelected()){matrix6.resetSnake2();}
                  try{Thread.sleep(1500);}catch(Exception er){}    
                  }
                  
                                            }
          }
         }
          
          if(GUI.Multi_Player.isSelected()){
          if((player_1OUT==1)&&(player_2OUT==1)){turn=1;count=0;}
                                        }
          else if(player_1OUT==1){turn=1;count=0;//System.out.println("out in key");
          }
          if(count==1)
        update_basic();   
        } 
        
    flag[1]=0;if(y!=KeyEvent.VK_ESCAPE)processKeyMoveSimple();
    
   }
    }    });
     
    
    }
  
    static void form1_basic(){
                   const_arr=null;
                  const_arr=new double[5][4];
                                 
                  
                   const_arr[0][0]=0;const_arr[0][1]=matrix6.getInitialHeight();//(int)matrix3.block_height/2;
                   const_arr[0][2]=const_arr[0][0]-4;const_arr[0][3]=const_arr[0][1];
                           length=5;                                  
                   for(int i=1;i<length;i++)
                  {
                      
                       const_arr[i][0]=const_arr[i-1][2];
                       const_arr[i][1]=const_arr[i-1][3];
                       const_arr[i][2]=const_arr[i-1][2];
                       const_arr[i][3]=const_arr[i-1][3];
                  }
                 
            
                     }
   
    static void MOVE_OTHER_SIDE_BASIC(){
    
       if((const_arr[0][0]>pWidth-10)&&(check_up()==1)){
          
                 const_arr[0][0]=0;const_arr[0][2]=-4;move_rest_basic();
             }    
       else if((const_arr[0][0]<0)&&(check_up()==2)){
           
                 const_arr[0][0]=pWidth-10;const_arr[0][2]=pWidth-6;move_rest_basic();
             }    
       else if((const_arr[0][1]>pHeight-10)&&(check_left()==2)){
           
                 const_arr[0][1]=0;const_arr[0][3]=-4;move_rest_basic();
             }    
       else if((const_arr[0][1]<0)&&(check_left()==1)){
       
                 const_arr[0][1]=pHeight-10;const_arr[0][3]=pHeight-6;move_rest_basic();
             }    
       
        
    }
   
    static void move_rest_basic(){
     for(int i=1;i<length;i++)
     {
       
           const_arr[i][2]=const_arr[i][0];  const_arr[i][3]=const_arr[i][1];
         const_arr[i][0]=const_arr[i-1][2];  const_arr[i][1]=const_arr[i-1][3];
         
         
     }
     
 
     
     
 }
    
    void  move_to_same_path_basic(){
   
          if(const_arr[0][0]>const_arr[0][2])      {
       const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]+=var2;}
      
   else if(const_arr[0][0]<const_arr[0][2]) {
      const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][0]-=var2;}
      
   else if(const_arr[0][1]>const_arr[0][3]) {
   const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]+=var2;}
    
   else if(const_arr[0][1]<const_arr[0][3]) {
   const_arr[0][2]=const_arr[0][0];const_arr[0][3]=const_arr[0][1];const_arr[0][1]-=var2;}
      
        
      
      }
    
    void run_basic(){
        beforetime=System.nanoTime();//System.out.println(beforetime);
             while(count==1){
           run_basic_calc();
          
          
          
          aftertime=System.nanoTime();
          timediff=aftertime-beforetime;
         // System.out.println("time_difference::::::::"+timediff);
          sleeptime=period -timediff-oversleeptime;//System.out.println(timediff);
          if(sleeptime>0){//System.out.println(">0"); 
          try{ Thread.sleep(sleeptime/1000000L);}catch(InterruptedException e){}
          oversleeptime=(System.nanoTime()-aftertime)-sleeptime;}
          else{//System.out.println("it is <0");
              excess-=sleeptime;
              oversleeptime=0;
              
          
          
          while((excess>period)&&(skip<5)&&(count==1)){//System.out.println("SKIPPING_PAINTING");
              excess-=period;
              run_basic_calc();
              skip++;
          }
          }
          beforetime=System.nanoTime();
          
           if(count==1)
            flag[0]=0;
          
            }
            try{Thread.currentThread().sleep(1000);}catch(Exception er){}
            msg=Double.toString(score);
    
   
    }

    void run_basic_calc(){
    flag[0]=1;turn=1;while(true){if((flag[1]!=1)||(turn!=1))break;else System.out.print("");}
            
           if(player_1OUT!=1){move_to_same_path_basic();move_rest_basic();}
               
               if(GUI.Multi_Player.isSelected()){
               
               if(player_2OUT!=1){plr.move_to_same_path_2();plr.move_rest_2();}
                   
                                            }
            if(player_1OUT!=1)
            OtherCollisions.check_for_walls_basic(const_arr);
          if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1)OtherCollisions.check_for_walls_2_basic();}
          if((snake_taste==1)||(GUI.Stage6.isSelected())){
              if(player_1OUT!=1)selfBite.did_not_bite(const_arr); 
              if(GUI.Multi_Player.isSelected()){if(player_2OUT!=1)selfBite.did_not_bite_2(plr.const_arr_player_2,plr.length_player_2);}}
           
          
          matrixSelect.matrix_collide(const_arr,plr.const_arr_player_2);
            
            
           if((player_1OUT!=1)||(player_2OUT!=1))
               food_generate.check_for_food_cord_basic(const_arr,d,plr.const_arr_player_2,plr.length_player_2);
           if((food==0)&&(GUI.Stage6.isSelected()))
          {
              if(food_generate.foodCount==matrix6.getFoodLimit()){
                  if(matrixSelect.number==5){minimum_Food_Count_for_Stage6=1;}
                  food_generate.foodCount=0;matrix6.create_stage_number();
                  if(matrixSelect.number==6)matrixSelect.number=5;
                  else{matrix6.resetSnake();sleepTime=0;
                  if(GUI.Multi_Player.isSelected()){matrix6.resetSnake2();}
                      try{Thread.sleep(1500);}catch(Exception er){}
                       }
                 
                                            }
          }
           
             if(GUI.Multi_Player.isSelected()){
           if((player_1OUT==1)&&(player_2OUT==1)){turn=1;count=0;}
                                        }
           else if(player_1OUT==1){turn=1;count=0;//System.out.println("out in run");
           }
        update_basic();
          if(sleepTime<3000)sleepTime+=50;     
          
    }
    
    static void realloc_memory_basic(){
   const_arr1=new double[length][4];
    
    for(int i=0;i<length-2;i++){
    const_arr1[i][0]=const_arr[i][0];const_arr1[i][1]=const_arr[i][1];
    const_arr1[i][2]=const_arr[i][2];const_arr1[i][3]=const_arr[i][3];
    }const_arr=null;const_arr=const_arr1;const_arr1=null;
    const_arr[length-2][0]=const_arr[length-3][0];const_arr[length-2][1]=const_arr[length-3][1];
    const_arr[length-2][2]=const_arr[length-2][0];const_arr[length-2][3]=const_arr[length-2][1];
    const_arr[length-1][0]=const_arr[length-2][0];const_arr[length-1][1]=const_arr[length-2][1];
    const_arr[length-1][2]=const_arr[length-1][0];const_arr[length-1][3]=const_arr[length-1][1];
        
    
    }
    
    void update_basic(){
        
      
          current_g=this.getGraphics();
          g2d1=(Graphics2D)(current_g);
          if(buffer==null)buffer=createImage(pWidth,pHeight);
         if((count==1))
          {
              Snake1.paint_basic(g2d,const_arr,this);
         }
      else
         {
             msg=Double.toString(score);count=0;
             if(key1!=null)removeKeyListener(key1);
             if(key2!=null)removeKeyListener(key2);
             if(GUI.Music.getState())try{MainFrame.stopMusic();}catch(Exception eee){}
             if(GUI.Sounds.getState())if(MainFrame.p1!=null)try{MainFrame.p1.stop();}catch(Exception eee){}
             
             try{Thread.currentThread().sleep(1000);}catch(Exception er){//System.out.println(er);
             }
             turn=1;addKeyListener(null);
             
             paint_out();
         }
                    
    
   
    }
    
    static int check_up(){
         if((const_arr[0][0]>const_arr[0][2]))return 1;
         if(const_arr[0][0]<const_arr[0][2])return 2; 
         return 0;}
    
    static  int check_left(){
         if((const_arr[0][1]<const_arr[0][3]))return 1;
         if(const_arr[0][1]>const_arr[0][3])return 2;
         return 0;}
    
    static void stopSound_Music(){
             if(GUI.Music.getState())try{MainFrame.stopMusic();}catch(Exception eee){}
             if(GUI.Sounds.getState())if(MainFrame.p1!=null)try{MainFrame.p1.stop();}catch(Exception eee){}
             
           }
}

