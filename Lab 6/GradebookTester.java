
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook object1;
	GradeBook object2;
	
	@BeforeEach
	void setUp() throws Exception {
		object1 = new GradeBook(5);
		object2 = new GradeBook(5);
		object1.addScore(100);
		object1.addScore(50);
		object2.addScore(80);
		object2.addScore(30);
	}

	@AfterEach
	void tearDown() throws Exception {
		object1 = null;
		object2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(object1.toString().equals("100.0 50.0 "));
		assertEquals(2,object1.getScoreSize());
		assertTrue(object2.toString().equals("80.0 30.0 "));
		assertEquals(2,object2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(150,object1.sum());
		assertEquals(110,object2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(50,object1.minimum());
		assertEquals(30,object2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(100,object1.finalScore());
		assertEquals(80,object2.finalScore());
	}

}
