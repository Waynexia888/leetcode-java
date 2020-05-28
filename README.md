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
* 8种基本数据类型：
  * 整型： byte, short, int(eg: 123), long（eg：123L， 123l）
  * 浮点型： float(eg: 1.23f, 1.23F)， double（eg: 1.23)
  * 字符型： char
  * 布尔型： boolean
  * 在Java中，可以进行数据类型转换，“小”的数据类型可以默认转化成“大”的数据类型，而“大”的数据类型需要强制转化成“小”的类型
* 引用数据类型：
  * 数组
  * class（类）
  * interface（接口）
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
  * 字符有两种，普通字符和转义字符。转义字符是以反斜杠()开头的字符，常常用来表示那些无法直接打印出来的字符。字符在计算机底层以整数的形式存储，每个字符对应的整数叫做unicode编码。字符之间的运算，以及字符与整数之间的运算都换转化为整数的运算
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
* break语句会直接退出循环，continue语句会提前结束本轮循环
* i++ 和 ++i 区别：
  * int i = 0; int j = ++i; System.out.println(j); // j = 1, i = 1; -> 先给i加上1以后赋值给j， 所以j=1
  * int l = 0; int k = l++; System.out.println(k); // k = 0, i = 1；-> 先把l赋值给k， 然后再给l加上1， 所以k=0，l=1 
  * i++和++i都是自增运算，结果都会把i的值自增1，但是i++返回的值是自增之前的值，++i返回的值是自增之后的值
* 选择排序(Selection Sort)
  * 选择整个数组中最小的元素与第一个元素交换
  * 每一次选取数组中剩下元素的最小值和前面的值交换
  * 时间复杂度O(n^2)
  * 参考资料：https://blog.csdn.net/jianyuerensheng/article/details/51254311
* Lintcode 练习：
  * 479 Second Max of Array
  * 478 Simple Calculator
  * 449 Char to Integer
  * 214 Max of Array
  * 283 Max of 3 Numbers
  * 145 Lowercase to Uppercase
  * 491 Palindrome Number
  * 521 Remove Duplicate Numbers in Array
  * 二维数组如何遍历？ 
### Lession 3: 函数，字符串，面向对象入门
* 函数(function)的定义
  * 具有特定功能的代码段
  * 增加代码复用（code reuse）
  * 增强程序可读性（readability）
  * 将功能封装，给出接口供调用
* 函数返回类型（return type）
  * void返回类型的函数可以没有return语句
  * return值的类型必须与函数返回类型匹配
* 函数的调用
  * 给定输入，返回输出
  * 程序执行流程
  * 把有返回类型的函数当作一个值来使用
* 函数名（function name）
  * 命名规则同变量命名方式
  * 使用驼峰命名法命名，推荐以动词开头
* 参数（parameters）
  * 可以理解为函数的输入
  * 数目不限，也可以没有参数（0个参数）
  * 每个参数都需要指定参数类型
* String字符串及其常用操作
  * String是Java中的内置类
  * 可以在JDK中找到， package java.lang; public final class String
  * string中的转义字符： 参考资料 https://blog.csdn.net/caoxiaohong1005/article/details/78570311
* String的不可变性（Immutable）
  * 没有setCharAt()方法
  * 一旦创建就无法改变其值
  * 如果需要改变值就得创建一个新的String对象
  * 在String类中使用字符数组保存字符串，是final修饰，因此是不可变的：private final char value[];
  * 对String对象的任何改变都不会影响到原来的对象，它一般是生成一个新的对象然后进行操作的
* 修改String？ - StringBuilder
  * StringBuilder sb = new StringBuilder("...")
  * StringBuilder sb = new StringBuilder()  // 什么都不传，相当于空字符串""
  * sb.append("hello");  // "hello"
  * sb.setCharAt(index: 1, ch: 'a');  // "hallo"
  * sb.deleteCharAt(0)   // "allo"
  * sb.toString();  // Returns a string representing the data in this sequence, 将数据以字符串的形式返回
  * 参考资料： https://blog.csdn.net/awq520tt1314/article/details/77493675
* String的比较和其他常用方法
  * String.equals()
  * 不能用"=" 来判断两个String的值是否相等，因为"="是基本数据类型， 是直接存在内存中的
* 字符串的运算：连接（concat）
  * "+"
  * 字符串可以和任何类型的变量进行连接操作
* String的常用方法
  * String string = "hello world";
  * string.substring(6);  // "world", [6, len)
  * string.substring(2, 5);  // "llo", [2, 5)
  * char[] charArray = string.toCharArray();  // 把字符串转变成一个字符数组
  * string.length();  // 11
  * string.isEmpty();
  * string.charAt(6)  // 'w'
  * string.concat("!"); // "hello world" + "!"
  * string.startsWith("hello") // true
  * string.endsWith("world")   // true
  * string.indexOf('l')   // 2， 返回最早出现'l'这个字符的下标， 如果没找到，就返回-1
  * string.indexOf("llo")  // 2， 返回最早出现"llo"这个字符串的下标， 如果没找到，就返回-1
  
  

  
  
