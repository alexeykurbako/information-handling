package com.epam.infoHandling.functional;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;

import java.util.List;

public class ComponentCloner {

    public Component clone(Component parentComponent) {
        Component component;

        try {
            List<Component> components = parentComponent.getChildren();
            component = new Composite();
            for (Component composite : components) {
                Component temp = composite;
                component.add(temp);

            }
        } catch (UnsupportedOperationException e) { // lexemes
            if (((Lexeme) parentComponent).isExpression()) {
                String expression = parentComponent.getValue();
                component = Lexeme.expression(expression);
            } else {
                String word = parentComponent.getValue();
                component = Lexeme.word(word);
            }
        }

        return component;
    }
}
