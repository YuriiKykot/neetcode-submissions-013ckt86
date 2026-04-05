/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, max = n;
        
        while(true){
            int mid = low + (max - low) / 2;
            int res = guess(mid);

            if(res > 0){
                low = mid + 1;
            }else if(res < 0){
                max = mid - 1;
            }else{
                return mid;
            }
        }
    }
}