package nextstep.qna.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteHistorys {
    private List<DeleteHistory> deleteHistoryList = new ArrayList<>();

    public DeleteHistorys(List<DeleteHistory> deleteHistoryList) {
        this.deleteHistoryList = deleteHistoryList;
    }

    public DeleteHistorys(DeleteHistory questionDeleteHistory, List<DeleteHistory> answerDeleteHistory) {
        this(Stream.concat(Stream.of(questionDeleteHistory), answerDeleteHistory.stream())
                .collect(Collectors.toList()));
    }


    public List<DeleteHistory> toList() {
        return Collections.unmodifiableList(deleteHistoryList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeleteHistorys)) return false;
        DeleteHistorys that = (DeleteHistorys) o;
        return Objects.equals(deleteHistoryList, that.deleteHistoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deleteHistoryList);
    }
}
