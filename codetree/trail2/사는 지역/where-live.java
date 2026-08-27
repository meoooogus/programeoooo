import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        String[] address = new String[n];
        String[] region = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
            address[i] = sc.next();
            region[i] = sc.next();
        }

        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            infos[i] = new Info(name[i], address[i], region[i]);
        }
        Arrays.sort(infos, (i1, i2) -> i1.getName().compareTo(i2.getName()));
        Info lastInfo = infos[n-1];
        System.out.println(lastInfo.getName());
        System.out.println(lastInfo.getAddr());
        System.out.println(lastInfo.getCity());
    }
}
class Info {
    private String name;
    private String addr;
    private String city;

    public Info(String name, String addr, String city) {
        this.name = name;
        this.addr = addr;
        this.city = city;
    }

    public String getName() {
        return "name " + name;
    }
    public String getAddr() {
        return "addr " + addr;
    }
    public String getCity() {
        return "city " + city;
    }
}
