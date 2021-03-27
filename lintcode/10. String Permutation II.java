public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        boolean[] isUsed = new boolean[arr.length];
        List<String> result = new ArrayList<>();
        String temp = new String();
        stringPermutation2Helper(result, temp, arr, isUsed);
        return result;
    }

    public void stringPermutation2Helper(List<String> result, String temp, char[] arr, boolean[] isUsed) {
        if (temp.length() == arr.length) {
            result.add(temp);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 如果已经用过了该字符，跳过即可
            if (isUsed[i] == true) {
                continue;
            }

            // 去重步骤
            // 不能跳过一个a选下一个a
            if (i != 0 && arr[i] == arr[i - 1] && isUsed[i - 1] == false) {
                continue;
            }

            // make change
            isUsed[i] = true;
            temp += arr[i];

            // 找到所有 temp 开头的排列
            stringPermutation2Helper(result, temp, arr, isUsed);

            // backtracking
            temp = temp.substring(0, temp.length() - 1);
            isUsed[i] = false;

        }
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }

        // string is immuatble
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        String temp = new String();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, temp, results, visited);
        return results;
    }

    private void dfs(char[] arr, String temp, List<String> results, boolean[] visited) {
        if (temp.length() == arr.length) {
            results.add(new String(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            temp += arr[i];
            visited[i] = true;
            dfs(arr, temp, results, visited);
            temp = temp.substring(0, temp.length() - 1);
            visited[i] = false;
        }
    }
}

////////////////////////////////////
为什么要判断str 是否为空，str 是否为空串？
在java中， String是一个类，类是一个引用数据类型，里面存储的是指向对象的地址（eg. 0x12345678）
通过地址才能找到真实对象。所以在做非空判断时，需要首先判断是否有地址，null就代表没有地址，
即未被初始化。
如果string为null，调用.length() 方法时，就会报空指针异常。
所以对于一个类（或引用数据类型），先要判断是否为null，然后才可以调用这个对象的所有方法。

/////////////////////////////////////
class Person {
    String hair;
    String eyes;
    public Person(String hair, String eyes) {
        this.hair = hair;
        this.eyes = eyes;
    }
}

Person 就是一个类;
Person p = new Person();  // 实例化
p 是一个对象名字;

对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：
声明：声明一个对象，包括对象名称和对象类型。
    String str;

实例化：使用关键字 new 来创建一个对象， 在构造一个实例的时候需要在内存中开辟空间
    String str = new String();
 
初始化：实例化的基础上，给对象赋值的过程
    str = "hello";
    
