package arrayhelper.builder;

import arrayhelper.exception.NullArrayRefException;

import java.util.Arrays;

/**
 * Created by ivann on 20.04.15.
 */
public class ArrayHelperDelegation {

    private final ArrayHelper arrayHelper;

    public ArrayHelperDelegation(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }

    public PojoNumber[] arraysMerge(PojoNumber[] lArray, PojoNumber[] rArray) throws NullArrayRefException
    {
        System.out.println("Left array:");
        System.out.println(Arrays.toString(lArray));
        System.out.println("Right array:");
        System.out.println(Arrays.toString(rArray));

        PojoNumber[] result = arrayHelper.arraysMerge(lArray, rArray);

        System.out.println("Result array:");
        System.out.println(Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) {


    }

}
