package br.com.moraes.prestadorservico.api.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("messages");
    }

    public static String getMessage(String key) {
        return getResourceBundle().getString(key);
    }
}
