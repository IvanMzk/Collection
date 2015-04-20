package arrayhelper.builder;

import java.util.Comparator;

/**
 * Created by ivann on 20.04.15.
 */
public class NumberComparator implements Comparator<PojoNumber> {

    public int compare(PojoNumber o1, PojoNumber o2){

        if (o1.equals(o2)){return 0;}
        if (o1.getNumber() > o2.getNumber()){return 1;}

        return -1;
    }
}