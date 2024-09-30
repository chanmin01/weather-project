package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 테스트 시 변경된 데이터베이스를 원상복구
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo newMemo = new Memo(10, "jpa memo");

        // when
        jpaMemoRepository.save(newMemo);

        // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        // given
        Memo newMemo = new Memo(10, "jpa");

        // when
        Memo memo = jpaMemoRepository.save(newMemo);

        // then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "jpa");

    }

}