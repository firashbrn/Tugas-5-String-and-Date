import java.util.Date;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String username = "AdminToko";
            String password = "12345";
            String captcha = "AZX098";

            boolean isLogIn = false;

            while (!isLogIn) {
               System.out.println("\n....................................................."); 
               System.out.print("Username: ");
               String InputUsername = scanner.nextLine().trim(); //method string
               System.out.print("Password: ");
               String InputPassword = scanner.nextLine().trim();
               System.out.print("Capctha (" + captcha + "): ");
               String InputCaptcha = scanner.nextLine().trim();
                System.out.println("\n....................................................."); 
            
            
            if (username.equals(InputUsername) && password.equals(InputPassword) && captcha.equals(InputCaptcha)){
                System.out.println( " Login Berhasil");
                isLogIn = true;
                
            } else {
               System.out.println( " Login Gagal. Silakan Entri Ulang \n "); 
            }
    }
    
        System.out.println("\nSelamat Datang di Supermarket Shabrina");
        Date date = new Date(); //method date
        String str = String.format("Current Date/Time :%tc", date) ; 
        System.out.println(str);
        System.out.println("\n....................................................."); 
    
        while (true) {
            try {
                System.out.println("\n=== Input Data Transaksi ===\n");
                System.out.print("Masukkan No Faktur: ");
                String noFaktur = scanner.nextLine().trim();
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim();
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim();

                double hargaBarang = 0;
                while (true) {
                    try {
                        System.out.print("Masukkan Harga Barang: ");
                        hargaBarang = Double.parseDouble(scanner.nextLine().trim());
                        if (hargaBarang <= 0) throw new IllegalArgumentException("Harga barang harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: " + e.getMessage());
                    }
                }

                int jumlahBeli = 0;
                while (true) {
                    try {
                        System.out.print("Masukkan Jumlah Beli: ");
                        jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                        if (jumlahBeli <= 0) throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: " + e.getMessage());
                    }
                }

                // Membuat objek Transaksi dan menghitung total
                Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, noFaktur, jumlahBeli);
                transaksi.hitungTotal();

                // Menampilkan invoice
                System.out.println("\n=== Faktur Pembelian ===");
                System.out.println(transaksi.displayInvoice());
                
                
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

            // Tanya ulang setelah input selesai
            System.out.print("\nApakah kamu ingin memasukkan data transaksi lain? (y/n): ");
            if (!konfirmasiUlang(scanner)) {
                System.out.println("\nTerima Kasih telah berbelanja di Supermarket Shabrina");
                System.out.println("\n....................................................."); 
                System.out.println("Kasir: Magfira Shabrina");
                System.out.println(".....................................................\n");
                break;
            }
        }
        scanner.close();
    }

    private static boolean konfirmasiUlang(Scanner scanner) {
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.print("Input tidak valid. Masukkan 'y' atau 'n': ");
            }
        }
    }
    

}