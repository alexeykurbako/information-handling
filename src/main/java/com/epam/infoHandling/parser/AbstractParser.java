package com.epam.infoHandling.parser;

import com.epam.infoHandling.composite.Component;

public abstract class AbstractParser{
    protected AbstractParser successor;

    public AbstractParser(AbstractParser successor) {
        this.successor = successor;
    }

    public AbstractParser() {
    }

//    protected Parser getSuccessor(){
//        return successor;
//    }

    public abstract Component parse(String text);

//    public void setSuccessor(Parser successor) {
//        this.successor = successor;
//    }
}
