package com.epam.infoHandling.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> children;

    public Composite() {
        children = new ArrayList<>();
    }

    public void add(Component component) {
        children.add(component);
    }
    @Override
    public String getValue() {
        StringBuilder text = new StringBuilder();
        for (Component component: children){
            text.append(component.getValue()).append(" ");
        }
        return text.toString();
    }
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(children, composite.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "children=" + children +
                '}';
    }
}
