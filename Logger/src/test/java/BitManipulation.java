public class BitManipulation {
    public static void main(String[] args) {
        long N = 0b10000000111;
        long M = 0b10010;
        long l1 = -1;
        int i =2,j=6;
        System.err.println(Long.toBinaryString(M<<i));
        System.err.println( Long.toBinaryString(l1<<j));
        System.err.println( Long.toBinaryString((1<<i)-1));
        long mask  = ((1<<i)-1) | (l1<<j) ;
        System.err.println( Long.toBinaryString((mask & N)|(M<<i)));
        System.err.println( Long.toBinaryString((1<<i)-1));
    }
}
