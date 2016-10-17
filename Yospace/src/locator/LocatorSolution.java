package locator;

public class LocatorSolution implements Locator {

	@Override
	public int getIndex(String itemSought, String[] candidates) {
		int index = -1;
		if (paramsContainData(itemSought, candidates)) {
			index = findItem(itemSought, candidates);
		}
		return index;
	}

	private int findItem(String itemSought, String[] candidates) {
		for (int i = 0; i < candidates.length; i++) {
			if (itemFound(itemSought, candidates[i]))
				return i;
		}
		return -1;
	}

	private boolean itemFound(String itemSought, String candidate) {
		return candidate != null && candidate.equals(itemSought);
	}

	private boolean paramsContainData(String itemSought, String[] candidates) {
		return itemSought != null && candidates != null && candidates.length > 0;
	}

}
