import java.util.Scanner;
import java.util.Random;

public class Lottery{
	public static long numPossibleTickets(int k, int n, int m){
		int sumK = 1;
		int sumN =1;
		int a = k ;
		while (k>0){
			sumK = sumK *k;
			k--;
}
		k=a;
		int j = n-k+1 ;

		//find out hr numerator
		while(n>=j){
			sumN = sumN *n;
			n--;
}
		

       //find out the final value
		long numPossible = sumN/sumK;
		numPossible = numPossible *m;
		
		return numPossible;


	}
	public static int[] getPlayerNumbers(int k, int n){
		Scanner scan = new Scanner(System.in);
		int[] x = new int[k]; 
		for ( int i=0; i <k;i++){
			System.out.print("Enter number "+(i+1)+"(must be 1-"+n+", cannot repeat): ");
			x[i] = scan.nextInt();

			while(x[i]>n || x[i]<1){
				System.out.print("Error - range must be at least 1 to " + n+" to have a valid game. please try again: ");
				x[i] = scan.nextInt();
			}
			for (int j =0 ; j<i;j++){
				while(x[j]==x[i]){
					System.out.print("Error - you've already entered "+x[i]+" . Please try again.");
					x[i] = scan.nextInt();
					
				}
			}
		}

			return x;
			}
		
	//get numbers
	public static int[] getDrawnNumbers(int k, int n){
		Random rand = new Random();
		int y[] =new int[k];
		for(int i =0; i<y.length; i++){
			y[i]= rand.nextInt(n-1)+1;
		}
		return y;
	}
	//counte how many match 
	public static int countMatches(int[] x, int[] y){
		int counter =0;
		
			for(int i = 0; i<x.length;i++){
			for(int j =0; j<y.length;j++){
				if(x[i]==y[j]){
					counter ++;
				}
			}
		
	}
		return counter;
	}
	public static void main(String[] args) {
		int d =0;
		//set the game
		System.out.println("*****");
		System.out.println("First, let's set up the game!");
		System.out.println(" ");
		System.out.print("How many distinct numbers should the player pick?");
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		//get intput
		while(k<1){
			System.out.print("Error - range must be greater or equal to 1. Please try again :");
			 k = scan.nextInt();
		}
		System.out.print("OK. Each of those 4 numbers should range from 1 to what?");
		int n = scan.nextInt();
		while (n<k){
			System.out.print("Error - range must be greater or equal to k, Please try again :");
			n= scan.nextInt();
		}
		System.out.print("OK. And finally, the bous number should range from to what?");
		int m = scan.nextInt();
		while (m<1){
			System.out.print("Error - range must be greater or equal to 1, Please try again :");
			m = scan.nextInt();
		}
		System.out.println(" ");
		System.out.println("******");
		long z = numPossibleTickets(k,n,m);

		double c = (1.0/z)*100;
		System.out.println("There are "+z+" possible tickets in this game. Each ticket has a "+ c +"% chance of winning the jackpot.  Let's play, good luck!");
		System.out.println(" ");
		System.out.print("How many tickets would you like to buy?");
		int numTicket = scan.nextInt();
		while(numTicket<1){
			System.out.print("Error - must buy at least 1 ticket! Please try again: ");
			numTicket = scan.nextInt();
		}
		int[][] x = new int[numTicket][k+1];

		//printing things
			if(numTicket == 1){
				System.out.println(" ");
				System.out.println("* Ticker #1 of 3 * ");;
				System.out.println(" ");
				System.out.println("Pick you "+ k+ " distinct numbers!");

				getPlayerNumbers(k,n);
				System.out.println(" ");
			System.out.print("Now pick your your bonus number (must be 1-"+m+"): ");
			int p = scan.nextInt();

			while(p>m || p<1){
				System.out.println("Error - number must be between 1 and "+ m +". Pkease try again: ");
				p = scan.nextInt();
				
}

			System.out.println(" Your tickets so far: ");
			//print out the ticket
			System.out.println("---------------------");
			for(int u = 0; u <k;u++){
					
				System.out.print(getPlayerNumbers(k,n)[u]);
				System.out.print("\t");
			}
			
			System.out.print("||");
			System.out.print("\t");
			System.out.print("bonus: "+ getPlayerNumbers(k,n)[k-1]);
			}

			
			
			
			else{
				
				for ( int i=0; i <numTicket;i++){
					
System.out.println(" ");
				System.out.println("* Ticker #"+(i+1)+" of 3 * ");;
				System.out.println(" ");
				System.out.println("Pick you "+ k+ " distinct numbers!");

					
			
			int[] f  = getPlayerNumbers(k,n);

			for(int o =0; o<f.length;o++){
				x[i][o] = f[o];

			}

			
			System.out.print("Now pick your your bonus number (must be 1-"+m+"): ");
			x[i][x[i].length-1] = scan.nextInt();

			while(x[i][x[i].length-1] >m || x[i][x[i].length-1] <1){
				System.out.println("Error - number must be between 1 and "+ m +". Pkease try again: ");
				x[i][x[i].length-1] = scan.nextInt();
				
}

			System.out.println(" Your tickets so far: ");
			System.out.println("---------------------");
			


			for ( int o = 0; o < x.length; o++) {   // for each row i…
   for (int j = 0; j < x[i].length-1; j++) {   // for each column j of row i…
      
					System.out.print(x[o][j]);
						System.out.print("\t");
 
   
}
			
			System.out.print("||");
			System.out.print("\t");
			System.out.print("bonus: "+ x[o][x[i].length-1]);
			System.out.println(" ");
			}
		
		}
			
			
			
					
			

				

			
				
			


			
			


			




		

	}

	System.out.println("*****");
	 int[] h = getDrawnNumbers(k,n);
//check the match
		System.out.println("The moment of trusth has arrived! Here are the drawn numbers: ");
	 for (int i = 0; i < k; i++) {   // for each column j of row i…
    
					System.out.print(h[i]);
						System.out.print("\t");
 
   
}
			
			System.out.print("||");
			System.out.print("\t");
			System.out.print("bonus: "+getDrawnNumbers(k,n)[k-1]);
			System.out.println(" ");
			int [] v = new int[numTicket];
		for(int i =0 ; i<numTicket;i++){
			v[i]=countMatches(x[i],h);
		}
		for(int i =0 ; i<numTicket;i++){
			System.out.println(v[i]);
		}
		System.out.println("Your best Ticket(s): ");
		int max = 0;
		for(int i =0 ; i<numTicket;i++){
			if(v[i]>=max){
				max =v[i];
			}
		}
			for(int i=0;i<v.length;i++){
			if(v[i]==max){
				
				for(int j =0; j<x[i].length;j++){
				System.out.print(x[i][j]);
			System.out.print("\t");

			}
			System.out.println(" ");
		}
			

		}
		System.out.println("You matched " + max+"/"+k+" drawn numbers");
		if(max==k){
			System.out.println("You did match the bonus number.");
			System.out.println(" ");
			System.out.println("WOOHOO, JACKPOT!!");

		}
		else{
			System.out.println("You did not match the bonus number.");
			System.out.println(" ");
			System.out.println("Sorry, no jackpot this time. Really, did you expect anything else ?");
		}


//}
}
}
