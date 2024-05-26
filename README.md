## API documentation

### `POST: ../vouchers`
![Create Voucher](https://github.com/b4-solid/sistemvoucher/assets/83630284/88843b43-24b3-44c5-8a9f-ae4df248d1c3)
![Database List New Voucher](https://github.com/b4-solid/sistemvoucher/assets/124948653/fa1a4b8e-76b0-44dc-afe9-032a95e9ac13)

### `GET: ../vouchers`
![Get All Vouchers](https://github.com/b4-solid/sistemvoucher/assets/83630284/0bb8def5-1a77-4cbe-8ca3-43b09c133aae)
![Database List All Voucher](https://github.com/b4-solid/sistemvoucher/assets/124948653/3c2ffbf9-7e50-4dbb-bfbe-ae8c98cc4be2)

### `GET: ../vouchers/{id}`
![Get Voucher](https://github.com/b4-solid/sistemvoucher/assets/83630284/0f4e9a99-a2ab-4559-b861-16a294f1a3a3)
![Database List Voucher by ID](https://github.com/b4-solid/sistemvoucher/assets/124948653/ac201245-48fe-473f-8941-308a6f11cb3e)

### `PUT: ../vouchers/{id}`
![Update Voucher](https://github.com/b4-solid/sistemvoucher/assets/83630284/6fb8d740-8463-479d-b91f-256447405500)
![Database Update Voucher](https://github.com/b4-solid/sistemvoucher/assets/124948653/dd3c32d2-1237-4099-b42d-8c74baeb8787)

### `DELETE: ../vouchers/{id}`
![Delete Voucher](https://github.com/b4-solid/sistemvoucher/assets/83630284/4142fca7-6e02-4e76-9be5-2fe4a3646ca5)
![Database Delete Voucher](https://github.com/b4-solid/sistemvoucher/assets/124948653/70e7bde8-6af3-4d47-a6c5-636dbfb9381d)


Implementasi High-Level Networking dilakukan menggunakan REST API. Adapun alasan penggunaan REST API sebagai berikut.
- **Komunikasi antar microservice**: REST API memungkinkan layanan dalam arsitektur mikroservis untuk berkomunikasi dengan mudah satu sama lain melalui HTTP/HTTPS karena REST API menggunakan standar protokol web yang umum (HTTP) sehingga berbagai layanan yang dikembangkan dengan teknologi dan bahasa pemrograman yang berbeda dapat berinteraksi tanpa masalah.
- **Sederhana dan fleksibel**: REST API sederhana dan fleksibel untuk menangani berbagai jenis data (seperti JSON, XML), serta mudah untuk dibuat dan dimodifikasi sesuai logika bisnis.
- **Statelessness**: REST API dirancang untuk menjadi stateless yang berarti setiap permintaan dari klien ke server dapat dibuat secara independen satu sama lain dan mengandung semua informasi yang diperlukan untuk memproses permintaan tersebut. Hal ini dapat mempercepat waktu respons dan mengurangi beban pada server karena server tidak menyimpan state dari klien.

## Testing
![CodeCoverage](https://github.com/b4-solid/sistemvoucher/assets/124948653/71d2ab70-43b9-454f-a9ac-11020bb5e52a)

## Code analysis result using PMD
![Screen Shot 2024-05-26 at 9 36 25 PM](https://github.com/b4-solid/sistemvoucher/assets/124948653/258191b5-3f48-4e2c-8981-12aff5410fde)

## Profiling
- _**CPU time**_
![Screen Shot 2024-05-26 at 11 50 34 PM](https://github.com/b4-solid/sistemvoucher/assets/124948653/6d2e4407-6ad9-40c5-97d3-247fbe6a70cc)
- _**Total time**_
![Screen Shot 2024-05-26 at 11 51 08 PM](https://github.com/b4-solid/sistemvoucher/assets/124948653/bb4b0274-bd6d-4c73-ac4e-916909d492ca)

Saya mensimulasikan proses CRUD sebanyak beberapa kali selama proses profiling menggunakan Intelij Profile dan mendapat hasil bahwa method `findAllVoucher` dan `createVoucher` memiliki CPU time yang lebih lama dibanding method-method lainnya. Sedangkan, untuk total time, method yang memerlukan waktu lebih banyak dibanding yang lainnya adalah `deleteVoucherById`.








