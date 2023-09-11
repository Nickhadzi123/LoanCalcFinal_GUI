module com.loancalcfinal_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.loancalcfinal_gui to javafx.fxml;
    exports com.loancalcfinal_gui;
}