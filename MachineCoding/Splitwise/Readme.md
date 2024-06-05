Here's a low-level design and working solution for the expense sharing application in Java. The design is modular with clear separation of concerns to make it easily maintainable and extensible. We will implement the following classes:

1. `User`: Represents a user in the system.
2. `Expense`: Abstract class representing a generic expense.
3. `EqualExpense`, `ExactExpense`, `PercentExpense`: Concrete classes for different types of expenses.
4. `ExpenseManager`: Manages the expenses and balances between users.
5. `Main`: The main class to run the application and handle inputs.

### User Class

The `User` class represents a user with id, name, email, and mobile number.

```java
public class User {
    private String id;
    private String name;
    private String email;
    private String mobile;

    public User(String id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    // Add getters for name, email, and mobile if needed
}
```

### Expense Abstract Class

The `Expense` class represents a generic expense. Subclasses will implement specific types of expenses.

```java
import java.util.List;

public abstract class Expense {
    protected String paidBy;
    protected double amount;
    protected List<String> involvedUsers;

    public Expense(String paidBy, double amount, List<String> involvedUsers) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.involvedUsers = involvedUsers;
    }

    public abstract void calculateSplits();
}
```

### EqualExpense Class

The `EqualExpense` class handles expenses split equally.

```java
public class EqualExpense extends Expense {
    public EqualExpense(String paidBy, double amount, List<String> involvedUsers) {
        super(paidBy, amount, involvedUsers);
    }

    @Override
    public void calculateSplits() {
        double splitAmount = amount / involvedUsers.size();
        for (String user : involvedUsers) {
            if (!user.equals(paidBy)) {
                ExpenseManager.updateBalance(user, paidBy, splitAmount);
            }
        }
    }
}
```

### ExactExpense Class

The `ExactExpense` class handles expenses split by exact amounts.

```java
import java.util.List;

public class ExactExpense extends Expense {
    private List<Double> exactAmounts;

    public ExactExpense(String paidBy, double amount, List<String> involvedUsers, List<Double> exactAmounts) {
        super(paidBy, amount, involvedUsers);
        this.exactAmounts = exactAmounts;
    }

    @Override
    public void calculateSplits() {
        for (int i = 0; i < involvedUsers.size(); i++) {
            if (!involvedUsers.get(i).equals(paidBy)) {
                ExpenseManager.updateBalance(involvedUsers.get(i), paidBy, exactAmounts.get(i));
            }
        }
    }
}
```

### PercentExpense Class

The `PercentExpense` class handles expenses split by percentage.

```java
import java.util.List;

public class PercentExpense extends Expense {
    private List<Double> percents;

    public PercentExpense(String paidBy, double amount, List<String> involvedUsers, List<Double> percents) {
        super(paidBy, amount, involvedUsers);
        this.percents = percents;
    }

    @Override
    public void calculateSplits() {
        for (int i = 0; i < involvedUsers.size(); i++) {
            if (!involvedUsers.get(i).equals(paidBy)) {
                double splitAmount = (amount * percents.get(i)) / 100;
                ExpenseManager.updateBalance(involvedUsers.get(i), paidBy, splitAmount);
            }
        }
    }
}
```

### ExpenseManager Class

The `ExpenseManager` class manages all expenses and calculates balances.

```java
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {
    private static Map<String, Map<String, Double>> balanceSheet = new HashMap<>();

    public static void addUser(User user) {
        balanceSheet.putIfAbsent(user.getId(), new HashMap<>());
    }

    public static void updateBalance(String userOwes, String userPaid, double amount) {
        balanceSheet.putIfAbsent(userOwes, new HashMap<>());
        balanceSheet.putIfAbsent(userPaid, new HashMap<>());

        Map<String, Double> userOwesMap = balanceSheet.get(userOwes);
        Map<String, Double> userPaidMap = balanceSheet.get(userPaid);

        userOwesMap.put(userPaid, userOwesMap.getOrDefault(userPaid, 0.0) + amount);
        userPaidMap.put(userOwes, userPaidMap.getOrDefault(userOwes, 0.0) - amount);
    }

    public static void showBalances() {
        boolean isEmpty = true;
        for (String user : balanceSheet.keySet()) {
            for (Map.Entry<String, Double> entry : balanceSheet.get(user).entrySet()) {
                if (entry.getValue() != 0) {
                    isEmpty = false;
                    if (entry.getValue() > 0) {
                        System.out.println(user + " owes " + entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
                    } else {
                        System.out.println(entry.getKey() + " owes " + user + ": " + String.format("%.2f", -entry.getValue()));
                    }
                }
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public static void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> entry : balanceSheet.get(userId).entrySet()) {
            if (entry.getValue() != 0) {
                isEmpty = false;
                if (entry.getValue() > 0) {
                    System.out.println(userId + " owes " + entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
                } else {
                    System.out.println(entry.getKey() + " owes " + userId + ": " + String.format("%.2f", -entry.getValue()));
                }
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }
}
```

### Main Class

The `Main` class handles inputs and runs the application.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create users
        User u1 = new User("u1", "User1", "user1@example.com", "1111111111");
        User u2 = new User("u2", "User2", "user2@example.com", "2222222222");
        User u3 = new User("u3", "User3", "user3@example.com", "3333333333");
        User u4 = new User("u4", "User4", "user4@example.com", "4444444444");

        ExpenseManager.addUser(u1);
        ExpenseManager.addUser(u2);
        ExpenseManager.addUser(u3);
        ExpenseManager.addUser(u4);

        // Handle inputs
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("SHOW")) {
                ExpenseManager.showBalances();
            } else if (command.startsWith("SHOW ")) {
                String userId = command.split(" ")[1];
                ExpenseManager.showBalance(userId);
            } else if (command.startsWith("EXPENSE ")) {
                String[] parts = command.split(" ");
                String paidBy = parts[1];
                double amount = Double.parseDouble(parts[2]);
                int numUsers = Integer.parseInt(parts[3]);
                List<String> users = new ArrayList<>();
                for (int i = 0; i < numUsers; i++) {
                    users.add(parts[4 + i]);
                }
                String type = parts[4 + numUsers];
                switch (type) {
                    case "EQUAL":
                        Expense equalExpense = new EqualExpense(paidBy, amount, users);
                        equalExpense.calculateSplits();
                        break;
                    case "EXACT":
                        List<Double> exactAmounts = new ArrayList<>();
                        for (int i = 0; i < numUsers; i++) {
                            exactAmounts.add(Double.parseDouble(parts[5 + numUsers + i]));
                        }
                        Expense exactExpense = new ExactExpense(paidBy, amount, users, exactAmounts);
                        exactExpense.calculateSplits();
                        break;
                    case "PERCENT":
                        List<Double> percents = new ArrayList<>();
                        for (int i = 0; i < numUsers; i++) {
                            percents.add(Double.parseDouble(parts[5 + numUsers + i]));
                        }
                        Expense percentExpense = new PercentExpense(paidBy, amount, users, percents);
                        percentExpense.calculateSplits();
                        break;
                }
            }
        }
    }
}
```

This code provides a basic implementation of the expense sharing application. You can run this code and interact with it using the specified commands. The design is modular, making it easy to extend and maintain.
