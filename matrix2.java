
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

matrix2.java is part of Champu_N_Chaandni.

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
public class matrix2 {
      
    
    
    static int AL,AL_b=Main.pWidth/2,AL_h=Main.pHeight/2;
    static int x,y,width,height,count=0,xPos,yPos,regionPos;
    static int vertical,horizontal,t_t_b,b_t_t,l_t_r,r_t_l;
    static int[][] matrix=null,temp=null;
  
    
     static void createMatrix(int x,int y,int width,int height,int region){
    
         if(matrix==null){
             matrix=new int[1][5];
             matrix[0][0]=x;matrix[0][1]=y;matrix[0][2]=width;matrix[0][3]=height;matrix[0][4]=region;
                         }
         else{
        temp=null;
        temp=new int[matrix.length][5];
       // System.out.println("temp allocate::"+temp+"length::"+temp.length);
        for(int i=0;i<matrix.length;i++)
        {
            
            temp[i][0]=
                    matrix[i][0];
            temp[i][1]=matrix[i][1];
            temp[i][2]=matrix[i][2];
            temp[i][3]=matrix[i][3];
            temp[i][4]=matrix[i][4];
        }
        matrix=null;
        matrix=new int[temp.length+1][5];
        for(int i=0;i<temp.length;i++)
        {
            matrix[i][0]=temp[i][0];matrix[i][1]=temp[i][1];matrix[i][2]=temp[i][2];matrix[i][3]=temp[i][3];
            matrix[i][4]=temp[i][4];
        }temp=null;
        matrix[matrix.length-1][0]=x;matrix[matrix.length-1][1]=y;
        matrix[matrix.length-1][2]=width;matrix[matrix.length-1][3]=(int)height;matrix[matrix.length-1][4]=region;
             }
                                                              }
    
     static void resetAll(){
   
                           AL=0;AL_b=Main.pWidth/2;AL_h=Main.pHeight/2;
                           x=y=width=height=0;
                           vertical=horizontal=t_t_b=b_t_t=l_t_r=r_t_l=0;
                          }
     
     static void pipe_bite_vertical(double b[][],int x,int y,int W,int H){
         
             initVertical(x,y,W,H);
             check_pipe(x, y,width, height,b[0][0],b[0][1]);vertical=0;horizontal=1;rest();t_t_b=1;
             while(AL>=5){
                             startVertical();
                             check_pipe(x, y,width, height,b[0][0],b[0][1]);
                         }
             resetAll();
             
                                     }
     
     static void pipe_bite_horizontal(double b[][],int x,int y,int W,int H){
         
             initHorizontal(x,y,W,H);
             check_pipe(x, y,width, height,b[0][0],b[0][1]);vertical=1;horizontal=0;rest();t_t_b=1;
             while(AL>=5){
                             startHorizontal();
                             check_pipe(x, y,width, height,b[0][0],b[0][1]);
                         }
             resetAll();
             
                                       }
     
     static void pipe_bite(double b[][]){
            if(count==0){
             pipe_bite_vertical(b,0,0,(Main.pWidth/2)-50,(Main.pHeight/2)-50);
             pipe_bite_horizontal(b,Main.pWidth/2,0,(Main.pWidth/2)-100,(Main.pHeight/2)-50);
             pipe_bite_vertical(b,0,Main.pHeight/2,(Main.pWidth/2)-50,(Main.pHeight/2)-100);
             pipe_bite_horizontal(b,Main.pWidth/2,Main.pHeight/2,(Main.pWidth/2)-100,(Main.pHeight/2)-100);
                       }
            
            else {
                    xPos=2*(int)b[0][0]/Main.pWidth;
                    yPos=2*(int)b[0][1]/Main.pHeight;
                    if(xPos==0){if(yPos==0)regionPos=0;else if(yPos==1)regionPos=2;}
                    else if(xPos==1){if(yPos==0)regionPos=1;else if(yPos==1)regionPos=3;}
                    
                for(int i=0;i<matrix.length;i++)
                {
                    if(matrix[i][4]==regionPos)
                  check_pipe(matrix[i][0], matrix[i][1], matrix[i][2],matrix[i][3],b[0][0],b [0][1]);
                }
            
                 }
        
    }
   
     static void pipe_bite_advnc(double b[][]){
           if(count==0){
            pipe_bite_vertical(b,0,0,(Main.pWidth/2)-50,(Main.pHeight/2)-50);
             pipe_bite_horizontal(b,Main.pWidth/2,0,(Main.pWidth/2)-100,(Main.pHeight/2)-50);
             pipe_bite_vertical(b,0,Main.pHeight/2,(Main.pWidth/2)-50,(Main.pHeight/2)-100);
             pipe_bite_horizontal(b,Main.pWidth/2,Main.pHeight/2,(Main.pWidth/2)-100,(Main.pHeight/2)-100);
            
             
                       }
            else {
                for(int i=0;i<matrix.length;i++)
                {
                  
                  check_pipe2(matrix[i][0], matrix[i][1], matrix[i][2],matrix[i][3],b[0][0],b [0][1]);
                }
            
                 }
    }
    
     static void check_pipe(int x_pillar,int y_pillar,int width,int height,double x_snakeHead,double y_snakeHead){
        
         
        
         if(contains(x_pillar-10,y_pillar-10,width+10,height+10,x_snakeHead, y_snakeHead))
        {
        
             Main.player_1OUT=1;
            
            
        }
       
    }
    
     static boolean contains(int x2,int y2,int width,int height,double x1,double y1){
        
        if((x1>=x2)&&(x1<=x2+width-1)&&(y1>=y2)&&(y1<=y2+height-1))
        return true;
        return false;
    }
     
     static void check_pipe2(int x_pillar,int y_pillar,int width,int height,double x_snakeHead,double y_snakeHead){
           
        
        if(contains(x_pillar-10,y_pillar-10,width+10,height+10,x_snakeHead, y_snakeHead))
        {
        
              Main.player_2OUT=1;
            
            
        }
        
      
    }
     
     static void show_matrix(Graphics2D g2d){
         if(count==0){
         
             drawVertical(g2d,0,0,(Main.pWidth/2)-50,(Main.pHeight/2)-50,0);
             drawHorizontal(g2d,Main.pWidth/2,0,(Main.pWidth/2)-100,(Main.pHeight/2)-50,1);
             drawVertical(g2d,0,Main.pHeight/2,(Main.pWidth/2)-50,(Main.pHeight/2)-100,2);
             drawHorizontal(g2d,Main.pWidth/2,Main.pHeight/2,(Main.pWidth/2)-100,(Main.pHeight/2)-100,3);
             
             count=1;
             
                    }
         else {
              
                for(int i=0;i<matrix.length;i++)
                {
                     
                  g2d.fill(new Rectangle2D.Double(matrix[i][0], matrix[i][1], matrix[i][2],matrix[i][3]));
                }
                
              }
         
         
                                            }
     
     static void drawVertical(Graphics2D g2d,int xOffset,int yOffset,int availBreadth,int availHeight,int region){
         
         initVertical(xOffset,yOffset,availBreadth,availHeight);
         g2d.fillRect(x, y,width, height);vertical=0;horizontal=1;rest();t_t_b=1;
            createMatrix(x,y,width,height,region);
             while(AL>=5){
                             startVertical();
                             g2d.fillRect(x, y,width, height);createMatrix(x,y,width,height,region);
                         }
             resetAll();
                               }
     
     static void drawHorizontal(Graphics2D g2d,int xOffset,int yOffset,int availBreadth,int availHeight,int region){
         initHorizontal(xOffset,yOffset,availBreadth,availHeight);
         g2d.fillRect(x, y,width, height);vertical=1;horizontal=0;
              createMatrix(x,y,width,height,region);
             while(AL>=5){
                             startHorizontal();
                             g2d.fillRect(x, y,width, height);createMatrix(x,y,width,height,region);
                         }
             resetAll();
                                               }
     
     //VERTICAL FILLING
     static void initVertical(int xOffset,int yOffset,int availBreadth,int availHeight)
     {
         x=50+xOffset;y=50+yOffset;
         AL_h=availHeight;AL_b=availBreadth;
         height=AL_h;width=5;AL=AL_h;
     }
     
     static void startVertical(){
         if(horizontal==1){
             
             horizontal=0;vertical=1;
             if(t_t_b==1){//System.out.println("Inside --horizontal left_to_right");
                 x=x+55;y=y+AL_h-5;
                 AL_b=AL_b-55;width=AL_b;rest();l_t_r=1;height=5;AL=AL_b;
                         }
             else if(b_t_t==1){//System.out.println("Inside --horizontal right_to_left");
                 x=x+5-AL_b;y=y;
                 width=AL_b=AL_b-55;rest();r_t_l=1;height=5;AL=AL_b;
                              }
                          }
         
         else if(vertical==1){
             
             vertical=0;horizontal=1;
             if(l_t_r==1){//System.out.println("Inside --Vertical bottom_to_top");
                 x=x+AL_b-5;y=y+5-AL_h;
                 height=AL_h=AL_h-55;width=5;rest();b_t_t=1;AL=AL_h;
                         }
             
             else if(r_t_l==1){//System.out.println("Inside --Vertical top_to_bottom");
                 x=x;y=y+55;
                 height=AL_h=AL_h-55;width=5;rest();t_t_b=1;AL=AL_h;
                              }
             
                             }
         
         
     }
     
     //HORIZONTAL FILLING
     static void initHorizontal(int xOffset,int yOffset,int availBreadth,int availHeight)
     {
         x=50+xOffset;y=50+yOffset;
         height=5;AL_h=availHeight;width=AL_b=availBreadth;
         AL=AL_b;rest();l_t_r=1;}
     
     static void startHorizontal(){
         
         if(vertical==1){
             vertical=0;horizontal=1;
             if(l_t_r==1){
                 x=x+AL_b-5;y+=55;height=AL_h=AL_h-55;width=5;rest();t_t_b=1;AL=AL_h;
                         }
             else if(r_t_l==1){
                 x=x;y=y+5-AL_h;AL_h=height=AL_h-55;width=5; rest(); b_t_t=1;AL=AL_h;
                              }
                         
                         }
         else if(horizontal==1){
             horizontal=0;vertical=1;
             if(t_t_b==1){
                 x=x+5-AL_b;y=y+AL_h-5;AL_b=width=AL_b-55;height=5;rest();r_t_l=1;AL=AL_b;
                         }
             else if(b_t_t==1){
                 x+=55;y=y;width=AL_b=AL_b-55;height=5;rest();l_t_r=1;AL=AL_b;
                              }
             
                               }
         
                                  }
     
     static void rest(){t_t_b=0;b_t_t=0;l_t_r=0;r_t_l=0;}
     
     
     
     
    
}
