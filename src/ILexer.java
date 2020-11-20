public interface ILexer {
    static int EOF = -1;
    int  getToken();
    String getTokenName(int t);
	boolean spellError(String line);
}
