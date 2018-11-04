package network;

public class Main {
    public static void main(String[] args) {
        final CurrentTime time = new CurrentTime();
        time.connect();

        final FtpClient ftp = new FtpClient("ftp.cisco.com");
        ftp.connect();

        UrlExists google = new UrlExists("google.com", "");
        google.connect();

       UrlExists googleNotFound = new UrlExists("google.com", "nothinghere");
       googleNotFound.connect();
    }
}
