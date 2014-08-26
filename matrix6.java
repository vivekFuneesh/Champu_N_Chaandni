
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

matrix6.java is part of Champu_N_Chaandni.

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



public class matrix6 {
    static int foodLimit;
    
    static void create_stage_number(){
        
        if(matrixSelect.number<6)
        {matrixSelect.number++;}
                                      }
    
    static void resetSnake(){
    Main.b=Main.arr=Main.arr=Main.b1=Main.const_arr=Main.const_arr1=null;
    if(GUI.Classic.isSelected()){Main.form1_basic();}
    else Main.form1();
    
    Main.count=1;Main.turn=1;Main.flag[0]=0;Main.flag[1]=0;Main.turn_b=1;
                            }
    
    static void resetSnake2(){
    
    player2.const_arr1_player_2=player2.const_arr_player_2=null;
    
    player_advnc_2.const_arr1_player_2=player_advnc_2.arr1=null;
    player_advnc_2.const_arr_player_2=player_advnc_2.b=player_advnc_2.arr=player_advnc_2.b1=null;    
    
    if(GUI.Classic.isSelected()){player2.form_player_2();}
    else player_advnc_2.form_player_2();
    
    player_advnc_2.turn_b_player_2=1;
    
                             }
    
    static int getFoodLimit(){
    
        if(matrixSelect.number==1){return 25; }
        else if(matrixSelect.number==2){return 25; }
        else if(matrixSelect.number==3){return 25; }
        else if(matrixSelect.number==4){return 20; }
        else if(matrixSelect.number==5){return 20; }
        return -1;
                              }
    
    static int getInitialHeight(){
        if(matrixSelect.number==1){return 50; }
        else if(matrixSelect.number==2){return 20; }
        else if(matrixSelect.number==3){return matrix3.block_height; }
        else if(matrixSelect.number==4){return matrix4.block_height/2; }
        else if(matrixSelect.number==5){return matrix4.block_height/2; }
        return -1;
        
                                  }
}
