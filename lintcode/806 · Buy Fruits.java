public class Solution {
    /**
     * @param codeList: The codeList
     * @param shoppingCart: The shoppingCart
     * @return: The answer
     */
    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        // Write your code here
        List<String> list = new ArrayList<>();
        for (List<String> strs : codeList) {
            list.addAll(strs);
        }

        if (list.size() > shoppingCart.size()) {
            return 0;
        }
        
        for (int i = 0; i + list.size() - 1 < shoppingCart.size(); i++) {
            int j = 0;
            while (j < list.size() && (shoppingCart.get(i + j).equals(list.get(j)) || list.get(j).equals("anything"))) {
                j++;
            }
            if (j == list.size()) {
                return 1;
            }
        }
        return 0;
    }
}


// shoppingCart = ["orange", "apple", "apple", "orange", "banana", "orange"]
//                             i
        
// list =         ["apple", "apple", "orange", "anything", "orange"]
//                                                                    j