Leetcode 271. Encode and Decode Strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            int slash = s.indexOf("/", i);
            int size = Integer.valueOf(s.substring(i, slash));
            results.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + 1 + size;
        }
        return results;   
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

// 如何加密？
// 假设：List<String> strs = ["apple", "google", "amazon"]
// encode 方式自己设定， 比如： 单词长度 + '/' + 单词
// 加密后， string -> "5/apple6/google6/amazon"
    
// 如何解密？
// 遍历这个字符串，
// 如果找到一个'/', 就把'/'后面的单词加入到result中

