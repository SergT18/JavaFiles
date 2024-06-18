import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFile {

    private final String fileName;
    private final ArrayList<String> data;
    private String fileDataString;

    TextFile(String fileName) {
        this.fileName = fileName;
        this.data = new ArrayList<>();
        getFileData();
    }

    public void getFileData() {

        try {

            File file = getFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                this.data.addAll(List.of(line.split(" ")));
            }
            this.fileDataString = sb.toString();
            fr.close();
            br.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


   public ArrayList<String> sortData(){
        if(this.data.isEmpty()){
            getFileData();
       }
       Collections.sort(this.data);
       return this.data;
   }

   public String getReadingFromFileData(){
       return this.fileDataString;
   }


   public void writeDataToFile(String s){
       try {

           File file = getFile();

           if(!file.canWrite()){
               throw new IOException("File can't open for writing");
           }

           BufferedWriter writer = new BufferedWriter(new FileWriter(file));
           writer.write(s);
           writer.close();
           getFileData();

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    private File getFile() throws IOException {

        File file = new File(this.fileName);
        File dir = new File(file.getParent());

        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        return file;

    }


}
