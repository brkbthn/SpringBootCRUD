package com.brkbthn.model;


import jakarta.persistence.*;
import lombok.*;

@Data // @Setter @Getter kullanmaya gerek yok  @Data içerir
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity //jpa bağlantısı sağlandı
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;


}
