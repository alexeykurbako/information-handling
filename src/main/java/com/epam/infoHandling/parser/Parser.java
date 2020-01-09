package com.epam.infoHandling.parser;

import com.epam.infoHandling.composite.Component;

public interface Parser {
    Component parse(String text);
}
