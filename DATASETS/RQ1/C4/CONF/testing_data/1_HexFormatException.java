


public class HexFormatException extends NumberFormatException {
    public HexFormatException(String hex) {
        super("Invalid Hex String: " + hex);
    }
}
