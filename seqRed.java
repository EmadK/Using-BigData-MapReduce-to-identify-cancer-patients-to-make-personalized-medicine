package seqallignment;

import java.io.IOException;
//import java.math.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class seqRed extends Reducer<Text,IntWritable,Text,IntWritable> {
	public void reduce(Text key,Iterable <IntWritable> value,Context context) throws IOException,InterruptedException{
		
	int maxScore = 0; 
	for(IntWritable val : value){
		maxScore = Math.max(maxScore, ((IntWritable) val).get()); 
		}
	
	context.write(key, new IntWritable(maxScore));
	}

}
