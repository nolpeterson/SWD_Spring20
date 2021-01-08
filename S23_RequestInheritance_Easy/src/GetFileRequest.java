import java.util.UUID;

/**
 * GetFileRequest - extends the class of GetRequest, which extends the base class Request, Gets the File information of a request.
 */
public class GetFileRequest extends GetRequest {
    /**
     * The Rand file.
     */
    private File randFile;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Get file request.
     * @param randUUID a Universally Unique Identifier of a GetFileRequest object.
     * @param randFile a random File object of a GetFileRequest object.
     */
    public GetFileRequest(UUID randUUID, File randFile){
        super(randUUID, randFile.getFilePath());
        this.randFile = randFile;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class + randFile.ToString().
     */
    @Override
    public String toString() {
        return (super.toString() + randFile.toString());
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
