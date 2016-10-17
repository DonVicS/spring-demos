package locator;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocatorSolutionTest {

	@Test
	public void testGetIndex() {
		String itemSought = "aaa";
		String[] candidates = new String[] { "aaa", "bbb", "ccc" };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, 0);
	}

	@Test
	public void findNullItem() {
		String itemSought = null;
		String[] candidates = new String[] { "aaa", "bbb", "ccc" };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, -1);
	}

	@Test
	public void findItemInNullArray() {
		String itemSought = "aaa";
		String[] candidates = null;

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, -1);
	}

	@Test
	public void findItemInArrayContainingOnlyNulls() {
		String itemSought = "aaa";
		String[] candidates = new String[] { null, null, null };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, -1);
	}

	@Test
	public void findItemInArrayContainingSomeNulls() {
		String itemSought = "aaa";
		String[] candidates = new String[] { null, "aaa", null };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, 1);
	}

	@Test
	public void testGetIndexItemNotFound() {
		String itemSought = "ddd";
		String[] candidates = new String[] { "aaa", "bbb", "ccc" };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, -1);
	}

	@Test
	public void findRepeatedItem() {
		String itemSought = "aaa";
		String[] candidates = new String[] { "aaa", "aaa", "aaa" };

		Locator locator = new LocatorSolution();
		int index = locator.getIndex(itemSought, candidates);

		assertEquals(index, 0);
	}

}
