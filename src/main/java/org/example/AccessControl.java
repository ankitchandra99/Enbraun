package org.example;

import java.util.ArrayList;
import java.util.List;

/*class Employee {
    private String department;
    private String team;
    private String office;

    public Employee(String department, String team, String office) {
        this.department = department;
        this.team = team;
        this.office = office;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeam() {
        return team;
    }

    public String getOffice() {
        return office;
    }
}

class User {
    private int userID;
    private String userName;
    private String dept; // Extra attribute for department access
    private String office; // Extra attribute for office access
    private String team; // Extra attribute for team access

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Define a method to check access privileges
    public boolean hasAccess(Employee employee) {
        if ((dept != null && dept.equals(employee.getDepartment())) ||
                (team != null && team.equals(employee.getTeam())) ||
                (office != null && office.equals(employee.getOffice()))) {
            return true;
        }
        return false;
    }
    public boolean matches(Employee employee) {
        return (department == null || department.equals(employee.getDepartment())) &&
                (team == null || team.equals(employee.getTeam())) &&
                (office == null || office.equals(employee.getOffice()));
    }
}

public class AccessControl {
    public static void main(String[] args) {
        // Create userDb and employeeDb
        List<User> userDb = new ArrayList<>();
        List<Employee> employeeDb = new ArrayList<>();

        // Add employees to the employeeDb
        employeeDb.add(new Employee("HR", "Team A", "Delhi"));
        employeeDb.add(new Employee("IT", "Team B", "Mumbai"));
        employeeDb.add(new Employee("Finance", "Team C", "Bangalore"));

        // Create users
        User user1 = new User(1, "John");
        User user2 = new User(2, "Alice");
        User user3 = new User(3, "Bob");
        User user4 = new User(4, "Eve");

        // Define access privileges for user1
        user1.setTeam("Team A");
        user1.setOffice("Delhi");

        user2.setTeam("Team C");
        user2.setOffice("Delhi");

        // Add users to the userDb
        userDb.add(user1);
        userDb.add(user2);
        userDb.add(user3);
        userDb.add(user4);

        // Check access privileges for user1
        for (User user : userDb) {
            for (Employee employee : employeeDb) {
                if (user.hasAccess(employee)) {
                    System.out.println(user.getUserName() + " has access to employee with department: " +
                            employee.getDepartment() + ", team: " + employee.getTeam() +
                            ", and office: " + employee.getOffice());
                }
            }
        }
    }
}*/
import java.util.ArrayList;
import java.util.List;
/*
class Employee {
    private String department;
    private String team;
    private String office;

    public Employee(String department, String team, String office) {
        this.department = department;
        this.team = team;
        this.office = office;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeam() {
        return team;
    }

    public String getOffice() {
        return office;
    }
}
/*
class User {
    private int userID;
    private String userName;
    private List<AccessRule> accessRules;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.accessRules = new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void addAccessRule(AccessRule rule) {
        accessRules.add(rule);
    }

    public boolean hasAccess(Employee employee) throws AccessDeniedException {
        for (AccessRule rule : accessRules) {
            if (rule.matches(employee)) {
                return true;
            }
        }
        throw new AccessDeniedException("Access denied for " + userName + " to employee with department: " +
                employee.getDepartment() + ", team: " + employee.getTeam() + ", and office: " + employee.getOffice());
    }
}

class AccessRule {
    private String department;
    private String team;
    private String office;

    public AccessRule(String department, String team, String office) {
        this.department = department;
        this.team = team;
        this.office = office;
    }

    public boolean matches(Employee employee) {
        return (department == null || department.equals(employee.getDepartment())) &&
                (team == null || team.equals(employee.getTeam())) &&
                (office == null || office.equals(employee.getOffice()));
    }
}

class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}

public class AccessControl {
    public static void main(String[] args) {
        // Create userDb and employeeDb
        List<User> userDb = new ArrayList<>();
        List<Employee> employeeDb = new ArrayList<>();

        // Add employees to the employeeDb
        employeeDb.add(new Employee("HR", "Team A", "Delhi"));
        employeeDb.add(new Employee("IT", "Team B", "Mumbai"));
        employeeDb.add(new Employee("Finance", "Team C", "Bangalore"));

        // Create users
        User user1 = new User(1, "John");
        User user2 = new User(2, "Tom");
        User user3 = new User(3, "Adam");
        User user4 = new User(4, "Lina");

        // Define access rules for users
        user1.addAccessRule(new AccessRule("IT", null, null));
        user2.addAccessRule(new AccessRule(null, "Team C", null));
        user2.addAccessRule(new AccessRule(null, null, "Delhi"));
        user3.addAccessRule(new AccessRule("Finance", null, null));
        user3.addAccessRule(new AccessRule(null, null, "Pune"));
        user4.addAccessRule(new AccessRule("HR", null, null));
        user4.addAccessRule(new AccessRule(null, null, "Mumbai"));

        // Add users to the userDb
        userDb.add(user1);
        userDb.add(user2);
        userDb.add(user3);
        userDb.add(user4);

        // Check access privileges for each user
        for (User user : userDb) {
            for (Employee employee : employeeDb) {
                try {
                    if (user.hasAccess(employee)) {
                        System.out.println(user.getUserName() + " has access to employee with department: " +
                                employee.getDepartment() + ", team: " + employee.getTeam() + ", and office: " +
                                employee.getOffice());
                    }
                } catch (AccessDeniedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    public static List<Employee> getEmployeesByUserId(int userId, List<User> userDb, List<Employee> employeeDb) throws AccessDeniedException {
        List<Employee> accessibleEmployees = new ArrayList<>();
        for (User user : userDb) {
            if (user.getUserID() == userId) {
                for (Employee employee : employeeDb) {
                    if (user.hasAccess(employee)) {
                        accessibleEmployees.add(employee);
                    }
                }
                return accessibleEmployees;
            }
        }
        return accessibleEmployees; // Return an empty list if the user with the given userId is not found.
    }*/


class Employee {
    private String department;
    private String team;
    private String office;

    public Employee(String department, String team, String office) {
        this.department = department;
        this.team = team;
        this.office = office;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeam() {
        return team;
    }

    public String getOffice() {
        return office;
    }
}

class User {
    private int userID;
    private String userName;
    private List<AccessRule> accessRules;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.accessRules = new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void addAccessRule(AccessRule rule) {
        accessRules.add(rule);
    }

    public boolean hasAccess(Employee employee) {
        for (AccessRule rule : accessRules) {
            if (rule.matches(employee)) {
                return true;
            }
        }
        throw new RuntimeException("Access denied for " + userName + " to employee with department: " +
                employee.getDepartment() + ", team: " + employee.getTeam() + ", and office: " + employee.getOffice());
    }
}

class AccessRule {
    private String department;
    private String team;
    private String office;

    public AccessRule(String department, String team, String office) {
        this.department = department;
        this.team = team;
        this.office = office;
    }

    public boolean matches(Employee employee) {
        return (department == null || department.equals(employee.getDepartment())) &&
                (team == null || team.equals(employee.getTeam())) &&
                (office == null || office.equals(employee.getOffice()));
    }
}

public class AccessControl {
    public static void main(String[] args) {
        // Create userDb and employeeDb
        List<User> userDb = new ArrayList<>();
        List<Employee> employeeDb = new ArrayList<>();

        // Add employees to the employeeDb
        employeeDb.add(new Employee("HR", "Team A", "Delhi"));
        employeeDb.add(new Employee("IT", "Team B", "Mumbai"));
        employeeDb.add(new Employee("Finance", "Team C", "Bangalore"));

        // Create users
        User user1 = new User(1, "John");
        User user2 = new User(2, "Tom");
        User user3 = new User(3, "Adam");
        User user4 = new User(4, "Lina");

        // Define access rules for users
        user1.addAccessRule(new AccessRule("IT", null, null));
        user2.addAccessRule(new AccessRule(null, "Team C", null));
        user2.addAccessRule(new AccessRule(null, null, "Delhi"));
        user3.addAccessRule(new AccessRule("Finance", null, null));
        user3.addAccessRule(new AccessRule(null, null, "Pune"));
        user4.addAccessRule(new AccessRule("HR", null, null));
        user4.addAccessRule(new AccessRule(null, null, "Mumbai"));

        // Add users to the userDb
        userDb.add(user1);
        userDb.add(user2);
        userDb.add(user3);
        userDb.add(user4);

        // Check access privileges for each user
        for (User user : userDb) {
            for (Employee employee : employeeDb) {
                try {
                    if (user.hasAccess(employee)) {
                        System.out.println(user.getUserName() + " has access to employee with department: " +
                                employee.getDepartment() + ", team: " + employee.getTeam() + ", and office: " +
                                employee.getOffice());
                    }
                } catch (RuntimeException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public static List<Employee> getEmployeesByUserId(int userId, List<User> userDb, List<Employee> employeeDb) {
        List<Employee> accessibleEmployees = new ArrayList<>();
        for (User user : userDb) {
            if (user.getUserID() == userId) {
                for (Employee employee : employeeDb) {
                    if (user.hasAccess(employee)) {
                        accessibleEmployees.add(employee);
                    }
                }
                return accessibleEmployees;
            }
        }
        return accessibleEmployees; // Return an empty list if the user with the given userId is not found.
    }
}



