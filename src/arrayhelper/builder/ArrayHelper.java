package arrayhelper.builder;

import arrayhelper.exception.NullArrayRefException;

import java.util.Arrays;
import java.util.Comparator;

import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_LREF_MES_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_REF_ECODE_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_REF_MES_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_RREF_MES_EXCEPTION;

/**
 * Created by ivann on 20.04.15.
 */
public class ArrayHelper {

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of merging without duplicates of lArray and rArray
     *
     */

    public PojoNumber[] arraysMerge(PojoNumber[] lArray, PojoNumber[] rArray) throws NullArrayRefException
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
        PojoNumber[] tmpArray = Arrays.copyOf(lArray, lLenght + rLenght);
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        Arrays.sort(lArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) < 0){
                tmpArray[rIndex] = rItem;
                rIndex++;
            }
        }
        //local code review (vtegza): no need for null here, inline it @ 21.04.15
        PojoNumber[] resultArray = null;
        resultArray = Arrays.copyOfRange(tmpArray, 0, rIndex);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
    }

    /**
     *
     * @param array should be sorted
     * @return input array without dublicates
     */


    private PojoNumber[] deleteDublicates(PojoNumber[] array) throws NullArrayRefException
    {

        if (null == array)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        final int length = array.length;

        if (length >= 2)
        {
            int tmpIndex = 0;
            boolean isEqualsSequence = false;
            PojoNumber[] tmpArray = new PojoNumber[length];

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


            PojoNumber[] resultArray = null;
            resultArray = Arrays.copyOfRange(tmpArray, 0, tmpIndex);

            return resultArray;
        }
        else {return array;}
    }
    

}
