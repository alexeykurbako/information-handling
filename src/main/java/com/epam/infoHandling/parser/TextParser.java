package com.epam.infoHandling.parser;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {
    private static final String SENTENCE_PATTERN = "[ a-zA-Z1-9,;:()*/+-]+([.]{3}|[.?!])";
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";
    private boolean isText;

    private TextParser(AbstractParser successor, boolean isText) {
        super(successor);
        this.isText = isText;
    }

    public static TextParser paragraphParser(AbstractParser successor) {
        return new TextParser(successor, false);
    }

    public static TextParser textParser(AbstractParser successor) {
        return new TextParser(successor, true);
    }

    @Override
    public Component parse(String text) {
        Pattern paragraphOrSentencePattern = choosePattern();
        Matcher paragraphOrSentenceMatcher = paragraphOrSentencePattern.matcher(text);

        Component TextOrParagraphComponent = new Composite();

        while (paragraphOrSentenceMatcher.find()) {
            String paragraphOrSentence = paragraphOrSentenceMatcher.group();

            Component paragraphOrSentenceComponent = successor.parse(paragraphOrSentence);

            TextOrParagraphComponent.add(paragraphOrSentenceComponent);
        }

        return TextOrParagraphComponent;
    }

    private Pattern choosePattern() {
        if (isText) {
            return Pattern.compile(PARAGRAPH_PATTERN);
        } else {
            return Pattern.compile(SENTENCE_PATTERN);
        }
    }
}
