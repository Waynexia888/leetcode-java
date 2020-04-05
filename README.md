# leetcode-java
### Lession 1: Java入门与基础算法
* Fizz Buzz -> https://www.lintcode.com/problem/fizz-buzz/description
* Java 语言
  * string and array 
  * class and object
  * reference
  * interface
* 数据结构：
  * 链表
  * 栈
  * 队列
  * 树
  * 哈希表
* 算法：
  * 枚举
  * 递归
  * 分治
  * 排序
* 在IDE里打印output，并且output分行 -> System.out.println(your output)
* Why IDE?
  * 代码提示：自动补全
  * 调试方便
  * 功能强大
* Homebrew install java 教程  -> https://pandacodez.com/tutorial/install-latest-jdk-java-on-mac-using-homebrew/
* Reverse 3-digit integer -> http://www.lintcode.com/en/problem/reverse-3-digit-integer/
* 变量
  * 变量名 - camelCase ： 1 使用英文单词； 2 第一个单词全部小写，后面的单词首字母大写
  * 变量类型： 1 整型：int； 2 浮点型：float，double； 3 布尔型：boolean； 4 字符型：char
* 整型变量 int
  * eg： int sum = 0, a = 1, b = 2; int count = 1;
  * int a = 1; int a = 2; 如何置换a和b的值？ -> int temp = a; a = b; b = temp;
  * 数据范围 -> -2^31 ~ 2^31 - 1; int minValue = Integer.MIN_VALUE; int maxValue = Integer.MAX_VALUE; 
  * overflow
* float/double:（优先用double）
  * double a = 1; System.out.println(a / 2) -> 0.5; double自动转换1 -> 1.0
* Lintcode 练习：
  * 37 Reverse 3-digit Integer
  * 9 Fizz Buzz
  * 1 A + B Problem
### Lession 2: 变量，数组和循环
* Boolean类型
  * 取值范围：true 和 false
  * 常见操作：与 &&; 或 ||; 非 ！
  * && -> true && true = true; false && true = false; true && false = false; false && false = false
  * eg: boolean isTodaySunny = true; boolean isWeekend = true; boolean shopping = isTodaySunny && isWeekend; System.out.println(shopping); // true
  * || -> true && true = true; true && false = true; false && true = true; false && false = false
  * ! -> !true = false; !false = true
* Char类型
  * char ch0 = 'a'; char ch1 = 'b'
  * char类型的数据：用单引号包起来的字符. 如果是双引号，代表字符串
  * int b = (int)ch0; System.out.println(b) -> 97
* ASCII & Unicode编码
  * http://www.asciitable.com/
  * https://unicode-table.com/en/#control-character
  * 'A' 对应整数 65； '0' 对应整数 48； 'a' 对应整数 97；  
* char类型 递增递减操作
  * 与整数参与运算的char类型，会转变成对应的整数
  * 将对应的整数强制转换成对应的char类型
  * eg: char a = 'c'; char next = (char)(a + 1)； System.out.println(next);  // 这里a 相当于'c' 自动转换成99, 99 + 1 = 100, char(100)就变成'd'了
  * char a = 'c'; char next = (char)(a + 1)； System.out.println(next);  // 'b'
* char之间的距离
  * 转换成对应的整数做减法
  * 实际对应着他们在table中的距离
  * eg: int delta = 'a' - 'b'; System.out.println(delta); // 97 - 98 = -1
* 'a' 转换成 'A', 如何操作？ 
  * 第一种方法： -> char a = 'a'; System.out.println(char(a - 32); // 97 - 32 = 65, char(65) = 'A'
  * 第二种方法： -> Character.toUpperCase(a); // 'A'
  * 第三种方法： -> char a = 'a'; System.out.println(char(a - 'a' + 'A');
* 数组 Array
  * 一维数组： 用一个变量来表示一组连续的相同类型的变量。
  * int[] score = new int[] {90, 95, 92, 89, 100, 98}; // [90, 95, 92, 89, 100, 98]
  * int[] score = new int[6];
  * score[0] = 90; score[1] = 95; score[2] = 92; score[3] = 89; score[4] = 100; score[5] = 98; // [90, 95, 92, 89, 100, 98]
  * 二维数组和多维数组
  * int[][] matrix = new int[][] {
  *     {1, 4, 7},
  *     {2, 6, 12, 15, 88, 95},
  *     {6, 8, 13, 31}
  * };
  * int[][] matrix1 = new int[3][4];
* 数组的操作
  * 数组的长度  -> array.length
  * 数组的元素访问  -> array[3]
  * 二维数组的元素访问  -> matrix[1]; matrix[2][3]
  * 数组元素的修改  -> array[2] = 99
* 数组的长度可以改变么？ -> 数组的长度不能修改
* 程序的三大结构：
  * 顺序结构： 顺序执行语句，从上到下执行
  * 控制结构： 根据条件，选择进入程序执行的分支
  * 循环结构
* if语句
  * if (condition1) {
  *    // condition1 is true;
  * } else if (condition2) {
  *    // condition1 is false and condition2 is true;
  * } else {
  *    // condition1 is false and condition2 is false;
  * }
* 循环结构 For循环： 不断重复的做一件事情
  * int sum = 0;
  * for (int i = 0; i < 10; i++) {
  *     sum += i;
  * }
  * System.out.println(sum);
* 循环结构For循环:
  * 1 如何遍历从0～100，或者从0到n   -> for (int i = 0; i <= 100; i++){}
  * 2 如何遍历从m到n   -> for (int i = m; i <= n; i++){}
  * 3 如何遍历从n到m（n > m）-> for (int i = n; i >= m; i--){}
  * 4 如何遍历从n到m，但是每隔2个（如：100，98，96…..） -> for (int i = n; i >= m; i -= 2){}
* 循环结构 While循环: 不断重复的做一件事情
  * int sum = 0, i = 1;
  * while (i < 10) {
  *     sum += i;
  *     i ++;
  * }
  * System.out.println(sum);
* 课堂小问题:
  * max and sum of array
  * print matrix
  * reverse integer e.g: 1234789
* 循环结构 Break语句: 跳出当前循环, break语句将退出整个循环语句，
  * int target = 89;
  * boolean found = false;
  * for (int i = 0; i < score.length; ++i) {
  *     if (score[i] == target) {
  *         found = true;
  *         break;
  *     }
  * }
* 循环continue语句: 跳过当前轮次continue语句后面的代码块, continue语句仅仅退出当前循环，继续执行下一次的循环。
  * for (int i = 0; i < score.length; ++i) {
  *     if (score[i] < 60) continue;
  *     System.out.println(score[i]);
  * }
* i++ 和 ++i 区别：
  * int i = 0; int j = ++i; System.out.println(j); // j = 1, i = 1; -> 先给i加上1以后赋值给j， 所以j=1
  * int l = 0; int k = l++; System.out.println(k); // k = 0, i = 1；-> 先把l赋值给k， 然后再给l加上1， 所以k=0，l=1 
* Lintcode 练习：
  * 479 Second Max of Array
  * 478 Simple Calculator
  * 449 Char to Integer
  * 214 Max of Array
  * 283 Max of 3 Numbers
  * 145 Lowercase to Uppercase
  * 491 Palindrome Number
  * 521 Remove Duplicate Numbers in Array
