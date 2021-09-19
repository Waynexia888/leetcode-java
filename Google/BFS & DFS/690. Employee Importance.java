Leetcode 690. Employee Importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        
        int totalImportance = 0;
        while (!queue.isEmpty()) {
            Employee emp = queue.poll();
            totalImportance += emp.importance;
            for (int sub : emp.subordinates) {
                queue.offer(map.get(sub));
            }
        }
        return totalImportance;
    }
}

///////////////////////////////////////////////////

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int totalImportance;
    public int getImportance(List<Employee> employees, int id) {
        totalImportance = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        dfs(id, map);
        return totalImportance;
    }
    
    private void dfs(int id, Map<Integer, Employee> map) {
        Employee emp = map.get(id);
        totalImportance += emp.importance;
        for (int sub : emp.subordinates) {
            dfs(sub, map);
        }
    }
}

///////////////////////////////////////////////

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        return dfs(id, map);
    }
    
    private int dfs(int id, Map<Integer, Employee> map) {
        int totalImportance = 0;
        Employee emp = map.get(id);
        totalImportance += emp.importance;
        for (int sub : emp.subordinates) {
            totalImportance += dfs(sub, map);
        }
        return totalImportance;
    }
}