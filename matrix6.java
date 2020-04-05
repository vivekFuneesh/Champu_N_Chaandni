


/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

Matrix6.java is part of Champu_N_Chaandni.

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



public class Matrix6 {
    static int foodLimit;
    
    static void create_stage_number(){
        
        if(MatrixSelect.number<6)
        {MatrixSelect.number++;}
                                      }
    
    static void resetSnake(){
    Main.b=Main.arr=Main.arr=Main.b1=Main.const_arr=Main.const_arr1=null;
    if(GUI.Classic.isSelected()){Main.form1_basic();}
    else Main.form1();
    
    Main.count=1;Main.turn=1;Main.flag[0]=0;Main.flag[1]=0;Main.turn_b=1;
                            }
    
    static void resetSnake2(){
    
    Player2.const_arr1_player_2=Player2.const_arr_player_2=null;
    
    Player_Advnc_2.const_arr1_player_2=Player_Advnc_2.arr1=null;
    Player_Advnc_2.const_arr_player_2=Player_Advnc_2.b=Player_Advnc_2.arr=Player_Advnc_2.b1=null;    
    
    if(GUI.Classic.isSelected()){Player2.form_player_2();}
    else Player_Advnc_2.form_player_2();
    
    Player_Advnc_2.turn_b_player_2=1;
    
                             }
    
    static int getFoodLimit(){
    
        if(MatrixSelect.number==1){return 25; }
        else if(MatrixSelect.number==2){return 25; }
        else if(MatrixSelect.number==3){return 25; }
        else if(MatrixSelect.number==4){return 20; }
        else if(MatrixSelect.number==5){return 20; }
        return -1;
                              }
    
    static int getInitialHeight(){
        if(MatrixSelect.number==1){return 50; }
        else if(MatrixSelect.number==2){return 20; }
        else if(MatrixSelect.number==3){return Matrix3.block_height; }
        else if(MatrixSelect.number==4){return Matrix4.block_height/2; }
        else if(MatrixSelect.number==5){return Matrix4.block_height/2; }
        return -1;
        
                                  }
}
