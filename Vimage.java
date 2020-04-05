



/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

Vimage.java is part of Champu_N_Chaandni.

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
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author vivek
 */
public class Vimage extends JPanel{
    ImageIcon img;
    static String imag;
    static int count=0;
    Vimage(int index){setBackground(Color.black);
        //--------FULL_SCREEN_WIDTH/2&&FULL_SCREEN_HEIGHT/2
        imag="";
    if(index==0){setLayout(new GridLayout(1,2));add(new Multi(0));}
    else if(index==1)imag="Image/Get_Up.png";
    else if(index==2)imag="Image/Puzzie.png";
    else if(index==3)imag="Image/Challenge.png";
    else if(index==4){
        setLayout(new GridLayout(3,1));
        add(new Multi(0));add(new Multi(1));add(new Multi(2));//add(new Multi(3));
    }
    else if(index==5){
        setLayout(new GridLayout(2,1));
        add(new Multi(5));add(new Multi(7));
    }
    
    img=new ImageIcon(imag);
    
    }
    
    
    @Override
    public void paintComponent(Graphics g){super.paintComponent(g);
    setBackground(Color.black);
    img.paintIcon(this, g, 0,40);
    
    }
    
}

class Multi extends JPanel{
    
    static String imag;
    ImageIcon img;
    
   Multi(int index){setBackground(Color.black);
        //--------FULL_SCREEN_WIDTH/2&&FULL_SCREEN_HEIGHT/2
        imag="";
    if(index==0)imag="Image/Random.png";
    else if(index==1)imag="Image/Get_Up.png";
    else if(index==2)imag="Image/Puzzie.png";
    else if(index==3)imag="Image/Challenge.png";
    else if(index==5)imag="Image/1st.jpg";
    else if(index==7)imag="Image/2nd.jpg";
    img=new ImageIcon(imag);
    
    }
    
    
    @Override
    public void paintComponent(Graphics g){super.paintComponent(g);
    setBackground(Color.black);
    img.paintIcon(this, g, 0,40);
    
    }

}
