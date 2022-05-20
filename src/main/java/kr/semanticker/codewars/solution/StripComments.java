package kr.semanticker.codewars.solution;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StripComments {

    public static String NEW_LINE = "\n";
    public static String END_OF_LINE = "EOL";

    public static void main(String[] args) {

        String txt = "\n\nc\n\nd\n\necf\n\ne\n\n!\n\nfb\n\nf\n\n\n\n\nfea\n\nf\n\nabe\n\naa\n\nd\n\nede\n\nabf\n\nac\n\nb\n\n\n\n\nb\n\nb\n\n!abb\n\nc\n\nb\n\nb\n\n!!f\n\ncac\n\ne\n\n\n!bb\n\ne\n\nbf!\n\nb\n\nb!bb!\n\n!\n\ne\n\na\n\n\ncebc\n\nbedf\na\n\ne\n\ncd\n\nef\n\n\n\n\ne\n\ne\n\ncedd\n\na\n\nfd\n\nddc\n\n!cb\n\n!\n\ne\n\n\nc\n\n!\n\n\n\n\necf\n\nb\n\nb\n\nf\n\n!\n\nca\n\n!";

        String snitizedString = stripComments(txt, new String[]{"#", "$", "!", "-"});
        System.out.println(snitizedString);
    }

    public static String stripComments(String text, String[] commentSymbols) {

        for (String symbol : commentSymbols) {
            text = removeSymbol(text, symbol);
        }

        return text;
    }

    private static String removeSymbol(String text, String symbol) {

        text = text + NEW_LINE + END_OF_LINE;

        String pp = "\\s?[" + symbol + "!]\\s?";

        String [] aa = text.split(NEW_LINE);
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (String line : aa) {
            Matcher m = Pattern.compile(pp).matcher(line);
            if (m.find()) {
                temp = line.substring(0, m.start());
            } else {
                temp = line + "\n";
            }
            sb.append(temp.replaceAll("\\s+$", ""));
            sb.append(NEW_LINE);
        }

        return sb.substring(0, sb.toString().lastIndexOf(NEW_LINE + END_OF_LINE));

    }

    private static String removeSymbol3(String text, String symbol) {

        String [] splitedStrArray = text.split(NEW_LINE);

        StringBuilder sb = new StringBuilder();

        for (String txt : splitedStrArray) {

            int idxSymbol = txt.indexOf(symbol);

            if (idxSymbol == 0) {
                //sb.append(NEW_LINE+NEW_LINE);
                txt = NEW_LINE + NEW_LINE;
                //continue;
            } else if (txt.indexOf(symbol) > -1) {
                txt = txt.substring(0, txt.indexOf(symbol));
            }
            txt = txt.replaceAll("[ ]*$", "");
            sb.append(txt + NEW_LINE);
        }

        String resultStr = sb.toString();
        String removeLastNewLineStr = resultStr.substring(0, resultStr.lastIndexOf(NEW_LINE));
        return removeLastNewLineStr.replaceAll("[ ]*$", "");
    }

    private static String removeSymbol2(String text, String symbol) {

        String NEW_LINE = "\n";

        while (text.indexOf(symbol) > -1) {

            // index of symbol
            int idxSymbol = text.indexOf(symbol)-1;
            // index of newline
            int idxNewline = text.indexOf(NEW_LINE, idxSymbol)-1;

            if(idxSymbol==-1)
                break;

            if (idxSymbol > idxNewline) {
                text = text.substring(0, text.indexOf(symbol) - 1);
            } else {
                text = text.substring(0, text.indexOf(symbol) - 1) + text.substring(text.indexOf(NEW_LINE));
            }

        }
        return text;
    }
}
