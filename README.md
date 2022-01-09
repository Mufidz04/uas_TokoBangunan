# Guide How To Use This Project
*Disclaimer this project used Look&Feel by Flatlaf*

## Open Project
Lakukan `git clone` pada project ini, setelah itu buka pada NetBeans `Open Projects`
![image](https://user-images.githubusercontent.com/27707873/148694154-695f8541-2809-4247-9c6f-eaad6be376ff.png)

## Configure Flatlaf Di Setiap Main Form
Import library Flatlaf pada project ini, folder library terletak pada `look&feel`


Setelah semua sudah dipersiapkan, hapus bagian yang di block
> ![image](https://user-images.githubusercontent.com/27707873/148694335-82e6780d-9ada-4768-b240-fc6541d97e0e.png)


Lalu lakukan inisialisasi look&feel terhadap fungsi main 
> ![image](https://user-images.githubusercontent.com/27707873/148694405-2d73d8de-a78d-460a-9e41-bb01bb67849a.png)

```
try {
    UIManager.setLookAndFeel( new FlatLightLaf() );
} catch( Exception ex ) {
    System.err.println( "Failed to initialize LaF" );
}
```
