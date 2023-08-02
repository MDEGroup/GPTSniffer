



public class CoinFlipper{
	public static void main(String[] args) {
		
		System.out.println("This program simulates flipping a coin one million times!\n"
				 + "Here are the results:\n");
		
		int heads = 0;
		int tails = 0;
		int count = 0;
		
		while(count++ < 1000000) {
			double headsOrtails = Math.random();
			
			if (headsOrtails > 0.5) {
				++heads;
			}
			else {
				++tails;
			}
			
		}
			System.out.println("Number of heads: " + heads);	
			System.out.println("Number of tails: " + tails);
		
		
		
		
		
	}

}
