//***********************************************************************************************************************************************
//       	This first section of code pulls in two imports: 
//				java.util.Random (which is used to generate a new random die) 
//				javax.swing.JOptionPane (which is the graphical user interface 
//				that shows the code to the player).
//***********************************************************************************************************************************************  	
import java.util.Random;
import javax.swing.JOptionPane;
public class Game 
{
	public static void main(String[] args) 
	{
	 //***********************************************************************************************************************************************
	 //       	This next section of code initializes the following 1D arrays: scorename, total, 
	 //			tBonus,	and names; the following 2D arrays: scores, chosenCombinations, and usedflag; 
	 //			and the following int variables: total1 and total2
	 //***********************************************************************************************************************************************  	
	
	int [][] scores = new int [2][13];
	int [][] chosenCombinations = new int [2][13];
	String [][] usedflag = new String [2][13];
	for(int x = 0; x < 13; x++)
	{
	for(int y = 0; y < 2; y++)
	{
		usedflag[y][x]="";
	}
	}
	String [] scorename = new String [13]; // The 2D Array scorename is used to show the different combinations correctly in the method showTotalScore
	scorename[0]="\n Ones - 1 ";
	scorename[1]="\n Twos - 2 ";
	scorename[2]="\n Threes - 3 ";
	scorename[3]="\n Fours - 4 ";
	scorename[4]="\n Fives - 5 ";
	scorename[5]="\n Sixes - 6 ";
	scorename[6]="\n Three of a Kind 7 ";
	scorename[7]="\n Four of a Kind - 8 ";
	scorename[8]="\n Full House - 9 ";
	scorename[9]="\n Small Straight - 10 ";
	scorename[10]="\n Large Straight - 11 ";
	scorename[11]="\n Yahtzee - 12 ";
	scorename[12]="\n Chance - 13 ";
	int total1=0; //total 1 is the running score total for Player 1
	int total2=0; //total 2 is the running score total for Player 2
	int total[]=new int [2]; //total is set equal to total 1 or total 2 depending on whose turn it is
	int tBonus[]=new int[2];
	String [] names = new String [2];
	names[0] = JOptionPane.showInputDialog("Write The Name For Player 1: ");
	names[1] = JOptionPane.showInputDialog("Write The Name For Player 2: ");
	//***********************************************************************************************************************************************
	//       	In this next section of code, two for loops run through the 13 turns for each player. 
	//***********************************************************************************************************************************************  	
	for(int scoreLoop = 0; scoreLoop < 13; scoreLoop++)
	{
	for(int playerLoop = 0; playerLoop < 2; playerLoop++)
	{
		// TODO Auto-generated method stub
		int topBonus=tBonus[playerLoop];
		Random rand = new Random();
		int[] saveddice = new int[5];
		for(int i = 0; i < 5; i++)
		{
		  
			  int randomInt = rand.nextInt(6)+1;
			  saveddice[i] = randomInt;
		}
		String die = JOptionPane.showInputDialog(showTotalScore(names, topBonus, scorename, usedflag, saveddice, playerLoop, total,scores)+"\n\n (2 Turns Left)    Which Die Do You Want To Reroll: "+"\n"+"\n (If You Want to Keep All Die, Don't Input Anything)"+"\n"+"\n Die 1: "+saveddice[0]+"\n Die 2: "+saveddice[1]+"\n Die 3: "+saveddice[2]+"\n Die 4: "+saveddice[3]+"\n Die 5: "+saveddice[4]);
		if (die.length()==0)
		{	
		}
		else
		{	
		for(int t = 0; t < die.length(); t++)
		{
			int u=die.charAt(t)-49;//I needed to subtract 49 to turn ASCII value into what I actually want
			int randomInt = rand.nextInt(6)+1;
			saveddice[u] = randomInt;
		}
		String die2 = JOptionPane.showInputDialog(showTotalScore(names, topBonus, scorename, usedflag, saveddice, playerLoop, total,scores)+"\n\n (1 Turn Left)    Which Die Do You Want to Reroll: "+"\n"+"\n (If You Want to Keep All Die, Don't Input Anything)"+"\n"+"\n Die 1: "+saveddice[0]+"\n Die 2: "+saveddice[1]+"\n Die 3: "+saveddice[2]+"\n Die 4: "+saveddice[3]+"\n Die 5: "+saveddice[4]);
		if (die2.length()==0)
		{
		}
		else
		{
		for(int t = 0; t < die2.length(); t++)
		{
			int u=die2.charAt(t)-49;//I needed to subtract 49 to turn ASCII value into what I actually want
			int randomInt = rand.nextInt(6)+1;
			saveddice[u] = randomInt;
		}
		}
		}
		//***********************************************************************************************************************************************
		// This section of code determines how many of each number there are in the final array.
		// This allows the program to correctly calculate some of the more challenging combinations
		//***********************************************************************************************************************************************
		 int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		 for (int y = 0; y < 5; y++) 
		 {
		      if (saveddice[y] == 1) 
		      {
		        ones++;
		      }
		      if (saveddice[y] == 2) 
		      {
		        twos++;
		      }
		      if (saveddice[y] == 3) 
		      {
		        threes++;
		      }
		      if (saveddice[y] == 4) 
		      {
		        fours++;
		      }
		      if (saveddice[y] == 5) 
		      {
		        fives++;
		      }
		      if (saveddice[y] == 6) 
		      {
		        sixes++;
		      }
		    } 
			String index1 = JOptionPane.showInputDialog(showTotalScore(names, topBonus, scorename, usedflag, saveddice, playerLoop, total,scores)+"\n Which Combination Do You Want: "+"\n Die: "+saveddice[0]+" "+saveddice[1]+" "+saveddice[2]+" "+saveddice[3]+" "+saveddice[4]);
			int index = Integer.parseInt(index1);
			chosenCombinations[playerLoop][scoreLoop]= index;
			
			if (playerLoop ==0)				
			total1=scores[playerLoop][0]+scores[playerLoop][1]+scores[playerLoop][2]+scores[playerLoop][3]+scores[playerLoop][4]+scores[playerLoop][5]+scores[playerLoop][6]+scores[playerLoop][7]+scores[playerLoop][8]+scores[playerLoop][9]+scores[playerLoop][10]+scores[playerLoop][11]+scores[playerLoop][12];
			if (playerLoop ==1)				
			total2=scores[playerLoop][0]+scores[playerLoop][1]+scores[playerLoop][2]+scores[playerLoop][3]+scores[playerLoop][4]+scores[playerLoop][5]+scores[playerLoop][6]+scores[playerLoop][7]+scores[playerLoop][8]+scores[playerLoop][9]+scores[playerLoop][10]+scores[playerLoop][11]+scores[playerLoop][12];
			int totalscores=scores[playerLoop][0]+scores[playerLoop][1]+scores[playerLoop][2]+scores[playerLoop][3]+scores[playerLoop][4]+scores[playerLoop][5];
		    if (totalscores >=63)
		  	   tBonus[playerLoop]=35;
			scoresCalculation(index,saveddice, playerLoop,scores, ones, twos, threes, fours, fives, sixes);
			if (playerLoop ==0)				
			{
				total1=scores[playerLoop][0]+scores[playerLoop][1]+scores[playerLoop][2]+scores[playerLoop][3]+scores[playerLoop][4]+scores[playerLoop][5]+scores[playerLoop][6]+scores[playerLoop][7]+scores[playerLoop][8]+scores[playerLoop][9]+scores[playerLoop][10]+scores[playerLoop][11]+scores[playerLoop][12];
				total[0]=total1;
			}
			if (playerLoop ==1)	
			{
				total2=scores[playerLoop][0]+scores[playerLoop][1]+scores[playerLoop][2]+scores[playerLoop][3]+scores[playerLoop][4]+scores[playerLoop][5]+scores[playerLoop][6]+scores[playerLoop][7]+scores[playerLoop][8]+scores[playerLoop][9]+scores[playerLoop][10]+scores[playerLoop][11]+scores[playerLoop][12];
				total[1]=total2;
			}	
			for(int y = 0; y < 13; y++)
			{
			for(int j = 0; j < 2; j++)
			{
		    if (chosenCombinations[j][y]>0)
		    	usedflag[j][chosenCombinations[j][y]-1]=" USED";
			}
			}
			 JOptionPane.showMessageDialog(null,showTotalScore(names, topBonus, scorename, usedflag, saveddice, playerLoop, total,scores));
	}
	}
	//***********************************************************************************************************************************************
	//       This final section of the main code adds the eligible bonus points (either 0 or 35) 
	//		 to each player's total score and determines the players' final scores as well as the winner. 
	//***********************************************************************************************************************************************  	
	total1=total1+tBonus[0];
	total2=total2+tBonus[1];
	if (total1>total2) 
	{
		JOptionPane.showMessageDialog(null, "With a Final Score of "+total1+" "+names[0]+" Beat "+names[1]+" Who Had a Score of "+total2);
	}
	else
		if (total2>total1)
		{
			JOptionPane.showMessageDialog(null, "With a Final Score of "+total2+" "+names[1]+" Beat "+names[0]+" Who Had a Score of "+total1);
		}	
		else 
		{
			JOptionPane.showMessageDialog(null, "Wow! With Both "+names[0]+" And "+names[1]+" Getting the Final Score "+total1+" The Game Is a Tie!");
		}
}
	 
	   
	   public static void scoresCalculation (int index, int[] saveddice, int player,  int [][] scores,	int ones,	int twos,	int threes, int fours, int fives, int sixes)
	 
	 //***********************************************************************************************************************************************
	 //        This method will calculate the score, using the 5 saved dice.  Each of the 13 different scoring items are 
	 //        accounted for.    	
	 //***********************************************************************************************************************************************  	
	   {
	   	  int x = 0, rolltotal = 0;
	   	     	  
	      switch (index)
	      {
	      	case 1:  	
	      		rolltotal=ones;
	      		scores[player][0] = rolltotal;;
	      		break;
	        case 2:
	        	rolltotal=twos*2;
	      		scores[player][1] = rolltotal;
	      		break;
	        case 3: 
	        	rolltotal=threes*3;
	      		scores[player][2] = rolltotal;      	    
	      		break;
	        case 4: 
	        	rolltotal=fours*4;
	      		scores[player][3] = rolltotal;
	      	    break;
	      	case 5: 
	      		rolltotal=fives*5;
	      		scores[player][4] = rolltotal;
	      		break;
	        case 6: 
	      		rolltotal=sixes*6;
	      		scores[player][5] = rolltotal;
	      		break;
	        case 7:  
	        	if (ones >=3||twos>=3||threes>=3||fours>=3||fives>=3||sixes>=3)
	        	{
	        		for (x=0; x<5;x++)
		      		{ 
		      		     rolltotal= rolltotal + saveddice[x];	
		      		}
		      		scores[player][6] = rolltotal;
	            } 
	      		break;  
	        case 8:
	        	if (ones >=4||twos>=4||threes>=4||fours>=4||fives>=4||sixes>=4)
	        	{
	        		for (x=0; x<5;x++)
		      		{ 
		      		     rolltotal= rolltotal + saveddice[x];	
		      		}
		      		scores[player][7] = rolltotal;
	            } 
	      		break;        
	        case 9:  
	        	if ((ones ==2) && (twos==3||threes==3||fours==3||fives==3||sixes==3)) 
	        	{
	        		scores[player][8]=25;
	            } 
	        	else if ((twos ==2) && (ones==3||threes==3||fours==3||fives==3||sixes==3))
	        	{
	        		scores[player][8]=25;
	            } 
	        	else if ((threes ==2) && (twos==3||ones==3||fours==3||fives==3||sixes==3))
	        	{
	        		scores[player][8]=25;
	            }
	        	else if ((fours ==2) && (twos==3||ones==3||threes==3||fives==3||sixes==3))
	        	{
	        		scores[player][8]=25;
	            }
	        	else if ((fives ==2) && (twos==3||ones==3||fours==3||threes==3||sixes==3))
	        	{
	        		scores[player][8]=25;
	            }
	        	else if ((sixes ==2) && (twos==3||ones==3||fours==3||fives==3||threes==3))
	        	{
	        		scores[player][8]=25;
	            }
	        		 break;
	        case 10: 
	        	if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) 
	        	{
	        		scores[player][9]=30;
	            } 
	        	else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) 
	        	{
	            	scores[player][9]=30;
	            } 
	        	else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) 
	        	{
	            	scores[player][9]=30;
	            }
	        		 break;
	        case 11: 
	        	if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0) && (fives > 0))
	        	{
	        		scores[player][10]=40;
	            } 
	        	else if ((twos > 0) &&(threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) 
	        	{
	        		scores[player][10]=40;
	            } 
	        		 break;
	        case 12: 
	        	if (saveddice[0]==saveddice[1]&&saveddice[0]==saveddice[2]&&saveddice[0]==saveddice[3]&&saveddice[0]==saveddice[4])
	        	{
	        		scores[player][11]=50;
	        	}
	        	 	 break;     
	        case 13:   
	        	rolltotal=ones+twos*2+threes*3+fours*4+fives*5+sixes*6;
	      		scores[player][12] = rolltotal;;
	      		break;	 
	        default: 
	        	JOptionPane.showMessageDialog(null, "Error in selecting a choice");
	        		 break;
	      }      
	   }
	    public static String showTotalScore (String[] names, int topBonus, String[] scorename, String[][] usedflag, int[] saveddice,  int playerNum, int[] total, int [][] scores)
		{
		  String rollString ="\t\t  CURRENT SCORES " + "           Current Total = " + total[playerNum] +    " for player -- " + names[playerNum] + " TOP HALF BONUS --  " + topBonus +
	                   "\n" + scorename[0] + "score is....." + scores[playerNum][0] + usedflag[playerNum][0] + "\n\t"+ scorename[1] + "score is....." + scores[playerNum][1] + usedflag[playerNum][1] +
	                   "\n" + scorename[2] + "score is....." + scores[playerNum][2] + usedflag[playerNum][2] + "\n\t"+ scorename[3] + "score is....." + scores[playerNum][3] + usedflag[playerNum][3] + 
	                   "\n" + scorename[4] + "score is....." + scores[playerNum][4] + usedflag[playerNum][4] + "\n\t"+ scorename[5] + "score is....." + scores[playerNum][5] + usedflag[playerNum][5] +
	                   "\n_______________________________________________________________________________________" +
	                   "\n" + scorename[6] + "score is....." + scores[playerNum][6] + usedflag[playerNum][6] + "\n\t"+ scorename[7] + "score is....." + scores[playerNum][7] + usedflag[playerNum][7]+ 
	                   "\n" + scorename[8] + "score is....." + scores[playerNum][8] + usedflag[playerNum][8] + "\n\t"+ scorename[9] + "score is....." + scores[playerNum][9] + usedflag[playerNum][9]+ 
	                   "\n" + scorename[10] + "score is....." + scores[playerNum][10] + usedflag[playerNum][10]+ "\n\t"+ scorename[11] + "score is....." + scores[playerNum][11] + usedflag[playerNum][11] + 
	                   "\n" + scorename[12] + "score is....." + scores[playerNum][12] + usedflag[playerNum][12] + 
	                   "\n";
		   return(rollString); 
		} 		
}



