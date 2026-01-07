package com.codegym.validateformregister.entity;

import com.codegym.validateformregister.common.annotation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 45)
    @NotBlank(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ phải từ 5-45 ký tự")
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 45)
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải từ 5-45 ký tự")
    private String lastName;
    @Column(name = "phone_number", nullable = false, length = 15)
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^$|^(0|84)(3|5|7|8|9)[0-9]{8}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;
    @Column(nullable = false)
    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private Integer age;
    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @UniqueEmail
    private String email;
}
