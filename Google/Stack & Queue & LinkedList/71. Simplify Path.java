Leetcode 71. Simplify Path

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            if (cur == null || cur.length() == 0 || cur.equals(".")) {
                continue;
            }
            
            if (cur.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }
        
        // String results = "";
        // while (!stack.isEmpty()) {
        //     results = "/" + stack.pop() + results;
        // }
        // return results.length() == 0 ? "/" : results;
        
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

//  "/home/"          -> ["", "home"]
//  "/../"            -> ["", ".."]
//  "/home//foo/"     -> ["", "home", "", "foo"]
// "/a/./b/../../c/"  -> ["", "a", ".", "b", "..", "..", "c"]