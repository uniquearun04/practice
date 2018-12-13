import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by achaudhary on 11/6/18.
 */
public class HLSTranscoding {

    public static void main(String ...args) throws IOException, InterruptedException {
        HLSTranscoding hlsTranscoding = new HLSTranscoding();
        hlsTranscoding.transcodeVideo("/tmp/downloaded/streams/devPub570646115343198600159.mp4", "devPub570646115343198600159");
    }

    public void transcodeVideo(String filePath, String streamId) throws IOException, InterruptedException {

        String targetPath = filePath.substring(0,filePath.lastIndexOf("/")+1) + streamId;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if(availableProcessors <= 0) {
            availableProcessors = 1;
        }
        String transcodeCommandArr[] = {"ffmpeg",  "-threads", availableProcessors+"","-i",  filePath, "-b",  "350k", "-minrate",  "350k", "-maxrate", "350k", "-bufsize", "350k",
                "-s", "216x386",  "-strict", "-2", "-hls_time",  "2",  "-hls_list_size",  "0",  "-g",  "2", "-f",  "hls", targetPath+"/400kbps.m3u8",  "-b",  "500k",  "-minrate",
                "500k", "-maxrate",  "500k", "-bufsize",  "500k",   "-s", "360x640",  "-strict",
                "-2",  "-hls_time",  "2",  "-hls_list_size",  "0",  "-g", "2", "-f", "hls", targetPath+"/600kbps.m3u8", "-b", "160k", "-minrate",
                "160k", "-maxrate",  "160k",  "-bufsize",  "160k",  "-s", "144x256",  "-strict", "-2", "-hls_time", "2", "-hls_list_size", "0",
                "-g", "2", "-f", "hls", targetPath+"/200kbps.m3u8",  "-vn",  "-acodec",  "copy", "-strict", "-2", "-hls_time", "2", "-hls_list_size",
                "0",  "-g", "2", "-f", "hls", targetPath + "/aud.m3u8"};

        String mkdir[] = {"mkdir","-p",targetPath};
        Process p = Runtime.getRuntime().exec(mkdir);
        System.out.println("command ffmpeg: "+mkdir);
        readFromInputStream(p);
        readFromErrorStream(p);

        System.out.println("command ffmpeg: "+transcodeCommandArr);
        p = Runtime.getRuntime().exec(transcodeCommandArr);
//        readFromInputStream(p);
//        readFromErrorStream(p);

        boolean alive = p.isAlive();
        p.waitFor(60, TimeUnit.SECONDS);

        System.out.println("transcode complete");

        createHLSPlayList(targetPath, streamId);
//        getFilesAndUploadFiles(targetPath, s3Properties.getVideoBucket(), streamId);
//        deleteDownloadedFiles(targetPath);
    }

    private void deleteDownloadedFiles(String targetPath) throws IOException {
        String deleteCommand[] = {"rm","-rf",targetPath+"*"};
        Process p = Runtime.getRuntime().exec(deleteCommand);
        System.out.println("command deleteCommand: {}"+deleteCommand);
        readFromInputStream(p);
        readFromErrorStream(p);
    }

    private void readFromInputStream(Process process) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while((line = br.readLine())!= null ) {
            System.out.println("ffmpeg input stream output:{} "+line);
        }
        br.close();
    }

    private void readFromErrorStream(Process process) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line = "";
        while((line = br.readLine())!= null ) {
            System.out.println("ffmpeg error stream output:{} "+line);
        }
        br.close();
    }


    public void createHLSPlayList(String targetDir, String streamId) throws IOException {

        String text = "#EXTM3U\n#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=945000,RESOLUTION=360x640,CODECS=\"avc1.42001e,mp4a.40.2\"\n" + streamId + "/600kbps.m3u8\n#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=667000,RESOLUTION=216x386,CODECS=\"avc1.42001e,mp4a.40.2\"\n" + streamId + "/400kbps.m3u8\n#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=450000,RESOLUTION=144x256,CODECS=\"avc1.42001e,mp4a.40.2\"\n" + streamId + "/200kbps.m3u8";
        File file = new File(targetDir+"_playlist.m3u8");

        OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(text.getBytes());
        writer.flush();
        writer.close();
    }
}
