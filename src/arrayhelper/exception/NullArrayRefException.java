package arrayhelper.exception;

/**
 * Created by ivann on 20.04.15.
 */
public class NullArrayRefException extends Exception{

    private String errorMessage;
    private String errorCode;

    public NullArrayRefException(String errorMessage, String errorCode) {
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