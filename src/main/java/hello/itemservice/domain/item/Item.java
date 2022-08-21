package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // lombok. 게터, 세터 등등 자동으로 다 만들어줌, 근데 위험. dto에서는 그냥 씀. 예시니까 그냥 쓸거임.
//@Getter // 이렇게 하나씩 꺼내 쓰자.
//@Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // Integer 쓰는 이유는 null 들어갈 수도 있기 떄문
    private Integer quantity; // int는 기본형이라 null 못 씀.

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) { // alt+insert 생성자 자동 생성
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
