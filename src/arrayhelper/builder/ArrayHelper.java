package arrayhelper.builder;

import arrayhelper.exception.NullArrayRefException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_LREF_MES_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_REF_ECODE_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_REF_MES_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_RREF_MES_EXCEPTION;

/**
 * Created by ivann on 20.04.15.
 */
public class ArrayHelper<T> {

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of merging without duplicates of lArray and rArray
     *
     */

    public T[] arraysMerge(T[] lArray, T[] rArray) throws NullArrayRefException
    {
        //local code review (vtegza): use automatic code formatter @ 21.04.15
        //local code review (vtegza): conside check object == null @ 21.04.15
        if (null == lArray && null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lArray)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}


        final int lLenght = lArray.length;
        final int rLenght = rArray.length;

        int rIndex = lLenght;
        T[] tmpArray = Arrays.copyOf(lArray, lLenght + rLenght);
        T[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        Comparator<T> numberComparator = new NumberComparator();
        Arrays.sort(lArraySorted,numberComparator);

        for (T rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) < 0){
                tmpArray[rIndex] = rItem;
                rIndex++;
            }
        }
        //local code review (vtegza): no need for null here, inline it @ 21.04.15
        T[] resultArray = null;
        resultArray = Arrays.copyOfRange(tmpArray, 0, rIndex);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
    }



    public HashSet<T> arraysInnerUnion(T[] lArray, T[] rArray) throws NullArrayRefException
    {
        if (null == lArray && null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lArray)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}



        HashSet<T> result = new HashSet(Arrays.asList(lArray));
        result.retainAll(Arrays.asList(rArray));




        return result;

    }

    /**
     *
     * @param array should be sorted
     * @return input array without dublicates
     */


    @SuppressWarnings({"unchecked"})
    private T[] deleteDublicates(T[] array) throws NullArrayRefException
    {

        if (null == array)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        final int length = array.length;

        if (length >= 2)
        {
            int tmpIndex = 0;
            boolean isEqualsSequence = false;
            //T[] tmpArray = new T[length];
            Class newType = array.getClass();
            Class elementType = newType.getComponentType();
            T[] tmpArray = Array.newInstance(elementType,length);

            for (int i = 0; i < length-1; i++) {
                if (array[i].equals(array[i+1]))
                {
                    if (!isEqualsSequence)
                    {
                        tmpArray[tmpIndex] = array[i];
                        tmpIndex++;
                        isEqualsSequence = true;
                    }
                }
                else
                {
                    if (isEqualsSequence) {
                        isEqualsSequence = false;
                        if (length-2 == i)
                        {
                            tmpArray[tmpIndex] = array[length-1];
                            tmpIndex++;
                        }
                    }
                    else {
                        tmpArray[tmpIndex] = array[i];
                        tmpIndex++;
                        if (length-2 == i)
                        {
                            tmpArray[tmpIndex] = array[length-1];
                            tmpIndex++;
                        }
                    }
                }
            }


            T[] resultArray = null;
            resultArray = Arrays.copyOfRange(tmpArray, 0, tmpIndex);

            return resultArray;
        }
        else {return array;}
    }

    private T[] new
    

}
