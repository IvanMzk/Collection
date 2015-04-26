package arrayhelper.exception;

/**
 * Created by ivann on 20.04.15.
 */
public class InvalidDataException extends Exception {

    private String errorMessage;
    private String errorCode;

    public InvalidDataException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
