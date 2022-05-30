/* doesn't work with source level 1.8:
module com.mycompany.gamecenter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.gamecenter to javafx.fxml;
    exports com.mycompany.gamecenter;
}
*/
