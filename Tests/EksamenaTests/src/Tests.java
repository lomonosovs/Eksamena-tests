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
        jautajumi.add(new Jautajums(
                "Kuras funkcijas izmanto skaitlu parversanai uz tekstu?",
                new String[]{"Integer.toString()", "Double.toString()", "Math.sqrt()", "Math.pow()"},
                new HashSet<>(Arrays.asList(1, 2))
        ));
        jautajumi.add(new Jautajums(
                "Kuras funkcijas izmanto, lai iegutu lielako un mazako vertibu?",
                new String[]{"Math.max()", "Math.abs()", "Math.sqrt()", "Math.min"},
                new HashSet<>(Arrays.asList(1, 4))
        ));
        jautajumi.add(new Jautajums(
                "Kuras funkcijas aprekina skaitli pakape un skaitla kvadrat sakni?",
                new String[]{"Math.min()", "Math.sqrt()", "Math.max()", "Math.pow()"},
                new HashSet<>(Arrays.asList(2, 4))
        ));
        jautajumi.add(new Jautajums(
                "Kur ir pareizi uzrakstits Random panemiens",
                new String[]{"Random rand = new Random();", "Random peppa = new Random();", "Randon rand = new Ramdon();", "Random rand = new Random"},
                new HashSet<>(Arrays.asList(1, 2))
        ));
        jautajumi.add(new Jautajums(
                "Kuras funkcijas izmanto lai aprekinatu absoluto vertibu un skaitlu noapalosanu",
                new String[]{"Math.abs()", "Math.min()", "Math.round()", "Math.max()"},
                new HashSet<>(Arrays.asList(1, 3))
        ));
        return jautajumi;
    }
}
