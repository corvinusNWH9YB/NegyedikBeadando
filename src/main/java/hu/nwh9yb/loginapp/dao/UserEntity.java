package hu.nwh9yb.loginapp.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username", nullable = false)
    private String username; // Save the name of the phone

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;
}
