package Google;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;



public class A {

	public static void main(String[] args) {

		final List<Integer> list = new ArrayList<Integer>();

		Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

		final Integer pos = 3;

		list.remove(pos);

		System.out.println(list);

	}

}