package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.TreeMap;

import DisjointSet.DisjointSet;
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
		TreeMap<String, DisjointSet> tree = new TreeMap<String, DisjointSet>();
		parser.parse(tree);
		assertEquals(tree.get("mistakenly").getWord(), "mistakenly");
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
