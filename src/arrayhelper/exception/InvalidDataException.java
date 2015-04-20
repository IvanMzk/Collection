package arrayhelper.exception;

/**
 * Created by ivann on 20.04.15.
 */
public class InvalidDataException extends Exception {

    public static final String INVALID_DATA_ECODE_EXCEPTION = "Invalid data";
    public static final String INVALID_DATA_EMPTY_NAME_EXCEPTION = "Field name is empty";
    public static final String INVALID_DATA_UNDEF_NAME_EXCEPTION = "Field name is null";


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
