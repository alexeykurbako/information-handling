package com.epam.infoHandling.composite;

import java.util.List;

public interface Component {
    void add(Component component);
    String getValue();
    List<Component> getChildren();
}
