// A team organizing a university career fair has a list of companies along 
// with their respective arrival times and their duration of stay. Only one company
// can present at any time. Given each company's arrival time and duration they will
// stay, determine the maximum number of presentations that can be hosted during 
// the career fair.

// example:
// n = 5
// arrival = [1, 3, 3, 5, 7]
// duration = [2, 2, 1, 2, 1]

// the first company arrives at time 1 and stays for 2 hours.  At time 3, two companies
// arrive, but only 1 can stay for either 1 or 2 hours. The next companies arrive at times
// 5 and 7 and do not conflict with any others. In total, there can be a maximum of 
// 4 promotional events.

// complete the function maxEvents in the editor below.

public int maxEvents(int[] arrival, int[] duration) {
    int[][] events = new int[arrival.length][2];
    for (int i = 0; i < arrival.length; i++) {
        events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
    }

    // events = [[1, 3], [3, 5], [3, 4], [5, 7], [7, 8]]
    // use start as a sweep line, from left to right
    // 1. create arrays to record all start points, and ends points
    // 2. sort starts and ends 
    // 3. sweep starts and ends from left to right
    // time: O(nlogn), space: O(n)

    int[] starts = new int[events.length];
    int[] ends = new int[events.length];
    for (int i = 0; i < events.length; i++) {
        starts[i] = events[i][0];
        ends[i] = events[i][1];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    int results = 0;
    int end = 0;
    for (int i = 0; i < events.length; i++) {
        if (starts[i] < ends[end]) {
            results++;
        } else {
            end++;
        }
    }
    return results;
}

//////////////////////////////////////////////////////////////////////
// 以start作为扫描线。从左往右扫描
        // 1. 创建数组来记录所有的starts扫描点，以及ends结束的交点
        // 2. 对starts，以及ends进行排序
        // 3. 从左往右扫描
        // time: O(nlogn), space: O(n)

public int maxEvents(int[] arrival, int[] duration) {
    int starts = new int[arrival.length];
    int ends = new int[arrival.length];
    for (int i = 0; i < arrival.length; i++) {
        starts[i] = arrival[i];
        ends[i] = arrival[i] + duration[i];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    int results = 0;
    int end = 0;
    for (int i = 0; i < arrival.length; i++) {
        if (start[i] < ends[end]) {
            results++;
        } else {
            end++;
        }
    }
    return results;
}


//////////////////////////////////////////////////////////////////
Java solution with minHeap:

private static int maxEvents(int[] arrival, int[] duration) {
	int[][] events = new int[arrival.length][2];
	for(int i=0;i<arrival.length;i++) {
		events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
	}
	Arrays.sort(events, (a, b)->(a[1] - b[1]));
	Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
	int[] first = events[0];
	for(int i=1;i<events.length;i++) {
		int[] cur = events[i];
		if(cur[0] < first[1])
			minHeap.offer(cur);
		else {
			first[1] = events[i][1];
		}	
	}
	return arrival.length - minHeap.size();
}