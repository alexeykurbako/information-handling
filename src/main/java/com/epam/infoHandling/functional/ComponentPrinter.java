package com.epam.infoHandling.functional;

import com.epam.infoHandling.composite.Component;

public class ComponentPrinter {

    public String parseToString(Component component) {
        String text = "\t";
        text += component.getValue();

        text = text.replace("   ", "\n\t");
        text = text.replace("  ", " ");

        return text;
    }
}
