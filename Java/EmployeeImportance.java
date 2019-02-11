/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #690. Employee Importance
 *
 */

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;

        HashMap<Integer, Employee> map = new HashMap<>();
        int res = 0;

        for (Employee em : employees) {
            map.put(em.id, em);
        }

        Queue<Employee> q= new LinkedList<>();
        q.offer(map.get(id));

        while (!q.isEmpty()) {
            Employee cur = q.poll();
            res += cur.importance;
            for (int sub : cur.subordinates) {
                q.offer(map.get(sub));
            }
        }

        return res;
    }
}
