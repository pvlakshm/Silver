package SyntaxChecking;

public class SourcePosition
{
    public int start;
    public int finish;

    public SourcePosition()
    {
        start  = 0;
        finish = 0;
    }

    public SourcePosition(int s, int f)
    {
        start  = s;
        finish = f;
    }

    public String toString()
    {
        return "[" + start + ", " + finish + "]";
    }
}
