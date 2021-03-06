package arrayhelper.builder;

import arrayhelper.exception.InvalidDataException;
import arrayhelper.exception.NullArrayRefException;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by ivan on 26.04.2015.
 */
public class InnerUnionTest {


    private static final String[] NUMBER_NAME = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final int NUMBER_NAME_LEN = NUMBER_NAME.length;
    private static final String OTHER_NUMBERS_NAME = "Some";
    private static final int OTHER_NUMBERS_NAME_THRESHOLD = 100;
    private static final int EMPTY_NUMBERS_NAME_THRESHOLD = 200;


    private String getNumberName(int number){
        if (number <= NUMBER_NAME_LEN)
            return NUMBER_NAME[number-1];

        if (number <= OTHER_NUMBERS_NAME_THRESHOLD)
            return OTHER_NUMBERS_NAME;

        if (number <= EMPTY_NUMBERS_NAME_THRESHOLD)
            return "";

        return null;

    }

    //local code review (vtegza): use generics @ 27.04.15
    //local code review (vtegza): create input values in test method @ 27.04.15
    //local code review (vtegza): prefear plain input instead of generated inputs @ 27.04.15
    protected Collection getTestCollection(int[] array){

        if (null != array) {
            int i = 0;
            PojoNumber[] resultArray = new PojoNumber[array.length];
            for (int item : array) {
                resultArray[i] = new PojoNumber.PojoNumberBuilder(item)
                        .name(getNumberName(item))
                        .build();
                i++;
            }
            return Arrays.asList(resultArray);
        }
        else
            return null;

    }

    @Test
    public void testInnerUnion() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1,5,4,23,65,32,78,1});
        Collection rArray = getTestCollection(new int[]{3,5,24,4,1,2,34,45,32,5,32});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        HashSet<PojoNumber> expectedValue = new HashSet<PojoNumber>(getTestCollection(new int[]{5,4,32,1}));

        //ivoke method on class to test
        HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
        //assert returned value
        //local code review (vtegza): use assertEquals @ 27.04.15
        assertTrue(expectedValue.equals(returnedValue));

    }

    @Test
    public void testInnerUnionLeftEmpty() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{});
        Collection rArray = getTestCollection(new int[]{3,5,24,4,1,2,34,45,32,5,32});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        HashSet<PojoNumber> expectedValue = new HashSet<PojoNumber>(getTestCollection(new int[]{}));

        //ivoke method on class to test
        HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
        //assert returned value
        //local code review (vtegza): use assertEquals @ 27.04.15
        assertTrue(expectedValue.equals(returnedValue));
    }

    @Test
    public void testInnerUnionRightEmpty() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1,5,4,23,65,32,78,1});
        Collection rArray = getTestCollection(new int[]{});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        HashSet<PojoNumber> expectedValue = new HashSet<PojoNumber>(getTestCollection(new int[]{}));

        //ivoke method on class to test
        HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
        //assert returned value
        //local code review (vtegza): use assertEquals @ 27.04.15
        assertTrue(expectedValue.equals(returnedValue));
    }


    @Test
     public void testInnerUnionLeftNull() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(null);
        Collection rArray = getTestCollection(new int[]{3,5,24,4,1,2,34,45,32,5,32});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Wrong parameter";

        //ivoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(NullArrayRefException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            //local code review (vtegza): use assertEquals @ 27.04.15
            assertTrue(expectedValue.equals(e.getErrorCode()));
        }
    }

    @Test
    public void testInnerUnionRightNull() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[] {1,5,4,23,65,32,78,1});
        Collection rArray = getTestCollection(null);

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Wrong parameter";

        //ivoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(NullArrayRefException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            assertTrue(expectedValue.equals(e.getErrorCode()));
        }
    }

    @Test
    public void testInnerUnionEmptyFieldInLeft() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1, 5, 4, 23, 65, 32, 78,102});
        Collection rArray = getTestCollection(new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Invalid data";

        //invoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(InvalidDataException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            //local code review (vtegza): use assertEquals @ 27.04.15
            assertTrue(expectedValue.equals(e.getErrorCode()));

        }
    }

    @Test
    public void testInnerUnionEmptyFieldInRight() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1, 5, 4, 23, 65, 32, 78});
        Collection rArray = getTestCollection(new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24,102});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Invalid data";

        //invoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(InvalidDataException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            //local code review (vtegza): use assertEquals @ 27.04.15
            assertTrue(expectedValue.equals(e.getErrorCode()));

        }
    }

    @Test
    public void testInnerUnionNullFieldInLeft() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1, 5, 4, 23, 65, 32, 78,202});
        Collection rArray = getTestCollection(new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Invalid data";

        //invoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(InvalidDataException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            //local code review (vtegza): use assertEquals @ 27.04.15
            assertTrue(expectedValue.equals(e.getErrorCode()));

        }
    }

    @Test
    public void testInnerUnionNullFieldInRight() throws Exception {

        //init input variables
        Collection lArray = getTestCollection(new int[]{1, 5, 4, 23, 65, 32, 78});
        Collection rArray = getTestCollection(new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24,202});

        //init class to test
        ArrayHelper resource = new ArrayHelper();
        ArrayHelperDelegation testClass = new ArrayHelperDelegation(resource);

        //init expected value
        String expectedValue = "Invalid data";

        //ivoke method on class to test
        try {
            //local code review (vtegza): no need for return value @ 27.04.15
            HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
            fail("Exception expected");
        }
        catch(InvalidDataException e)
        {
            //assert returned value
            System.out.println(e.getErrorMessage());
            //local code review (vtegza): use assertEquals @ 27.04.15
            assertTrue(expectedValue.equals(e.getErrorCode()));

        }
    }





}
