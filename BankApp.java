import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BankApp extends Application{

  /*
  *Instance variables
  **/
  private BankAccount account;
  private TextField balanceTxf;
  private Label balanceLbl;

  public static void main(String[] args)
  {
     launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception{

    /*
    * new BankAccount creates a Bank Account object in which
    * it is assigned to the instance variable account.
    **/
    this.account = new BankAccount();
    Pane root = new Pane();

    /*
    *This block of code is to create a button called Deposit.
    **/
    Button depositBtn = new Button();
    depositBtn.setText("Deposit");
    depositBtn.setLayoutX(136);
    depositBtn.setLayoutY(160);

    /*
    * This block of code is to create a button called withdraw.
    **/
    Button withdrawBtn = new Button();
    withdrawBtn.setText("Withdraw");
    withdrawBtn.setLayoutX(208);
    withdrawBtn.setLayoutY(160);

    /*
    * This block of code creates a lable the displays Balance and
    * the balance from the BankAccount class.
    **/
    balanceLbl = new Label("Balance: " + (account.getBalance()));
    balanceLbl.setLayoutX(160);
    balanceLbl.setLayoutY(30);

    /*
    * Code that creates a lable that displays Account Holder and
    * the name of the account holder from the BankAccount class.
    **/
    Label customerLbl = new Label("Account Holder: " + (account.getAccountHolder()));
    customerLbl.setLayoutX(120);
    customerLbl.setLayoutY(10);

    /*
    * lable that displays Enter Amount
    **/
    Label amountLbl = new Label("Enter Amount: ");
    amountLbl.setLayoutX(50);
    amountLbl.setLayoutY(94);

    /*
    * Creates a Textfield so that user can enter thier desired balance
    **/
    balanceTxf = new TextField();
    balanceTxf.setPrefWidth(190);
    balanceTxf.setLayoutX(150);
    balanceTxf.setLayoutY(90);

    /*
    * The block of code takes in the input from TextField,
    * converts it to a double and allows use of the deposite button,
    * it would deposite the input into the BankAccount class and
    * display the new BankAccount balance.
    **/
    depositBtn.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent e){
          double d = Double.valueOf(balanceTxf.getText());
          account.deposit(d);
          balanceLbl.setText("Balance: " + account.getBalance());
      }
    });

    /*
    * The block of code takes in the input from the TextField,
    * converts it to a double and allows use of the withdraw button
    * it will withdraw the input from the Bankaccount class and
    * display the new Bank balance.
    **/
    withdrawBtn.setOnAction(new EventHandler<ActionEvent>(){

      @Override
      public void handle(ActionEvent e){
        double w = Double.valueOf(balanceTxf.getText());
        account.withdraw(w);
        balanceLbl.setText("Balance: " + account.getBalance());
      }
    });


    root.getChildren().add(depositBtn);
    root.getChildren().add(withdrawBtn);
    root.getChildren().add(balanceLbl);
    root.getChildren().add(customerLbl);
    root.getChildren().add(amountLbl);
    root.getChildren().add(balanceTxf);

    Scene scene = new Scene(root, 400, 200);
    primaryStage.setTitle("Bank App");
    primaryStage.setScene(scene);


    primaryStage.show();
  }
}
