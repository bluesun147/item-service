package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository { //ctrl+shift+t로 테스트 자동 생성
    // 실제로는 HashMap, long 사용하면 안됨, 동시접근 문제
    // 여러 스레드 동시 접근.
    private static final Map<Long, Item> store = new HashMap<>(); // 키와 밸류
    private static long sequence = 0L;

    // 아이템 저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    // 조회
    public Item findById(Long id) {
        return store.get(id);
    }

    // 전체 조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 업데이트
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // 다 날리기 (테스트 용)
    public void clearStore() {
        store.clear();
    }

}
