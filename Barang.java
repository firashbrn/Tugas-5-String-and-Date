public class Barang {
        private String kodeBarang;
        private String namaBarang;
        private double hargaBarang;
        
    
        // Konstruktor
        public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
            if (kodeBarang == null || kodeBarang.isEmpty()) {
                throw new IllegalArgumentException("Kode barang tidak boleh kosong");
            }
            if (namaBarang == null || namaBarang.isEmpty()) {
                throw new IllegalArgumentException("Nama barang tidak boleh kosong");
            }
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih besar dari 0");
            }
            this.kodeBarang = kodeBarang;
            this.namaBarang = namaBarang;
            this.hargaBarang = hargaBarang;
        }
    
        // Getter dan Setter
        public String getKodeBarang() {
            return kodeBarang;
        }
    
        public String getNamaBarang() {
            return namaBarang;
        }
    
        public double getHargaBarang() {
            return hargaBarang;
        }
    
        @Override
        public String toString() {
            return "Kode: " + kodeBarang + "\nNama Barang: " + namaBarang + "\nHarga: Rp." + hargaBarang;
        }
    }
    


