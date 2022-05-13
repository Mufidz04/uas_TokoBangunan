# Perancangan Pemrograman Detskop Toko Bangunan UD. Tiga Saudara
Tujuan Pembuatan Aplikasi Detskop Untuk Memenuhi Permintaan Client Dimana Kebutuhan Yang Diperlukan Adalah
- Bagaimana cara untuk menyetok barang menggunakan aplikasi agar tertata secara rapi?
- Bagaimana cara agar laporan penjualan tersimpan secara rapi dalam aplikasi sistem kasir?
- Bagaimana membuat sistem transaksi secara prosedural?

# Macam Macam Modul Pada Pembuatan Project Pemrograman Detskop UD. Tiga Saudara
- Modul Barang (Arip Irwansyah & Aditya Dava)
- Modul DB (Asep Supriyanto & Tsaqif Mutashim Mufid)
- Modul Laporan (Asep Supriyanto)
- Modul Login (Tsaqif Mutashim Mufid)
- Modul Transaksi (Tsaqif Mutashim Mufid)
- Aplikasi Utama (Kelompok 1)

# Kelompok 1
Universitas SingaPerbangsa Karawang
- Arip Irwansyah                (1910631170009)
- Aditya Dava                   (1910631170002)
- Agnia Virli                   (1910631170003)
- Asep Supriyanto               (1910631170166)
- Tsaqif Mutashim Mufid         (1910631170144)

```
Kelas 5B
Pemrograman Berbasis Desktop
Link Github: https://github.com/Mufidz04/uas_TokoBangunan
Link Laporan: https://drive.google.com/file/d/1UCiN0qUX44bEhjfqCzq3cuRtkvxUTFoa/view?usp=sharing
```

## Open Project
Lakukan `git clone` pada project ini, setelah itu buka pada NetBeans `Open Projects`
![image](https://user-images.githubusercontent.com/27707873/148694154-695f8541-2809-4247-9c6f-eaad6be376ff.png)

## Configure Flatlaf Di Setiap Main Form
Import library Flatlaf pada project ini, folder library terletak pada `look&feel`
> ![image](https://user-images.githubusercontent.com/27707873/148694721-1fd7469a-8515-47b0-9047-a81f98805571.png)


Setelah semua sudah dipersiapkan, terapkan kode dibawah `Look and feel setting code (optional)`
> ![image](https://user-images.githubusercontent.com/27707873/148694335-82e6780d-9ada-4768-b240-fc6541d97e0e.png)


Lalu lakukan inisialisasi look&feel terhadap fungsi `main `
> ![image](https://user-images.githubusercontent.com/27707873/148694405-2d73d8de-a78d-460a-9e41-bb01bb67849a.png)

```
try {
    UIManager.setLookAndFeel( new FlatLightLaf() );
} catch( Exception ex ) {
    System.err.println( "Failed to initialize LaF" );
}
```
## Result
### Dashboard
![image](https://user-images.githubusercontent.com/27707873/148694843-a529bcf8-b663-4cc5-a726-9437b7b2eb52.png)


### Transaksi
![image](https://user-images.githubusercontent.com/27707873/148699070-dbeb47bc-888d-4b65-adae-8f29a798bf27.png)

