package arrayhelper.exception;

/**
 * Created by ivann on 20.04.15.
 */
public class NullArrayRefException extends Exception{

    public static final String NULL_ARRAY_REF_ECODE_EXCEPTION = "Wrong parameter";
    public static final String NULL_ARRAY_LREF_MES_EXCEPTION = "Input param lArray reference is null";
    public static final String NULL_ARRAY_RREF_MES_EXCEPTION = "Input param rArray reference is null";
    public static final String NULL_ARRAY_REF_MES_EXCEPTION = "Input params lArray and rArray references are nulls";


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