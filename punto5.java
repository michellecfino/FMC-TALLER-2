public class punto5 {

    public static void main(String[] args) {
        String raw = "EL HIJO DE RANA RINRIN RENACUAJO SALIO ESTA MANANA MUY TIESO Y MUY MAJO CON PANTALON CORTO CORBATA A LA MODA SOMBRERO ENCINTADO Y CHUPA DE BODA";
        String[] palabras = raw.split(" ");
        int a = 19, b = 7, m = 26;

        System.out.println("Cifrado Afín (a=19, b=7)");
        System.out.println("E(x) = (19*x + 7) mod 26\n");

        for (String palabra : palabras) {
            if (palabra.length() == 0) continue;
            System.out.println(palabra + " -> ");
            StringBuilder cif = new StringBuilder();
            for (int i = 0; i < palabra.length(); i++) {
                char ch = Character.toUpperCase(palabra.charAt(i));
                if (ch < 'A' || ch > 'Z') {
                    System.out.println("  (carácter no alfabético: '" + ch + "')");
                    continue;
                }
                int x = ch - 'A';
                int N = 19 * x + 7;
                int r = N % m;
                char c = (char) (r + 'A');
                cif.append(c);
                System.out.printf("  %c(%d) -> (19*%d + 7) = %d ≡ %d ⇒ %c%n", ch, x, x, N, r, c);
            }
            System.out.println("  Resultado palabra cifrada: " + cif.toString() + "\n");
        }
    }
}
