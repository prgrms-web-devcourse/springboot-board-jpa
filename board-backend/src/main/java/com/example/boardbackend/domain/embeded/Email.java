package com.example.boardbackend.domain.embeded;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Email {
    @Column(name = "email", nullable = false, length = 45)
    private String address;

    public Email(String address){
        Assert.isTrue(checkAddress(address), "Invalid email address");
        this.address = address;
    }

    public boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b", address);
    }
}
