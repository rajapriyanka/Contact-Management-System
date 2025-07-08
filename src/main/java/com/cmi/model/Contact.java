
package com.cmi.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @NotBlank(message = "First name is mandatory")
 private String firstName;

 @NotBlank(message = "Last name is mandatory")
 private String lastName;

 private String address;

 @Email(message = "Email should be valid")
 @NotBlank
 private String emailId;

 @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
 private String phoneNumber;
}

