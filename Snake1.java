
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

Snake1.java is part of Champu_N_Chaandni.

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
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author vivek
 */
public class Snake1 {
    
 static int check=0,count=0;
    static void paint_advance(Graphics2D g2d,double b[][],Main m){
    
        
        
           g2d=(Graphics2D)m.buffer.getGraphics();
    
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,m.pWidth,m.pHeight);
    
   //START PAINTING NEW IMAGE 
           g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true));
           matrixSelect.matrix_paint(g2d);
           
           if(m.food==0){food_generate.create_food();Main.showFoodCount=0;Main.relaxTime=0;}
           else{g2d.fill( new Ellipse2D.Double(food_generate.x, food_generate.y, 20, 20));} 
           if((Main.showFoodCount==0)&&(GUI.Stage6.isSelected())&&((Main.minimum_Food_Count_for_Stage6!=1))){
               Main.relaxTime+=50;
               if(Main.relaxTime>=1400)Main.showFoodCount=1;
             Font font = new Font(Font.SERIF, Font.BOLD, 100);
        g2d.setFont(font);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        check=matrix6.getFoodLimit()-food_generate.foodCount;
        if(check==0){
              g2d.drawString("BAS", Main.pWidth/2, Main.pHeight/2);count=1;}
        else g2d.drawString(Integer.toString(check), Main.pWidth/2, Main.pHeight/2);
           }
           
           if(m.player_1OUT!=1){
           for(int i=m.length-3;i>0;i--){ 
         
               if(i%2==0) g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true)); 
               else g2d.setPaint(new GradientPaint(50,10,Color.green,60,20,Color.red,true));
               g2d.fill(new Ellipse2D.Double(b[i][0], b[i][1],10,10));
               if(show_mouth_snakeHead(b,m)==1)open_mouth_snakeHead(g2d,b,m); 
               else close_mouth_snakeHead(g2d,b,m);}
               draw_last_snakeTail(g2d,b,m);
                              }
           if(GUI.Multi_Player.isSelected()){if(m.player_2OUT!=1)m.plr_advnc.paint_player_2(g2d);}
       //g2d.drawImage(buffer, 0,0,null); 
       
           if(m.food==0){m.food=1;}
           m.current_g=m.getGraphics();
           if((m.buffer!=null)&&(m.current_g!=null)){m.current_g.drawImage(m.buffer, 0,0,null); 
           Toolkit.getDefaultToolkit().sync();
           if(m.current_g!=null)m.current_g.dispose();}
       
        
        
                                }
    
    static void paint_basic(Graphics2D g2d,double const_arr[][],Main b){
    
        
        
        
              g2d=(Graphics2D)b.buffer.getGraphics();
    
              g2d.setColor(Color.black);
              g2d.fillRect(0,0,b.pWidth,b.pHeight);
    
   //START PAINTING NEW IMAGE 
              g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true));
              matrixSelect.matrix_paint(g2d);
              
              if(b.food==0){food_generate.create_food();Main.showFoodCount=0;Main.relaxTime=0;}
              else{g2d.fill( new Ellipse2D.Double(food_generate.x, food_generate.y, 20, 20));} 
              if((Main.showFoodCount==0)&&(GUI.Stage6.isSelected())&&(Main.minimum_Food_Count_for_Stage6!=1)){
               Main.relaxTime+=50;
               if(Main.relaxTime>=1400)Main.showFoodCount=1;
             Font font = new Font(Font.SERIF, Font.BOLD, 100);
        g2d.setFont(font);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        
              check=matrix6.getFoodLimit()-food_generate.foodCount;
        if(check==0)
              g2d.drawString("BAS", Main.pWidth/2, Main.pHeight/2);
        else g2d.drawString(Integer.toString(check), Main.pWidth/2, Main.pHeight/2);
        }
               if(b.player_1OUT!=1){
              for(int i=b.length-3;i>0;i--){ 
                 
                 if(i%2==0) g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true)); 
                 else g2d.setPaint(new GradientPaint(50,10,Color.green,60,20,Color.red,true));
                g2d.fill(new Ellipse2D.Double(const_arr[i][0], const_arr[i][1],10,10));
                 if(show_mouth_snakeHead(const_arr,b)==1){open_mouth_snakeHead(g2d,const_arr,b);} 
                 else close_mouth_snakeHead(g2d,const_arr,b);
                                          }
               
               draw_last_snakeTail(g2d,const_arr,b);}
               if(GUI.Multi_Player.isSelected()){if(b.player_2OUT!=1)b.plr.paint_player_2(g2d);}
               if(b.food==0){b.food=1;}
      
               if((b.buffer!=null)&&(b.current_g!=null)){b.current_g.drawImage(b.buffer, 0,0,null);}
               Toolkit.getDefaultToolkit().sync();
               if(b.current_g!=null)b.current_g.dispose();
               
                             }
    
    static void open_mouth_snakeHead(Graphics2D g2d,double const_arr[][],Main b){
        
         if(b.check_up()==1){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+4,const_arr[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+4,const_arr[1][1]+8,12,3));
        }
        if(b.check_up()==2){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]-3,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+8,12,3));
        }
        if(b.check_left()==1){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-3,const_arr[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]-6,3,12));
        }
        if(b.check_left()==2){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-3,const_arr[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]+6,3,12));
        }
           
    }
    
   static void close_mouth_snakeHead(Graphics2D g2d,double const_arr[][],Main b){
    
        if(b.check_up()==1){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+5,const_arr[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+5,const_arr[1][1]+8,12,3));
        }
        if(b.check_up()==2){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+1,12,6));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+8,12,3));
        }
        if(b.check_left()==1){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+1,const_arr[1][1]-6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]-6,3,12));
        }
        if(b.check_left()==2){
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+1,const_arr[1][1]+6,5,12));
            g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]+6,3,12));
        }
    
    }
  
   static int show_mouth_snakeHead(double const_arr[][],Main b){
    b.dist=Math.sqrt((const_arr[0][0]-5-food_generate.x)*(const_arr[0][0]-5-food_generate.x)+(const_arr[0][1]-5-food_generate.y)*(const_arr[0][1]-5-food_generate.y));
    if(b.dist<=25)
        return 1;
        return 0;
     
    }
    
   static void draw_last_snakeTail(Graphics2D g2d,double const_arr[][],Main b){
    g2d.fill(new Ellipse2D.Double(const_arr[b.length-3][0],const_arr[b.length-3][1],9,9));
    g2d.fill(new Ellipse2D.Double(const_arr[b.length-2][0],const_arr[b.length-2][1],8,8));
    g2d.fill(new Ellipse2D.Double(const_arr[b.length-1][0],const_arr[b.length-1][1],7,7));
     
    }
    
    
}
