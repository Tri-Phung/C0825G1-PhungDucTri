package com.codegym.validatesonginfo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không quá 800 ký tự")
    @Pattern(regexp = "^$|^[a-zA-Z0-9\\sÀ-ỹ]+$",
            message = "Tên bài hát không được chứa ký tự đặc biệt")
    @Column(name = "song_name", nullable = false, length = 800)
    private String songName;
    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không quá 300 ký tự")
    @Pattern(regexp = "^$|^[a-zA-Z0-9\\sÀ-ỹ]+$",
            message = "Tên nghệ sĩ không được chứa ký tự đặc biệt")
    @Column(nullable = false, length = 300)
    private String artist;
    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không quá 1000 ký tự")
    @Pattern(regexp = "^$|^[a-zA-Z0-9\\sÀ-ỹ,]+$",
            message = "Thể loại chỉ cho phép dấu phẩy, không chứa ký tự đặc biệt khác")
    @Column(nullable = false, length = 1000)
    private String genre;
}
