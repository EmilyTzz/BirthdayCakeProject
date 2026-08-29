module emily.birthday_cake.birthdaycakeproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens emily.birthday_cake.birthdaycakeproject to javafx.fxml;
    exports emily.birthday_cake.birthdaycakeproject;
}