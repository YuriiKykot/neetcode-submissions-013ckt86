class Solution {
    /**
     * @param {number[]} flowerbed
     * @param {number} n
     * @return {boolean}
     */
    canPlaceFlowers(flowerbed, n) {
        const f = [0, ...flowerbed, 0];

        for(let i = 1; i < f.length - 1; i++){
            if(f[i - 1] === 0 && f[i] === 0 && f[i + 1] === 0){
                f[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
