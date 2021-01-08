import java.util.UUID;

/**
 * GetVideoRequest - extends the class of GetRequest, which extends the base class Request, Gets the Video information of a request.
 */
public class GetVideoRequest extends GetRequest {
    /**
     * The Rand video.
     */
    private Video randVideo;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Get video request.
     * @param randUUID the Universally Unique Identifier of a GetVideoRequest object.
     * @param randVideo a random Video object of a GetVideoRequest object.
     */
    public GetVideoRequest(UUID randUUID, Video randVideo){
        super(randUUID, randVideo.getURL());
        this.randVideo = randVideo;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class + randVideo.ToString().
     */
    @Override
    public String toString() {
        return (super.toString() + randVideo.toString());
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
