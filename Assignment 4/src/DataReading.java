import java.io.IOException;
import java.io.FileWriter;
import java.math.BigInteger;

public class DataReading {

	private long[] values = new long[6];
	private long timestamp;

	public DataReading(long a, long b, long c, long d, long e, long f) {
		values = new long[] { a, b, c, d, e, f };
		timestamp = System.currentTimeMillis();
	}

	public long getMax() {
		long max = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}

	public long getMin() {
		long min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}

	public BigInteger getTotal() {
		BigInteger result = new BigInteger(Long.toString(values[0]));
		for (int i = 1; i < values.length; i++) {
			result = result.add(new BigInteger(Long.toString(values[i])));
		}
		return result;
	}

	public void save() throws IOException {
		FileWriter out = new FileWriter(".dataoutput", true);
		out.write(Long.toString(timestamp));
		for (int i = 1; i < values.length; i++) {
			out.write(",");
			out.write(Long.toString(values[i]));
		}
		out.write("\n");
		out.close();
	}

	public int hashCode() {
		int totalHash = getTotal().hashCode();
		int result = totalHash;
		boolean hasHashCode = false;
		int hc = 0;
		int hcode = Long.hashCode(getMax());
		if (!hasHashCode) {
			result *= 31;
			result += hcode;
			result *= 31;
			result += getMin();
			result += values[0];
			result *= 31;
			result += values[1];
			result += 31;
			result += values[2];
			result *= 31;
			result += values[3];
			result += 31;
			result += values[5];
			result *= 31;
			result += values[4];
			hc = result;
			hasHashCode = true;
		}
		return hc;
	}
}