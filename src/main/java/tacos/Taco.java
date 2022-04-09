package tacos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 5, message="최소 5개 이상의 문자가 되어야합니다.")
	private String name;
	
	@ManyToMany(targetEntity = Ingredient.class)
	@Size(min=1, message = "최소 1개의 재료를 선택해야합니다.")
	private List<Ingredient> ingredients;
	
	
	
	private Date createdAt;
	
	//Taco 객체가 저장되기 전에 createAt 속성을 현재 일자와 시간으로 설정하는데 사용하는 애토네이션 
	@PrePersist
	void createAt() {
		this.createdAt = new Date();
	}
	
}
