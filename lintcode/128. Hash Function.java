public class Solution {
    /**
     * @param key:       A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // "abcd" = 97 * 33^3 + 98 * 33^2 + 99 * 33^1 + 100 * 33^0
        // = ((97 * 33 + 98) * 33 + 99) * 33 + 100
        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (ans * 33 + (int) (key[i])) % HASH_SIZE;
        }
        return (int) ans;
    }
}