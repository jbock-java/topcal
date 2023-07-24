package io.jbock.cal;

// https://en.wikipedia.org/wiki/ANSI_escape_code
class AnsiCode {

    private static final char ESC = 0x1B;
    private static final String CSI = ESC + "[";
    private static final String INVERT = CSI + "48;5;11m";
    private static final String RESET = CSI + "m";

    static String highlight(String text) {
        if (text.startsWith(" ")) {
            return " " + INVERT + text.substring(1) + RESET;
        }
        return INVERT + text + RESET;
    }
}
