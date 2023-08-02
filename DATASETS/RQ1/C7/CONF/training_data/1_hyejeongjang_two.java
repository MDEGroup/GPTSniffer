
public class Main {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");

        System.out.print("결제 금액을 입력해 주세요.(금액): ");
        Scanner scanner=new Scanner(System.in);
        int amount=scanner.nextInt();

        
        int cashBack= (int) Math.floor(amount*0.1/100)*100;

        
        if (cashBack>=300) {
            cashBack = 300;
        }

        System.out.println("결제 금액은 " + amount +"원이고, 캐시백은 "+ cashBack + "원 입니다.");

    }
}
