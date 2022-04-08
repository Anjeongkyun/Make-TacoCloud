package tacos;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	@NotNull
	@Size(min = 5, message="최소 5개 이상의 문자가 되어야합니다.")
	private String name;
	
	@Size(min=1, message = "최소 1개의 재료를 선택해야합니다.")
	private List<String> ingredients;
}
