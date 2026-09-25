# News Feed Simulator

Aplikasi Android sederhana untuk menampilkan dan mengelola simulasi news feed.

## Fitur

- Menampilkan daftar berita
- Filter berita berdasarkan kategori
- Kategori Teknologi, Kesehatan, Olahraga, Ekonomi, dan Pendidikan
- Menandai berita sebagai sudah dibaca
- Menghitung jumlah berita yang sudah dibaca
- Menggunakan Kotlin, Jetpack Compose, Flow, Coroutines, dan StateFlow

## Teknologi yang Digunakan

- Kotlin
- Android Studio
- Jetpack Compose
- Kotlin Coroutines
- Kotlin Flow
- StateFlow

## Cara Menjalankan

1. Clone atau download repository ini.
2. Buka project menggunakan Android Studio.
3. Tunggu proses Gradle Sync selesai.
4. Pilih emulator atau perangkat Android.
5. Tekan tombol Run.
6. Aplikasi akan berjalan pada perangkat atau emulator Android.

## Package

com.example.newsfeedsimulator

This is a Kotlin Multiplatform project targeting Android, Desktop (JVM).

* [/shared](./shared/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./shared/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./shared/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./shared/src/jvmMain/kotlin)
    folder is the appropriate location.

### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and options:

- Android app: `./gradlew :androidApp:assembleDebug`
- Desktop app:
  - Hot reload: `./gradlew :desktopApp:hotRun --auto`
  - Standard run: `./gradlew :desktopApp:run`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

