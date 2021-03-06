package destinychild.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String tp;
    private String szint;
    private String nyersanyagok;
    private String energia;
    private String szovetseg;
    private String planetNumber;
}