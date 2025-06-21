package com.algohub.model;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpRequest {
	
	public String email;
	
	public String otp;

}
