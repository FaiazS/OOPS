# Bank Account Domain Modeling in Java

**Turning familiar business rules into objects, state, and behavior.**

How should a program represent an account, change its balance, and keep a record of money moving in and out? This project explores those questions through a small Java bank-account model: a focused exercise in classes, constructors, encapsulation, methods, conditional logic, and collections.

Built during my transition from a business education and e-commerce operations into software engineering, this repository captures a foundational step: expressing a business concept as code and examining whether its rules hold when inputs and conditions change.

**Current status:** the `master` source contains an initial account implementation with a compilation blocker and validation issues described below. The application entry point is currently empty.

[Explore the Java source](https://github.com/FaiazS/OOPS/tree/master/src/main/java/com/scaler) · [BankAccount.java](https://github.com/FaiazS/OOPS/blob/master/src/main/java/com/scaler/BankAccount.java) · [Main.java](https://github.com/FaiazS/OOPS/blob/master/src/main/java/com/scaler/Main.java)

## Why this domain matters

A bank account is a useful way to learn object-oriented programming because its operations have consequences. A deposit or withdrawal changes state, invalid input must be handled, and transaction records should explain what happened. Those requirements introduce questions that also arise in order management, inventory, wallets, and other applications that maintain business state.

The value of this exercise is the connection between a requirement and its implementation: which information belongs to an object, which methods may change it, and which conditions must remain true after an operation.

## What the code contains

The repository contains two Java classes in the `com.scaler` package:

| Component | Responsibility represented in the source |
|---|---|
| `BankAccount` | Holds a balance, account-holder name, and transaction-history collection; defines account operations |
| `Main` | Declares the Java application entry point; its method body is currently empty |

### Account construction

`BankAccount` provides a default constructor with sample account values and an overloaded constructor that accepts an opening balance and account-holder name. This explores how the same class can initialize objects in different ways.

### Account operations

The class defines methods for depositing, withdrawing, accessing the balance, changing the account-holder name, and printing transaction history. Credit and debit descriptions are stored in an `ArrayList<String>` in memory.

The implementation also attempts to restrict balance access using the account-holder name. This is a conditional-logic exercise; it is not an authentication mechanism.

## Java concepts represented

| Concept | Where it appears | What it helps practice |
|---|---|---|
| Classes and objects | `BankAccount` | Grouping related state and behavior into a domain model |
| Private fields | Balance, holder name, and transaction history | Controlling direct field access through the class boundary |
| Constructor overloading | Default and parameterized constructors | Initializing objects with different inputs |
| Methods and parameters | Deposit, withdrawal, getters, and setters | Defining how callers interact with an object |
| Conditional logic | Amount, balance, and account-name checks | Translating conditions into executable decisions |
| Collections and generics | `ArrayList<String>` | Holding a growing collection of transaction descriptions |
| Iteration | Enhanced `for` loop in the history-printing code | Visiting collection elements |
| Exceptions | `RuntimeException` in balance access methods | Exploring a failure path distinct from a return value |

This exercise concentrates on these foundations. Inheritance and polymorphism are not implemented in the reviewed source.

## Business rules to make explicit

The account model provides a starting point for discussing rules such as:

- A deposit must be positive before it changes the balance.
- A withdrawal must be positive and must not exceed the available balance.
- A rejected operation must leave the balance and transaction history unchanged.
- A successful operation should produce a consistent balance update and transaction record.
- An operation's reported result should match what actually happened.

These are **requirements for the next iteration**, rather than guarantees made by the current implementation. Defining them makes the project easier to refine and test.

## Current implementation status

The `master` source needs the following corrections before it can support a working demonstration:

- **Compilation:** `printTransactionHistory()` is declared inside `withdraw()`. Java does not allow a method declaration inside another method; it needs to be moved to class scope.
- **Deposit validation:** a negative deposit prints an invalid-amount message, but execution continues to update the balance and record a credit.
- **Withdrawal validation:** negative withdrawal amounts are not rejected. The completion message also prints after an insufficient-balance rejection.
- **Balance access:** the account-holder check compares strings with `==`, which compares object references rather than string contents. A name check would still not provide authentication after correcting that comparison.
- **Method semantics:** `setBalance()` adds to the balance instead of replacing it, so its name and behavior need to be reconciled.
- **Demonstration:** `Main.main()` has no example operations, and the reviewed source tree contains no automated tests.

The model currently uses `double` for the balance and amounts. A future financial-domain refinement should use an explicit decimal representation and rounding rules. Transaction history is a collection of strings in memory; it is not a persistent ledger or audit system.

## Technology and project structure

- Java source and target level **23**, as configured in `pom.xml`
- Maven project with no application or test dependencies declared in the reviewed POM
- Java standard-library collections

```text
OOPS/
├── pom.xml
└── src/main/java/com/scaler/
    ├── BankAccount.java
    └── Main.java
```

The current source requires the compilation correction above before a runnable demonstration can be documented. No successful build, test execution, or sample runtime output is claimed here.

## Next iteration

1. Correct method placement and compile the project.
2. Define and implement validation rules before any balance mutation.
3. Clarify the public methods and remove the misleading account-name authorization check.
4. Choose a decimal money representation with explicit precision and rounding behavior.
5. Add a small demonstration in `Main` and automated tests for successful and rejected operations.
6. Consider a structured transaction type if the project grows beyond printed descriptions.

## About the developer

I am building Java backend skills through hands-on projects that connect business workflows to software concepts. This repository is a small, inspectable part of that journey: learning to model state, express rules, recognize edge cases, and improve correctness before expanding functionality.

[View my GitHub projects](https://github.com/FaiazS) · [Connect on LinkedIn](https://www.linkedin.com/in/faiazahmed22/)

