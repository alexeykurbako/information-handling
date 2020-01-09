package parser;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.parser.AbstractParser;
import com.epam.infoHandling.parser.SentenceParser;
import com.epam.infoHandling.parser.TextParser;
import org.junit.Assert;
import org.junit.Test;

public class TextParserTest {
    private static final String PARAGRAPH = "First sentence. Second, sentence! 2 1 + sentence?\n";
    private static final String TEXT = "    First sentence. 1 1 + sentence?\n" +
            "    Third sentence. Fourth sentence 2 3 * 4 + ok?\n" +
            "    Bye...\n";

    private Component expectedParagraph = new Composite();  // paragraph
    private Component expectedText = new Composite();  // whole text

    @Test
    public void shouldParseParagraphToComponent() {
        // given
        initParseParagraph();
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser paragraphParser = TextParser.paragraphParser(sentenceParser);

        // when
        Component actualComponent = paragraphParser.parse(PARAGRAPH);

        // then
        Assert.assertEquals(expectedParagraph, actualComponent);
    }

    @Test
    public void shouldParseTextToComponent() {
        // given
        initParseText();
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser paragraphParser = TextParser.paragraphParser(sentenceParser);
        AbstractParser textParser = TextParser.textParser(paragraphParser);

        // when
        Component actualText = textParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedText, actualText);
   }

    private void initParseParagraph() {
        Component firstComponent = Lexeme.word("First");
        Component secondComponent = Lexeme.word("sentence.");

        Component firstSentence = new Composite(); // sentence
        firstSentence.add(firstComponent);
        firstSentence.add(secondComponent);

        Component thirdComponent = Lexeme.word("Second,");
        Component fourthComponent = Lexeme.word("sentence!");

        Component secondSentence = new Composite(); // sentence
        secondSentence.add(thirdComponent);
        secondSentence.add(fourthComponent);

        Component fifthComponent = Lexeme.expression("2 1 +");
        Component sixthComponent = Lexeme.word("sentence?");

        Component thirdSentence = new Composite(); // sentence
        thirdSentence.add(fifthComponent);
        thirdSentence.add(sixthComponent);


        expectedParagraph.add(firstSentence);
        expectedParagraph.add(secondSentence);
        expectedParagraph.add(thirdSentence);
    }

    private void initParseText() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.expression("1 1 +");
        Component lexeme4 = Lexeme.word("sentence?");
        Component lexeme5 = Lexeme.word("Third");
        Component lexeme6 = Lexeme.word("sentence.");
        Component lexeme7 = Lexeme.word("Fourth");
        Component lexeme8 = Lexeme.word("sentence");
        Component lexeme9 = Lexeme.expression("2 3 * 4 +");
        Component lexeme10 = Lexeme.word("ok?");
        Component lexeme11 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        Component sentence2 = new Composite();
        Component sentence3 = new Composite();
        Component sentence4 = new Composite();
        Component sentence5 = new Composite();

        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        sentence2.add(lexeme3);
        sentence2.add(lexeme4);

        sentence3.add(lexeme5);
        sentence3.add(lexeme6);

        sentence4.add(lexeme7);
        sentence4.add(lexeme8);
        sentence4.add(lexeme9);
        sentence4.add(lexeme10);

        sentence5.add(lexeme11);

        Component paragraph1 = new Composite();
        Component paragraph2 = new Composite();
        Component paragraph3 = new Composite();

        paragraph1.add(sentence1);
        paragraph1.add(sentence2);

        paragraph2.add(sentence3);
        paragraph2.add(sentence4);

        paragraph3.add(sentence5);

        expectedText.add(paragraph1);
        expectedText.add(paragraph2);
        expectedText.add(paragraph3);
    }
}