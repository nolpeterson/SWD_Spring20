import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * DataGenerator - Generates data for requests in Server.
 */
class DataGenerator {
    /**
     * A random object.
     */
// fields to hold example data
    private Random rand;
    /**
     * The Names.
     */
    private String[] names;
    /**
     * The Encryption.
     */
    private String[] encryption;
    /**
     * The Video titles.
     */
    private String[] videoTitles;
    /**
     * The File paths.
     */
    private String[] filePaths;
    /**
     * The File types.
     */
    private String[] fileTypes;
    /**
     * The Colors.
     */
    private String[] colors;

    /**
     * Instantiates a new Data generator.
     */
// Constructor
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    /**
     * Gets rand name.
     * @return the rand name
     */
// private utilities for data generation
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * Gets rand color.
     * @return the rand color
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * Gets rand video title.
     * @return the rand video title
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * Gets rand file type.
     * @return the rand file type
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * Gets rand file path.
     * @return the rand file path
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    /**
     * Gets rand url.
     * @return the rand url
     */
// public data generation tools
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * Gets rand payment.
     * @return the rand payment
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * Gets rand uuid.
     * @return the rand uuid
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * Gets rand encryption scheme.
     * @return the rand encryption scheme
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * Gets rand video.
     * @return the rand video
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * Gets rand file.
     * @return the rand file
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * Gets rand form.
     * @return the rand form
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * Gets rand ip.
     * @return the rand ip
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }
}