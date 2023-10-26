package WebLogAnalysis;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class LogReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int totalRequests = 0;
        for (IntWritable value : values) {
            totalRequests += value.get();
        }
        // Émettre le résultat par adresse IP avec le nombre total de requêtes.
        context.write(key, new IntWritable(totalRequests));
    }
}
