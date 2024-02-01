package com.polishchuk.mschool;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortCheck {

	public static <T> boolean isDescSorted(List<T> list, Comparator<T> comparator) {
		return IntStream.range(0, list.size() - 1).allMatch(i -> comparator.compare(list.get(i), list.get(i + 1)) >= 0);
	}
}
