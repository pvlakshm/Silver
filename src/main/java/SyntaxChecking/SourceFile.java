// this represents a source of the i/p text.
// an instance of SourceFile will be handed off
// to the scanner. The scanner will call into the public
// methods to readin characters.

package SyntaxChecking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SourceFile
{
    public static final char EOL = '\n';        // end ofline
    public static final char EOT = '\u0000';    // end of text

    private FileInputStream source;
    private int             currentLine;
    private int             currentCol;

    public SourceFile(String filename)
    {
        try
        {
            File f = new File(filename);
            source = new FileInputStream(f);
            currentLine = 1;
            currentCol  = 0;
        }
        catch (IOException e)
        {
            source = null;
            currentLine = 0;
            currentCol  = 0;
            System.out.println("Can't access sourcefile: " + filename);
            System.exit(1);
        }
    }

    public char getSource()
    {
        try
        {
            int c = source.read();
            currentCol++;

            if (c == -1)
            {
                c = EOT;
                currentCol--;
            }
            else if (c == EOL)
            {
                currentLine++;
                currentCol = 0;
            }

            return (char) c;
        }
        catch (IOException e)
        {
            return EOT;
        }
    }

    public int getCurrentLine()
    {
        return currentLine;
    }

    public int getCurrentCol()
    {
        return currentCol;
    }
}