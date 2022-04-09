package tacos;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// 소스 코드에 누락된 final 속성들을 초기화 하는 생성자, 속성들의 게터와 세터 등을 생성하라고 Lombok에 알려주는 애노테이션
@Data 
@RequiredArgsConstructor
// JPA에서는 개체가 인자없는 생성자를 가져야하는데, 여기서는 인자 없는 생성자의 사용을 원치 않기때문에 PRIVATE로 설정하여
// 클래스 외부에서 사용을 못하게 했다.
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
	
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
