package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.separateLineWithComma;

public class LadderGameRewords {

    private final List<LadderGameReword> ladderGameRewords;

    private LadderGameRewords(final List<LadderGameReword> ladderGameRewords) {
        validate(ladderGameRewords);
        this.ladderGameRewords = Collections.unmodifiableList(ladderGameRewords);
    }

    private void validate(final List<LadderGameReword> ladderGameRewords) {
        if (Objects.isNull(ladderGameRewords) || ladderGameRewords.isEmpty()) {
            throw new IllegalArgumentException("LadderGameRewords is empty");
        }
    }

    public static LadderGameRewords newInstance(final String rewords) {
        return newInstance(separateLineWithComma(rewords));
    }

    public static LadderGameRewords newInstance(final String[] rewordArray) {
        List<LadderGameReword> rewords = Arrays.stream(rewordArray)
                .map(LadderGameReword::of)
                .collect(Collectors.toList());

        return newInstance(rewords);
    }

    public static LadderGameRewords newInstance(final List<LadderGameReword> rewords) {
        return new LadderGameRewords(rewords);
    }

    public int count() {
        return ladderGameRewords.size();
    }

    public LadderGameReword get(int i) {
        return ladderGameRewords.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameRewords)) return false;
        LadderGameRewords that = (LadderGameRewords) o;
        return Objects.equals(ladderGameRewords, that.ladderGameRewords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderGameRewords);
    }
}