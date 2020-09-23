// A group of friends are playing a video game together. During the game, each 
// player earns a number of points. At the end of a round, players who receive at 
// least a certain rank get to "level up" their characters to gain increased abilities.
// Given the scores of the players at the end of a round, how many players will 
// be able to level up?

// for example: if there are four players, and three players tie for first place,
// their ranks are 1, 1, 1, and 4

// example: k = 3; scores = [100, 50, 50, 25]

// these players' ranks are [1, 2, 2, 4]. Because the players need to have a rank 
// of at leasr 3 to level up. only the first three players qualify. 
// Therefore, the answer is 3.


// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions


第一题注意分数为0的时候不要加到最后结果里 不然case5过不了

public int numPlayers(int k, int[] scores) {
    if (scores == null || scores.length == 0) {
        return 0;
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int score : scores) {
        minHeap.offer(score);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    int count = minHeap.size();
    return count;
}


// time: O(nlogk);
// space: O(k)