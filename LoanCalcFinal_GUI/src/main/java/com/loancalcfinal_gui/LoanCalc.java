package com.loancalcfinal_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoanCalc extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoanCalc.class.getResource("hello-view.fxml"));

        Text yearlyInterest = new Text("Annual Interest Rate:");
        Text numYears = new Text("Number of Years:");
        Text loanAmount = new Text("Loan Amount:");
        Text monthlyPayment = new Text("Monthly Payment:");
        Text totalPayment = new Text("Total Payment:");

        TextField yearlyInterestField = new TextField();
        TextField numYearsField = new TextField();
        TextField loanAmountField = new TextField();
        TextField monthlyPaymentField = new TextField();
        TextField totalPaymentField = new TextField();

        monthlyPaymentField.setEditable(false);
        totalPaymentField.setEditable(false);

        Button btn = new Button("Calculate!");

        btn.setOnAction(e -> {
            double yI = getNum(yearlyInterestField) / 100;
            double nY = getNum(numYearsField);
            double lA = getNum(loanAmountField);
            monthlyPaymentField.setText(String.format("$%.2f", ((lA * yI * nY)/12)));
            totalPaymentField.setText(String.format("$%.2f", (lA * yI * nY) + lA));
        });

        GridPane pane = new GridPane();
        pane.addRow(0, yearlyInterest, yearlyInterestField);
        pane.addRow(1, numYears, numYearsField);
        pane.addRow(2, loanAmount, loanAmountField);
        pane.addRow(3, monthlyPayment, monthlyPaymentField);
        pane.addRow(4, totalPayment, totalPaymentField);
        pane.add(btn,1,5);
        pane.setVgap(6);
        pane.setHgap(6);
        pane.setPadding(new Insets(6));
        GridPane.setHalignment(btn, HPos.RIGHT);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();
    }
    private static double getNum(TextField t){return Double.parseDouble(t.getText());
    }
    public static void main(String[] args) {
        launch();
    }
}