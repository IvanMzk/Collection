package arrayhelper.builder;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ivan on 26.04.2015.
 */
public class MergeTest {

    /*
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
*/

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
}
