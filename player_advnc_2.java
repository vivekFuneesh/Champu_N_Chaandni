
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

player_advnc_2.java is part of Champu_N_Chaandni.

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


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;



class player_advnc_2{
static double[][] const_arr_player_2;
 
 static double[][] const_arr1_player_2,arr1;
 
 static int pWidth,pHeight;
 static double score_player_2;
 
 static int length_player_2=5;
 
 static double d_player_2,b[][],arr[][],b1[][];
 
 static int turn_b_player_2=1;
 static int var1=2;
 static double var3=Math.PI+5.5;
 static double dist_player_2;
 
 static double var2;
 
 
 static java.lang.String msg_player_2;
 
 

 
  static void reset(){
 
const_arr_player_2=null;
 
  const_arr1_player_2=null;arr1=null;
 
 
  score_player_2=0;
 
  length_player_2=5;
 
  d_player_2=0;b=null;arr=null;b1=null;
 
  turn_b_player_2=1;
  var1=2;
  var3=Math.PI+5.5;
  dist_player_2=0;
 

 var2=Main.var2;
 
 
 msg_player_2="";
 
  
 
 
 }
 
  static int check_up_2(){
         if((const_arr_player_2[0][0]>const_arr_player_2[0][2]))return 1;
         if((const_arr_player_2[0][0]<const_arr_player_2[0][2]))return 2;
         return 0;}
   
  static int check_left_2(){
         if((const_arr_player_2[0][1]<const_arr_player_2[0][3]))return 1;
         if((const_arr_player_2[0][1]>const_arr_player_2[0][3]))return 2;
         return 0;}
      
  static void move_other_side_2(){  pWidth=Main.pWidth;pHeight=Main.pHeight;
        if((b[0][0]>=pWidth-10)&&(check_up_2()==1)){
          
                 const_arr_player_2[0][0]=0;const_arr_player_2[0][2]=-1;
                 arr[0][1]=b[0][1];b[0][0]=0;arr[0][0]=-1;player_advnc_2.move_rest_2();
                  
             }    
       else if((b[0][0]<=0)&&(check_up_2()==2)){
           
                 const_arr_player_2[0][0]=pWidth-5;const_arr_player_2[0][2]=pWidth-2;
                 arr[0][0]=pWidth-2;arr[0][1]=b[0][1];b[0][0]=pWidth-5;player_advnc_2.move_rest_2();
           
             }    
       else if((b[0][1]>=pHeight-10)&&(check_left_2()==2)){
                 arr[0][0]=b[0][0];arr[0][1]=-1;b[0][1]=0;
                 const_arr_player_2[0][1]=0;const_arr_player_2[0][3]=-1;player_advnc_2.move_rest_2();
            
             }    
       else if((b[0][1]<=0)&&(check_left_2()==1)){
             arr[0][0]=b[0][0];arr[0][1]=pHeight-2;b[0][1]=pHeight-5;
           const_arr_player_2[0][1]=pHeight-5;const_arr_player_2[0][3]=pHeight-2;player_advnc_2.move_rest_2();
         
             }    
    }
 
  static void move_rest_2(){
 
     for(int i=1;i<length_player_2;i++)
     {
        
         arr[i][0]=b[i][0];
         arr[i][1]=b[i][1];
         b[i][0]=arr[i-1][0];
         b[i][1]=arr[i-1][1];
           const_arr_player_2[i][2]=const_arr_player_2[i][0];  const_arr_player_2[i][3]=const_arr_player_2[i][1];
         const_arr_player_2[i][0]=const_arr_player_2[i-1][2];  const_arr_player_2[i][1]=const_arr_player_2[i-1][3];
         
         
     }
     
 
 }
 
  static void move_to_same_path_2(){
      
      
       if(const_arr_player_2[0][0]>const_arr_player_2[0][2])      {arr[0][0]=b[0][0];arr[0][1]=b[0][1];
       if(turn_b_player_2==1)
       b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3));else b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3)); 
       b[0][0]+=var2;const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][0]+=var2;}
      
   else if(const_arr_player_2[0][0]<const_arr_player_2[0][2]) {arr[0][0]=b[0][0];arr[0][1]=b[0][1];
      if(turn_b_player_2==1)
      b[0][1]=b[0][1]+(var1*Math.sin(b[0][0]/var3)); else b[0][1]=b[0][1]-(var1*Math.sin(b[0][0]/var3));
      b[0][0]-=var2;const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][0]-=var2;}
      
   else if(const_arr_player_2[0][1]>const_arr_player_2[0][3]) {arr[0][1]=b[0][1];arr[0][0]=b[0][0];
   if(turn_b_player_2==0)
   b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));else b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));
   b[0][1]+=var2;const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][1]+=var2;}
    
   else if(const_arr_player_2[0][1]<const_arr_player_2[0][3]) {arr[0][1]=b[0][1];arr[0][0]=b[0][0];
   if(turn_b_player_2==0)
   b[0][0]=b[0][0]-(var1*Math.sin(b[0][1]/var3));else b[0][0]=b[0][0]+(var1*Math.sin(b[0][1]/var3));
   b[0][1]-=var2;const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][1]-=var2;}
          
      }
 
  static void realloc_memory_player_2(){
   arr1=new double[length_player_2][2];b1=new double[length_player_2][2];const_arr1_player_2=new double[length_player_2][4];
    for(int i=0;i<length_player_2-2;i++){
        arr1[i]=arr[i];b1[i]=b[i];
    }
    arr=null;arr=arr1;
    b=null;b=b1;b1=arr1=null;
    b[length_player_2-2][0]=arr[length_player_2-3][0];b[length_player_2-1][0]=b[length_player_2-2][0];
    b[length_player_2-2][1]=arr[length_player_2-3][1];b[length_player_2-1][1]=b[length_player_2-2][1];
    for(int i=0;i<length_player_2-2;i++){
    const_arr1_player_2[i][0]=const_arr_player_2[i][0];const_arr1_player_2[i][1]=const_arr_player_2[i][1];
    const_arr1_player_2[i][2]=const_arr_player_2[i][2];const_arr1_player_2[i][3]=const_arr_player_2[i][3];
    }const_arr_player_2=null;const_arr_player_2=const_arr1_player_2;const_arr1_player_2=null;
    
  
  }
   
  static void paint_player_2(Graphics2D g2d){
  
       for(int i=length_player_2-3;i>0;i--){ 
         
              if(i%2==0) g2d.setPaint(new GradientPaint(50,100,Color.blue,60,20,Color.white,true)); 
              
              else g2d.setPaint(new GradientPaint(50,10,Color.ORANGE,60,20,Color.red,true));
                 
            
              if((check_up_2() ==1)||(check_up_2()==1))
              g2d.fill(new Ellipse2D.Double(b[i][0], b[i][1],10,10));
              else g2d.fill(new Ellipse2D.Double(b[i][0], b[i][1],10,10));
              if(show_mouth_player_2()==1)
              open_mouth_player_2(g2d); 
              else close_mouth_player_2(g2d);
         } draw_last_player_2(g2d);
          
    
  
  }
     
  static void close_mouth_player_2(Graphics2D g2d){
    if(check_up_2()==1){
            g2d.fill(new Ellipse2D.Double(b[1][0]+5,b[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(b[1][0]+5,b[1][1]+8,12,3));
        }
        if(check_up_2()==2){
            g2d.fill(new Ellipse2D.Double(b[1][0]-6,b[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(b[1][0]-6,b[1][1]+8,12,3));
        }
        if(check_left_2()==1){
            g2d.fill(new Ellipse2D.Double(b[1][0]+1,b[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(b[1][0]+8,b[1][1]-6,3,12));
        }
        if(check_left_2()==2){
            g2d.fill(new Ellipse2D.Double(b[1][0]+1,b[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(b[1][0]+8,b[1][1]+6,3,12));
        }
    
    }
    
  static int show_mouth_player_2(){
     dist_player_2=Math.sqrt((b[0][0]-5-food_generate.x)*(b[0][0]-5-food_generate.x)+(b[0][1]-5-food_generate.y)*(b[0][1]-5-food_generate.y));
    if(dist_player_2<=25)
        return 1;
        return 0;
    }
  
  static void draw_last_player_2(Graphics2D g2d){
   g2d.fill(new Ellipse2D.Double(b[length_player_2-3][0],b[length_player_2-3][1],9,9));
   
      g2d.fill(new Ellipse2D.Double(b[length_player_2-2][0],b[length_player_2-2][1],8,8));
            g2d.fill(new Ellipse2D.Double(b[length_player_2-1][0],b[length_player_2-1][1],7,7)); 
    }
  
  static void open_mouth_player_2(Graphics2D g2d){
         if(check_up_2()==1){
            g2d.fill(new Ellipse2D.Double(b[1][0]+4,b[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(b[1][0]+4,b[1][1]+8,12,3));
        }
        if(check_up_2()==2){
            g2d.fill(new Ellipse2D.Double(b[1][0]-6,b[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(b[1][0]-6,b[1][1]+8,12,3));
        }
        if(check_left_2()==1){
            g2d.fill(new Ellipse2D.Double(b[1][0]-3,b[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(b[1][0]+8,b[1][1]-6,3,12));
        }
        if(check_left_2()==2){
            g2d.fill(new Ellipse2D.Double(b[1][0]-3,b[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(b[1][0]+8,b[1][1]+6,3,12));
        }
           }
    
  static void form_player_2(){
  
                  b=new double[5][2];arr=new double[5][2];const_arr_player_2=new double[5][4];
                  b[0][0]=0;b[0][1]=matrix6.getInitialHeight();
                  arr[0][0]=-10;arr[0][1]=b[0][1];
                   const_arr_player_2[0][0]=b[0][0];const_arr_player_2[0][1]=b[0][1];
                   const_arr_player_2[0][2]=const_arr_player_2[0][0]-4;const_arr_player_2[0][3]=const_arr_player_2[0][1];
                      length_player_2=5;                                       
                   for(int i=1;i<length_player_2;i++)
                  {
                      b[i][0]=b[i-1][0]-4;
                      b[i][1]=b[i-1][1];
                      arr[i][0]=b[i][0]-4;
                      arr[i][1]=b[i][1];
                       const_arr_player_2[i][0]=const_arr_player_2[i-1][2];const_arr_player_2[i][1]=const_arr_player_2[i-1][3];
                       const_arr_player_2[i][2]=const_arr_player_2[i][0]-4;const_arr_player_2[i][0]=const_arr_player_2[i][3];
                  }
                 
                   
  
  }
  

}
