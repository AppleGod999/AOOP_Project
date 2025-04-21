import java.util.*;
import java.io.*;

public class Filereader {

    Map<Integer,SpaceObject> parseCsv() throws FileNotFoundException {
        File file = new File("rso_metrics.csv");
        Scanner sc = new Scanner(file);

        SpaceObject factory = null;

        Map<Integer,SpaceObject> map = new HashMap<>();

        sc.nextLine();
        while(sc.hasNext()){
            String[] data = sc.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            //System.out.println(data[6]);

            SpaceObject so = SpaceObject.create(data[5],data);

            map.put(Integer.parseInt(data[0]),so);
        }

        return map;
    }
}

