

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

matrix3.java is part of Champu_N_Chaandni.

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
import java.util.Random;

/**
 *
 * @author vivek
 */
public class matrix3 {
    
    
    
    static int x,y,X,Y,i,j,k,num;
    
    static byte[][] matrix;
    
    static int VSL_breadth,VSL_height,block_width,block_height;//VIRTUAL_SCREEN_LENGTH
   
    
    static Random random;
    
    
    static void calculate_vsl(){
      VSL_breadth=Main.pWidth/10;
      VSL_breadth*=10;
      
      VSL_height=Main.pHeight/10;
      VSL_height*=10;
      
      block_width=VSL_breadth/10;
      block_height=VSL_height/10;
      
      //System.out.println("pWidth="+block_width+" pHeight="+block_height+" VSL_breadth="+ VSL_breadth+" height:"+VSL_height);
     }
    
    static void generate_matrix(){
       matrix=null;
       matrix=new byte[10][10];
       random=new Random();
       j=k=0;
       for(i=0;i<100;i++)
       {
           num=random.nextInt(2);
           if(num==0){matrix[j][k]=1;}
           else if(num==1){matrix[j][k]=2;}
           
           k++;
           if(k==10){k=0;j++;}
       }
       
   }
   
    static void drawObstacle(Graphics2D g2d){
       for(i=0;i<10;i++)
       {
           for(j=0;j<10;j++)
           {
               
                   create_OBSTACLES(g2d,i,j);
           }
       }
       
   }
    
    static void create_OBSTACLES(Graphics2D g2d,int i,int j){
       x=j*block_width;
       x+=block_width/2;
       y=i*block_height;
       y+=block_height/2;
       
       X=j*block_width;
       X+=block_width/2;
       Y=i*block_height;
       Y+=block_height/2;
       
       
       if(matrix[i][j]==1)     {x+=5;y+=5;X-=15;Y-=15;}
       else if(matrix[i][j]==2){x+=5;y-=15;X-=15;Y+=5;}
       
     
       g2d.fill(new Rectangle2D.Double(x,y,7,7));
       g2d.fill(new Rectangle2D.Double(X, Y,7,7));
              
       
                                                             }
    
    static void collision_Detector(double x,double y){
        if((x<VSL_breadth)&&(y<VSL_height))
        {
        j=(int)x/block_width;
        i=(int)y/block_height;
               
        check_collide(i,j,x,y);
        if((i-1>0)&&(j-1>0))check_collide(i-1,j-1,x,y);
        if((i-1>0))check_collide(i-1,j,x,y);
        if((i-1>0)&&(j+1<10))check_collide(i-1,j+1,x,y);
        if((j-1>0))check_collide(i,j-1,x,y);
        if((j+1<10))check_collide(i,j+1,x,y);
        if((i+1<10)&&(j-1>0))check_collide(i+1,j-1,x,y);
        if((i+1<10))check_collide(i+1,j,x,y);
        if((i+1<10)&&(j+1<10))check_collide(i+1,j+1,x,y);
        }  
        
        
    }
    
    static void check_collide(int i,int j,double xPos,double yPos){
    
       x=j*block_width;
       x+=block_width/2;
       y=i*block_height;
       y+=block_height/2;
       
       X=j*block_width;
       X+=block_width/2;
       Y=i*block_height;
       Y+=block_height/2;
       
       if(matrix[i][j]==1)     {x+=5;y+=5;X-=15;Y-=15;}
       else if(matrix[i][j]==2){x+=5;y-=15;X-=15;Y+=5;}
           
            
            if((contains(x-10,y-10,17,17,xPos,yPos))||(contains(X-10,Y-10,17,17,xPos,yPos)))
         {
        
             //System.out.println("OUT_INSIDE_MATRIX3_CORDS_ARE::");
             //System.out.println();
             
             Main.player_1OUT=1;
            
            
         }
         
                                          }
    
     static boolean contains(int x2,int y2,int width,int height,double x1,double y1){
        
        if((x1>=x2)&&(x1<=x2+width-1)&&(y1>=y2)&&(y1<=y2+height-1))
        return true;
        return false;
    }
    
    static void collision_Detector2(double x,double y){
    
        
        
        if((x<VSL_breadth)&&(y<VSL_height))
        {
        j=(int)x/block_width;
        i=(int)y/block_height;
               
                              check_collide2(i,j,x,y);
                              
        if((i-1>0)&&(j-1>0))  check_collide2(i-1,j-1,x,y);
        
        if((i-1>0))           check_collide2(i-1,j,x,y);
        
        if((i-1>0)&&(j+1<10)) check_collide2(i-1,j+1,x,y);
        
        if((j-1>0))           check_collide2(i,j-1,x,y);
        
        if((j+1<10))          check_collide2(i,j+1,x,y);
        
        if((i+1<10)&&(j-1>0)) check_collide2(i+1,j-1,x,y);
        
        if((i+1<10))          check_collide2(i+1,j,x,y);
        
        if((i+1<10)&&(j+1<10))check_collide2(i+1,j+1,x,y);
        
        }
        
                                                      }
    
    static void check_collide2(int i,int j,double xPos,double yPos){
        
        
       x=j*block_width;
       x+=block_width/2;
       y=i*block_height;
       y+=block_height/2;
       
       X=j*block_width;
       X+=block_width/2;
       Y=i*block_height;
       Y+=block_height/2;
       
       if(matrix[i][j]==1)     {x+=5;y+=5;X-=15;Y-=15;}
       else if(matrix[i][j]==2){x+=5;y-=15;X-=15;Y+=5;}
           
            
            if((contains(x-10,y-10,17,17,xPos,yPos))||(contains(X-10,Y-10,17,17,xPos,yPos)))
         {
        
             
             Main.player_2OUT=1;
            
            
         }
         
                                                       }


 }
