import java.nio.file.Files;
import java.util.*;
import java.io.*;

/**
 * reads and writes in the rso_metrics files.
 *
 * @author Diego
 * @version 1.0
 */
public class Filereader {

    /**
     * reads rso_metrics file and assigns an object based on the data from the file
     * @return Hashmap with int as key and spaceobject as the value
     * @throws FileNotFoundException if file is not found
     */
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

    /**
     * takes a debris hashmap then updates the objects and writes changes into a new file
     * @param map hashmap of debris objects
     * @throws IOException if a file or buffered writer fails
     */
    void reWriteCSV(Map<Integer,Debris> map) throws IOException {
        File ogfile = new File("rso_metrics.csv");
        File newfile = new File("rso_metrics_write.csv");
        File changefile = new File("debris_orbit.txt");
        String splitRE = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        int inOrbit = 0;
        int outOrbit = 0;

        try(Scanner sc = new Scanner(ogfile);
            BufferedWriter writer = Files.newBufferedWriter(newfile.toPath());
            BufferedWriter resultFile = Files.newBufferedWriter(changefile.toPath()))
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
                if(orbit.equals("TRUE")){
                    inOrbit += 1;
                }else{
                    outOrbit += 1;
                }
                writer.write(line + "," + risk + "," + orbit);
                writer.newLine();

            }

            resultFile.write("Debris in Orbit: " + inOrbit);
            resultFile.newLine();
            resultFile.write("Debris out of Orbit: " + outOrbit);
            resultFile.newLine();

            for(Debris d : map.values()){
                if(!d.isStillInOrbit()) {
                  resultFile.write(d.display());
                  resultFile.newLine();
                }
            }


        }
    }
}

