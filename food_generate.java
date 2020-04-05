/**********************
 *************************
        @author::Vivek Mangla
 **************************
 *****************************/

/*******************************************************************

Food_generate.java is part of Champu_N_Chaandni.

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



import java.util.Random;

/**
 *
 * @author vivek
 */

class Food_generate{

	static int x,y,curr_x,curr_y,pre_x,pre_y,count;
	static int foodCount=1;
	static int count_Stage4_1,count_Stage4_2,count_Stage5_1,count_Stage5_2;


	public static void create_food(){
		foodCount++;
		Random r=new Random();
		x=r.nextInt(Main.pWidth-30);
		y=r.nextInt(Main.pHeight-30); 
		curr_x=x;curr_y=y;
		pre_x=curr_x-1;pre_y=curr_y-1;count=1;
	}

	static void check_for_food_cord(double b[][],double d,double b2[][],double d2){

		if(count==1){
			if(MatrixSelect.number!=2)
				move_food(Food_generate.x,Food_generate.y);
		}

		if(Main.food==1){
			if((GUI.Multi_Player.isSelected())&&(Main.player_2OUT!=1)){check_for_food_cord_advnc(b2,d2);}
			if(Main.player_1OUT!=1){
				d=Math.sqrt((b[0][0]-5-Food_generate.x)*(b[0][0]-5-Food_generate.x)+(b[0][1]-5-Food_generate.y)*(b[0][1]-5-Food_generate.y));

				if(d<=12){
					if(GUI.Sounds.getState()){Vibrations.playSound();}
					Main.food=0;
					Main.score+=10;

					if(MatrixSelect.number==5){
						if(count_Stage5_1<16){count_Stage5_1++;Main.length+=2;Main.realloc_memory();}
					}

					else if(MatrixSelect.number==4){
						if(count_Stage4_1<8){count_Stage4_1++;Main.length+=2;Main.realloc_memory();}
					}
					else{Main.length+=2;Main.realloc_memory();}
				}                         
			}
		} 
	}

	static void check_for_food_cord_advnc(double b[][],double d_player_2){


		d_player_2=Math.sqrt((b[0][0]-5-Food_generate.x)*(b[0][0]-5-Food_generate.x)+(b[0][1]-5-Food_generate.y)*(b[0][1]-5-Food_generate.y));

		if(d_player_2<=12){
			if(GUI.Sounds.getState()){Vibrations.playSound();}
			Main.food=0;
			Player_Advnc_2.score_player_2+=10;
			if(MatrixSelect.number==5){
				if(count_Stage5_2<16){
					count_Stage5_2++;
					Player_Advnc_2.length_player_2+=2;Player_Advnc_2.realloc_memory_player_2();
				}
			}
			else if(MatrixSelect.number==4){if(count_Stage4_2<8){count_Stage4_2++;
			Player_Advnc_2.length_player_2+=2;Player_Advnc_2.realloc_memory_player_2();}
			}
			else{Player_Advnc_2.length_player_2+=2;Player_Advnc_2.realloc_memory_player_2();}
		}



	}

	static void check_for_food_cord_basic(double const_arr[][],double d,double b2[][],double d2){

		if(count==1){
			if(MatrixSelect.number!=2)
				move_food(Food_generate.x,Food_generate.y);
		}

		if(Main.food==1){
			if((GUI.Multi_Player.isSelected())&&(Main.player_2OUT!=1)){check_for_food_cord_2_basic(b2,d2);}
			if(Main.player_1OUT!=1){
				d=Math.sqrt((const_arr[0][0]-5-Food_generate.x)*(const_arr[0][0]-5-Food_generate.x)+(const_arr[0][1]-5-Food_generate.y)*(const_arr[0][1]-5-Food_generate.y));
				if(d<=12){

					if(GUI.Sounds.getState()){Vibrations.playSound();}
					Main.food=0;
					Main.score+=10;

					if(MatrixSelect.number==5){
						if(count_Stage5_1<16){count_Stage5_1++;Main.length+=2;Main.realloc_memory_basic();}
					}   
					else if(MatrixSelect.number==4){
						if(count_Stage4_1<8){count_Stage4_1++;Main.length+=2;Main.realloc_memory_basic();}
					}
					else{Main.length+=2;Main.realloc_memory_basic();}

				}
			}
		}
	}

	static void check_for_food_cord_2_basic(double const_arr_player_2[][],double d_player_2) {



		d_player_2=Math.sqrt((const_arr_player_2[0][0]-5-Food_generate.x)*(const_arr_player_2[0][0]-5-Food_generate.x)+(const_arr_player_2[0][1]-5-Food_generate.y)*(const_arr_player_2[0][1]-5-Food_generate.y));
		if(d_player_2<=12){
			if(GUI.Sounds.getState())Vibrations.playSound();
			Main.food=0;
			Player2.score_player_2+=10;
			if(MatrixSelect.number==5){
				if(count_Stage5_2<16){count_Stage5_2++;
				Player2.length_player_2+=2;Player2.realloc_memory_player_2();
				}
			}           
			else if(MatrixSelect.number==4){
				if(count_Stage4_2<8){count_Stage4_2++;
				Player2.length_player_2+=2;Player2.realloc_memory_player_2();}
			}           
			else{Player2.length_player_2+=2;Player2.realloc_memory_player_2();}
		}                                

	}

	static void move_food(int x,int y){

		if(curr_x<pre_x){curr_x--;pre_x--;}
		else if(curr_x>pre_x){curr_x++;pre_x++;}
		if(curr_y<pre_y){curr_y--;pre_y--;}
		else if(curr_y>pre_y){curr_y++;pre_y++;}

		if(curr_x>Main.pWidth){curr_x=pre_x-1;}
		else if(curr_x<0){curr_x=pre_x+1;}
		if(curr_y>Main.pHeight){curr_y=pre_y-1;}
		else if(curr_y<0){curr_y=pre_y+1;}

		Food_generate.x=curr_x;
		Food_generate.y=curr_y;

	}

}
