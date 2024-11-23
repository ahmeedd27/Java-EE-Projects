
package model;


public class FileInformation {
    private int id;
    private String name , filename , filepath;
    

    public FileInformation() {
    }

    public FileInformation(String name, String filename, String filepath) {
        this.name = name;
        this.filename = filename;
        this.filepath = filepath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileInformation(int id, String name, String filename, String filepath) {
        this.id = id;
        this.name = name;
        this.filename = filename;
        this.filepath = filepath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "FileInformation{" + "name=" + name + ", filename=" + filename + ", filepath=" + filepath + '}';
    }
    
}
