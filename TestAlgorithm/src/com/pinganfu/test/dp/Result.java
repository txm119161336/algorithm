package com.pinganfu.test.dp;

public class Result implements Comparable<Result> {

	public Integer value;

	public Result(int i) {
		this.value = i;
	}

	@Override
	public int compareTo(Result o) {
		System.out.println("test time");
		if (value.intValue() < o.value.intValue())
			return -1;
		else if (value.intValue() > o.value.intValue())
			return 1;

		return 0;
	}

}
