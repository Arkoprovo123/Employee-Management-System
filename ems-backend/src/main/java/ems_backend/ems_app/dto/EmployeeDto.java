package ems_backend.ems_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// We use this EmployeeDto class to transfer the data between Client and Server.
// We use this class as a response for RestAPIs.
public class EmployeeDto  {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
