package com.MVCDemo;

import java.io.IOException;

public class PlayingWithParsing{
    public static void main(String[] args) throws IOException {
        doTest("-1", Integer.class);
        doTest("-1", Double.class);
        doTest("1.0", Double.class);
        doTest(".1", Double.class);
        doTest("1.", Integer.class);
        doTest("1.0", Integer.class);
        doTest("1.", Double.class);
        doTest("-", Double.class);
        doTest("-", Integer.class);
        doTest("-.1", Double.class);
        System.in.read();
    }

    private static void doTest(String test, Class<? extends Number> parsingClass) {
        System.out.println(parsingClass.getSimpleName() + ".parse('" + test + "') is " + parseOrException(test, parsingClass));
    }

    private static String parseOrException(String parsable, Class<? extends Number> numberFormat) {
        if(canParse(parsable, numberFormat)){
            return "" + appropriateParseFor(parsable, numberFormat);
        }
        else{
            return "exception";
        }

    }

    private static boolean canParse(String text, Class<? extends Number> numberFormat){
        try{
            appropriateParseFor(text, numberFormat);
            return true;
        }
        catch (NumberFormatException exception){
            return false;
        }
    }

    private static Number appropriateParseFor(String text, Class<? extends Number> numberFormat) throws NumberFormatException {
        if(numberFormat == Long.class){
            return Long.parseLong(text);
        }
        else if(numberFormat == Integer.class){
            return Integer.parseInt(text);
        }
        else if(numberFormat == Double.class){
            return Double.parseDouble(text);
        }
        else if(numberFormat == Float.class){
            return Float.parseFloat(text);
        }
        else{
            throw new RuntimeException("cant figure out appropriate number format");
        }
    }
}
