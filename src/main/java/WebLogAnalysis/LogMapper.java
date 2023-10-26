package WebLogAnalysis;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final IntWritable one = new IntWritable(1);

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(" ");

        if (fields.length >= 7) {
            String ip = fields[0];
            String httpCode = fields[6];

            // Émettre un couple clé-valeur avec l'adresse IP et le code de réponse HTTP.
            context.write(new Text(ip + "-" + httpCode), one);
        }
    }
}
