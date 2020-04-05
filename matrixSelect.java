


/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

MatrixSelect.java is part of Champu_N_Chaandni.

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

/**
 *
 * @author vivek
 */
public class MatrixSelect {
    
    static int number=0;
    
    static void checkStage(){
    
        if(GUI.Stage1.isSelected())number=1;
        else if(GUI.Stage2.isSelected())number=2;
        else if(GUI.Stage3.isSelected())number=3;
        else if(GUI.Stage4.isSelected())number=4;
        else if(GUI.Stage5.isSelected())number=5;
        else if(GUI.Stage6.isSelected()){}
       // else if(GUI.Stage7.isSelected())number=7;
    }    
    
    static void matrix_collide(double arr1[][],double arr2[][]){if(Main.sleepTime==3000){
        
        
        if(number==2){
              if(Main.player_1OUT!=1)Matrix2.pipe_bite(arr1);
              if(GUI.Multi_Player.isSelected()){if(Main.player_2OUT!=1)Matrix2.pipe_bite_advnc(arr2);}
                  }
        
        else if(number==3){
            if(Main.player_1OUT!=1){Matrix3.collision_Detector(arr1[0][0],arr1[0][1]);}
            if(GUI.Multi_Player.isSelected()){if(Main.player_2OUT!=1){Matrix3.collision_Detector2(arr2[0][0],arr2[0][1]);}}
                          }
        
        else if(number==4){
            
            Matrix4.move_matrix();
          
            if(Main.player_1OUT!=1){
                for(int i=0;i<arr1.length;i++)
                 {   
                    if(i==arr1.length-1){Matrix4.collisionDetector(arr1[i][0],arr1[i][1],16);}
                    else if(i==arr1.length-2){Matrix4.collisionDetector(arr1[i][0],arr1[i][1],17);}    
                    else if(i==arr1.length-3){Matrix4.collisionDetector(arr1[i][0],arr1[i][1],18);}
                    else {Matrix4.collisionDetector(arr1[i][0],arr1[i][1],20);}
                }
                                   }
            
            if(GUI.Multi_Player.isSelected()){
                  if(Main.player_2OUT!=1){
                      for(int i=0;i<arr2.length;i++)
                {   if(i==arr2.length-1)Matrix4.collisionDetector2(arr2[i][0],arr2[i][1],16);
                    else if(i==arr2.length-2)Matrix4.collisionDetector2(arr2[i][0],arr2[i][1],17);    
                    else if(i==arr2.length-3)Matrix4.collisionDetector2(arr2[i][0],arr2[i][1],18);
                    else Matrix4.collisionDetector2(arr2[i][0],arr2[i][1],20);
                }                    }
                                              }
                           
                           }
        else if(number==5){
        
        
            Matrix5.move_matrix();
          
            if(Main.player_1OUT!=1){
                for(int i=0;i<arr1.length;i++)
                {   
                    if(i==arr1.length-1){Matrix5.collisionDetector(arr1[i][0],arr1[i][1],16);}
                    
                    else if(i==arr1.length-2){Matrix5.collisionDetector(arr1[i][0],arr1[i][1],17);}    
                    
                    else if(i==arr1.length-3){Matrix5.collisionDetector(arr1[i][0],arr1[i][1],18);}
                    
                    else {Matrix5.collisionDetector(arr1[i][0],arr1[i][1],20);}
                }
                                   }
            
            if(GUI.Multi_Player.isSelected()){
                  if(Main.player_2OUT!=1){
                      for(int i=0;i<arr2.length;i++)
                {   if(i==arr2.length-1)Matrix5.collisionDetector2(arr2[i][0],arr2[i][1],16);
                    else if(i==arr2.length-2)Matrix5.collisionDetector2(arr2[i][0],arr2[i][1],17);    
                    else if(i==arr2.length-3)Matrix5.collisionDetector2(arr2[i][0],arr2[i][1],18);
                    else Matrix5.collisionDetector2(arr2[i][0],arr2[i][1],20);
                }                    }
                                              }
                           
                           
                          }
        else if(number==6){}
        else if(number==7){}
        
        
    }}
    
    static void matrix_paint(Graphics2D g2d){
        
        if(number==2){Matrix2.show_matrix(g2d);}
        else if(number==3){Matrix3.drawObstacle(g2d);}
        else if(number==4){Matrix4.drawObstacle(g2d);
        }
        else if(number==5){Matrix5.drawObstacle(g2d);
        }
        else if(number==6){}
        else if(number==7){}
        
        
    }
    
    
    
}
