# Write your MySQL query statement below
SELECT 
    d.name as Department, e.name as Employee, e.salary as Salary 
    from Department d INNER JOIN(
        SELECT name, salary, departmentId 
        FROM Employee 
        WHERE (departmentId,salary) IN (
            SELECT departmentId, max(salary)
            FROM Employee GROUP BY departmentId
        )
    ) e ON e.departmentId = d.id;