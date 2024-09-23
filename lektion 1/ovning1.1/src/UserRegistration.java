import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserRegistration {
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }

    public void readFileSafely(String userProvidedFilename) {

        String secureDirectoryPath = "/Users/aleksanderbjelk/Documents/GitHub/Grit_Java23_IT-s-kerhet/lektion 1/ovning1.1/src/Files";

        try {
            File secureDirectory = new File(secureDirectoryPath);
            File file = new File(secureDirectory, userProvidedFilename);

            String secureDirectoryCanonicalPath = secureDirectory.getCanonicalPath();
            String fileCanonicalPath = file.getCanonicalPath();

            if (!fileCanonicalPath.startsWith(secureDirectoryCanonicalPath)) {
                throw new SecurityException("nej nej");
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (SecurityException se) {
                System.err.println(se.getMessage());
            }
        }


    public void readFileUnsafely(String userProvidedFilename) {

        String insecureDirectoryPath = "/Users/aleksanderbjelk/Documents/GitHub/Grit_Java23_IT-s-kerhet/lektion 1/ovning1.1";

        try {
            File insecureDirectory = new File(insecureDirectoryPath);
            File file = new File(insecureDirectory, userProvidedFilename);


            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (SecurityException se) {
            System.err.println(se.getMessage());
        }
    }


    }
