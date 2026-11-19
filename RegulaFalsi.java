
import java.util.Scanner;

public class RegulaFalsi {

    static Scanner sc = new Scanner(System.in);

    // Fungsi persamaan
    static double f(double x) {
        return x * x - x - 3;
    }

    public static void main(String[] args) {

        double a, b, x = 0, fa, fb, fx;
        double error = 0, xLama = 0;

        // Input nilai
        System.out.print("Masukkan batas bawah (a): ");
        a = sc.nextDouble();

        System.out.print("Masukkan batas atas (b): ");
        b = sc.nextDouble();

        System.out.print("Masukkan jumlah iterasi: ");
        int n = sc.nextInt();

        // Cek syarat keberadaan akar
        fa = f(a);
        fb = f(b);

        if (fa * fb >= 0) {
            System.out.println("Interval tidak memenuhi syarat Regula Falsi!");
            sc.close();
            return;
        }

        System.out.println("\nMETODE REGULA FALSI");
        System.out.println("==============================================");

        for (int i = 1; i <= n; i++) {

            fa = f(a);
            fb = f(b);

            // Menghitung akar hampiran
            x = b - (fb * (b - a)) / (fb - fa);

            // Menghitung nilai fungsi
            fx = f(x);

            System.out.println("\nIterasi ke-" + i);
            System.out.println("a     = " + a);
            System.out.println("b     = " + b);
            System.out.println("x     = " + x);
            System.out.println("f(x)  = " + fx);

            // Menghitung error relatif hampiran
            if (i > 1) {
                error = Math.abs((x - xLama) / x) * 100;
                System.out.println("Error relatif = " + error + "%");
            }

            // Menentukan interval baru
            if (fa * fx < 0) {
                b = x;
            } else if (fa * fx > 0) {
                a = x;
            } else {
                System.out.println("Akar ditemukan!");
                break;
            }

            xLama = x;
        }

        System.out.println("\n==============================================");
        System.out.println("HASIL AKHIR");
        System.out.println("Akar hampiran = " + x);
        System.out.println("Error relatif = " + error + "%");

        sc.close();
    }
}

