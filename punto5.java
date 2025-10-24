public class punto5 {
    public static void main(String[] args) {
        int a = 19, b = 7, m = 26;
        String raw = "EL HIJO DE RANA RINRIN RENACUAJO SALIO ESTA MANANA MUY TIESO Y MUY MAJO CON PANTALON CORTO CORBATA A LA MODA SOMBRERO ENCINTADO Y CHUPA DE BODA";
        String[] palabras = raw.split(" ");

        System.out.println("E(x) = (19*x + 7) mod 26\n");

        for (String palabra : palabras) {
            if (palabra.isEmpty()) continue;
            System.out.println(palabra + " →");
            StringBuilder cif = new StringBuilder();
            for (int i = 0; i < palabra.length(); i++) {
                char ch = Character.toUpperCase(palabra.charAt(i));
                if (ch < 'A' || ch > 'Z') continue;
                int x = ch - 'A';
                int N = a * x + b;
                int r = N % m;
                char c = (char) (r + 'A');
                System.out.printf("  %c(%d) → (19*%d + 7) = %d ≡ %d ⇒ %c%n", ch, x, x, N, r, c);
                cif.append(c);
            }
            System.out.println("  Resultado palabra cifrada: " + cif + "\n");
        }
    }
}
