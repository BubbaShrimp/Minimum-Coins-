
public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {2, 5, 3, 9};
		int sum =12;
		System.out.println("minimum number of coins: " + getMinCoins(values, sum) );

	}
	
	//Recursive Solution to find min number of coins
	public static int getMinCoins(int[] values, int sum){
		if(sum ==0) return 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i < values.length; i++){
			if(values[i] <= sum)
				min = Math.min(min, getMinCoins(values, sum-values[i]));
		}
		if(min != Integer.MAX_VALUE) //prevent overflow
			return min+1;
		else
			return Integer.MAX_VALUE;
	}
	
	//DP solution!
	public static int getMinCoinsDP(int[] values, int sum){
		int[] minCoins = new int[sum+1]; //memoized dictionary?
		minCoins[0] = 0; //0 coins to get a value of 0
		for(int i=1; i<=sum; i++){ //controls sum you're looking at
			int min = Integer.MAX_VALUE;
			for(int j=0; j<values.length; j++) //looks through coins in values
				if(values[j] <= i) //if even possible
					min = Math.min(min, minCoins[i-values[j]]);
			if(min != Integer.MAX_VALUE) //preventing min from overflowing
				minCoins[i] = min+1;
			else 
				minCoins[i] = Integer.MAX_VALUE;
		}
		return minCoins[sum];
	}

}
