package arrayhelper.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

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
        //local code review (vtegza): only one method call per test method @ 21.04.15
        HashSet<PojoNumber> returnedValue = testClass.innerUnion(lArray, rArray);
        //assert returned value
        Assert.assertTrue(expectedValue.equals(returnedValue));

    }
}
