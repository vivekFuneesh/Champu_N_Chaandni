



/**********************
 *************************
        @author::Vivek Mangla
 **************************
 *****************************/

/*******************************************************************

SelfBite.java is part of Champu_N_Chaandni.

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




public class SelfBite {

	/*
    SELF COLLISION METHOD NEEDS RECTIFICATION
	 */
	//NOTE CAN'T BITE IT'S TAIL OR LAST TRAILING BLOCK.......

	/*
	 * IF THREAD SLEEP TIME DECREASES OR SPEEED INCREASES THEN BELOW METHOD WILL NOT WORK..
	 * SHOULD IMPLEMENT IT AS PIPE BITE WITH ALL CONSIDERATIONS OF GAP B/W ADJACENT COORDINATES
	 * AND SPECIAL ATTENTION TO MOUTH AND TAIL.
	 */


	static  void did_not_bite(double const_arr[][]){
		for(int i=1;i<Main.length-1;i++)
		{
			if((const_arr[0][0]==const_arr[i][0])&&(const_arr[0][1]==const_arr[i][1]))
			{
				Main.player_1OUT=1;//System.out.println("Out inside did_not_bite");

			}
		}
	}

	static void did_not_bite_2(double const_arr_player_2[][],int length_player_2){

		for(int i=1;i<length_player_2-1;i++)
		{
			if((const_arr_player_2[0][0]==const_arr_player_2[i][0])&&(const_arr_player_2[0][1]==const_arr_player_2[i][1]))
			{ 

				Main.player_2OUT=1;

			}

		}

	}



}
