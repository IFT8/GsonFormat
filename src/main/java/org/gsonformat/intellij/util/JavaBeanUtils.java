package org.gsonformat.intellij.util;

/**
 * Created by IFT8 on 2017/6/19.
 */
public class JavaBeanUtils {
    private JavaBeanUtils() {
    }

    /**
     * 转驼峰
     */
    public static String getCamelCaseString(String inputString,
                                            boolean firstCharacterUppercase) {
        //忽略
        if (!inputString.contains("_") && !inputString.contains("$")) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
                case '_':
                case '$':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;

                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }
}
