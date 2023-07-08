package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> ans = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            boolean add = false;
            for (String delimiter : delimiters) {
                if (Character.toString(source.charAt(i)).equals(delimiter)) {
                    if (current.length() > 0) {
                        ans.add(current.toString());
                        current = new StringBuilder();
                    }
                    add = true;
                }
            }
            if (!add ) {
                current.append(source.charAt(i));
            }
        }
        if (current.length() > 0) ans.add(current.toString());


        return ans;
    }
}