package seqallignment;


import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class seqMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
	@Override
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException{
		String line = value.toString();
     String s1 ="NTTAATAAATACAAATATTATATTTTTGATTATCCAATTGCCTAATGAGCAAAACGAATTGCTGTGAGGGATAAAGTTAAAAAATATACATAAAATTCATTTGCACAGAATCAAATACAATCAACAAAAAGATAACACCATACCACTAACA"; 
		SmithWaterman sw = new SmithWaterman(line,s1);
		double score = sw.computeSmithWaterman();
		context.write(new Text(line), new IntWritable((int) score));
	}

}

