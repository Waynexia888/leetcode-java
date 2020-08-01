// On the Qixi Festival, the Cowherd and the Weaver play together in a maze size of 
// n*m . However, they get separated from each other. Now given the maze consisting 
// of .,*,S,T, where . denotes an empty space, * denotes an obstacle, S denotes the 
// position of the cowherd, T denotes the position of the weaver, the Cowherd and 
// the Weaver will try to find each other(they can move to the grid up or down or 
// left or right or stand still, but they can't walk outside of the maze or move 
// to obstacles).Is it possible for them reunion? If possible, return True, otherwise 
// return False.

// Example
// Example 1:

// Input: 
// [
// "S..*",
// "*.**",
// "...T"
// ]
// Output: true
// Explanation:
// weaver don't need to move
// Cowherd's route:(0,0)->(0,1)->(1,1)->(2,1)->(2,2)->(2,3)
// Example 2:

// Input:
// [
// "S..*",
// "***.",
// "...T"
// ]
// Output: false
// Explanation
// It is impossible for them to reunion
// Notice
// 2<=n,m<=1000