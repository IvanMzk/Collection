package arrayhelper.builder;

/**
 * Created by ivann on 20.04.15.
 */
final public class PojoNumber implements Comparable<PojoNumber> {

    private final int number;   //mandatory
    private final String name;        //optional

    private PojoNumber(PojoNumberBuilder builder)
    {
        this.number = builder.number;
        this.name = builder.name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PojoNumber)) return false;

        PojoNumber that = (PojoNumber) o;

        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number)+"/"+name;
    }

    public int compareTo(PojoNumber o){

        if (equals(o)){return 0;}
        if (number > o.getNumber()){return 1;}

        return -1;
    }

    public static class PojoNumberBuilder{

        private final int number;
        private String name;

        public PojoNumberBuilder(int number) {
            this.number = number;
        }

        public PojoNumberBuilder name(String name){
            this.name = name;
            return this;
        }

        public PojoNumber build(){
            return new PojoNumber(this);
        }
    }

}