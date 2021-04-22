public class Solution {
    /**
     * @param key:       A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // (97* 33^3 + 98 * 33^2 + 99 * 33 + 100 * 1) % HASH_SIZE
        // = (((97 * 33 + 98) * 33) + 99) * 33 + 100
        // = (((0 * 33 + 97) * 33 + 98) * 33 + 99) * 33 + 100

        // 需要进行类型转换
        long hashcode = 0;
        for (int i = 0; i < key.length; i++) {
            hashcode = (hashcode * 33 + (int) key[i]) % HASH_SIZE;
        }
        return (int) hashcode;
    }
}

// ['a', 'b', 'c', 'd']
// hashcode = 0 + 97;
// hashcode = 97 * 33 + 98;
// hashcode = (97 * 33 + 98) * 33 + 99
