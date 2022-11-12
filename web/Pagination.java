import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 페이지네이션 시 페이지 번호를 계산해주는 서비스
 * - "0페이지"부터 시작한다
 */
@Service
public class PagingService {

    private final int DEFAULT_BAR_LENGTH = 5; // 페이지 바 길이

    // 현재 페이지와 전체 페이지 수를 매개변수로 
    public List<Integer> getPaginationNumbers(int currentPage, int totalPage) {
        int startNumber = Math.max(currentPage - (DEFAULT_BAR_LENGTH / 2), 0); // 시작 페이지는 항상 0보다 크도록 세팅
        int endNumber = Math.min(startNumber + DEFAULT_BAR_LENGTH, totalPage); // 마지막 페이지는 전체 페이지보다 클 수 없음

        return IntStream.range(startNumber, endNumber).boxed().collect(Collectors.toList());
    }
}
