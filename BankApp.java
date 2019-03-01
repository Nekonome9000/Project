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

  private BankAccount account;
  private TextField balanceTxf;
  private Label balanceLbl;

  public static void main(String[] args){
     launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception{
    this.account = new BankAccount();
    Pane root = new Pane();

    balanceLbl = new Label("Balance: " + account.getBalance());
    balanceLbl.setLayoutX(160);
    balanceLbl.setLayoutY(30);

    Label customerLbl = new Label("Account Holder: ");
    customerLbl.setLayoutX(120);
    customerLbl.setLayoutY(10);

    Label amountLbl = new Label("Enter Amount: ");
    amountLbl.setLayoutX(50);
    amountLbl.setLayoutY(94);

    balanceTxf = new TextField();
    balanceTxf.setPrefWidth(190);
    balanceTxf.setLayoutX(150);
    balanceTxf.setLayoutY(90);

    // deposit button
    Button depositBtn = new Button();
    depositBtn.setText("Deposit");
    depositBtn.setLayoutX(136);
    depositBtn.setLayoutY(160);
    depositBtn.setOnAction(new EventHandler<ActionEvent>(){

      @Override
      public void handle(ActionEvent event){
          double d = Double.valueOf(balanceTxf.getText());
          account.deposit(d);
          balanceLbl.setText("Balance: " + account.getBalance());
      }
    });

    // withdraw button
    Button withdrawBtn = new Button();
    withdrawBtn.setText("Withdraw");
    withdrawBtn.setLayoutX(208);
    withdrawBtn.setLayoutY(160);
    withdrawBtn.setOnAction(new EventHandler<ActionEvent>(){

      @Override
      public void handle(ActionEvent event){
        double w = Double.valueOf(balanceTxf.getText());
        account.withdraw(w);
        balanceLbl.setText("Balance: " + account.getBalance());

      }
    });

    root.getChildren().add(depositBtn,withdrawBtn,balanceLbl,customerLbl,amountLbl,balanceTxf);
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
