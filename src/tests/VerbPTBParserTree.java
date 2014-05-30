package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.VerbPTBParser;

public class VerbPTBParserTree {

	VerbPTBParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new VerbPTBParser("ptp-flat-test.txt");
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}
	
	@Test
	public void testParse() throws IOException{
		TreeMap<String, String> tree = new TreeMap<String, String>();
		parser.parse(tree);
		assertEquals(tree.get("plays"), "plays");
	}

	@Test
	public void testIsWord() {
		assertEquals(true, parser.isWord("word)"));
	}
	
	@Test
	public void testIsSubstantive(){
		assertEquals(true, parser.isVerb("V"));
	}

}
