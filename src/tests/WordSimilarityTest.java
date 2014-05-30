package tests;



import static org.junit.Assert.*;

import org.junit.Test;

import similarity.WordSimilarity;

public class WordSimilarityTest {
	
	@Test
	public void isSimilarTest() {
		boolean similar = WordSimilarity.isSimilar("bold", "bald");
		assertTrue(similar);
		similar = WordSimilarity.isSimilar("longerword", "shortword");
		assertFalse(similar);
		similar = WordSimilarity.isSimilar("loooong", "short");
		assertFalse(similar);
	}

	@Test
	public void computeTest() {
		int computed = WordSimilarity.compute("bold", "bald");
		assertEquals(1, computed);
	}

}
