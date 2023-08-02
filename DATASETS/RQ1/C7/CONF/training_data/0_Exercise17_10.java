
public class BigFileSplitter{
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.out.println("Usage: java BigFileSplittersourceFile numberOfPieces");
            System.exit(1);
        }

        
        String sourceFile = args[0];
        int numberOfPieces = Integer.parseInt(args[1]);

        
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));

        
        long fileSize = new File(sourceFile).length();

        
        long pieceSize = fileSize / numberOfPieces;
        long lastPieceSize = fileSize - (numberOfPieces - 1) * pieceSize;

        
        for (int i = 0; i < numberOfPieces; i++) {
            String outputFileName = sourceFile + ".part" + i;
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFileName));

            
            if (i == numberOfPieces - 1) {
                
                byte[] lastPiece = new byte[(int) lastPieceSize];
                input.read(lastPiece);
                output.write(lastPiece);
            } else {
                byte[] piece = new byte[(int) pieceSize];
                input.read(piece);
                output.write(piece);
            }

            
            output.close();
        }

        
        input.close();

        System.out.println("File split successfully into " + numberOfPieces + " pieces.");
    }
}
