import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Thiet lap giao dien GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Tao cac thanh phan
        Label lblSo1 = new Label("So thu nhat:");
        grid.add(lblSo1, 0, 0);
        TextField txtSo1 = new TextField();
        grid.add(txtSo1, 1, 0);

        Label lblSo2 = new Label("So thu hai:");
        grid.add(lblSo2, 0, 1);
        TextField txtSo2 = new TextField();
        grid.add(txtSo2, 1, 1);

        Label lblKetQua = new Label("Ket qua:");
        grid.add(lblKetQua, 0, 2);
        Label lblDisplayResult = new Label("---");
        grid.add(lblDisplayResult, 1, 2);

        Button btnTinhTong = new Button("Tinh tong");
        grid.add(btnTinhTong, 1, 3);

        // Xu ly su kien nut bam
        btnTinhTong.setOnAction(e -> {
            try {
                double so1 = Double.parseDouble(txtSo1.getText());
                double so2 = Double.parseDouble(txtSo2.getText());
                double tong = so1 + so2;
                lblDisplayResult.setText(String.valueOf(tong));
            } catch (NumberFormatException ex) {
                lblDisplayResult.setText("Loi!");
            }
        });

        // Hien thi cua so
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("May Tinh Cong");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}