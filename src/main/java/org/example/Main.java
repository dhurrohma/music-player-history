package org.example;

import org.example.config.BeanConfiguration;
import org.example.controller.*;
import org.example.model.*;
import org.example.service.IGenreService;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        GenreController genreController = ctx.getBean(GenreController.class);
        SingerController singerController = ctx.getBean(SingerController.class);
        SongWriterController songWriterController = ctx.getBean(SongWriterController.class);
        SongController songController = ctx.getBean(SongController.class);
        HistoryController historyController = ctx.getBean(HistoryController.class);

        Scanner input = new Scanner(System.in);

        System.out.println("===== Music Player History =====");
        System.out.println("1. Song");
        System.out.println("2. Singer");
        System.out.println("3. Genre");
        System.out.println("4. Song Writer");
        System.out.println("5. Putar lagu");
        System.out.println("6. Riwayat Putar Lagu");
        System.out.print("Masukkan pilihan : ");
        Integer menu = input.nextInt();

        if(menu == 1) {
            System.out.println("===== Song =====");
            System.out.println("1. Tambah lagu");
            System.out.println("2. Lihat semua lagu");
            System.out.println("3. Cari lagu");
            System.out.println("4. Update lagu");
            System.out.println("5. Hapus lagu");
            System.out.print("Masukkan pilihan : ");
            Integer song = input.nextInt();
            if(song == 1) {
                System.out.println("===== Tambah lagu =====");
                System.out.print("Masukkan judul lagu : ");
                input.nextLine();
                String title = input.nextLine();
                System.out.print("Masukkan id penyanyi : ");
                Integer singerId = input.nextInt();
                System.out.print("Masukkan id genre : ");
                Integer genreId = input.nextInt();
                System.out.print("Masukkan id penulis lagu : ");
                Integer songWriterId = input.nextInt();
                System.out.print("Masukkan tahun rilis : ");
                input.nextLine();
                String releaseYear = input.nextLine();

                Song addSong = new Song();
                addSong.setTitle(title);
                addSong.setSingerId(singerId);
                addSong.setGenreId(genreId);
                addSong.setSongWriterId(songWriterId);
                addSong.setReleaseYear(releaseYear);
                songController.create(addSong);
            }
            else if(song == 2){
                System.out.println("===== Daftar Semua Lagu =====");
                songController.getAll();
            }
            else if(song == 3){
                System.out.println("===== Cari Lagu =====");
                System.out.println("1. Berdasarkan id");
                System.out.println("2. Berdasarkan judul");
                System.out.println("3. Berdasarkan penyanyi");
                System.out.println("4. Berdasarkan genre");
                System.out.println("5. Berdasarkan penulis lagu");
                System.out.println("6. Berdasarkan tahun release");
                System.out.print("Masukkan pilihan : ");
                Integer findSong = input.nextInt();
                if (findSong == 1){
                    System.out.println("===== Cari Lagu Berdasarkan ID =====");
                    System.out.print("Masukkan id : ");
                    Integer songId = input.nextInt();
                    songController.findById(songId);
                }
                else if (findSong == 2){
                    System.out.println("===== Cari Lagu Berdasarkan Judul =====");
                    System.out.print("Masukkan judul : ");
                    input.nextLine();
                    String songTitle = input.nextLine();
                    songController.findByTitle(songTitle);
                }
                else if (findSong == 3) {
                    System.out.println("===== Cari Lagu Berdasarkan Penyanyi =====");
                    System.out.print("Masukkan nama penyanyi : ");
                    input.nextLine();
                    String songSinger = input.nextLine();
                    songController.findBySinger(songSinger);
                }
                else if (findSong == 4) {
                    System.out.println("===== Cari Lagu Berdasarkan Genre =====");
                    System.out.print("Masukkan genre lagu : ");
                    input.nextLine();
                    String songGenre = input.nextLine();
                    songController.findByGenre(songGenre);
                }
                else if (findSong == 5) {
                    System.out.println("===== Cari Lagu Berdasarkan Penulis Lagu =====");
                    System.out.print("Masukkan nama penulis lagu : ");
                    input.nextLine();
                    String songWriter = input.nextLine();
                    songController.findBySongWriter(songWriter);
                }
                else if (findSong == 6) {
                    System.out.println("===== Cari Lagu Berdasarkan Tahun Release =====");
                    System.out.print("Masukkan tahun : ");
                    input.nextLine();
                    String songYear = input.nextLine();
                    songController.findByReleaseYear(songYear);
                }
                else {
                    System.out.println("Menu tidak valid");
                }
            }
            else if(song == 4){
                System.out.println("===== Update lagu =====");
                System.out.print("Masukkan id lagu : ");
                Integer id = input.nextInt();
                System.out.print("Masukkan judul lagu terupdate : ");
                input.nextLine();
                String title = input.nextLine();
                System.out.print("Masukkan id penyanyi terupdate : ");
                Integer singerId = input.nextInt();
                System.out.print("Masukkan id genre terupdate : ");
                Integer genreId = input.nextInt();
                System.out.print("Masukkan id penulis lagu terupdate : ");
                Integer songWriterId = input.nextInt();
                System.out.print("Masukkan tahun rilis terupdate : ");
                input.nextLine();
                String releaseYear = input.nextLine();

                Song addSong = new Song();
                addSong.setTitle(title);
                addSong.setSingerId(singerId);
                addSong.setGenreId(genreId);
                addSong.setSongWriterId(songWriterId);
                addSong.setReleaseYear(releaseYear);
                songController.update(addSong, id);
            }
            else if (song == 5){
                System.out.println("===== Hapus Lagu =====");
                System.out.print("Masukkan id lagu yang ingin dihapus : ");
                Integer id = input.nextInt();
                songController.delete(id);
            }
            else {
                System.out.println("Menu tidak valid");
            }
        }
        else if(menu == 2){
            System.out.println("===== Singer =====");
            System.out.println("1. Tambah penyanyi");
            System.out.println("2. Lihat semua penyanyi");
            System.out.println("3. Cari penyanyi");
            System.out.println("4. Update penyanyi");
            System.out.println("5. Hapus penyanyi");
            System.out.println("Masukkan pilihan : ");
            Integer singer = input.nextInt();

            if(singer == 1){
                System.out.println("===== Tambah Penyanyi =====");
                System.out.print("Masukkan nama penyanyi : ");
                input.nextLine();
                String singerName = input.nextLine();

                Singer addSinger = new Singer();
                addSinger.setName(singerName);
                singerController.create(addSinger);
            }
            else if(singer == 2){
                System.out.println("===== Daftar Semua Penyanyi =====");
                singerController.getAll();
            }
            else if(singer == 3){
                System.out.println("===== Cari Penyanyi =====");
                System.out.println("1. Berdasarkan id");
                System.out.println("2. Berdasarkan nama");
                System.out.print("Masukkan pilihan : ");
                Integer findSinger = input.nextInt();

                if(findSinger == 1){
                    System.out.println("===== Cari Penyanyi Berdasarkan ID");
                    System.out.print("Masukkan id penyanyi : ");
                    Integer id = input.nextInt();
                    singerController.findById(id);
                }
                else if(findSinger == 2){
                    System.out.println("===== Cari Penyanyi Berdasarkan Name");
                    System.out.print("Masukkan nama penyanyi : ");
                    input.nextLine();
                    String singerName = input.nextLine();
                    singerController.findByName(singerName);
                }
                else {
                    System.out.println("Menu tidak valid");
                }
            }
            else if(singer == 4){
                System.out.println("===== Update Penyanyi =====");
                System.out.print("Masukkan id penyanyi : ");
                Integer id = input.nextInt();
                System.out.print("Masukkan nama penyanyi : ");
                input.nextLine();
                String singerName = input.nextLine();

                Singer addSinger = new Singer();
                addSinger.setName(singerName);
                singerController.update(addSinger, id);
            }
            else if(singer == 5){
                System.out.println("===== Hapus Penyanyi =====");
                System.out.print("Masukkan id penyanyi : ");
                Integer id = input.nextInt();
                singerController.delete(id);
            }
            else {
                System.out.println("Menu tidak valid");
            }
        }
        else if(menu == 3){
            System.out.println("===== Genre =====");
            System.out.println("1. Tambah genre");
            System.out.println("2. Lihat semua genre");
            System.out.println("3. Cari genre");
            System.out.println("4. Update genre");
            System.out.println("5. Hapus genre");
            System.out.print("Masukkan pilihan : ");
            Integer genre = input.nextInt();

            if(genre == 1){
                System.out.println("===== Tambah Genre =====");
                System.out.print("Masukkan nama genre : ");
                input.nextLine();
                String genreName = input.nextLine();

                Genre addGenre = new Genre();
                addGenre.setGenreName(genreName);
                genreController.create(addGenre);
            }
            else if(genre == 2){
                System.out.println("===== Daftar Semua Genre =====");
                genreController.getAll();
            }
            else if(genre == 3){
                System.out.println("===== Cari Genre =====");
                System.out.println("1. Berdasarkan id");
                System.out.println("2. Berdasarkan nama genre");
                System.out.print("Masukkan pilihan : ");
                Integer findGenre = input.nextInt();

                if(findGenre == 1){
                    System.out.println("===== Cari Genre Berdasarkan ID");
                    System.out.print("Masukkan id genre : ");
                    Integer id = input.nextInt();
                    genreController.findById(id);
                }
                else if(findGenre == 2){
                    System.out.println("===== Cari Genre Berdasarkan Nama Genre");
                    System.out.print("Masukkan nama genre : ");
                    input.nextLine();
                    String genreName = input.nextLine();
                    genreController.findByName(genreName);
                }
                else {
                    System.out.println("Menu tidak valid");
                }
            }
            else if(genre == 4){
                System.out.println("===== Update Genre =====");
                System.out.print("Masukkan id genre : ");
                Integer id = input.nextInt();
                System.out.print("Masukkan nama genre terbaru : ");
                input.nextLine();
                String genreName = input.nextLine();

                Genre addGenre = new Genre();
                addGenre.setGenreName(genreName);
                genreController.update(addGenre, id);
            }
            else if(genre == 5){
                System.out.println("===== Hapus Genre =====");
                System.out.print("Masukkan id genre : ");
                Integer id = input.nextInt();
                genreController.delete(id);
            }
            else {
                System.out.println("Menu tidak valid");
            }
        }
        else if(menu == 4){
            System.out.println("===== Song Writer =====");
            System.out.println("1. Tambah penulis lagu");
            System.out.println("2. Lihat semua penulis lagu");
            System.out.println("3. Cari penulis lagu");
            System.out.println("4. Update penulis lagu");
            System.out.println("5. Hapus penulis lagu");
            System.out.print("Masukkan pilihan : ");
            Integer writer = input.nextInt();

            if(writer == 1){
                System.out.println("===== Tambah Penulis Lagu =====");
                System.out.print("Masukkan nama penulis lagu : ");
                input.nextLine();
                String writerName = input.nextLine();

                SongWriter addWriter = new SongWriter();
                addWriter.setName(writerName);
                songWriterController.create(addWriter);
            }
            else if(writer == 2){
                System.out.println("===== Daftar Semua Penulis Lagu =====");
                songWriterController.getAll();
            }
            else if(writer == 3){
                System.out.println("===== Cari Penulis Lagu =====");
                System.out.println("1. Berdasarkan id");
                System.out.println("2. Berdasarkan nama");
                System.out.print("Masukkan pilihan : ");
                Integer findWriter = input.nextInt();

                if(findWriter == 1){
                    System.out.println("===== Cari Penulis Lagu Berdasarkan ID");
                    System.out.print("Masukkan id penulis lagu : ");
                    Integer id = input.nextInt();
                    songWriterController.findById(id);
                }
                else if(findWriter == 2){
                    System.out.println("===== Cari Penulis Lagu Berdasarkan Nama");
                    System.out.print("Masukkan nama penulis lagu : ");
                    input.nextLine();
                    String writerName = input.nextLine();
                    songWriterController.findByName(writerName);
                }
                else {
                    System.out.println("Menu tidak valid");
                }
            }
            else if(writer == 4){
                System.out.println("===== Update Penulis Lagu =====");
                System.out.print("Masukkan id penulis lagu : ");
                Integer id = input.nextInt();
                System.out.print("Masukkan nama penulis lagu terbaru : ");
                input.nextLine();
                String writerName = input.nextLine();

                SongWriter addWriter = new SongWriter();
                addWriter.setName(writerName);
                songWriterController.update(addWriter, id);
            }
            else if(writer == 5){
                System.out.println("===== Hapus Penulis Lagu =====");
                System.out.print("Masukkan id penulis lagu : ");
                Integer id = input.nextInt();
                songWriterController.delete(id);
            }
            else {
                System.out.println("Menu tidak valid");
            }
        }
        else if(menu == 5) {
            System.out.println("===== Putar Lagu =====");
            System.out.print("Masukkan id lagu yang ingin diputar : ");
            Integer idLagu = input.nextInt();
            System.out.println("===== Memutar Lagu =====");
            History history = new History();
            LocalDate date = LocalDate.now();
            history.setDatePlay(date);
            history.setSongId(idLagu);
            historyController.create(history);
        }
        else if(menu == 6){
            System.out.println("===== Riwayat Putar Lagu =====");
            historyController.getAll();
        }
        else {
            System.out.println("Menu tidak valid");
        }
    }
}