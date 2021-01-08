/**
 * File - an Object that has a file type, and file path.
 */
public class File {
    /**
     * The File path.
     */
    private String filePath;
    /**
     * The File type.
     */
    private String fileType;

    /**
     * Instantiates a new File.
     * @param filePath the file path on hard drive directory.
     * @param fileType the type of file.
     */
    public File(String filePath, String fileType) {
        this.filePath = filePath;
        this.fileType = fileType;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the File object.
     */
    @Override
    public String toString() {
        return ("\n-File Info-\nUniversal Resource Locator (URL): file://" + getFilePath() + "." + getFileType() + "\nFile Path: " + getFilePath() + "\nFile Type: " + getFileType());
    }

    /**
     * Gets file path.
     * @return the path to the file.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Gets file type.
     * @return the type of the file.
     */
    public String getFileType() {
        return fileType;
    }
}
