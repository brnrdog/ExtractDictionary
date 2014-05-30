package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.AdverbPTBParser;

public class AdverbPTBParserTest {
	
	AdverbPTBParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new AdverbPTBParser("ptp-flat-test.txt");
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}
	
	@Test
	public void testParse() throws IOException{
		TreeMap<String, String> tree = new TreeMap<String, String>();
		parser.parse(tree);
		assertEquals(tree.get("mistakenly"), "mistakenly");
	}

	@Test
	public void testIsWord() {
		assertEquals(true, parser.isWord("word)"));
	}
	
	@Test
	public void testIsAdverb(){
		assertEquals(true, parser.isAdverb("(RB"));
	}
}
