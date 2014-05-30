package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdjectivePTBParserTest.class, AdverbPTBParserTest.class,
		AllPTBParserTest.class, SubstantivePTBParserTest.class,
		VerbPTBParserTree.class })
public class ParserTests {

}
