937. Reorder Data in Log Files

class Solution {
    public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int index1 = s1.indexOf(' ');
            int index2 = s2.indexOf(' ');
            String Id1 = s1.substring(0, index1);
            String Id2 = s2.substring(0, index2);
            String body1 = s1.substring(index1);
            String body2 = s2.substring(index2);
            if (body1.equals(body2)) {
                return Id1.compareTo(Id2);
            } else {
                return body1.compareTo(body2);
            }
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        List<String> list = new ArrayList<>();
        String[] results = new String[logs.length];
        int idx = logs.length - 1;
        
        for (int i = logs.length - 1; i >= 0; i--) {
            int index = logs[i].indexOf(' ');
            String body = logs[i].substring(index + 1);
            if (Character.isDigit(body.charAt(0))) {
                results[idx--] = logs[i];
            } else {
                list.add(logs[i]);
            }
        }
        
        Collections.sort(list, new MyComparator());
        
        idx = 0;
        for (String s : list) {
            results[idx++] = s;
        }
        return results;
    }
}