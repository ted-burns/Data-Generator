
public class Decider<O> {
	private O[] output;
	private double[] buckets;
	private final double tolerance = 0.0001;
	
	public Decider(double[] input, O[] output)
	{
		this.output = output;
		buckets = new double[input.length+1];
		buckets[0] = 0;
		for(int i = 0; i < input.length; i++)
		{
			buckets[i+1] = buckets[i] + input[i];
		}
	}
	
	public Decider(O[] output)
	{
		this.output = output;
		buckets = new double[output.length+1];
		buckets[0] = 0;
		double increment = 1.0/output.length;
		for(int i = 0; i < buckets.length-1; i++)
		{
			buckets[i+1] = buckets[i] + increment;
		}
	}
	
	//What actually performs the action
	public O zone(double in)
	{
		for(int i = 0; i < buckets.length - 1; i++)
		{
			if(in < buckets[i])
				return this.output[i-1];
		}
		return this.output[0];
	}
}
