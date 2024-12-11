package com.zentinel.resume.resume.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import static jakarta.persistence.GenerationType.SEQUENCE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @SequenceGenerator(
      name="user_sequence",
      sequenceName="user_sequence",
      allocationSize=1
    )
    @GeneratedValue(
      strategy=SEQUENCE,
      generator="user_sequence"
    )
    private Long id; 

    private String name;

    private Boolean active;

    @CreationTimestamp
    private Timestamp createAt;

    @Column(name="email", length=50, nullable=false)
    private String email;

    @Column(name="second_email", length=50)
    private String secondEmail;
}
