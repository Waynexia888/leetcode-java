// https://leetcode.com/discuss/interview-question/221639/

3.building offices，在一个n * m的grid中简 n个office building，要求在grid中除
building之外的所有点到达building的距离最短，返回这些点到building最大的距离。

build office没有时间复杂度要求，我暴力解也全过了case。思路是先暴力把几种office的排布情况写出来，
然后对于每一种情况(每一个matrix)用BFS求距离，可以参考leetcode542 (把office设为0)，
可以知道每个位置到office的最短距离，所有情况都可以求出来，最后比一下就行。