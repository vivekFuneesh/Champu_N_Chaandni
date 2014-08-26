
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

player2.java is part of Champu_N_Chaandni.

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



class player2 {
    
static double[][] const_arr_player_2;
 
 static double[][] const_arr1_player_2;
 
 
 static double score_player_2;
 
 static int length_player_2=5,pWidth,pHeight;
 
 static double d_player_2;
 
 
 static double dist_player_2,var2;
 

 
 
 static java.lang.String msg_player_2;
 
 
 
 
     static void reset(){
 
    
const_arr_player_2=null;
 
 const_arr1_player_2=null;
 
 
  score_player_2=0;
 
  length_player_2=5;
 
  d_player_2=0;
 
 
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
      
     static  void move_other_side_2(){  pWidth=Main.pWidth;pHeight=Main.pHeight;
       if((const_arr_player_2[0][0]>=pWidth-10)&&(check_up_2()==1)){
          
                 const_arr_player_2[0][0]=0;const_arr_player_2[0][2]=-1;player2.move_rest_2();
             }    
       else if((const_arr_player_2[0][0]<=0)&&(check_up_2()==2)){
           
                 const_arr_player_2[0][0]=pWidth-5;const_arr_player_2[0][2]=pWidth-2;player2.move_rest_2();
             }    
       else if((const_arr_player_2[0][1]>=pHeight-10)&&(check_left_2()==2)){
           
                 const_arr_player_2[0][1]=0;const_arr_player_2[0][3]=-1;player2.move_rest_2();
             }    
       else if((const_arr_player_2[0][1]<=0)&&(check_left_2()==1)){
       
                 const_arr_player_2[0][1]=pHeight-5;const_arr_player_2[0][3]=pHeight-2;player2.move_rest_2();
             }    
    }
 
     static void move_rest_2(){
 for(int i=1;i<length_player_2;i++){
      const_arr_player_2[i][2]=const_arr_player_2[i][0];  const_arr_player_2[i][3]=const_arr_player_2[i][1];
         const_arr_player_2[i][0]=const_arr_player_2[i-1][2];  const_arr_player_2[i][1]=const_arr_player_2[i-1][3];
         
     
     }
 }
 
     static void move_to_same_path_2(){
      
      
          if(check_up_2()==1)      {
       const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][0]+=var2;}
      
   else if(check_up_2()==2) {
      const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][0]-=var2;}
      
   else if(check_left_2()==2) {
   const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][1]+=var2;}
    
   else if(check_left_2()==1) {
   const_arr_player_2[0][2]=const_arr_player_2[0][0];const_arr_player_2[0][3]=const_arr_player_2[0][1];const_arr_player_2[0][1]-=var2;}
   
          
          
      }

     static void realloc_memory_player_2(){
   const_arr1_player_2=new double[length_player_2][4];
    
    for(int i=0;i<length_player_2-2;i++){
    const_arr1_player_2[i][0]=const_arr_player_2[i][0];const_arr1_player_2[i][1]=const_arr_player_2[i][1];
    const_arr1_player_2[i][2]=const_arr_player_2[i][2];const_arr1_player_2[i][3]=const_arr_player_2[i][3];
    }const_arr_player_2=null;const_arr_player_2=const_arr1_player_2;const_arr1_player_2=null;
    
    const_arr_player_2[length_player_2-2][0]=const_arr_player_2[length_player_2-3][0];const_arr_player_2[length_player_2-2][1]=const_arr_player_2[length_player_2-3][1];
    const_arr_player_2[length_player_2-2][2]=const_arr_player_2[length_player_2-2][0];const_arr_player_2[length_player_2-2][3]=const_arr_player_2[length_player_2-2][1];
    const_arr_player_2[length_player_2-1][0]=const_arr_player_2[length_player_2-2][0];const_arr_player_2[length_player_2-1][1]=const_arr_player_2[length_player_2-2][1];
    const_arr_player_2[length_player_2-1][2]=const_arr_player_2[length_player_2-1][0];const_arr_player_2[length_player_2-1][3]=const_arr_player_2[length_player_2-1][1];
    
    
     }
    
     static void paint_player_2(Graphics2D screengc){
  
          for(int i=length_player_2-3;i>0;i--){ 
         
              if(i%2==0) screengc.setPaint(new GradientPaint(50,100,Color.blue,60,20,Color.white,true)); 
              
              else screengc.setPaint(new GradientPaint(50,10,Color.orange,60,20,Color.red,true));
                 
              screengc.fill(new Ellipse2D.Double(const_arr_player_2[i][0], const_arr_player_2[i][1],10,10));
             
              if(show_mouth_player_2()==1)open_mouth_player_2(screengc); 
              else close_mouth_player_2(screengc);
                                            }
              draw_last_player_2(screengc);
           
    
  
  }
     
     static void close_mouth_player_2(Graphics2D g2d){
    if(check_up_2()==1){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+5,const_arr_player_2[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+5,const_arr_player_2[1][1]+8,12,3));
        }
        if(check_up_2()==2){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-6,const_arr_player_2[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-6,const_arr_player_2[1][1]+8,12,3));
        }
        if(check_left_2()==1){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+1,const_arr_player_2[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+8,const_arr_player_2[1][1]-6,3,12));
        }
        if(check_left_2()==2){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+1,const_arr_player_2[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+8,const_arr_player_2[1][1]+6,3,12));
        }
    
    }
     
     static int show_mouth_player_2(){
    dist_player_2=Math.sqrt((const_arr_player_2[0][0]-5-food_generate.x)*(const_arr_player_2[0][0]-5-food_generate.x)+(const_arr_player_2[0][1]-5-food_generate.y)*(const_arr_player_2[0][1]-5-food_generate.y));
    if(dist_player_2<=25)
        return 1;
        return 0;
    }
   
     static void draw_last_player_2(Graphics2D g2d){
         
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[length_player_2-3][0],const_arr_player_2[length_player_2-3][1],9,9));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[length_player_2-2][0],const_arr_player_2[length_player_2-2][1],8,8));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[length_player_2-1][0],const_arr_player_2[length_player_2-1][1],7,7));
    }
  
     static void open_mouth_player_2(Graphics2D g2d){
        if(check_up_2()==1){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+4,const_arr_player_2[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+4,const_arr_player_2[1][1]+8,12,3));
        }
        if(check_up_2()==2){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-6,const_arr_player_2[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-6,const_arr_player_2[1][1]+8,12,3));
        }
        if(check_left_2()==1){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-3,const_arr_player_2[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+8,const_arr_player_2[1][1]-6,3,12));
        }
        if(check_left_2()==2){
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]-3,const_arr_player_2[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr_player_2[1][0]+8,const_arr_player_2[1][1]+6,3,12));
        }
           }
    
     static void form_player_2(){
  
                   const_arr_player_2=new double[5][4];
                 
                   const_arr_player_2[0][0]=0;const_arr_player_2[0][1]=matrix6.getInitialHeight();
                   const_arr_player_2[0][2]=const_arr_player_2[0][0]-4;const_arr_player_2[0][3]=const_arr_player_2[0][1];
                        length_player_2=5;                                     
                   for(int i=1;i<length_player_2;i++)
                  {
                      
                       const_arr_player_2[i][0]=const_arr_player_2[i-1][2];const_arr_player_2[i][1]=const_arr_player_2[i-1][3];
                       const_arr_player_2[i][2]=const_arr_player_2[i-1][2];const_arr_player_2[i][3]=const_arr_player_2[i-1][3];
                  }
                 
                   
  
  }
  
   

}
