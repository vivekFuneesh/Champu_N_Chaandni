
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

matrix4.java is part of Champu_N_Chaandni.

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



import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author vivek
 */

public class matrix4 {
    
    static int VSL_breadth,VSL_height,block_width,block_height;
 
    static int i,j,k,num,x,X,y,Y,xX,xxXX,yY,yyYY,xPos,yPos;
    
    static int x1,y1,x2,y2,x3,x4,y3,y4;
   
   
    
    static void reset(){
    
        i=j=k=num=x=X=y=Y=xX=xxXX=yY=yyYY=xPos=yPos=0;
        x1=y1=x2=y2=x3=x4=y3=y4=0;
        VSL_breadth=VSL_height=block_width=block_height=0;     
                calculate_VSL();
        
                       }
    
    static void calculate_VSL(){
        
        VSL_breadth=Main.pWidth/10;
        VSL_breadth*=10;
      
        VSL_height=Main.pHeight/10;
        VSL_height*=10;
      
        block_width=VSL_breadth/5;
        block_height=VSL_height/5;
      
        y2=block_height-21;
        x2=block_width-21;
        
        x3=block_width-21;
        y4=block_height-21;
       
        
                                }
    
    
    static void drawObstacle(Graphics2D g2d){
        
    for(i=0;i<5;i++)
       {
           for(j=0;j<5;j++)
           {
               
               create_OBSTACLES(g2d,i,j);
   
           }
       }
         
        
                     
                              }
    
    
    static void create_OBSTACLES(Graphics2D g2d,int i,int j){
        
       x=j*block_width+x1;
       y=i*block_height+y1;
       
       
       X=j*block_width+x2;
       Y=i*block_height+y2;
       
       xX=j*block_width+x3;
       yY=i*block_height+y3;
       
       xxXX=j*block_width+x4;
       yyYY=i*block_height+y4;
       
         
       g2d.fill(new Rectangle2D.Double(x,y,10,10));
       g2d.fill(new Rectangle2D.Double(X, Y,10,10));
       g2d.fill(new Rectangle2D.Double(xX, yY,10,10));
       g2d.fill(new Rectangle2D.Double(xxXX, yyYY,10,10));
              
    }
    
    static void move_matrix(){
        
      if(y1==0){if(x1<block_width-21)x1++;else{x1=block_width-21;y1++;}}
      else if(x1==block_width-21){if(y1<block_height-21)y1++;else{y1=block_height-21;x1--;}}
      else if(y1==block_height-21){if(x1>0)x1--;else{x1=0;y1--;}}
      else if(x1==0){if(y1>0)y1--;else{y1=0;x1++;}}
      
      if(y2==0){if(x2<block_width-21)x2++;else{x2=block_width-21;y2++;}}
      else if(x2==block_width-21){if(y2<block_height-21)y2++;else{y2=block_height-21;x2--;}}
      else if(y2==block_height-21){if(x2>0)x2--;else{x2=0;y2--;}}
      else if(x2==0){if(y2>0)y2--;else{y2=0;x2++;}}
     
      if(y3==0){if(x3<block_width-21)x3++;else{x3=block_width-21;y3++;}}
      else if(x3==block_width-21){if(y3<block_height-21)y3++;else{y3=block_height-21;x3--;}}
      else if(y3==block_height-21){if(x3>0)x3--;else{x3=0;y3--;}}
      else if(x3==0){if(y3>0)y3--;else{y3=0;x3++;}}
      
      if(y4==0){if(x4<block_width-21)x4++;else{x4=block_width-21;y4++;}}
      else if(x4==block_width-21){if(y4<block_height-21)y4++;else{y4=block_height-21;x4--;}}
      else if(y4==block_height-21){if(x4>0)x4--;else{x4=0;y4--;}}
      else if(x4==0){if(y4>0)y4--;else{y4=0;x4++;}}
      
                             }
    
    static void collisionDetector(double x,double y,int SIZE){
       
        if((x<VSL_breadth)&&(y<VSL_height)){
            
            j=(int)x/block_width;i=(int)y/block_height;
            xPos=j*block_width;yPos=i*block_height;
            
            check_collide(xPos,yPos,x,y,SIZE);
            if((i-1>0)&&(j-1>0))check_collide(xPos-block_width,yPos-block_height,x,y,SIZE);
        if((i-1>0))check_collide(xPos,yPos-block_height,x,y,SIZE);
        if((i-1>0)&&(j+1<5))check_collide(xPos+block_width,yPos-block_height,x,y,SIZE);
        if((j-1>0))check_collide(xPos-block_width,yPos,x,y,SIZE);
        if((j+1<5))check_collide(xPos+block_width,yPos,x,y,SIZE);
        if((i+1<5)&&(j-1>0))check_collide(xPos-block_width,yPos+block_height,x,y,SIZE);
        if((i+1<5))check_collide(xPos,yPos+block_height,x,y,SIZE);
        if((i+1<5)&&(j+1<5))check_collide(xPos+block_width,yPos+block_height,x,y,SIZE);
           
            
                                           }
       
                                                    }
    
    static void check_collide(int xPos,int yPos,double x,double y,int SIZE){
        
       
        if((contains(xPos+x1-10,yPos+y1-10,SIZE,x,y))||(contains(xPos+x2-10,yPos+y2-10,SIZE,x,y))||(contains(xPos+x3-10,yPos+y3-10,SIZE,x,y))||(contains(xPos+x4-10,yPos+y4-10,SIZE,x,y)))
        {
            
           
            Main.player_1OUT=1;
            System.out.println("For 1st"+"x"+x+"y"+y+"xPos"+xPos+"yPos"+yPos+"SIZE"+SIZE);
            
        }
   
    }

    static boolean contains(int x2,int y2,int SIZE,double x1,double y1){
        
        if((x1>=x2)&&(x1<=x2+SIZE-1)&&(y1>=y2)&&(y1<=y2+SIZE-1))
        return true;
        return false;
    }
    
    static void collisionDetector2(double x,double y,int SIZE){
     
        if((x<VSL_breadth)&&(y<VSL_height)){
            
            j=(int)x/block_width;i=(int)y/block_height;
            xPos=j*block_width;yPos=i*block_height;
            
            check_collide2(xPos,yPos,x,y,SIZE);
            if((i-1>0)&&(j-1>0))check_collide2(xPos-block_width,yPos-block_height,x,y,SIZE);
        if((i-1>0))check_collide2(xPos,yPos-block_height,x,y,SIZE);
        if((i-1>0)&&(j+1<5))check_collide2(xPos+block_width,yPos-block_height,x,y,SIZE);
        if((j-1>0))check_collide2(xPos-block_width,yPos,x,y,SIZE);
        if((j+1<5))check_collide2(xPos+block_width,yPos,x,y,SIZE);
        if((i+1<5)&&(j-1>0))check_collide2(xPos-block_width,yPos+block_height,x,y,SIZE);
        if((i+1<5))check_collide2(xPos,yPos+block_height,x,y,SIZE);
        if((i+1<5)&&(j+1<5))check_collide2(xPos+block_width,yPos+block_height,x,y,SIZE);
           
            
                                           }
       
                                                    }
    
    static void check_collide2(int xPos,int yPos,double x,double y,int SIZE){
        
       
        if((contains(xPos+x1-10,yPos+y1-10,SIZE,x,y))||(contains(xPos+x2-10,yPos+y2-10,SIZE,x,y))||(contains(xPos+x3-10,yPos+y3-10,SIZE,x,y))||(contains(xPos+x4-10,yPos+y4-10,SIZE,x,y)))
        {
            Main.player_2OUT=1;//System.out.println("For 2nd"+"x"+x+"y"+y+"xPos"+xPos+"yPos"+yPos+"SIZE"+SIZE);
            
        }

    }

                     }
