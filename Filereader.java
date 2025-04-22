import java.nio.file.Files;
import java.util.*;
import java.io.*;

public class Filereader {

    Map<Integer,SpaceObject> parseCsv() throws FileNotFoundException{
        File file = new File("rso_metrics.csv");
        Scanner sc = new Scanner(file);

        SpaceObject factory = null;

        Map<Integer,SpaceObject> map = new HashMap<>();

        sc.nextLine();
        while(sc.hasNext()){
            String[] data = sc.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            SpaceObject so = SpaceObject.create(data[5],data);

            map.put(Integer.parseInt(data[0]),so);
        }

        return map;
    }

    void reWriteCSV(Map<Integer,Debris> map) throws IOException {
        File ogfile = new File("rso_metrics.csv");
        File newfile = new File("rso_metrics_write.csv");
        String splitRE = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        try(Scanner sc = new Scanner(ogfile);
            BufferedWriter writer = Files.newBufferedWriter(newfile.toPath()))
        {
            String header = sc.nextLine();
            writer.write(header + ",Risk_Level,Still_in_Orbit");
            writer.newLine();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(splitRE,-1);
                String orbit = "";
                String risk = "";

                if(data[5].equals("DEBRIS")) {
                    orbit = String.valueOf(map.get(Integer.parseInt(data[0])).isStillInOrbit());
                    risk = map.get(Integer.parseInt(data[0])).getRiskLevel();
                }
                writer.write(line + "," + risk + "," + orbit);
                writer.newLine();

            }
        }
    }
}

