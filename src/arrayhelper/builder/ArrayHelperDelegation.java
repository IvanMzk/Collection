package arrayhelper.builder;

import arrayhelper.exception.InvalidDataException;
import arrayhelper.exception.NullArrayRefException;


import java.util.Collection;
import java.util.HashSet;


/**
 * Created by ivann on 20.04.15.
 */
public class ArrayHelperDelegation {

    private static final String INVALID_DATA_ECODE_EXCEPTION = "Invalid data";
    private static final String INVALID_DATA_EMPTY_NAME_EXCEPTION = "Field name is empty";
    private static final String INVALID_DATA_UNDEF_NAME_EXCEPTION = "Field name is null";

    private final ArrayHelper<PojoNumber> arrayHelper;

    public ArrayHelperDelegation(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }

    public HashSet<PojoNumber> merge(Collection<PojoNumber> lCollection, Collection<PojoNumber> rCollection)  throws NullArrayRefException, InvalidDataException
    {
        System.out.println("merge invocation");
        System.out.println("Left data:");
        System.out.println(lCollection == null ? null : lCollection.toString());
        System.out.println("Right data:");
        System.out.println(rCollection == null ? null : rCollection.toString());

        if (null != lCollection) {
            for (PojoNumber item : lCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        if (null != rCollection) {
            for (PojoNumber item : rCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        HashSet<PojoNumber> result = arrayHelper.merge(lCollection, rCollection);

        System.out.println("Result data:");
        System.out.println(result.toString());
        return result;
    }



    public HashSet<PojoNumber> innerUnion(Collection<PojoNumber> lCollection, Collection<PojoNumber> rCollection)  throws NullArrayRefException, InvalidDataException
    {

        System.out.println("innerUnion invocation");
        System.out.println("Left data:");
        System.out.println(lCollection == null ? null : lCollection.toString());
        System.out.println("Right data:");
        System.out.println(rCollection == null ? null : rCollection.toString());


        if (null != lCollection) {
            for (PojoNumber item : lCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        if (null != rCollection) {
            for (PojoNumber item : rCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        HashSet<PojoNumber> result = arrayHelper.innerUnion(lCollection, rCollection);

        System.out.println("Result data:");
        System.out.println(result.toString());
        return result;
    }

    public HashSet<PojoNumber> outerUnion(Collection<PojoNumber> lCollection, Collection<PojoNumber> rCollection)  throws NullArrayRefException, InvalidDataException
    {
        System.out.println("outerUnion invocation");
        System.out.println("Left data:");
        System.out.println(lCollection == null ? null : lCollection.toString());
        System.out.println("Right data:");
        System.out.println(rCollection == null ? null : rCollection.toString());

        if (null != lCollection) {
            for (PojoNumber item : lCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        if (null != rCollection) {
            for (PojoNumber item : rCollection) {
                String name = item.getName();
                if (null == name) {throw new InvalidDataException(INVALID_DATA_UNDEF_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
                if (name.equals("")) {throw new InvalidDataException(INVALID_DATA_EMPTY_NAME_EXCEPTION, INVALID_DATA_ECODE_EXCEPTION);}
            }
        }

        HashSet<PojoNumber> result = arrayHelper.outerUnion(lCollection, rCollection);

        System.out.println("Result data:");
        System.out.println(result.toString());
        return result;
    }



    public static void main(String[] args) {


    }

}
