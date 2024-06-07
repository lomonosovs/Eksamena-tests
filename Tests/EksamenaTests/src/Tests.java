import java.util.*;
public class Tests {
    private static class Jautajums {
        String jautajums;
        String[] atbildes;
        Set<Integer> pareizasAtbildes;
        Jautajums(String jautajums, String[] atbildes, Set<Integer> pareizasAtbildes) {
            this.jautajums = jautajums;
            this.atbildes = atbildes;
            this.pareizasAtbildes = pareizasAtbildes;
        }
        boolean irPareizi(Set<Integer> lietotajaAtbildes) {
            return lietotajaAtbildes.equals(pareizasAtbildes);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Jautajums> jautajumi = izveidotJautajumus();
        int pareizasPirmoReiziSkaits = 0;
        for (Jautajums j : jautajumi) {
            boolean atbildetsPareizi = false;
            boolean pirmaisMeginajums = true;
            while (!atbildetsPareizi) {
                System.out.println(j.jautajums);
                for (int i = 0; i < j.atbildes.length; i++) {
                    System.out.println((i + 1) + ": " + j.atbildes[i]);
                }
                Set<Integer> lietotajaAtbildes = new HashSet<>();
                System.out.print("izvelies pareizos variantus un atdali tos ar komatiem ");
                String[] ievades = scan.nextLine().split(",");
                try {
                    for (String ievade : ievades) {
                        lietotajaAtbildes.add(Integer.parseInt(ievade.trim()));
                    }
                    if (j.irPareizi(lietotajaAtbildes)) {
                        atbildetsPareizi = true;
                        System.out.println("pareizi!\n");
                        if (pirmaisMeginajums) {
                            pareizasPirmoReiziSkaits++;
                        }
                    } else {
                        System.out.println("nepareizi! atbildi velreiz");
                        pirmaisMeginajums = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("nepareiz ievads");
                }
            }
        }
        System.out.println("jus atbildejat pareizi ar pirmo reizi uz " + pareizasPirmoReiziSkaits + " jautajumiem.");
    }
    private static List<Jautajums> izveidotJautajumus() {
        List<Jautajums> jautajumi = new ArrayList<>();
        jautajumi.add(new Jautajums(
                "Kuras ir matematikas funkcijas?",
                new String[]{"Math.max()", "Math.sqrt()", "Math.saskaitit()", "Math.abs()"},
                new HashSet<>(Arrays.asList(1, 2, 4))
        ));
        return jautajumi;
    }
}
