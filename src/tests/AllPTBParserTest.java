package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.TreeMap;

import DisjointSet.DisjointSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.AllPTBParser;

public class AllPTBParserTest {

	AllPTBParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new AllPTBParser("ptp-flat-test.txt");
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}
	
	@Test
	public void testParse() throws IOException{
		TreeMap<String, DisjointSet> tree = new TreeMap<String, DisjointSet>();
		parser.parse(tree);
		assertEquals(tree.get("steady").getWord(), "steady");
	}

	@Test
	public void testIsWord() {
		assertEquals(true, parser.isWord("word)"));
	}

}
