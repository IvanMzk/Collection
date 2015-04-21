package arrayhelper.builder;

import arrayhelper.exception.InvalidDataException;
import arrayhelper.exception.NullArrayRefException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static arrayhelper.exception.InvalidDataException.INVALID_DATA_ECODE_EXCEPTION;
import static arrayhelper.exception.NullArrayRefException.NULL_ARRAY_REF_ECODE_EXCEPTION;
import static org.junit.Assert.*;


public class ArrayInnerUnionTest {


    private static final String[] NUMBER_NAME = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final int NUMBER_NAME_LEN = NUMBER_NAME.length;
    private static final String OTHER_NUMBERS_NAME = "Some";
    private static final int OTHER_NUMBERS_NAME_THRESHOLD = 100;
    private static final int EMPTY_NUMBERS_NAME_THRESHOLD = 200;


    private String GetNumberName(int number){
        if (number <= NUMBER_NAME_LEN)
            return NUMBER_NAME[number-1];

        if (number <= OTHER_NUMBERS_NAME_THRESHOLD)
            return OTHER_NUMBERS_NAME;

        if (number <= EMPTY_NUMBERS_NAME_THRESHOLD)
            return "";

        return null;

    }


    protected PojoNumber[] GetTestArray(int[] array){

        if (null != array) {
            int i = 0;
            PojoNumber[] resultArray = new PojoNumber[array.length];
            for (int item : array) {
                resultArray[i] = new PojoNumber.PojoNumberBuilder(item)
                        .name(GetNumberName(item))
                        .build();
                i++;
            }
            return resultArray;
        }
        else
            return null;

    }

    @Test
    public void testArraysInnerUnion() throws Exception {

        //init input variables
        PojoNumber[] lArray = GetTestArray(new int[]{1,5,4,23,65,32,78,1});
        PojoNumber[] rArray = GetTestArray(new int[]{3,5,24,4,1,2,34,45,32,5,32});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        HashSet<PojoNumber> expectedValue = new HashSet<PojoNumber>(Arrays.asList(GetTestArray(new int[]{5,4,32,1})));

        //ivoke method on class to test
        //local code review (vtegza): only one method call per test method @ 21.04.15
        HashSet<PojoNumber> returnedValue = testClass.arraysInnerUnion(lArray, rArray);
                //assert returned value
        Assert.assertTrue(expectedValue.equals(returnedValue));

    }
}