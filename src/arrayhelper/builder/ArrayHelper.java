package arrayhelper.builder;

import arrayhelper.exception.NullArrayRefException;


import java.util.*;


public class ArrayHelper<T> {


    private static final String NULL_ARRAY_REF_ECODE_EXCEPTION = "Wrong parameter";
    private static final String NULL_ARRAY_LREF_MES_EXCEPTION = "Input param lArray reference is null";
    private static final String NULL_ARRAY_RREF_MES_EXCEPTION = "Input param rArray reference is null";
    private static final String NULL_ARRAY_REF_MES_EXCEPTION = "Input params lArray and rArray references are nulls";


    public HashSet<T> merge(Collection<T> lCollection, Collection<T> rCollection) throws NullArrayRefException
    {
        if (null == lCollection && null == rCollection)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lCollection)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rCollection)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        HashSet<T> result = new HashSet<T>(lCollection);
        result.addAll(rCollection);

        return result;


    }

    public HashSet<T> innerUnion(Collection<T> lCollection, Collection<T> rCollection) throws NullArrayRefException
    {
        if (null == lCollection && null == rCollection)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lCollection)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rCollection)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        HashSet<T> result = new HashSet(lCollection);
        result.retainAll(rCollection);

        return result;

    }

    public HashSet<T> outerUnion(Collection<T> lCollection, Collection<T> rCollection) throws NullArrayRefException
    {
        HashSet<T> result = merge(lCollection, rCollection);
        result.removeAll(innerUnion(lCollection, rCollection));
        return result;
    }

}
