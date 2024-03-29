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
  * 整型： byte（8位）, short（16位）, int(32位，eg: 123), long（64位，eg：123L， 123l）
  * 浮点型： float(32位，eg: 1.23f, 1.23F)， double（64位， eg: 1.23)
  * 字符型： char（16位）
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
  * Java是一门强类型的编程语言，函数需要指明输入参数的类型和返回值类型，函数可以没有参数，也可以有多个参数
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
  * string.valueOf(xx); // 返回xx类型参数的字符串表示形式； eg：valueOf(int i): 返回 int 参数的字符串表示形式； valueOf(char c): 返回 char 参数的字符串表示形式。valueOf(boolean b): 返回 boolean 参数的字符串表示形式。valueOf(Object obj): 返回 Object 参数的字符串表示形式。
* 面试真题： Valid Palindrome 
  * 先考虑没有特殊字符和大写的情况
  * 将大写字符转成小写字符
  * 过滤掉特殊字符
* 面试真题：String to int
  * 先考虑正数情况
  * 在考虑负数情况
  * 最后考虑有overflow的情况
* 什么是面向对象（object-oriented）？
  * 面向对象是一种世界观：世间万物皆为对象
  * 面向对象是一种程序设计方式
  * 易维护， 易复用， 易扩展， 易灵活
* 什么是对象（Object）？
  * 在面向对象的世界观中： 世间万物皆为对象
  * 属性 & 行为
* 什么是类（class）？
  * 类是对象的蓝图
  * 在Java中，类是对现实事物的抽象
  * 命名规则：首字母大写（UpperCamelCase）， eg：MyClass
  * 用类创建对象， eg： Student student = new Student();
* 什么是实例（instance）？
  * 实例就是对象： eg： Student student = new Student();
  * 在上面的代码中， student 是Student类的一个对象（实例）
* 什么是OOP(Object-Oriented Programming)?
  * 用对象构建程序
* 成员变量（member variable）
  * 又叫域（field）
  * 表示对象的属性
  * 命名规则和变量名相同
  * Java面向对象编程中，属性的命名规则是lower camel case，与普通变量一致。类的命名规则是upper camel case。方法的命名和普通函数的命名要求一致
* 成员函数（member function）
  * 又叫方法（method）
  * 表示对象的行为
  * 命名时，第一个单词必须是动词
* 构造函数（constructor）
  * 一种对对象进行初始化（initialize）的函数
  * 在对象被用new关键字创建时自动调用， Student student = new Student();
  * 其主要功能是用来在创建对象时初始化对象
* 构造函数特点
  * 必须与所属类同名
  * 每个类可以有一个以上的构造函数
  * 构造函数可以有0个，1个或1个以上的参数
  * 构造函数没有返回值
  * 构造函数总是伴随着new操作一起调用
  * 构造函数可以不写
* Java的访问权限修饰符(Access Level Modifier)：控制访问权限
  * privite（仅类自己可以访问），通过setter（写入，赋值）和getter（读取）就可以访问和修改属性了
  * protected(类class，同包package，子函数subclass都可以访问）
  * public（所有人都可以访问）
  * https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
* this
  * 指当前这个对象本身
  * 常用来防止名称重复
  * https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
* 面向对象的三大特征
  * 封装（Encapsulation）
  * 继承（Inheritance）
  * 多态（Polymorphism）
* 封装
  * 数据被保护在抽象数据类型的内部，只保留一些对外接口使之与外部发生联系
  * 将属性和行为封装成一个类，并尽可能隐蔽类（对象）的内部细节，对外形成一个边界，只保留有限的对外接口使之与外部发生联系
  * 优点： 改变程序的组织方式， 增加代码的复用率， 提高程序开发效率
### Lession 4: 引用和数据结构
* Java的内存模型
  * bit, 二进制位， 取值要么是0， 要么是1
  * 1GB = 1024MB, 1MB = 1024KB， 1KB = 1024B
  * 1B（Byte，字节） = 8bits（八个二进制位）， byte取值是0～255之间，也就是说一共156个取值，相当于2^8,即八个二进制位
  * 内存： 巨大的数组，每个格子包含1Byte，也就是8 bits；每个格子都有唯一的地址，可以通过这个地址直接得到那个格子的数据； 地址长度为32位或64位，取决于操作系统的位数。
  * 可以把Java的内存空间想象成一个大的数组，可以在这个数组中存储数据，内存的访问是需要根据内存地址进行的。同时，无论硬件上的内存还是内存空间的大小都是有限的，32位操作系统中，内存的地址用一个32bits的整数表示，最多可以表示2^32个内存空间(每个内存空间大小为1Byte)，所以32位系统可用内存空间最大为4GB
  * 变量存储： eg：int num1 = 2; int是32位，32位整数 00000000｜00000000｜00000000｜00000010， 分成4个字节存放在相邻的4个格子中
  * 内存分区： 不同内存区域的职责不同；
  * - 堆区（Heap-based/Dynamic memory allocation）：保存通过new操作符创建的object
  * - 栈区（Stack-based memory allocation）： 局部变量，函数调用等  
* Reference的原理 -> Copy address
  * reference本质上就是一个变量，只不过这个变量和基本数据类型的变量不太一样，它里面存的是object的地址，而普通基本数据类型的变量存储的就是值
  * 引用好比遥控器，对象好比电视机
  * 赋值操作（引用型变量  = 对象）， 通过地址，找到object本身，然后访问object的属性和方法
  * birthday myBirthday = new birthday(); new birthday() -> 实例化一个birthday类的对象
  * 实例化一个birthday类的对象，并声明一个引用型变量myBirthday，并让变量myBirthday引用对象，也就是将对象的地址赋值给变量myBirthday
  * 对象模型 
  * eg: Student student1 = new Student(); student1.name = "Tom"; Student student2 = student1; 这里student2相当于引用了student1的对象模型
* 基本数据类型的赋值：Copy value
  * 当定义了一个基本数据类型变量时，就等于我们在内存当中申请了一块空间，并规定这块空间中存储的内容为指定的变量类型
  * 比如int num； 相当于在内存中开辟了一块空间； int num2 = 10； 相当于开辟了一块空间，并且把值10存进去； num = num2； 我们把num2所在的内存空间的值拷贝一份，然后放在num那块空间中， 赋值完后，num 和 num2不再有任何联系，只是值一样； num2 = 20，num2空间里的值是20， num 空间里的值依然是10；
* 总结：
  * Java中的变量分为基本数据类型变量和引用型变量两种，基本数据类型变量中直接存储值，引用型变量通过地址和堆中的object产生关联。在赋值操作中，都是将变量中存储的内容进行复制，只是基本类型的变量直接复制值，引用型变量复制的是地址，本质是相同的，都是二进制数。在函数传参的时候都会发生值复制，引用型变量大小固定，用来存储内存地址
  * 空的引用， 没有引用任何对象
  * int number = null, 这是错误的写法，int是基本数据类型
  * Student student = null; 这是对的
  * 空指针异常: NullPointerException; eg: Student student = null; int studentScore = student.score; student.printScore();
  * 如何防止？ 检查方法：看点号之前的引用变量是否可能为null
  * 注意以下两种情况：1 引用类型的数组创建时，每个数组元素会被初始化为null； 2 没有初始化的引用类型成员变量会被自动初始化为null
* 数组
  * 数组变量本身是个引用，会在堆空间开辟一片空间来存储数组的内容
* 字符串
  * String是一个类
  * String对象有特殊的创建方法；String str1 = "abcd"; String str2 = new String("abcd");
  * String类型不可变（Immutable）
  * 只能用String.equals()来比较是否相等，不能用"=="
* 什么是数据结构？ Data Structure
  * 数据
  * 结构
  * 操作
* ArrayList及其操作：
  * ArrayList<Integer> arrayList = new ArrayList<>();  // generic 泛型， Integer 是 int的类（Class）
  * 增删改查CRUD
  * arrayList.add(10);  // 增加操作， [10]
  * arrayList.add(0, 3); index: 0, element: 3; // [3, 10]
  * arrayList.get(1);  // 读取操作, index: 1; 返回的是10
  * arrayList.set(1, 2); // 修改操作， index：1， element：2；[3, 2]
  * arrayList.delete(1);  // 删除方法， index: 1, 返回的是[3]
  * arrayList.clear(); // 把所有元素清空， 返回的是[]
  * List<Integer> arrayList = new ArrayList();   // List是ArrayList实现的一个接口，因此可以使用List所有的方法
### Lession 5: 链表和时间复杂度
* 链表的定义和构建（Linked List）
  * 由节点构成的列表
  * 线性的数据结构
  * class ListNode {
  *     public int val;
  *     public ListNode next;
  * }
  * ArrayList和LinkedList都是线性的数据结构，区别在于数据的组织方式不同。两种数据结构各有其应用场景，没有优劣之分
  * ListNode node1 = new ListNode(1);
  * node1.next = node2;
  * 链表的头结点可以代表整个链表，因为当知道链表的头结点后，可以通过每个节点的next引用访问下一个节点，进而访问整个链表。面试题中的链表题目都只会给出链表的头节点的引用，去操作链表，所以使用Java内置的链表是没意义的。链表在操作系统的内存管理中起着重要作用，所以是非常有意义的数据结构
* Java中自带的LinkedList方法（面试中用不到）
  * LinkedList<Integer> linkedList = new LinkedList<>();
  * linkedList.add(10);
  * linkedList.add(0, 12);
  * linkedList.get(1);
  * linkedList.remove(0);
  * linkedList.set(0, 13);
* 链表的操作
  * 遍历（traverse）
  * 插入（insert）
  * 查找（find）
  * 删除（delete）
  * 更新（update）
* 链表的遍历（traverse）
  * ListNode cur = node1;
  * while (cur != null) {
  *     System.out.print(cur.val + " ");
  *     cur = cur.next;
  * }
* 链表的插入（insert）
  * 插入位置在中间; if location > 0; ListNode pre = head; for (int i = 0; i < location - 1; i++){ pre = pre.next; }; 
  * ListNode newNode = new ListNode(value); newNode.next = pre.next; pre.next = newNode;
  * 插入位置在头部; if location = 0; ListNode newNode = new ListNode(value); newNode.next = head; head = newNode; (LinkedList里本身存在一个head这个全局变量属性的，所以需要把head设置成newNode）
* 链表的删除（delete）
  * 删除操作有返回值的；ListNode res = null;
  * 删除位置在中间; if location > 0; ListNode pre = head; for (int i = 0; i < location - 1; i++){ pre = pre.next; }; res = pre.next; pre.next = pre.next.next;
  * 删除位置在头部; if location == 0; res = head; head = head.next;                                                         
  * 返回返回值res.val即可; return res.val;
* 链表的查找（find）
  * 有返回值的
  * ListNode cur = head; for (int i = 0; i < location; i++){ cur = cur.next; }; return cur.val;
* 链表的更新（update）
  * ListNode cur = head; for (int i = 0; i < location; i++){ cur = cur.next; }; cur.val = newValue;  
* 神奇的dummy节点
  * 在整个链表前插入一个特殊的哨兵节点（dummy不是head头节点，而是head头节点前面的一个节点）
  * 使得对于链表头部的操作和中间操作的逻辑相同
  * 由于在头部前面插入了一个dummy节点，此时不再存在head这个变量了， dummy.next 表示head节点                                               
  * ListNode dummy = new ListNode(-1)
  * 查找操作: ListNode cur = dummy.next; for (int i = 0; i < location; i++){ cur = cur.next; }; return cur.val;                   * 更新操作: ListNode cur = dummy.next; for (int i = 0; i < location; i++){ cur = cur.next; }; cur.val = newValue;               * 插入操作:  ListNode pre = dummy; for (int i = 0; i < location; i++){ pre = pre.next; }; ListNode newNode = new ListNode(value); newNode.next = pre.next; pre.next = newNode;
  * 删除操作: ListNode res = null; ListNode pre = dummy; for (int i = 0; i < location; i++){ pre = pre.next; }; res = pre.next; pre.next = pre.next.next; return res.val;
* 算法的时间复杂度 (Time Complexity)
  * 评估算法时间效率的标准
  * "执行时间" 和输入问题规模之间的关系
  * 不是实际时间，而是单位时间                                                                                
  * ArrayList: add(0,val) -> O(n); add(n, val) -> O(1); add(average) -> O(n); get -> O(1); set -> O(1)
  * LinkedList: add(0,val) -> O(1); add(n, val) -> O(n); add(average) -> O(n); get -> O(n); set -> O(n)
### Lession 6: 栈，队列和哈希表
* 栈(stack)
  * 栈是一种后进先出（last in first out, LIFO)的线性数据结构
  * 栈的操作：push， pop， peek（getTop）【获取栈顶元素的值】， isEmpty
  * Stack<Integer> stack = new Stack<>();(java中自带的栈）
* 栈的实现 - LinkedList
  * 使用链表来模拟栈的过程中，链表的头部代表栈顶，这样push，pop操作的时间复杂度都是O(1)的，如果用链表的尾部代表栈顶的话，那么复杂度均为O(n)的
* 函数调用栈（Call Stack）
  * 操作系统(OS)用来保存函数的状态
  * 函数的调用过程中，主调函数停止执行，转而去执行被调函数，被调函数执行结束之后会返回主调函数。调用的时候要求参数的数量和类型都和定义时匹配，在函数执行过程中，遇到return语句后会立即返回
  * 在函数调用的过程中，操作系统使用函数调用栈来维护函数调用的状态。每个函数运行过程中有一段属于自己的栈帧结构，主要用来记录一些临时变量和主调函数的返回地址，这样当被调函数执行结束之后可以根据这个地址返回主调函数中，从而实现了函数调用的过程。函数调用栈的先进后出的结构与函数先调用后返回的特性恰好相符，是栈的重要应用，在调用过程中，先开始执行的函数后结束
* 队列(queue)及其实现
  * 队列是一种先进先出(first in first out, FIFO)的线性数据结构
  * 队列的应用：Message queue（消息队列）
  * 队列操作：enqueue(进队列), dequeue(出队列), peek(getHead), isEmpty
  * Queue<Integer> que = new LinkedList<>();(java中自带的队列）
  * que.offer(10); que.poll();
* 手动完成队列的实现 - LinkedList （参考截图）
  * 使用链表实现队列的过程中，需要同时记录链表的头结点和尾节点。这样才能保证进队列和出队列的时间复杂度都是O(1)的。消息队列是队列在操作系统中的重要应用
* 集合(Set)
  * 集合中存储非重复的无序数据
  * 集合的操作：插入(insert), 查找(find), 删除(delete)
  * Set<Integer> set = new HashSet<>(); 
  * Set是一个接口(Interface)，HashSet和TreeSet是其两个具体的实现。Set可以非常高效的进行元素的插入和查找
  * 在TreeSet里面的增删查改是O(log(n))的时间复杂度； 在HashSet里面的增删查改是O(1)的时间复杂度；
  * set.add(5); set.contains(5); set.remove(5); set.isEmpty(); set.size();
  * set的遍历：for(int num : set) {}
* 索引(Index)
  * A map(C++, java), A dictionary(python), A key-value pairs
  * key值唯一的key-value pairs, 无序的
  * Map<String, String> map = new HashMap<>(); 同样，HashMap的增删改查效率比TreeMap高
  * map.put("jack", "CMU"); map.get("jack"); map.size(); map.isEmpty(); map.containsKey();
  * map中如果key值一样，则会覆盖原来key所对应的value值
  * map的key遍历: for(String key : map.keySet()) {}
  * map的value遍历: for(String value : map.values()) {}
  * map的key和value遍历: for(Map.Entry<> entry : map.entrySet()) {}; entry.getKey(); entry.getValue();
* 哈希表(Hash Table)的原理
  * 实现数据的快速查找
  * 哈希表设计要素：哈希函数(hash function), 冲突解决方案(collision solution), 重哈希(rehashing)
* 哈希函数(hash function)
  * 确定性，不可逆性
  * 输入：任何二进制数据
  * 输出：整数
  * 好的哈希函数: - 在给定的输入范围内，尽可能少的发生碰撞(collision)
  * 计算复杂度不能太高
  * 除余法(modulo division),平方取中法(mid-square), 基础转换法等(radix transformation)
  * Java String哈希函数: for (char c : str) { hashCode = 31 * hashCode + c; }
  * 碰撞（Collision):例如 Aa 和 BB； Ab 和 BC
* 哈希表的冲突解决方案(collision solution)
  * 开散列: open hashing, 也称为拉链法(separate chaining)
  * 闭散列: closed hashing, 也称为开地址方法(open addressing)
* 开散列（open hashing）
  * 开辟一个数组
  * 数组的每一个元素是一个链表的头节点引用
  * 通过Hash函数，计算key对应的index，将index相同的key-value插入到同一个链表中
* 闭散列（close hashing）
  * 开辟一个数组，一个位置只放一个key-value
  * 通过Hash函数，计算key对应的index，将key-value放在相应的位置
  * 如果这个位置已经有了元素，则查找其他合适的空位置放入
  * 冲突时，查找其他空位置的策略， 尽量探查到所有位置，减少聚集现象的出现
* 重哈希（rehashing）
  * 负载因子（load factor）- 哈希表中的元素个数初一哈希表的容量
  * 哈希表检索的时间与负载因子有关：当负载因子小于0.5时，大部分检索长度小于2； 当负载因子大于0.5，性能急剧下降； 空间换时间：O(1)
  * 重哈希：调整哈希表的大小年，并将元素重新摆放； 当哈希表过于稀疏 -> 节省空间； 当哈希表过于稠密 -> 加速查找
### Lession 7: 树和递归
* 什么是树（tree）
  * 树是一种用来表示`层次关系`的`非线性`数据结构
  * eg: 文件系统， 数据库的索引， 字典树， 结构化存储
  * 由节点（node）组成
  * 每个节点有零个或多个子节点（child node）
  * 没有父节点的是根节点（root node）
  * 每个非根节点只有一个父节点（parent node）
* 二叉树（binary tree）
  * 每个节点最多有两个子节点
  * 两个子节点分别被称为左孩子（left child） 和右孩子（right child）
  * 叶子节点： 没有孩子节点的节点
  * 节点位置很难描述，操作很难定义， 不完整的数据结构
  * 二叉树的构建： 先建立单个节点，将节点连接起来；
  * class TreeNode {
  *     public int val;
  *     public TreeNode left;
  *     public TreeNode right;
  *     public TreeNode(int val) {
  *         this.val = val;
  *     }
  * }
  * TreeNode node1 = new TreeNode(8); TreeNode node2 = new TreeNode(3); TreeNode node3 = new TreeNode(10);
  * node1.left = node1; node1.right = node3; return node1;
* 二叉树的深度优先搜索
  * 子树（sub-tree): 树中的每个节点代表以它为跟的一棵树；左孩子所代表的树称为左子树(left sub-tree);右孩子所代表的树称为右子树(right sub-tree);
  * 时间复杂度: O(n)
  * 空间复杂度: 程序最多占用的空间与树的高度成线性关系， 算法的空间复杂度O(h), h介于logn和n之间， 即O(log(n)) ~ O(n)
  * 二叉树的遍历(traverse)
  * public static void traverseTree(TreeNode root) {
  *     if (root == null) {
  *         return;
  *     }
  *     System.out.println(root.val);
  *     traverseTree(root.left);
  *     traverseTree(root.right);
  * }
  * 先序遍历(preorder): root-left-right
  * 中序遍历(inorder): left-root-right
  * 后序遍历(postorder): left-right-root
  * Binary tree preorder traversal: https://www.lintcode.com/problem/binary-tree-preorder-traversal/description
  * Binary tree inorder traversal: https://www.lintcode.com/problem/binary-tree-inorder-traversal/description
  * Binary tree postorder traversal: https://www.lintcode.com/problem/binary-tree-postorder-traversal/description
* 递归(Recursive)算法及其复杂度
  * 数据结构的递归，树就是一种递归的数据结构
  * 算法（程序）的递归， 函数自己调用自己
  * 定义：首先这个问题或者数据结构需要是递归定义的
  * 出口： 什么时候递归终止
  * 拆解： 递归不终止的时候，如何分解问题
  * 经典例题Fibonacci： https://www.lintcode.com/problem/fibonacci/description
* 时间复杂度(Time complexity)
  * 程序执行的时间和输入问题规模之间的关系
  * 函数调用的次数 x 每次函数调用的时间消耗
* 空间复杂度（Space complexity）
  * 程序占用的空间和输入问题规模之间的关系
  * 堆（heap）空间 + 栈（stack）空间
* 面试真题: Binary tree leaf sum -> https://www.lintcode.com/problem/binary-tree-leaf-sum/description
* 面试真题: Maximum depth of binary tree -> https://www.lintcode.com/problem/maximum-depth-of-binary-tree/description
### Lession 8: 宽度优先遍历和分治法
* 二叉树的宽度优先遍历(普通遍历）
  * 访问每一个节点，不重不漏
  * 按层次的顺序遍历二叉树
  * 使用队列（Queue）作为主要的数据结构
  * Queue<TreeNode> queue = new LinkedList<>();
  * 时间复杂度O(n)
  * 空间复杂度: 由节点最多的层的节点数决定，O(n)
* 二叉树的分层遍历
  * 多一个循环
  * 层数记录了根节点到当前节点的路径长度（level - 1）
  * 时间复杂度O(n)
  * 空间复杂度: 由节点最多的层的节点数决定，O(n)
* 面试真题: Binary Tree Level Order Traversal
  * https://www.lintcode.com/problem/binary-tree-level-order-traversal/description
* 面试真题: Convert Binary Tree to Linked Lists by Depth
  * https://www.lintcode.com/problem/convert-binary-tree-to-linked-lists-by-depth/description
* 分治算法(divide and conquer)
  * 将一个大问题分解成多个独立的小问题: 分
  * 分别解决每个小问题（小问题和大问题是同一类问题，可以用递归）
  * 将小问题的解合并，从而得到大问题的解: 合
* 面试真题: Identical Binary Tree
  * https://www.lintcode.com/problem/same-tree/description
  * 判断两颗树根的值是否相同
  * 判断左子树是否一致
  * 判断右子树是否一致
* 面试真题: Balanced Binary Tree
  * https://www.lintcode.com/problem/balanced-binary-tree/description
  * 判断左子树是否平衡
  * 判断右子树是否平衡
  * 左右子树高度差不超过1
* 面试真题: Validate Binary Search Tree
  * https://www.lintcode.com/problem/validate-binary-search-tree/description
  * 判断左子树是否是BST
  * 判断右子树是否是BST
  * 左子树的最大值 < 跟节点的值 < 右子树的最小值
  * 二分搜索树（BST）是一种特殊的二叉树，对于树中的任何一个节点，其左子树中所有节点的值都小，右子树中所有节点的值都大。对BST进行中序遍历可以得到一个非降的序列，相比于普通的二叉树，BST内部结构更加严谨有序，可以定义插入，查找，删除等操作
### Lession 9: 高级排序算法
* 普通排序算法
  * 选择排序(Selection sort)
  * http://www.algolist.net/Algorithms/Sorting/Selection_sort
  * 插入排序(Insertion sort)
  * http://www.algolist.net/Algorithms/Sorting/Insertion_sort
  * 冒泡排序(Bubble sort)
  * http://www.algolist.net/Algorithms/Sorting/Bubble_sort
  * 时间复杂度都是: O(n^2)
  * 空间复杂度: O(1)
  * 演示动画： https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
* 归并排序(Merge sort) - 分治
  * 把数组均分成左右两半
  * 将左右两半分别排序（递归）
  * 将排好序的两半数组合并（merge）
  * 参考代码： https://www.jiuzhang.com/solutions/merge-sort
  * 归并排序是一种高级的排序算法，其使用的方法是分治法，先将大数组分成左右两半，对左右两半分别进行递归归并排序，然后将排好序的小数组进行归并，得到最终有序的大数组。归并过程是整个算法的核心， 先局部有序再整体有序。
  * 注意事项： int mid = left + (right - left) / 2;
  * 时间复杂度：O(nlogn)
  * 空间复杂度: O(n) , 栈空间:O(logn), 堆空间:O(nlogn) -> O(n)
  * 如何merge？ 练习1: merge two sorted arrays
  * https://www.lintcode.com/problem/merge-two-sorted-arrays/description
* 快速排序（quick sort）
  * 20世纪依赖十大经典算法
  * https://www.quora.com/What-are-the-top-10-algorithms-of-the-20th-century
  * 把数组分成两边，使得：数组的左边小于等于数组的右边（左右两边长度不一定相等）
  * 对左右两部分数组分别排序（递归）
  * 先整体有序再局部有序
  * Pivot的选取是快速排序中很重要的一部分，其策略的好坏会影响快速排序的时间复杂度。在选取Pivot的过程中，比较好的方法是随机选取。但是快速排序的最坏时间复杂度是O(n^2)，无论pivot的选取规则怎样，肯定可以构建出一组输入数据使得排序的时间复杂度为O(n^2)
  * 时间复杂度: O(nlogn) -> 平均情况； O(n^2) -> 最坏情况;
  * 空间复杂度: O(logn) -> 平均情况; O(n) -> 最坏情况
  * 代码参考: https://www.jiuzhang.com/solutions/quick-sort
* 快速排序步骤：
  * 选取基准数（pivot）
  * 将数组分割为两部分，长度不一定相等（partition）
  * 递归处理子问题
* partition：
  * 两个指针，分别指向当前数组的头和尾
  * 移动左边的指针，直到左指针指向的数 >= pivot
  * 移动右边的指针，直到右指针指向的数 <= pivot
  * 交换两个指针指向的数
  * 回到第2步，直到两个指针相遇
  * 时间复杂度: O(n), 空间复杂度: O(1)
  * 两个子问题的边界：[left, j], [i, right]                            
* 在Java中使用排序:
  * Arrays.sort()；排数组
  * Collections.sort(); 排list，不管ArrayList，还是LinkedList，都可以排  
  * 自定义比较函数：
  * Comparator[Integer] comparator = new Comparator<>() {
  *     @Override
  *     public int compare(Integer o1, Integer o2) {
  *         return o1 - o2;   // o1.compareTo(o2);  string 比较
  *     }
  *  }
  * 或者：private class XXComparator implements Comparator[String] {
  *          @Override
  *          public int compare(String a, String b) {
  *              String s1 = a + b;
  *              String s2 = b + a;
  *              return s2.compareTo(s1);   // 从大到小排
  *          }
  *      }
  * 因为无法显示<>, 所以用[]来代替
 
