

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

OtherCollisions.java is part of Champu_N_Chaandni.

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



public class OtherCollisions {
    
    
    
       static void check_for_walls(double b[][]){
           
       if(GUI.UNWALLED.isSelected()){
                       Main.MOVE_OTHER_SIDE();
                      
                             }
           
           else{
           if((b[0][0]>Main.pWidth-10)||(b[0][0]<0)||(b[0][1]>Main.pHeight-10)||(b[0][1]<0))
           {
               
            Main.player_1OUT=1;
           }
               }
                

    }
   
       static void check_for_walls_advnc(){
       if(GUI.UNWALLED.isSelected()){
                              player_advnc_2.move_other_side_2();
                                 }
       
       else  if((player_advnc_2.b[0][0]>Main.pWidth-10)||(player_advnc_2.b[0][0]<0)||(player_advnc_2.b[0][1]>Main.pHeight-10)||(player_advnc_2.b[0][1]<0))
           {
               
               Main.player_2OUT=1;
            }
   
                               }

    
       static void check_for_walls_basic(double const_arr[][]){
                   if(GUI.UNWALLED.isSelected()){
                    
                        Main.MOVE_OTHER_SIDE_BASIC();
                        
                                  }
                    else{                   
           if((const_arr[0][0]>Main.pWidth-10)||(const_arr[0][0]<0)||(const_arr[0][1]>Main.pHeight-10)||(const_arr[0][1]<0))
           {
               
               Main.player_1OUT=1;//System.out.println(" Out Inside check_for_walls_basic ");
           
           } 
           
                         }
                    
    }
    
       static void check_for_walls_2_basic(){
           
    if(GUI.UNWALLED.isSelected()){player2.move_other_side_2();}
    
    else if((player2.const_arr_player_2[0][0]>Main.pWidth-10)||(player2.const_arr_player_2[0][0]<0)||(player2.const_arr_player_2[0][1]>Main.pHeight-10)||(player2.const_arr_player_2[0][1]<0))
           {
               Main.player_2OUT=1;
                   
           }
    
    
    }
   
    
    
    
}
