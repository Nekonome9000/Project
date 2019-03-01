public class BankAccount{
  private double balance;
  private String accountNumber;
  private Customer accountHolder;

  /**
   * gets this account's balance
   */
  public double getBalance(){
    return balance;
  }

  /**
   * gets this account's number
   */
  public String getAccountNumber(){
    return accountNumber;
  }
  
  /**
   * gets the customer acting as account holder
   *
   * potential privacy leak; returns account holder Customer object's direct address
   */
  public Customer getAccountHolder(){
    return accountHolder;
  }

  /**
   * returns formatted string of this account holder's name, ID and this bank account's balance and number
   */
  public String toString(){
    return "("+accountHolder+") " + accountNumber + ": " + balance;
  }

  /**
   * adds positive amount to this account's balance
   */
  public void deposit(double cash){
    if (cash > 0.0)balance += cash;
  }

  /**
   * removes positive amount from this account's balance
   * prevents removal if it results in a negative balance
   */
  public void withdraw(double cash){
    if ((cash > 0.0) && (cash <= balance) && (balance > 0.0))balance -= cash;
  }

  /**
   * withdraws positive amount from this account into a given account
   * prevents transaction if it results in a negative balance
   *
   * potential privacy leak; 
   */
  public void transfer(double amount, BankAccount otherBankAccount){
    if (amount > 0.0 && amount <= this.balance){
      withdraw(amount);
      otherBankAccount.deposit(amount);
    }
  }

  /**
   * sets this account's account holder
   *
   * potential privacy leak; account holder Customer object must be declared outside of this method
   * thus reference to Customer object may exist outside of this account
   */
  public void setAccountHolder(Customer newAccountHolder){
    this.accountHolder = newAccountHolder;
  }

  /**
   * default constructor
   * sets balance to 0.0 and account number to "8888"
   */
  public BankAccount(){
    this(0.0);
  }

  /**
   * constructor given starting balance
   * sets account number to "8888"
   */
  public BankAccount(double balance){
    this(balance, "8888");
  }

  /**
   * constructor given starting balance and accountNumber
   */
  public BankAccount(double balance, String accountNumber){
    this.balance = balance;
    this.accountNumber = accountNumber;
  }

  /**
   * constructor given starting balance and the account holder
   *
   * potential privacy leak; account holder Customer object must be declared outside of constructor
   * thus reference to Customer object may exist outside of this account
   */
  public BankAccount(Customer accountHolder, double balance){
    setAccountHolder(accountHolder);
    this.balance = balance;
  }

  /**
   * copy constructor
   * copies balance, account number and account holder
   * 
   * potential privacy leak; this copy account's account holder references same Customer object as the account to copy from
   */
  public BankAccount(BankAccount copy){
    this.balance = copy.balance;
    this.accountNumber = copy.accountNumber;
    this.accountHolder = copy.accountHolder;
  }
}
