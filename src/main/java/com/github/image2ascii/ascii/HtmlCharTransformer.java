package com.github.image2ascii.ascii;

public class HtmlCharTransformer implements CharTransformer {
    public String getString(Pair<Character, Integer> p) {
        return String.format("<span style=\"color:#%06x\">%c</span>", p.B.intValue(), p.A.charValue());
    }
}
