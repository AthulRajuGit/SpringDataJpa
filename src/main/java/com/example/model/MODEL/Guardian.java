package com.example.model.MODEL;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name="name",column=@Column(name="guardianName")
			),
	@AttributeOverride(
			name="email",column=@Column(name="guardianEmail")
			),
	@AttributeOverride(
			name="mobile",column=@Column(name="guardianMobile")
			)	
})
public class Guardian {

	private String name;

	private String email;
	private String mobile;
}
