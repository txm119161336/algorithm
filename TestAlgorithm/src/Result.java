
public class Result implements Comparable<Result> {

	public Integer value;

	public Result(int i) {
		this.value = i;
	}

	@Override
	public int compareTo(Result o) {
		if (value.intValue() < o.value.intValue())
			return -1;
		else if (value.intValue() > o.value.intValue())
			return 1;

		return 0;
	}

}
