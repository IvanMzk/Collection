package arrayhelper.builder;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.*;

import arrayhelper.exception.NullArrayRefException;
import arrayhelper.exception.InvalidDataException;
import static arrayhelper.exception.NullArrayRefException.*;
import static arrayhelper.exception.InvalidDataException.*;

@RunWith(Parameterized.class)
public class ArrayHelperDelegationTest {

    private int[] lArray;
    private int[] rArray;
    private int[] expectedValue;
    private String expectedErrorCode;

    private static final String[] NUMBER_NAME = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final int NUMBER_NAME_LEN = NUMBER_NAME.length;
    private static final String OTHER_NUMBERS_NAME = "Some";
    private static final int OTHER_NUMBERS_NAME_THRESHOLD = 100;
    private static final int EMPTY_NUMBERS_NAME_THRESHOLD = 200;

    public ArrayHelperDelegationTest(int[] lArray, int[] rArray, int[] expectedValue, String expectedErrorCode) {
        this.lArray = lArray;
        this.rArray = rArray;
        this.expectedValue = expectedValue;
        this.expectedErrorCode = expectedErrorCode;
    }

    private String GetNumberName(int number){
        if (number <= NUMBER_NAME_LEN)
            return NUMBER_NAME[number-1];

        if (number <= OTHER_NUMBERS_NAME_THRESHOLD)
            return OTHER_NUMBERS_NAME;

        if (number <= EMPTY_NUMBERS_NAME_THRESHOLD)
            return "";

        return null;

    }

    private PojoNumber[] GetTestArray(int[] array){

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

    private boolean CompareTestArrays(PojoNumber[] test, PojoNumber[] etalon){

        Comparator<PojoNumber> comparator = new NumberComparator();
        Arrays.sort(test, comparator);
        Arrays.sort(etalon, comparator);

        return Arrays.equals(test, etalon);

    }

    private boolean hasInvalidData(PojoNumber[] array)
    {
        for (PojoNumber item : array) {
            String name = item.getName();
            if ("" == name || null == name) {return true;}
        }
        return false;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        Object[][] data = new Object[][]{
                {new int[]{1, 5, 4, 23, 65, 32, 78}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45}, null},
                {new int[]{}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32}, null},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, new int[]{}, new int[]{1, 5, 4, 23, 65, 32, 78}, null},
                {null, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, null, NULL_ARRAY_REF_ECODE_EXCEPTION},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, null,  null, NULL_ARRAY_REF_ECODE_EXCEPTION},
                {new int[]{1, 5, 4, 23, 65, 32, 78,102}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45,102}, INVALID_DATA_ECODE_EXCEPTION},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24,102}, new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45,102}, INVALID_DATA_ECODE_EXCEPTION},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24,202}, new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45,202}, INVALID_DATA_ECODE_EXCEPTION},
                {new int[]{1, 5, 4, 23, 65, 32, 78,202}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45,202}, INVALID_DATA_ECODE_EXCEPTION},

        };

        return Arrays.asList(data);
    }


    @Test
    public void testArraysMerge() throws Exception {

        //init input variables
        PojoNumber[] lArray = GetTestArray(this.lArray);
        PojoNumber[] rArray = GetTestArray(this.rArray);

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        if (null != lArray && null != rArray) {
            if (!hasInvalidData(lArray) && !hasInvalidData(rArray)) {
                //init expected value
                PojoNumber[] expectedValue = GetTestArray(this.expectedValue);

                //ivoke method on class to test
                PojoNumber[] returnedValue = testClass.arraysMerge(lArray, rArray);

                //assert returned value
                Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));
            }
            else{
                String expectedValue = this.expectedErrorCode;
                try{
                    PojoNumber[] returnedValue = testClass.arraysMerge(lArray, rArray);
                    fail("Exception should be thrown");
                }
                catch(InvalidDataException e){
                    Assert.assertEquals(e.getErrorCode(), expectedValue);
                    System.out.println(e.getErrorMessage());
                }
            }
        }
        else
        {
            String expectedValue = this.expectedErrorCode;
            try{
                PojoNumber[] returnedValue = testClass.arraysMerge(lArray, rArray);
                fail("Exception should be thrown");
            }
            catch(NullArrayRefException e){
                Assert.assertEquals(e.getErrorCode(), expectedValue);
                System.out.println(e.getErrorMessage());
            }

        }

    }
}