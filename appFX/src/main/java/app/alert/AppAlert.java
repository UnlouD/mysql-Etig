package app.alert;

/**
 * Created by Этигэл
 */
import javafx.scene.control.Alert;

public class AppAlert {

    private static Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    private static Alert alertWarning = new Alert(Alert.AlertType.WARNING);
    private static Alert alertError = new Alert(Alert.AlertType.ERROR);

    public void setAlertInfo(String title, String header, String content) {
        alertInfo.setTitle(title);
        alertInfo.setHeaderText(header);
        alertInfo.setContentText(content);
        alertInfo.showAndWait();
    }

    public void setAlertWarning(String title, String header, String content) {
        alertWarning.setTitle(title);
        alertWarning.setHeaderText(header);
        alertWarning.setContentText(content);
        alertWarning.showAndWait();
    }

    public void setAlertError(String title, String header, String content) {
        alertError.setTitle(title);
        alertError.setHeaderText(header);
        alertError.setContentText(content);
        alertError.showAndWait();
    }
}

