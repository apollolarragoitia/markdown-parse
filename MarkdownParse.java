// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            //int imagePointer = markdown.indexOf("!", currentIndex);
            int imagePointer = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf (")", openParen);
            /*
            if (markdown.charAt(closeBracket+1) != ('(')){
                continue;
            }
            */
            if (openParen == -1 || closeParen == -1) {
                break;
            }
            else {
                toReturn.add(markdown.substring(openParen+1, closeParen));
            }
            currentIndex++;
            System.out.println(closeParen);
        }
        System.out.println(markdown.charAt(40));
        System.out.println(markdown.charAt(72));
        return toReturn;
    }
    

    public static void main(String[] args) throws IOException {
		/*
        Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
        */

        String filename="test-file.md";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
    }
}