package functional;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.exception.SortException;
import com.epam.infoHandling.functional.ComponentCloner;
import com.epam.infoHandling.functional.ComponentSorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
    private static final char SYMBOL_FOR_COUNT_OF_OCCURRENCE = 'e';

    private ComponentCloner cloner = new ComponentCloner();
    private ComponentSorter componentSorter = new ComponentSorter(cloner);
    private Component initComponent;
    private Component expectedComponent;

    @Before
    public void init() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.word("Second");
        Component lexeme4 = Lexeme.word("twice");
        Component lexeme5 = Lexeme.word("sentence?");
        Component lexeme6 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("sentence.");
        Component lexeme8 = Lexeme.word("Fourth");
        Component lexeme9 = Lexeme.word("sentence");
        Component lexeme10 = Lexeme.word("and");
        Component lexeme11 = Lexeme.word("ok?");
        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        Component sentence2 = new Composite();
        sentence2.add(lexeme3);
        sentence2.add(lexeme4);
        sentence2.add(lexeme5);

        Component sentence3 = new Composite();
        sentence3.add(lexeme6);
        sentence3.add(lexeme7);

        Component sentence4 = new Composite();
        sentence4.add(lexeme8);
        sentence4.add(lexeme9);
        sentence4.add(lexeme10);
        sentence4.add(lexeme11);

        Component sentence5 = new Composite();
        sentence5.add(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.add(sentence3);
        paragraph2.add(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.add(sentence5);

        initComponent = new Composite();
        initComponent.add(paragraph1);
        initComponent.add(paragraph2);
        initComponent.add(paragraph3);
    }

    @Test
    public void shouldSortParagraphsByCountOfSentences() throws SortException {
        // given
        initForSortParagraphsByCountOfSentencesTest();

        // when
        Component actualComponent = componentSorter.sortParagraphsByCountOfSentences(initComponent);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    @Test
    public void shouldSortSentencesByWordsLength() throws SortException {
        // given
        initForSortSentencesByWordsLengthTest();

        // when
        Component actualComponent = componentSorter.sortSentencesByWordsLength(initComponent);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    @Test
    public void sortLexemesByCountOfSymbolOccurrenceByDecrease() throws SortException {
        // given
        initForSortLexemesByCountOfSymbolOccurrenceByDecreaseTest();

        // when
        Component actualComponent =
                componentSorter.sortLexemesByCountOfSymbolOccurrenceByDecrease(initComponent, SYMBOL_FOR_COUNT_OF_OCCURRENCE);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    private void initForSortParagraphsByCountOfSentencesTest() {
        Component lexeme1 = Lexeme.word("Bye...");
        Component lexeme2 = Lexeme.word("First");
        Component lexeme3 = Lexeme.word("sentence.");
        Component lexeme4 = Lexeme.word("Second");
        Component lexeme5 = Lexeme.word("twice");
        Component lexeme6 = Lexeme.word("sentence?");
        Component lexeme7 = Lexeme.word("Third");
        Component lexeme8 = Lexeme.word("sentence.");
        Component lexeme9 = Lexeme.word("Fourth");
        Component lexeme10 = Lexeme.word("sentence");
        Component lexeme11 = Lexeme.word("and");
        Component lexeme12 = Lexeme.word("ok?");

        Component sentence1 = new Composite();
        sentence1.add(lexeme1);

        Component sentence2 = new Composite();
        sentence2.add(lexeme2);
        sentence2.add(lexeme3);

        Component sentence3 = new Composite();
        sentence3.add(lexeme4);
        sentence3.add(lexeme5);
        sentence3.add(lexeme6);

        Component sentence4 = new Composite();
        sentence4.add(lexeme7);
        sentence4.add(lexeme8);

        Component sentence5 = new Composite();
        sentence5.add(lexeme9);
        sentence5.add(lexeme10);
        sentence5.add(lexeme11);
        sentence5.add(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.add(sentence1);

        Component paragraph2 = new Composite();
        paragraph2.add(sentence2);
        paragraph2.add(sentence3);

        Component paragraph3 = new Composite();
        paragraph3.add(sentence4);
        paragraph3.add(sentence5);

        expectedComponent = new Composite();
        expectedComponent.add(paragraph1);
        expectedComponent.add(paragraph2);
        expectedComponent.add(paragraph3);
    }

    private void initForSortSentencesByWordsLengthTest() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.word("twice");
        Component lexeme4 = Lexeme.word("Second");
        Component lexeme5 = Lexeme.word("sentence?");
        Component lexeme6 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("sentence.");
        Component lexeme8 = Lexeme.word("and");
        Component lexeme9 = Lexeme.word("ok?");
        Component lexeme10 = Lexeme.word("Fourth");
        Component lexeme11 = Lexeme.word("sentence");
        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        Component sentence2 = new Composite();
        sentence2.add(lexeme3);
        sentence2.add(lexeme4);
        sentence2.add(lexeme5);

        Component sentence3 = new Composite();
        sentence3.add(lexeme6);
        sentence3.add(lexeme7);

        Component sentence4 = new Composite();
        sentence4.add(lexeme8);
        sentence4.add(lexeme9);
        sentence4.add(lexeme10);
        sentence4.add(lexeme11);

        Component sentence5 = new Composite();
        sentence5.add(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.add(sentence3);
        paragraph2.add(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.add(sentence5);

        expectedComponent = new Composite();
        expectedComponent.add(paragraph1);
        expectedComponent.add(paragraph2);
        expectedComponent.add(paragraph3);
    }

    private void initForSortLexemesByCountOfSymbolOccurrenceByDecreaseTest() {
        Component lexeme1 = Lexeme.word("sentence.");
        Component lexeme2 = Lexeme.word("First");

        Component lexeme3 = Lexeme.word("sentence?");
        Component lexeme4 = Lexeme.word("twice");
        Component lexeme5 = Lexeme.word("Second");

        Component lexeme6 = Lexeme.word("sentence.");
        Component lexeme7 = Lexeme.word("Third");

        Component lexeme8 = Lexeme.word("sentence");
        Component lexeme9 = Lexeme.word("ok?");
        Component lexeme10 = Lexeme.word("Fourth");
        Component lexeme11 = Lexeme.word("and");

        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        Component sentence2 = new Composite();
        sentence2.add(lexeme3);
        sentence2.add(lexeme4);
        sentence2.add(lexeme5);

        Component sentence3 = new Composite();
        sentence3.add(lexeme6);
        sentence3.add(lexeme7);

        Component sentence4 = new Composite();
        sentence4.add(lexeme8);
        sentence4.add(lexeme9);
        sentence4.add(lexeme10);
        sentence4.add(lexeme11);

        Component sentence5 = new Composite();
        sentence5.add(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.add(sentence3);
        paragraph2.add(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.add(sentence5);

        expectedComponent = new Composite();
        expectedComponent.add(paragraph1);
        expectedComponent.add(paragraph2);
        expectedComponent.add(paragraph3);
    }
}