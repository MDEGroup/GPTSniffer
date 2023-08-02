
public class ScissorRockPaper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        
        int computerChoice = rand.nextInt(3);
        
        
        System.out.print("Enter 0 for scissor, 1 for rock, or 2 for paper: ");
        int userChoice = input.nextInt();
        
        
        if (userChoice == computerChoice) {
            System.out.println("It's a draw!");
        } else if (userChoice == 0 && computerChoice == 2 ||
                   userChoice == 1 && computerChoice == 0 ||
                   userChoice == 2 && computerChoice == 1) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
        
        
        switch (computerChoice) {
            case 0:
                System.out.println("Computer chose scissor.");
                break;
            case 1:
                System.out.println("Computer chose rock.");
                break;
            case 2:
                System.out.println("Computer chose paper.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
