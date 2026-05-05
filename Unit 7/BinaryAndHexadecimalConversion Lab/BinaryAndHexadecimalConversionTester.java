public class BinaryAndHexadecimalConversionTester {
    public static void main(String[] args) {
        System.out.println(BinaryAndHexadecimalConversion.convertIntToBinary(4315));
        System.out.println(BinaryAndHexadecimalConversion.convertBinaryToInt("1000011011011"));
        System.out.println(BinaryAndHexadecimalConversion.convertIntToHexadecimal(4315));
        System.out.println(BinaryAndHexadecimalConversion.convertHexadecimalToInt("10DB"));
        System.out.println(BinaryAndHexadecimalConversion.convertHexadecimalToBinary("10DB"));
        System.out.println(BinaryAndHexadecimalConversion.convertBinaryToHexadecimal("1000011011011"));
        System.out.println(BinaryAndHexadecimalConversion.convertStringToInt("0b1000011011011"));
        System.out.println(BinaryAndHexadecimalConversion.convertStringToInt("0x10DB"));
        System.out.println(BinaryAndHexadecimalConversion.convertStringToInt("4315"));
    }
}
