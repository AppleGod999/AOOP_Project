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
     */
    HashMap<Integer,SpaceObject> parseCsv(){
        try {
            File file = new File("rso_metrics_columns_jumbled.csv");
            Scanner sc = new Scanner(file);

            HashMap<Integer, SpaceObject> map = new HashMap<>();
            String[] th = sc.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            HashMap<String, Integer> header = getHeader(th);

            while (sc.hasNext()) {
                String[] data = sc.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                SpaceObject so = new SpaceObject(
                        data[header.get("record_id")],
                        data[header.get("norad_cat_id")],
                        data[header.get("satellite_name")],
                        data[header.get('\uFEFF' + "country")],
                        data[header.get("approximate_orbit_type")],
                        data[header.get("object_type")],
                        Integer.parseInt(data[header.get("launch_year")]),
                        data[header.get("launch_site")],
                        Double.parseDouble(data[header.get("longitude")]),
                        Double.parseDouble(data[header.get("avg_longitude")]),
                        data[header.get("geohash")],
                        Integer.parseInt(data[header.get("days_old")]),
                        Boolean.parseBoolean(data[header.get("is_nominated")]),
                        Boolean.parseBoolean(data[header.get("has_dossier")]),
                        Boolean.parseBoolean(data[header.get("is_unk_object")]),
                        Integer.parseInt(data[header.get("conjunction_count")])

                );
                map.put(Integer.parseInt(data[header.get("record_id")]), so);
            }
            return map;
        }catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        return null;
    }

    /**
     * takes a debris hashmap then updates the objects and writes changes into a new file
     * @param map hashmap of debris objects
     * */
    void reWriteCSV(Map<Integer,SpaceObject> map){
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

            for(SpaceObject d : map.values()){
                if(!d.isStillInOrbit()) {
                  resultFile.write(d.display());
                  resultFile.newLine();
                }
            }


        }catch (IOException e){
            System.out.println("IO exception has occurred in reWriteCSV");
        }
    }

    HashMap<String, Integer> getHeader(String[] headers){
        HashMap<String, Integer> header = new HashMap<>();

        for(int i=0;i<headers.length;i++){
            header.put(headers[i].trim(),i);
        }


        return header;
    }

    public HashMap<String,User> GenUsers(){
        HashMap<String,User> users = new HashMap<>();
        try {
            File file = new File("UserPassword.csv");
            Scanner scan = new Scanner(file);
            User u = null;
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String[] data = scan.nextLine().split(",");
                users.put(data[0], User.factory(data));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return users;
    }

    public void saveUsers(HashMap<String,User> users){
        File file = new File("UserPassword.csv");

        try(Scanner sc = new Scanner(file);
            BufferedWriter writer = Files.newBufferedWriter(file.toPath());)
        {
            writer.write("Users,Password,Role");
            writer.newLine();

            for(User user : users.values()){
                writer.write(user.getUsername() + "," + user.password + "," + user.getRole());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("IO exception has occurred in saveUsers");
        }
    }
}

