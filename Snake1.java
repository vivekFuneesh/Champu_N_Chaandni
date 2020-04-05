


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
		g2d=(Graphics2D)Main.buffer.getGraphics();

		g2d.setColor(Color.black);
		g2d.fillRect(0,0,Main.pWidth,Main.pHeight);

		//START PAINTING NEW IMAGE 
		g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true));
		MatrixSelect.matrix_paint(g2d);//paint matrix first.

		if(Main.food==0){Food_generate.create_food();Main.showFoodCount=0;Main.relaxTime=0;}
		else{g2d.fill( new Ellipse2D.Double(Food_generate.x, Food_generate.y, 20, 20));} 
		
		if((Main.showFoodCount==0)&&(GUI.Stage6.isSelected())&&((Main.minimum_Food_Count_for_Stage6!=1))){
			Main.relaxTime+=50;
			if(Main.relaxTime>=1400)Main.showFoodCount=1;
			Font font = new Font(Font.SERIF, Font.BOLD, 100);
			g2d.setFont(font);

			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
			check=Matrix6.getFoodLimit()-Food_generate.foodCount;
			if(check==0){
				g2d.drawString("BAS", Main.pWidth/2, Main.pHeight/2);count=1;}
			else g2d.drawString(Integer.toString(check), Main.pWidth/2, Main.pHeight/2);
		}

		if(Main.player_1OUT!=1){
			for(int i=Main.length-3;i>0;i--){ 

				if(i%2==0) g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true)); 
				else g2d.setPaint(new GradientPaint(50,10,Color.green,60,20,Color.red,true));
				g2d.fill(new Ellipse2D.Double(b[i][0], b[i][1],10,10));
				if(show_mouth_snakeHead(b,m)==1)open_mouth_snakeHead(g2d,b,m); 
				else close_mouth_snakeHead(g2d,b,m);}
			draw_last_snakeTail(g2d,b,m);
		}
		if(GUI.Multi_Player.isSelected()){if(Main.player_2OUT!=1)Player_Advnc_2.paint_player_2(g2d);}
		//g2d.drawImage(buffer, 0,0,null); 

		if(Main.food==0){Main.food=1;}
		Main.current_g=m.getGraphics();
		if((Main.buffer!=null)&&(Main.current_g!=null)){Main.current_g.drawImage(Main.buffer, 0,0,null); 
		Toolkit.getDefaultToolkit().sync();
		if(Main.current_g!=null)Main.current_g.dispose();}
	}

	static void paint_basic(Graphics2D g2d,double const_arr[][],Main b){

		g2d=(Graphics2D)Main.buffer.getGraphics();
		g2d.setColor(Color.black);
		g2d.fillRect(0,0,Main.pWidth,Main.pHeight);

		//START PAINTING NEW IMAGE 
		g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true));
		MatrixSelect.matrix_paint(g2d);

		if(Main.food==0){Food_generate.create_food();Main.showFoodCount=0;Main.relaxTime=0;}
		else{g2d.fill( new Ellipse2D.Double(Food_generate.x, Food_generate.y, 20, 20));} 
		if((Main.showFoodCount==0)&&(GUI.Stage6.isSelected())&&(Main.minimum_Food_Count_for_Stage6!=1)){
			Main.relaxTime+=50;
			if(Main.relaxTime>=1400)Main.showFoodCount=1;
			Font font = new Font(Font.SERIF, Font.BOLD, 100);
			g2d.setFont(font);

			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

			check=Matrix6.getFoodLimit()-Food_generate.foodCount;
			if(check==0)
				g2d.drawString("BAS", Main.pWidth/2, Main.pHeight/2);
			else g2d.drawString(Integer.toString(check), Main.pWidth/2, Main.pHeight/2);
		}
		if(Main.player_1OUT!=1){
			for(int i=Main.length-3;i>0;i--){ 

				if(i%2==0) g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true)); 
				else g2d.setPaint(new GradientPaint(50,10,Color.green,60,20,Color.red,true));
				g2d.fill(new Ellipse2D.Double(const_arr[i][0], const_arr[i][1],10,10));
				if(show_mouth_snakeHead(const_arr,b)==1){open_mouth_snakeHead(g2d,const_arr,b);} 
				else close_mouth_snakeHead(g2d,const_arr,b);
			}

			draw_last_snakeTail(g2d,const_arr,b);}
		if(GUI.Multi_Player.isSelected()){if(Main.player_2OUT!=1)Player2.paint_player_2(g2d);}
		if(Main.food==0){Main.food=1;}

		if((Main.buffer!=null)&&(Main.current_g!=null)){Main.current_g.drawImage(Main.buffer, 0,0,null);}
		Toolkit.getDefaultToolkit().sync();
		if(Main.current_g!=null)Main.current_g.dispose();

	}

	static void open_mouth_snakeHead(Graphics2D g2d,double const_arr[][],Main b){

		if(Main.check_up()==1){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+4,const_arr[1][1]-3,12,6));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+4,const_arr[1][1]+8,12,3));
		}
		if(Main.check_up()==2){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]-3,12,6));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+8,12,3));
		}
		if(Main.check_left()==1){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-3,const_arr[1][1]-6,5,12));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]-6,3,12));
		}
		if(Main.check_left()==2){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-3,const_arr[1][1]+6,5,12));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]+6,3,12));
		}

	}

	static void close_mouth_snakeHead(Graphics2D g2d,double const_arr[][],Main b){

		if(Main.check_up()==1){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+5,const_arr[1][1]+1,12,6));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+5,const_arr[1][1]+8,12,3));
		}
		if(Main.check_up()==2){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+1,12,6));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]-6,const_arr[1][1]+8,12,3));
		}
		if(Main.check_left()==1){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+1,const_arr[1][1]-6,5,12));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]-6,3,12));
		}
		if(Main.check_left()==2){
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+1,const_arr[1][1]+6,5,12));
			g2d.fill(new Ellipse2D.Double(const_arr[1][0]+8,const_arr[1][1]+6,3,12));
		}

	}

	static int show_mouth_snakeHead(double const_arr[][],Main b){
		Main.dist=Math.sqrt((const_arr[0][0]-5-Food_generate.x)*(const_arr[0][0]-5-Food_generate.x)+(const_arr[0][1]-5-Food_generate.y)*(const_arr[0][1]-5-Food_generate.y));
		if(Main.dist<=25)
			return 1;
		return 0;

	}

	static void draw_last_snakeTail(Graphics2D g2d,double const_arr[][],Main b){
		g2d.fill(new Ellipse2D.Double(const_arr[Main.length-3][0],const_arr[Main.length-3][1],9,9));
		g2d.fill(new Ellipse2D.Double(const_arr[Main.length-2][0],const_arr[Main.length-2][1],8,8));
		g2d.fill(new Ellipse2D.Double(const_arr[Main.length-1][0],const_arr[Main.length-1][1],7,7));

	}


}
